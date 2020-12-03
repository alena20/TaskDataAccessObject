package edu.epam.taskoop.service;

import edu.epam.taskoop.entity.Book;
import edu.epam.taskoop.entity.BookShop;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SortService {

    public List<Book> sortByAuthors(BookShop bookShop) {
        List<Book> result = bookShop.getBooks();
        return result.stream()
                .sorted(Comparator.comparing(Book::getAuthors))
                .collect(Collectors.toList());
    }

    public List<Book> sortByName(BookShop bookShop) {
        List<Book> result = bookShop.getBooks();
        return result.stream()
                .sorted(Comparator.comparing(Book::getName))
                .collect(Collectors.toList());
    }

    public List<Book> sortByPrice(BookShop bookShop) {
        List<Book> result = bookShop.getBooks();
        return result.stream()
                .sorted(Comparator.comparing(Book::getPrice))
                .collect(Collectors.toList());
    }

    public List<Book> sortByBindingType(BookShop bookShop) {
        List<Book> result = bookShop.getBooks();
        return result.stream()
                .sorted(Comparator.comparing(Book::getBindingType))
                .collect(Collectors.toList());
    }
}
