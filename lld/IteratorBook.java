package lld;
import java.util.*;
class Book {
    String name;
    Book(String name) { this.name = name; }
    String getName() { return name; }
}


interface Iterator<T>{
    T next();
    boolean hasNext();
}

interface BookCollection {
    Iterator<Book> createIterator();
}

class BookIterator implements Iterator<Book> {
    private List<Book> books;
    private int index = 0;

    BookIterator(List<Book> books) {
        this.books = books;
    }

    public boolean hasNext() {
        return index < books.size();
    }

    public Book next() {
        return books.get(index++);
    }
}

class Library implements BookCollection {
    private List<Book> books = new ArrayList<>();

    public void addBook(Book b) {
        books.add(b);
    }

    public Iterator<Book> createIterator() {
        return new BookIterator(books);
    }
}
public class IteratorBook{
    public static void main(String args[]){
Library lib = new Library();
        lib.addBook(new Book("DSA"));
        lib.addBook(new Book("OS"));
        lib.addBook(new Book("DBMS"));

        Iterator<Book> it = lib.createIterator();

        while(it.hasNext()) {
            System.out.println(it.next().getName());
        }
    }
}