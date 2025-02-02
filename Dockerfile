# Use OpenJDK 17 as the base image
FROM openjdk:17-slim

# Set working directory
WORKDIR /app

# Install essential tools
RUN apt-get update && apt-get install -y \
    maven \
    git \
    && rm -rf /var/lib/apt/lists/*

# Copy the Java files into the container
COPY . .

# Set the default command to bash
CMD ["bash"]
