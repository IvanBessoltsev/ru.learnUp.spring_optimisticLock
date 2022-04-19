package ru.learnup.spring_boot.spring_test_springboot.myController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.learnup.spring_boot.spring_test_springboot.Service.BookService;
import ru.learnup.spring_boot.spring_test_springboot.Service.BookServiceImpl;
import ru.learnup.spring_boot.spring_test_springboot.entity.Book;

import java.util.List;

@RestController
@RequestMapping("/api")
public class Controller {

    @Autowired
    public BookService bookService;

    @GetMapping("/books")
    public List<Book> showAllBooks() {
        List<Book> allBooks = bookService.getAllBooks();
        return allBooks;
    }


}

