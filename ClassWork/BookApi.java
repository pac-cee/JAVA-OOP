package ClassWork;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.List;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

public class BookApi {

    // In-memory storage for simplicity
    private static final List<Book> books = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        // Create an HTTP server listening on port 8080
        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);

        // Create a context for /books endpoint
        server.createContext("/books", new BookHandler());
        server.setExecutor(null); // Use the default executor
        server.start();

        System.out.println("Server started on port 8080");
    }

    static class BookHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            String method = exchange.getRequestMethod();

            if ("GET".equalsIgnoreCase(method)) {
                handleGet(exchange);
            } else if ("POST".equalsIgnoreCase(method)) {
                handlePost(exchange);
            } else {
                exchange.sendResponseHeaders(405, -1); // Method Not Allowed
            }
        }

        // Handle GET requests to return the list of books in JSON format
        private void handleGet(HttpExchange exchange) throws IOException {
            StringBuilder response = new StringBuilder("[");
            for (Book book : books) {
                response.append("{\"id\":")
                        .append(book.getId())
                        .append(", \"title\":\"")
                        .append(book.getTitle())
                        .append("\"},");
            }
            if (!books.isEmpty()) {
                response.setLength(response.length() - 1); // Remove trailing comma
            }
            response.append("]");

            exchange.getResponseHeaders().add("Content-Type", "application/json");
            byte[] responseBytes = response.toString().getBytes("UTF-8");
            exchange.sendResponseHeaders(200, responseBytes.length);
            OutputStream os = exchange.getResponseBody();
            os.write(responseBytes);
            os.close();
        }

        // Handle POST requests to add a new book
        private void handlePost(HttpExchange exchange) throws IOException {
            InputStream is = exchange.getRequestBody();
            BufferedReader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            StringBuilder bodyBuilder = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                bodyBuilder.append(line);
            }
            String body = bodyBuilder.toString();

            // For simplicity, assume the request body is in the format: title=BookTitle
            String title = "";
            if (body.startsWith("title=")) {
                title = body.substring(6);
            }

            int id = books.size() + 1;
            Book book = new Book(String.valueOf(id), title, "defaultAuthor");
            books.add(book);

            String response = "{\"message\":\"Book added\", \"id\":" + id + "}";
            exchange.getResponseHeaders().add("Content-Type", "application/json");
            byte[] responseBytes = response.getBytes("UTF-8");
            exchange.sendResponseHeaders(201, responseBytes.length);
            OutputStream os = exchange.getResponseBody();
            os.write(responseBytes);
            os.close();
        }
    }
}
