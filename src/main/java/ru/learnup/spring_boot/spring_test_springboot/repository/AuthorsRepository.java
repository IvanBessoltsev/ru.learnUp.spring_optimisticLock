package ru.learnup.spring_boot.spring_test_springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.learnup.spring_boot.spring_test_springboot.entity.Authors;


@Repository
public interface AuthorsRepository extends JpaRepository<Authors, Integer> {
}
