package edu.epam.taskoop.dao;

import edu.epam.taskoop.entity.Book;
import edu.epam.taskoop.entity.BookShop;
import edu.epam.taskoop.service.CheckData;
import edu.epam.taskoop.exception.DaoException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BookDao implements IDao {
    private static final Logger logger = LogManager.getLogger(BookDao.class);
    BookShop bookShop = BookShop.getInstance();


    @Override
    public void addBook(Book book) throws DaoException {
        List<Book> allBooks = bookShop.getBooks();
        if (allBooks.contains(book)) {
            throw new DaoException("This book is already exists!");
        }
        bookShop.add(book);
        logger.info("Add success");
    }

    @Override
    public void deleteBook(Book removingBook) throws DaoException{
        BookShop bookShop = BookShop.getInstance();
        List<Book> allBooks = new ArrayList<>(bookShop.getBooks());
        boolean result = false;
        for (Book book : allBooks) {
            if (isSimilar(book, removingBook)) {
                bookShop.delete(book);
                result = true;
            }
        }
        if (!result) {
            throw new DaoException("Such book doesn't exist!");
        }
        bookShop.delete(removingBook);
    }

    private boolean isSimilar(Book book, Book removingBook) {
        return (book.getName().equals(removingBook.getName()) &&
                book.getAuthors().equals(removingBook.getAuthors()) &&
                book.getPublisher().equals(removingBook.getPublisher()) &&
                book.getBindingType() == removingBook.getBindingType() &&
                book.getPagesCount() == removingBook.getPagesCount() &&
                book.getPrice() == removingBook.getPrice());
    }


    @Override
    public Book findBookById(int id){
        Optional<Book> optionalBook = bookShop.getBooks().stream().filter(book->book.getId() == id).findAny();
        if(optionalBook.isPresent()){
            return optionalBook.get();
        }
        else
            return null;
    }

    @Override
    public void updateBookName(String oldName, String newName) throws DaoException {
        Optional<Book> optionalBook = bookShop.getBooks().stream().filter(book->book.getName() == oldName).findAny();
        if(optionalBook.isPresent()){
            optionalBook.get().setName(newName);
        }else{
            throw new DaoException("Such book doesn't exist!");
        }
    }

    @Override
    public List<Book> findBooksByName(String name) {
        List<Book> allBooks = bookShop.getBooks();
        List<Book> resultList = new ArrayList<>();
        for (Book book : allBooks) {
            if (book.getName().equals(name)) {
                resultList.add(book);
            }
        }
        return resultList;
    }

    @Override
    public List<Book> findBooksByAuthor(String author) {
        List<Book> allBooks = bookShop.getBooks();
        List<Book> resultList = new ArrayList<>();
        for (Book book : allBooks) {
            if (book.getAuthors().contains(author)) {
                resultList.add(book);
            }
        }
        return resultList;
    }

    @Override
    public List<Book> findBooksByYear(int year) {
        List<Book> allBooks = bookShop.getBooks();
        List<Book> resultList = new ArrayList<>();
        for (Book book : allBooks) {
            if (String.valueOf(book.getPublisher().getYear()).equals(year)) {
                resultList.add(book);
            }
        }
        return resultList;
    }

    @Override
    public List<Book> findBooksByPagesCount(int pages) {
        List<Book> allBooks = bookShop.getBooks();
        List<Book> resultList = new ArrayList<>();
        for (Book book : allBooks) {
            if (String.valueOf(book.getPagesCount()).equals(pages)) {
                resultList.add(book);
            }
        }
        return resultList;
    }

    @Override
    public List<Book> findBooksByPublisherName(String name) {
        List<Book> allBooks = bookShop.getBooks();
        List<Book> resultList = new ArrayList<>();
        for (Book book : allBooks) {
            if (book.getPublisher().getName().equals(name)) {
                resultList.add(book);
            }
        }
        return resultList;
    }

    @Override
    public List<Book> sortBooksById() {
        List<Book> allBooks = bookShop.getBooks();
        List<Book> sortedList = new ArrayList<>(allBooks);
        sortedList.sort(new Book.BookIdComparator());
        return sortedList;
    }

    @Override
    public List<Book> sortBooksByName() {
        List<Book> allBooks = bookShop.getBooks();
        List<Book> sortedList = new ArrayList<>(allBooks);
        sortedList.sort(new Book.BookTitleComparator());
        return sortedList;
    }

    @Override
    public List<Book> sortBooksByAuthors() {
        List<Book> allBooks = bookShop.getBooks();
        List<Book> sortedList = new ArrayList<>(allBooks);
        sortedList.sort(new Book.BookAuthorsComparator());
        return sortedList;
    }

    @Override
    public List<Book> sortBooksByYear() {
        List<Book> allBooks = bookShop.getBooks();
        List<Book> sortedList = new ArrayList<>(allBooks);
        sortedList.sort(new Book.BookYearComparator());
        return sortedList;
    }

    @Override
    public List<Book> sortBooksByPages() {
        List<Book> allBooks = bookShop.getBooks();
        List<Book> sortedList = new ArrayList<>(allBooks);
        sortedList.sort(new Book.BookPagesComparator());
        return sortedList;
    }

    @Override
    public List<Book> sortBooksByPublisherName() {
        List<Book> allBooks = bookShop.getBooks();
        List<Book> sortedList = new ArrayList<>(allBooks);
        sortedList.sort(new Book.BookPublisherNameComparator());
        return sortedList;
    }

}
