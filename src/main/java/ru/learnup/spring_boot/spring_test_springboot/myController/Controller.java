package ru.learnup.spring_boot.spring_test_springboot.myController;

import org.hibernate.annotations.Synchronize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.learnup.spring_boot.spring_test_springboot.Service.*;
import ru.learnup.spring_boot.spring_test_springboot.entity.Book;
//import ru.learnup.spring_boot.spring_test_springboot.entity.BooksWarehouse;
import ru.learnup.spring_boot.spring_test_springboot.entity.Client;
import ru.learnup.spring_boot.spring_test_springboot.entity.Order;

import javax.persistence.LockModeType;
import javax.transaction.Transactional;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@RestController
@RequestMapping("/api")
public class Controller {
    @Autowired
    public BookService bookService;
    @Autowired
    public ClientService clientService;
    @Autowired
    public OrderService orderService;

    @GetMapping("/books")
    public List<Book> showAllBooks() {
        List<Book> allBooks = bookService.getAllBooks();
        return allBooks;
    }


    @Transactional
    @Lock(LockModeType.OPTIMISTIC)
    public synchronized void buyBooks(Client client, int id, int count) {
        Book b = bookService.getBookById(id);
        if (b.getStockBalance() > count) {
            b.setStockBalance(b.getStockBalance() - count);
            Order order = new Order();
            order.setPurchaseAmount(b.getPrice() * count);
            order.setClient(client);
            orderService.saveOrder(order);
            System.out.println("Ваш заказ, книга \"" + b.getTitle() + "\" в количестве " + count + "шт. принят");
        } else {
            throw new RuntimeException("Извините, товар распродан");

        }
    }

}

