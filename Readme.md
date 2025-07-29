# 📚 RESTful Bookstore API

## 🛠️ What It Does & How It Works

Imagine you're building a digital bookstore management system. Your backend is like a **smart librarian** that handles all bookstore operations through the internet. Instead of walking into a physical store, customers and store managers send requests, and your backend understands and responds accordingly.

Your API manages two main entities:

- 📘 **Books**
- 🖋️ **Authors**

It’s like having a super-efficient assistant who never sleeps, never forgets, and can handle thousands of requests simultaneously.

---

## 🌊 Complete Workflow Journey

### 🚀 1. A Request Arrives
When someone wants to interact with your bookstore (e.g., fetch books or add a new author), they send an HTTP request to your API.

**Example**:  
`GET /api/books?minPrice=10&maxPrice=30&sort=title`

---

### 🚪 2. Controller Layer — The Gatekeeper
The **Controller** is like a multilingual front-desk receptionist. It:

- Identifies HTTP method (GET, POST, PUT, DELETE)
- Extracts parameters from URL/path/body
- Validates the request
- Sends back errors if something is wrong

---

### 🧠 3. Service Layer — The Brain
The **Service Layer** is your business manager. It:

- Applies rules (e.g., no duplicate authors)
- Decides how to respond to requests
- Controls application flow

---

### 🗄️ 4. Repository Layer — The Memory Vault
The **Repository** handles communication with the database. It:

- Talks to PostgreSQL via Spring Data JPA
- Converts SQL queries into simple Java methods
- Automatically handles searching, saving, and updating

---

### 🏛️ 5. PostgreSQL — The Vault
The **PostgreSQL database** is your organized warehouse:

- `authors` table: stores name, bio, etc.
- `books` table: stores title, ISBN, price, stock
- Relationships: links between books and authors

---

### 🔄 6. The Return Journey
The response travels back through:

1. **Database** →
2. **Repository** →
3. **Service** →
4. **Controller** →
5. **Client Response**

---

### ✨ 7. Bonus Features

- ✅ **Pagination**: Returns limited books per page
- 🔍 **Filtering & Sorting**: Based on price, title, etc.
- 🛡️ **Validation**: Prevents invalid data
- 🧯 **Error Handling**: Returns helpful messages
- 📖 **Documentation**: Auto-generated via Swagger UI

---

## 🎭 Real-World Example Walkthrough

📌 **Goal**: Add a new book

1. **POST** request to `/api/books` with JSON data
2. **Controller** validates the format
3. **Service** checks business logic (duplicate ISBN?)
4. **Repository** saves the book
5. **Database** stores the data
6. **Response** returns `201 Created` with book info

❌ If something fails (e.g., ISBN duplicate), it returns `400 Bad Request` with error details.

---

## 🌟 Why This Matters

Your backend creates a **bridge between humans and digital storage**:

- 🌍 **Scalable**: Serves one or many users
- 🔧 **Reliable**: Withstand errors and edge cases
- 🧼 **Maintainable**: Clean architecture and separation of concerns
- 📜 **Professional**: With proper documentation and HTTP standards

---

> 💡 *This API powers digital platforms like websites or mobile apps — serving as the foundation for efficient, modern bookstore management.*  
