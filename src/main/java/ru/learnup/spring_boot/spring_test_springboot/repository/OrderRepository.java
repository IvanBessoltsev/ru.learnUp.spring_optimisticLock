package ru.learnup.spring_boot.spring_test_springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.learnup.spring_boot.spring_test_springboot.entity.Order;



@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
}
