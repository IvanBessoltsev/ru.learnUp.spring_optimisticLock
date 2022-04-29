package ru.learnup.spring_boot.spring_test_springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import ru.learnup.spring_boot.spring_test_springboot.Service.*;
import ru.learnup.spring_boot.spring_test_springboot.entity.Authors;
import ru.learnup.spring_boot.spring_test_springboot.entity.Book;
import ru.learnup.spring_boot.spring_test_springboot.entity.Client;
import ru.learnup.spring_boot.spring_test_springboot.myController.Controller;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        //----------------Создаем контекст
        ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
        Controller controller = context.getBean(Controller.class);
        //--------------------------------
        BookService bookService = context.getBean(BookServiceImpl.class);
        AuthorsService authorsService = context.getBean(AuthorsServiceImpl.class);
        OrderService orderService = context.getBean(OrderServiceImpl.class);
        ClientService clientService = context.getBean(ClientServiceImpl.class);
        //-----------------------Заполняем таблицы
        Book book = new Book("Война и мир", 1917, 333, 350, 3);
        Authors authors = new Authors("Л.Н.Толстой");
        book.setAuthorID(authors);
        //-----------------------Создаем клиентов
        Client client1 = new Client("Иван", "11.11.2011");
        Client client2 = new Client("Вова", "12.12.2012");
        //-----------------------Запускаем потоки
        new Thread(() -> {
            controller.buyBooks(client1, 54, 2);
        }).start();

        new Thread(() -> {
            controller.buyBooks(client2, 54, 2);
        }).start();


    }
}
//        BooksWarehouseService booksWarehouseService = context.getBean(BooksWarehouseImpl.class);
//        BooksWarehouse booksWarehouse = new BooksWarehouse(1);
//        booksWarehouse.setBookID(book);
//       //-----------------------Вызываем методы
//        System.out.println(bookService.getBookById(45));
//        System.out.println(booksWarehouseService.getBooksWarehouseById(46));
//        System.out.println(bookService.getAllBooks());
//        System.out.println(booksWarehouseService.getAllBooks());
//        booksWarehouseService.saveBookWarehouse(booksWarehouse);
//        System.out.println(booksWarehouseService.getBooksWarehouseById(1));
//        System.out.println(bookService.getAllBooks());
//        authorsService.saveAuthors(new Authors("И.С.Тургенев"));
//        booksWarehouseService.getBooksWarehouseById(40);
//        bookService.saveBook(book);
//        authorsService.deleteAuthor(41);