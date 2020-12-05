package edu.epam.taskoop.main;

import edu.epam.taskoop.dao.BookDao;
import edu.epam.taskoop.entity.*;
import edu.epam.taskoop.exception.DaoException;
import edu.epam.taskoop.exception.FileReaderException;
import edu.epam.taskoop.exception.ServiceException;
import edu.epam.taskoop.reader.FileReader;
import edu.epam.taskoop.service.BookShopService;
import edu.epam.taskoop.service.SortService;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String [] args) throws FileReaderException, DaoException, ServiceException {
        FileReader reader = new FileReader();
        BookShop bookShop = new BookShop((ArrayList<Book>) reader.readFromFile());
        logger.info("books "+bookShop.getBooks().toString());
        BookShopService bookShopService = new BookShopService();
        Book book = customBookInfo("someName", "someAuthors", "somePublisher", "GB",
                2010, 570, 150, "HARD");
        bookShopService.add(book);
        bookShopService.update("someName", "someDifferentName");
        bookShopService.delete(book);
        SortService sortService = new SortService();
        ArrayList<Book> list1,list2,list3,list4,list5 = new ArrayList<Book>();
        list1 = (ArrayList<Book>) sortService.sortByName();
        logger.info("sortByName "+list1.toString());
        list2 = (ArrayList<Book>) sortService.sortByAuthors();
        logger.info("sortByAuthors "+list1.toString());
        list3 = (ArrayList<Book>) sortService.sortByPagesCount();
        logger.info("sortByPrice "+list1.toString());
        list4 = (ArrayList<Book>) sortService.sortBooksByPublisherName();
        logger.info("sortByBindingType "+list1.toString());
        list5 = (ArrayList<Book>) sortService.sortBooksByYear();
        logger.info("sortByBindingType "+list1.toString());
    }

    public static Book customBookInfo(String name, String authors, String publisherName, String country, int year, int pages, int price, String bind){
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
