# Time Operations Exercises

This package contains exercises focused on time-based operations and calculations in Java.

## Key Concepts Covered
- Time-based greetings
- Hour validation
- Time period classification
- Conditional logic with time

## Solutions Overview

### TimeGreeting.java
- `getGreeting(int hour)`: Returns appropriate greeting based on time of day
  - Input validation for 24-hour format (0-23)
  - Time periods:
    - 00:00-05:00: "Good Night"
    - 06:00-11:00: "Good Morning"
    - 12:00-17:00: "Good Afternoon"
    - 18:00-23:00: "Good Evening"
  - Returns "Invalid hour" for out-of-range inputs

## Best Practices Demonstrated
- Input validation
- Clear time period boundaries
- Readable conditional logic
- Consistent return types
- Meaningful error messages
