package com.alex.springrestapi.controller;

import com.alex.springrestapi.entity.Book;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class MyController {
    private static List<Book> books = new ArrayList<>();

    @PostMapping(value = {"/add_book"})
    public List<Book> addBook(@RequestBody Book book) {
        books.add(book);
        return books;
    }

    @GetMapping(value = "/get_books")
    public List<Book> getBooks() {
        return books;
    }

    @GetMapping(value = {"/get_book_by_index/{id}"})
    public Book getBookByIndex(@PathVariable("id") int id) {
        return books.get(id);
    }

    @GetMapping(value = {"/get_book_by_name/{name}"})
    public Book getBookByName(@PathVariable("name") String name) {
        Book res = new Book();
        for (Book b : books) {
            if (b.getName().equalsIgnoreCase(name)) {
                res = b;
                break;
            }
        }
        return res;
    }

    @PutMapping(value = {"/edit_book/{id}"})
    public List<Book> editBook(@PathVariable("id") int id, @RequestBody Book book) {
        books.get(id).setName(book.getName());
        return books;
    }

    @DeleteMapping(value = {"/delete_by_index/{id}"})
    public List<Book> deleteByIndex(@PathVariable("id") int index) {
        books.remove(index);
        return books;
    }
}
