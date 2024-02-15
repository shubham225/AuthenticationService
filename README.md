# OAuth2 Authorization Server
This is a simple OAuth2 authorization server written in Spring Boot, capable of generating and validating JWT tokens, client registration, and user signup.

## Prerequisites
This project is created using Java 17 and Spring boot 3.2.1, maven framework is used as build system.

Before you begin, ensure you have met the following requirements:

- **Java:** Version 17 or later. You can download it from [OpenJDK](https://openjdk.java.net/).
- **Spring Boot:** Version 3.2.1. Check the [official Spring Boot website](https://spring.io/projects/spring-boot) for details.
- **Maven:** The project uses Maven as the build system. Install Maven by following the instructions [here](https://maven.apache.org/install.html).
- **Database**: Set up a MySQL or MariaDB database server. You can install MySQL or MariaDB server locally on your development machine or use a cloud-based database service. You can download MySQL from the [official MySQL website](https://dev.mysql.com/downloads/) or MariaDB from the [official MariaDB website](https://mariadb.org/download/).

## Getting Started

To get a local copy up and running, follow these simple steps:

1. Clone the repository.
   ```bash
   git clone https://github.com/shubham225/authorization-service.git
2. Navigate to the project directory.
    ```bash
   cd authorization-service
3. Build the project using Maven.
    ```bash
   mvn clean install
4. Run the application.
    ```bash
   mvn spring-boot:run
5. The application will now be accessible at http://localhost:9000. Make sure to configure any additional settings or credentials according to your specific use case.

## Deployment

Follow these steps to deploy the application in a production environment:

1. Build the JAR file:
   ```bash
   mvn clean install
2. Copy the JAR file to the deployment server:
    ```bash
   scp target/authorization-server-0.0.1.jar user@your-server-ip:/path/to/deployment/
3. SSH into the deployment server:
    ```bash
   ssh user@your-server-ip
4. Run the application:
    ```bash
   java -jar /path/to/deployment/authorization-server-0.0.1.jar
5. The application will be deployed and accessible on the specified port. Make sure to configure environment-specific settings and secure any sensitive information.

## Environment Variables

To properly configure and run this project, you will need to set up the following environment variables:

- **AUTH_DATASOURCE_URL**: This variable should be set to the URL of your server datasource. For example, if you're using a MySQL/MariaDB database for service, the URL might look like `jdbc:mariadb://localhost:3306/your_database_name`.

- **AUTH_DB_USER**: Set this variable to the username used to access your database.

- **AUTH_DB_PASSWORD**: Set this variable to the password used to access your database.

Make sure to set these environment variables either directly in your development environment or using a configuration file such as `application.properties` or `application.yml` for local development. Additionally, when deploying your Spring Boot application, you can configure these variables through your deployment environment settings.

## Features

- **JWT Token Handling:** Generate and validate JWT tokens for secure communication.
- **Client Registration:** Allow applications to register for OAuth2 authorization.
- **User Signup:** Enable user registration for accessing protected resources.

## API Endpoints

Here are some of the key API endpoints provided by the OAuth2 authorization service:
### Registration Endpoints
- **`/api/V1/users/signup`:** Register a new user for accessing protected resources.
- **`/api/V1/clients/register`:** Register a new client application for OAuth2 authorization.

### Discovery Endpoints
- **`/.well-known/oauth-authorization-server`:** Provides information about the OAuth2 Authorization Server, including its capabilities and supported endpoints.
- **`/.well-known/openid-configuration`:** Publishes configuration information, including endpoints and supported features, for clients using OpenID Connect.

### Authorization Endpoints
- **`/oauth2/authorize`:** Authorization endpoint for initiating the OAuth2 authorization process.
- **`/oauth2/device_authorization`:** Endpoint for device authorization flow, allowing devices with limited input capabilities to obtain OAuth2 tokens.
- **`/oauth2/token`:** Token endpoint for obtaining OAuth2 access tokens and refresh tokens.
- **`/oauth2/jwks`:** JSON Web Key Set (JWKS) endpoint providing public keys for validating JWTs issued by the Authorization Server.
- **`/oauth2/introspect`:** Token introspection endpoint for checking the validity and details of an OAuth2 token.

### Other Endpoints
- **`/actuator/health`:** Exposes the health status of the application
- **`/actuator/info`:** Provides general information about the application.

Refer to the [API Documentation](./docs/DOCUMENTATION.md) for a complete list of endpoints and their usage. 

## License

This project is licensed under the [MIT License](LICENSE.md).