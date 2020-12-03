package edu.epam.taskoop.entity;

public class Book {
    private static int Id = 1;
    private final int id = Id++;
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
    public <T> T getParameretSearch(T parameter){
        return parameter;
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
}
