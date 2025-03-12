#include <stdio.h>
#include <string.h>

#define MAX_INPUT 256

int main(void) {
    char input[MAX_INPUT];

    printf("Simple Terminal. Type 'exit' to quit.\n");

    while (1) {
        // Display a prompt
        printf("myterminal> ");

        // Read user input from standard input (stdin)
        if (fgets(input, sizeof(input), stdin) == NULL) {
            // If an error occurs or EOF is reached, break out of the loop
            printf("\nExiting terminal...\n");
            break;
        }

        // Remove trailing newline character, if present
        input[strcspn(input, "\n")] = '\0';

        // Process commands
        if (strcmp(input, "exit") == 0) {
            printf("Exiting terminal...\n");
            break;
        } else if (strcmp(input, "hello") == 0) {
            printf("Hello, user!\n");
        } else if (strlen(input) == 0) {
            // Do nothing on empty input (just show prompt again)
            continue;
        } else {
            // For any other input, echo the input back
            printf("You typed: %s\n", input);
        }
    }
    return 0;
}
