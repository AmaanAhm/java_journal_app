# Java Journal App

This is a Spring Boot application that provides a RESTful API for managing journal entries. It allows users to create, read, update, and delete journal entries stored in a MongoDB database.

## Features

- Retrieve all journal entries
- Get a journal entry by ID
- Create a new journal entry
- Update an existing journal entry
- Delete a journal entry

## Technologies Used

- Java 17+
- Spring Boot
- Spring Web
- MongoDB
- Maven

## API Endpoints

| Method | Endpoint                   | Description                  |
|--------|----------------------------|------------------------------|
| GET    | `/journal/getJournal`      | Get all journal entries      |
| GET    | `/journal/id/{myId}`       | Get a journal entry by ID    |
| POST   | `/journal/createJournal`   | Create a new journal entry   |
| PUT    | `/journal/id/{myId}`       | Update a journal entry       |
| DELETE | `/journal/id/{myId}`       | Delete a journal entry       |

## Prerequisites

- Java 17 or later
- Maven 3.6+
- MongoDB running locally on port `27017`

## Getting Started

1. **Clone the repository**
   ```bash
   git clone https://github.com/your-username/java_journal_app.git
   cd java_journal_app
   ```

2. **Configure MongoDB**
   Ensure MongoDB is running locally or update the MongoDB URI in `application.properties`:
   ```
   spring.data.mongodb.uri=mongodb://localhost:27017/journal_db
   ```

3. **Build the project**
   ```bash
   mvn clean install
   ```

4. **Run the application**
   ```bash
   mvn spring-boot:run
   ```

5. **Test the API**
   Use tools like Postman or curl to interact with the API endpoints.

## Sample JSON for Journal Entry

```json
{
  "title": "My First Journal",
  "content": "Today was a great day!"
}
```

## License

This project is licensed under the MIT License.
