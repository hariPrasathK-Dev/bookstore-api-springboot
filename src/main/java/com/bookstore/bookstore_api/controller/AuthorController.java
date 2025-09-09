package com.bookstore.bookstore_api.controller;

import com.bookstore.bookstore_api.entity.Author;
import com.bookstore.bookstore_api.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
 The @RestController annotation in Spring is a specialized version of the @Controller annotation, 
 specifically designed for building RESTful web services.
 It combines the functionality of @Controller and @ResponseBody, meaning that all methods within a class 
 annotated with @RestController automatically have their return values serialized to JSON or XML and written 
 directly to the HTTP response body, eliminating the need to explicitly annotate each method with @ResponseBody.
 This annotation is used at the class level to mark a component as a request handler for REST APIs, where the 
 primary goal is to return data in standard formats like JSON or XML rather than resolving view names for 
 rendering HTML pages. It is particularly useful for creating APIs that handle standard HTTP methods such as GET,
 POST, PUT, and DELETE, and it simplifies development by automatically managing response serialization based on 
 the client's Accept header.
 */
@RestController //RESTful API controller

/*
 The @RequestMapping annotation in Spring is a core component used to map incoming web requests to specific 
 handler methods within a controller class, making web resources addressable.
 It can be applied at both the class level to define a shared base URL path for all methods in the controller, 
 and at the method level to specify the exact path and HTTP method for a particular endpoint.
 For example, a class-level @RequestMapping("/api/users") sets a base path, while a method-level @RequestMapping(value = "/{id}", 
 method = RequestMethod.GET) maps a GET request to retrieve a specific user.

The annotation offers extensive flexibility by allowing developers to define mappings based on various criteria,
including the HTTP method (GET, POST, PUT, DELETE, etc.), request parameters, headers, and media types.
 By default, @RequestMapping maps to all HTTP methods, but the method attribute can be used to restrict it to a 
 specific method, such as GET or POST.It can also handle dynamic URI values using the @PathVariable annotation 
 and supports regular expressions for input validation.Furthermore, it can be used with @RequestParam to bind 
 query parameters and with @RequestHeader to bind request headers.

To simplify common use cases, Spring provides specialized annotations like @GetMapping, @PostMapping, @PutMapping,
and @DeleteMapping, which are shorthand versions of @RequestMapping specifically for their respective HTTP methods.
 These specialized annotations enhance code readability and conciseness, particularly for GET requests. While 
 @RequestMapping remains a powerful and flexible tool, its use is often complemented by these more specific 
 annotations for cleaner, more maintainable code.
 */
@RequestMapping("/authors")
public class AuthorController {

    /*
    Autowired Annotation : 
    The @Autowired annotation in the Spring Framework is used to enable automatic dependency injection, allowing 
    the Spring container to automatically wire required beans (dependencies) into a class without manual 
    configuration.This annotation can be applied to constructors, setter methods, fields, or methods with arbitrary names and multiple arguments.
    It simplifies code by reducing boilerplate and focusing development on business logic.

    Since Spring Framework 4.3, the @Autowired annotation is not required on a constructor if the target bean has
    only one constructor, as Spring will automatically perform constructor injection in such cases.
    However, if a class has multiple constructors, at least one must be annotated with @Autowired to specify 
    which one the container should use for dependency injection.
    Constructor injection is often recommended for better readability and immutability.

    The annotation can also be used to inject collections or maps of beans. For example, it can inject an array,
    list, or set of beans that match a specific type, or a map where the keys are bean names and the values are 
    the corresponding beans.When injecting collections, the order of elements can be controlled using the @Order or @Priority annotations.

    If multiple beans of the same type exist in the application context, @Autowired will result in an ambiguity
     error. To resolve this, the @Qualifier annotation can be used to specify the exact bean to inject.
    Alternatively, the @Resource annotation can be used, which combines the functionality of @Autowired and 
    @Qualifier.

    The @Autowired annotation is also used for self-references, where a bean is injected into itself, although 
    this is considered a fallback mechanism and should be used sparingly.
    For @Bean methods within a configuration class, using @Autowired on fields can lead to self-reference 
    scenarios; in such cases, declaring the @Bean methods as static is a recommended alternative.
    */

    @Autowired
    private AuthorService authorService;

    @GetMapping //specialized version of the RequestMapping annotation
    public List<Author> getAllAuthors() {
        return authorService.getAllAuthors();
    }

    @GetMapping("/{id}") //specialized version of the RequestMapping annotation
    public Author getAuthorById(@PathVariable Long id) {
        return authorService.getAuthorById(id);
    }

    @PostMapping //specialized version of the RequestMapping annotation
    public Author createAuthor(@RequestBody Author author) {
        return authorService.createAuthor(author);
    }

    @DeleteMapping("/{id}") //specialized version of the RequestMapping annotation
    public void deleteAuthor(@PathVariable Long id) {
        authorService.deleteAuthor(id);
    }

    /*
     * Application programming Interface [API] :
     * 
     * An API (Application Programming Interface) is like a menu in a restaurant.

You (the customer) don’t go into the kitchen to cook your food.
Instead, you look at the menu, choose what you want, and place your order.
The waiter takes your order to the kitchen, and the kitchen prepares and sends back your food.
In this analogy:

You = The frontend (like a website or mobile app)
The menu = The API
The kitchen = The backend (server, database, etc.)
The waiter = The API handling the request and response
So, an API is a set of rules and tools that lets different software applications talk to each other. It defines how you can ask for data (like "get user info") and how the system will respond (like sending back user details).

In Spring Boot, the controller layer acts as this API — it receives requests (like from a website or app), processes them, and returns the right data.




what do you mean by set of rules. i have understood that the api servs as per the request but you also say that api is a set of rules. what do you mean by that ?
Great question! When we say an API is a "set of rules", we mean it defines how two pieces of software should communicate with each other — like a contract or a guidebook.

Let’s break it down simply:

Think of an API like a phone number and instruction manual for a service.
Imagine you want to call a pizza shop to order food. But you can’t just call any number and shout "I want pizza!" — you need to:

Call the correct number (e.g., the pizza shop’s hotline)
Speak at the right time (after they answer)
Say things in a way they understand (e.g., "I want a large pepperoni pizza")
Give your address and payment info if asked
If you don’t follow these steps, they won’t know what you want — or they might not help you at all.

An API works the same way. It defines:

Rule	Example in API
What URL to use	https://api.example.com/users
What method to use	GET (to read), POST (to create), etc.
What data to send	{ "name": "John", "email": "john@example.com" }
How to send it	In JSON format, in the request body
What you’ll get back	A success message or user data in JSON
How errors are shown	{ "error": "User not found" } with status 404
👉 So, the "set of rules" means:

The client (like a frontend app) must ask correctly.
The server (your Spring Boot app) knows how to respond.
Both sides agree on the format and behavior.
In Spring Boot:
When you write:

@GetMapping("/users")
public List<User> getUsers() { ... }

You’re defining a rule:
👉 "If someone sends a GET request to /users, return a list of users in JSON."

That’s part of your API’s rulebook.

✅ So, an API isn’t just a messenger — it’s a clear agreement on how to request and receive data. That’s why we call it a set of rules.
     */
}
