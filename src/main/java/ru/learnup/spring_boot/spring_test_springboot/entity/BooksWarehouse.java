//package ru.learnup.spring_boot.spring_test_springboot.entity;
//
//import javax.persistence.*;
//
//@Entity
//@Table(name = "book_warehouse")
//public class BooksWarehouse {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id")
//    private int warehouseID;
//
//
//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "book_id")
//    private Book bookID;
//
//    @Column(name = "stock_balance")
//    private int stockBalance;
//
//    public BooksWarehouse() {
//    }
//
//
//    public BooksWarehouse(int stockBalance) {
//        this.stockBalance = stockBalance;
//    }
//
//    public Book getBookID() {
//        return bookID;
//    }
//
//    public void setBookID(Book bookID) {
//        this.bookID = bookID;
//    }
//
//    public int getStockBalance() {
//        return stockBalance;
//    }
//
//    public void setStockBalance(int stockBalance) {
//        this.stockBalance = stockBalance;
//    }
//
//}
//
