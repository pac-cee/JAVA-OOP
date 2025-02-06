# String Formatting Exercises

This package contains exercises focused on string manipulation and formatting operations in Java.

## Key Concepts Covered
- Date and time formatting
- String manipulation
- Name formatting
- URL generation
- Log message formatting

## Solutions Overview

### StringFormatter.java
- `formatDateTime(LocalDateTime dateTime)`: Formats date and time
  - Uses DateTimeFormatter for consistent output
  - Format pattern: "yyyy-MM-dd HH:mm:ss"

- `formatName(String firstName, String lastName)`: Formats full names
  - Combines first and last names in "lastName, firstName" format
  - Handles name concatenation

- `reverseWords(String sentence)`: Reverses word order in a sentence
  - Splits sentence into words
  - Maintains word integrity while reversing order
  - Uses StringBuilder for efficiency

- `generateURL(String username)`: Creates URL from username
  - Converts to lowercase
  - Removes non-alphanumeric characters
  - Adds www. prefix and .com suffix

- `generateLogMessage(String username, String action)`: Creates log entries
  - Formats system log messages
  - Includes username and action
  - Timestamp integration

## Best Practices Demonstrated
- Efficient string manipulation
- StringBuilder usage
- Input sanitization
- Consistent formatting
- Date/time handling
