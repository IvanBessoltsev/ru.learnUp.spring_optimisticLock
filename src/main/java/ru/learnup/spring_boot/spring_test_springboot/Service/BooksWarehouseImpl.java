package ru.learnup.spring_boot.spring_test_springboot.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.learnup.spring_boot.spring_test_springboot.entity.Book;
import ru.learnup.spring_boot.spring_test_springboot.entity.BooksWarehouse;
import ru.learnup.spring_boot.spring_test_springboot.repository.BooksWarehouseRepository;

import java.util.List;
import java.util.Optional;

@Service
public class BooksWarehouseImpl implements BooksWarehouseService {
    @Autowired
    public BooksWarehouseRepository booksWarehouseRepository;

    @Override
    public List<BooksWarehouse> getAllBooks() {
        return booksWarehouseRepository.findAll();
    }

    @Override
    public BooksWarehouse getBooksWarehouseById(int id) {
        BooksWarehouse booksWarehouse = null;
        Optional<BooksWarehouse> b = booksWarehouseRepository.findById(id);
        if (b.isPresent()) {
            booksWarehouse = b.get();
        }
        return booksWarehouse;
    }

    @Override
    public void saveBookWarehouse(BooksWarehouse booksWarehouse) {
        booksWarehouseRepository.save(booksWarehouse);
    }

    @Override
    public void deleteBookWarehouse(int id) {
        booksWarehouseRepository.deleteById(id);
    }
}
