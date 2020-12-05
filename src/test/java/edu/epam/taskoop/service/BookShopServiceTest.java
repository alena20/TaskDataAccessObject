package edu.epam.taskoop.service;

import edu.epam.taskoop.entity.*;
import edu.epam.taskoop.exception.DaoException;
import edu.epam.taskoop.exception.ServiceException;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;


public class BookShopServiceTest {
    BookShopService bookShopService = new BookShopService();
    BookShop bookShop = BookShop.getInstance();

    @Test
    public void isAdd() throws DaoException, ServiceException {
        Book book = customBookInfo("someName", "someAuthors", "somePublisher", "GB",
                2010, 570, 150, "HARD");
        List<Book> expected = new ArrayList<>();
        expected.add(book);
        List<Book> result = bookShopService.add(book);
        Assert.assertEquals(result, expected);
    }

    @Test
    public void isDelete() throws DaoException, ServiceException {
        Book book = customBookInfo("someName", "someAuthors", "somePublisher", "GB",
                2010, 570, 150, "HARD");
        List<Book> expected = new ArrayList<>();
        expected.add(book);
        List<Book> result = bookShopService.delete(book);
        Assert.assertEquals(result, expected);
    }

    public Book customBookInfo(String name, String authors, String publisherName, String country, int year, int pages, int price, String bind){
        Book book = new Book();
        Publisher publisher = new Publisher();
        book.setName(name);
        book.setAuthors(authors);
        publisher.setName(publisherName);
        publisher.setCountry(PublishCountry.valueOf(country));
        publisher.setYear(year);
        book.setPublisher(publisher);
        book.setPagesCount(pages);
        book.setPrice(price);
        book.setBindingType(BindingType.valueOf(bind));
        return book;
    }
}