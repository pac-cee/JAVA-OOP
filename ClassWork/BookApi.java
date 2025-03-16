package ClassWork;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

class Book {
    private final int id;
    private final String title;

    public Book(int id, String title) {
        this.id = id;
        this.title = title;
    }

    public int getId() { return id; }
    public String getTitle() { return title; }
}

public class BookApi {
    private static final List<Book> books = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);
        server.createContext("/books", new BookHandler());
        // Use a thread pool instead of default executor
        server.setExecutor(Executors.newFixedThreadPool(10));
        server.start();

        System.out.println("Server started on port 8080");
        System.out.println("Available endpoints:");
        System.out.println("GET  /books - List all books");
        System.out.println("POST /books - Add a new book");
    }

    static class BookHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            try (exchange) {
                String method = exchange.getRequestMethod();
                switch (method.toUpperCase()) {
                    case "GET" -> handleGet(exchange);
                    case "POST" -> handlePost(exchange);
                    default -> sendResponse(exchange, 405, "Method Not Allowed");
                }
            } catch (Exception e) {
                sendResponse(exchange, 500, "Internal Server Error: " + e.getMessage());
            }
        }

        private void handleGet(HttpExchange exchange) throws IOException {
            StringBuilder response = new StringBuilder("[");
            for (int i = 0; i < books.size(); i++) {
                Book book = books.get(i);
                response.append(String.format(
                    "{\"id\": %d, \"title\": \"%s\"}",
                    book.getId(),
                    book.getTitle().replace("\"", "\\\"")
                ));
                if (i < books.size() - 1) {
                    response.append(",");
                }
            }
            response.append("]");

            sendJsonResponse(exchange, 200, response.toString());
        }

        private void handlePost(HttpExchange exchange) throws IOException {
            String body = readRequestBody(exchange);
            
            // Parse JSON input (assuming format: {"title": "Book Title"})
            if (body.contains("title")) {
                String title = body.split("\"title\"")[1]
                    .split("\"")[2]
                    .trim();

                if (title.isEmpty()) {
                    sendResponse(exchange, 400, "Title cannot be empty");
                    return;
                }

                int id = books.size() + 1;
                Book book = new Book(id, title);
                books.add(book);

                String response = String.format(
                    "{\"id\": %d, \"title\": \"%s\", \"message\": \"Book added successfully\"}",
                    book.getId(),
                    book.getTitle()
                );
                sendJsonResponse(exchange, 201, response);
            } else {
                sendResponse(exchange, 400, "Invalid request format. Expected: {\"title\": \"Book Title\"}");
            }
        }

        private String readRequestBody(HttpExchange exchange) throws IOException {
            try (BufferedReader reader = new BufferedReader(
                    new InputStreamReader(exchange.getRequestBody(), "UTF-8"))) {
                StringBuilder body = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    body.append(line);
                }
                return body.toString();
            }
        }

        private void sendJsonResponse(HttpExchange exchange, int statusCode, String response) 
                throws IOException {
            exchange.getResponseHeaders().set("Content-Type", "application/json");
            byte[] responseBytes = response.getBytes("UTF-8");
            exchange.sendResponseHeaders(statusCode, responseBytes.length);
            try (OutputStream os = exchange.getResponseBody()) {
                os.write(responseBytes);
            }
        }

        private void sendResponse(HttpExchange exchange, int statusCode, String message) 
                throws IOException {
            String response = String.format("{\"message\": \"%s\"}", message);
            sendJsonResponse(exchange, statusCode, response);
        }
    }
}