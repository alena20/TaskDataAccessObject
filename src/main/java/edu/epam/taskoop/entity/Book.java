package edu.epam.taskoop.entity;

import java.util.Comparator;

public class Book {
    private static int Id = 1;
    private int id = Id++;
    private String name;
    private String authors;
    private Publisher publisher;
    private int pagesCount;
    private double price;
    private BindingType bindingType;

    public Book(){ }

    public Book(String name, String authors, Publisher publisher, int pagesCount, int price, BindingType bindingType) {
        this.name = name;
        this.authors = authors;
        this.publisher = publisher;
        this.pagesCount = pagesCount;
        this.price = price;
        this.bindingType = bindingType;
    }

    public int getId(){ return id;}

    public void setId(int id){ this.id = id;}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthors() {
        return authors;
    }

    public void setAuthors(String authors) {
        this.authors = authors;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public int getPagesCount() {
        return pagesCount;
    }

    public void setPagesCount(int pagesCount) {
        this.pagesCount = pagesCount;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public BindingType getBindingType() {
        return bindingType;
    }

    public void setBindingType(BindingType bindingType) {
        this.bindingType = bindingType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return id == book.id &&
                pagesCount == book.pagesCount &&
                price == book.price &&
                getName().equals(book.name) &&
                getAuthors().equals(book.authors) &&
                publisher.equals(book.publisher) &&
                bindingType == book.bindingType;

    }

    @Override
    public int hashCode() {
        int result = 31 * id;
        result = 31 * result + (name != null ?name.hashCode() : 0);
        result = 31 * result + (authors != null ? authors.hashCode() : 0);
        result = 31 * result + (publisher != null ? publisher.hashCode() : 0);
        result = 31 * result + pagesCount;
        result = 31 * result + (int)price;
        result = 31 * result + (bindingType != null ? bindingType.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Book{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", authors='").append(authors).append('\'');
        sb.append(", publisher=").append(publisher);
        sb.append(", pagesCount=").append(pagesCount);
        sb.append(", price=").append(price);
        sb.append(", bindingType=").append(bindingType);
        sb.append('}');
        return sb.toString();
    }

    public static class BookAuthorsComparator implements Comparator<Book> {
        @Override
        public int compare(Book o1, Book o2) {
            return o1.getAuthors().compareTo(o2.getAuthors());
        }
    }

    public static class BookIdComparator implements Comparator<Book> {
        @Override
        public int compare(Book o1, Book o2) {
            return o1.getPagesCount() - o2.getPagesCount();
        }
    }

    public static class BookPagesComparator implements Comparator<Book> {
        @Override
        public int compare(Book o1, Book o2) {
            return o1.getPagesCount() - o2.getPagesCount();
        }
    }

    public static class BookPublisherNameComparator implements Comparator<Book> {
        @Override
        public int compare(Book o1, Book o2) {
            return o1.getPublisher().getName().compareTo(o2.getPublisher().getName());
        }
    }

    public static class BookTitleComparator implements Comparator<Book> {
        @Override
        public int compare(Book o1, Book o2) {
            return o1.getName().compareTo(o2.getName());
        }
    }

    public static class BookYearComparator implements Comparator<Book> {
        @Override
        public int compare(Book o1, Book o2) { return o1.getPublisher().getYear() - o2.getPublisher().getYear(); }
    }
}
