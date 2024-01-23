# Use the official OpenJDK 17 base image
FROM openjdk:17

# Set the working directory inside the container
WORKDIR /app

# Copy the JAR file into the container at /app
COPY target/SpringaiApplication.jar /app/SpringaiApplication.jar

# Expose the port that your Spring Boot application will run on
EXPOSE 8080

# Set the OpenAI API key as an environment variable
ENV OPENAI_API_KEY=${OPENAI_API_KEY}

# Command to run your application
CMD ["java", "-jar", "/app/SpringaiApplication.jar"]
