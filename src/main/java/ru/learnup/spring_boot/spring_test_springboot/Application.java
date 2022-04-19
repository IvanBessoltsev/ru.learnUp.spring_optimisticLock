package ru.learnup.spring_boot.spring_test_springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import ru.learnup.spring_boot.spring_test_springboot.Service.*;
import ru.learnup.spring_boot.spring_test_springboot.entity.Authors;
import ru.learnup.spring_boot.spring_test_springboot.entity.Book;
import ru.learnup.spring_boot.spring_test_springboot.entity.BooksWarehouse;
import ru.learnup.spring_boot.spring_test_springboot.myController.Controller;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        //----------------Создаем контекст
        ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
        //--------------------------------
        BookService bookService = context.getBean(BookServiceImpl.class);
        AuthorsService authorsService = context.getBean(AuthorsServiceImpl.class);
        BooksWarehouseService booksWarehouseService = context.getBean(BooksWarehouseImpl.class);
        OrderService orderService = context.getBean(OrderServiceImpl.class);
        ClientService clientService = context.getBean(ClientServiceImpl.class);
        //-----------------------Заполняем таблицы
        Book book = new Book("Евгений Онегин", 1823, 250, 100);
        Authors authors = new Authors("А.С.Пушкин");
        BooksWarehouse booksWarehouse = new BooksWarehouse(1);
        book.setAuthorID(authors);
        booksWarehouse.setBookID(book);
        //-----------------------Вызываем методы
        bookService.saveBook(book);
        System.out.println(bookService.getAllBooks());
        System.out.println(booksWarehouseService.getAllBooks());
        booksWarehouseService.saveBookWarehouse(booksWarehouse);
        System.out.println(booksWarehouseService.getBooksWarehouseById(1));
        System.out.println(bookService.getAllBooks());
        authorsService.saveAuthors(new Authors("И.С.Тургенев"));

    }
}
