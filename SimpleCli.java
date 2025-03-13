import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class SimpleCli {
    private static final Map<String, Command> commands = new HashMap<>();
    private static final List<String> commandHistory = new ArrayList<>();
    private static boolean isRunning = true;

    // Command interface for implementing different commands
    private interface Command {
        void execute(String[] args);
        String getDescription();
    }

    public static void main(String[] args) {
        initializeCommands();
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Welcome to Advanced CLI");
            System.out.println("Type 'help' for available commands");
            
            while (isRunning) {
                System.out.print("\n> ");
                String input = scanner.nextLine().trim();
                
                if (!input.isEmpty()) {
                    processCommand(input);
                    commandHistory.add(input);
                }
            }
        }
    }

    private static void initializeCommands() {
        commands.put("help", new Command() {
            @Override
            public void execute(String[] args) {
                System.out.println("\nAvailable Commands:");
                commands.forEach((name, cmd) -> 
                    System.out.printf("%-10s - %s%n", name, cmd.getDescription()));
            }
            @Override
            public String getDescription() {
                return "Shows all available commands";
            }
        });

        commands.put("exit", new Command() {
            @Override
            public void execute(String[] args) {
                System.out.println("Goodbye!");
                isRunning = false;
            }
            @Override
            public String getDescription() {
                return "Exits the CLI";
            }
        });

        commands.put("history", new Command() {
            @Override
            public void execute(String[] args) {
                System.out.println("\nCommand History:");
                for (int i = 0; i < commandHistory.size(); i++) {
                    System.out.printf("%d: %s%n", i + 1, commandHistory.get(i));
                }
            }
            @Override
            public String getDescription() {
                return "Shows command history";
            }
        });

        commands.put("clear", new Command() {
            @Override            
            public void execute(String[] args) {
                // Clear screen by printing multiple newlines
                for (int i = 0; i < 50; i++) System.out.println();
            }
            
            @Override
            public String getDescription() {
                return "Clears the screen";
            }
        });

        commands.put("echo", new Command() {
            @Override
            public void execute(String[] args) {
                if (args.length > 0) {
                    System.out.println(String.join(" ", Arrays.copyOfRange(args, 0, args.length)));
                }
            }
            @Override
            public String getDescription() {
                return "Echoes the input text";
            }
        });

        commands.put("time", new Command() {
            @Override
            public void execute(String[] args) {
                System.out.println("Current time: " + new Date());
            }
            @Override
            public String getDescription() {
                return "Shows current time";
            }
        });
    }

    private static void processCommand(String input) {
        String[] parts = input.split("\\s+");
        String commandName = parts[0].toLowerCase();
        String[] args = Arrays.copyOfRange(parts, 1, parts.length);

        Command command = commands.get(commandName);
        if (command != null) {
            command.execute(args);
        } else {
            System.out.println("Unknown command: " + commandName);
            System.out.println("Type 'help' for available commands");
        }
    }
}
