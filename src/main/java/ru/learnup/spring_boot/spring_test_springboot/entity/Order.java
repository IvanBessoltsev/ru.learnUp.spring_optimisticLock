package ru.learnup.spring_boot.spring_test_springboot.entity;

import javax.persistence.*;

@Entity
@Table(name = "orders")
public class Order {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private int order;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "client_id")
    private Client client;

    @Column(name = "purchase_amount")
    private double purchaseAmount;

    public Order() {
    }


    public Order(double purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Client getClient() {
        return client;
    }


}