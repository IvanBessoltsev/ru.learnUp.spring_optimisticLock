package ru.learnup.spring_boot.spring_test_springboot.entity;


import javax.persistence.*;

@Entity
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private int bookID;

    @Column(name = "title")
    private String title;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "author_id")
    private Authors authorID;

    @Column(name = "age")
    private int yearOfRelease;

    @Column(name = "count_page")
    private int countPage;

    @Column(name = "price")
    private double price;


    public Book() {
    }

    @Override
    public String toString() {
        return "\nBooks{" +
                "bookID=" + bookID +
                ", title='" + title + '\'' +
                ", authorID=" + authorID +
                ", yearOfRelease=" + yearOfRelease +
                ", countPage=" + countPage +
                ", price=" + price +
                '}';
    }

    public Book(String title, int yearOfRelease, int countPage, double price) {
        this.title = title;
        this.yearOfRelease = yearOfRelease;
        this.countPage = countPage;
        this.price = price;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Authors getAuthorID() {
        return authorID;
    }

    public void setAuthorID(Authors authorID) {
        this.authorID = authorID;
    }

    public int getYearOfRelease() {
        return yearOfRelease;
    }

    public void setYearOfRelease(int yearOfRelease) {
        this.yearOfRelease = yearOfRelease;
    }

    public int getCountPage() {
        return countPage;
    }

    public void setCountPage(int countPage) {
        this.countPage = countPage;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}

