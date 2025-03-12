#include <iostream>
#include <string>

int main() {
    std::string input;

    std::cout << "Simple Terminal in C++ (type 'exit' to quit):\n";
    
    while (true) {
        // Display prompt
        std::cout << "myterminal> ";
        
        // Read the full line of user input
        std::getline(std::cin, input);
        
        // Check for end-of-file or input failure
        if (std::cin.eof() || std::cin.fail()) {
            std::cout << "\nExiting terminal...\n";
            break;
        }
        
        // Process the input commands
        if (input == "exit") {
            std::cout << "Exiting terminal...\n";
            break;
        } else if (input == "hello") {
            std::cout << "Hello, user!\n";
        } else if (input.empty()) {
            // Skip empty input and show prompt again
            continue;
        } else {
            // Echo back any other input
            std::cout << "You typed: " << input << "\n";
        }
    }
    
    return 0;
}
