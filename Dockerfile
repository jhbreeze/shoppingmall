# Use the official MySQL image from Docker Hub
FROM mysql:latest

# Set environment variables for MySQL configuration
ENV MYSQL_ROOT_PASSWORD=1234
ENV MYSQL_DATABASE=shoppingmall
ENV MYSQL_USER=jaehee
ENV MYSQL_PASSWORD=1234

# Expose the default MySQL port (3306) to the host machine
EXPOSE 3306