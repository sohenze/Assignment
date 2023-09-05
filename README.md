## SETUP
1. Install Java 20, Gradle, MYSQL.
2. Create a MYSQL user and password.
3. Create a MYSQL database.
4. In `src/main/resources/application.properties`, add the following lines of code:
    ```
    spring.datasource.url=jdbc:mysql://localhost:3306/databasename
    spring.datasource.username=user
    spring.datasource.password=password
    spring.jpa.hibernate.ddl-auto=update
    server.port=8080
    ```
5. Replace `databasename`, `user` and `password` with appropriate values.
6. Run the app using `./gradlew bootRun`.

### Assumptions
1. All requests to the endpoints are made with valid inputs.
