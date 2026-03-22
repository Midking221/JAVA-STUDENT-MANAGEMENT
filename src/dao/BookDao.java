package dao;

import model.entities.Book;

import java.util.ArrayList;
import java.util.List;

public class BookDao {
    private static final List<Book> books = new ArrayList<>();
    private static int nextId = 1;

    static {
        books.add(new Book(nextId++, "978-0134685991", "Effective Java", "3rd", "1.0", 2018, 5, 5));
        books.add(new Book(nextId++, "978-0596009205", "Head First Java", "2nd", "1.0", 2005, 4, 4));
    }

    public static Book addBook(Book book) {
        book.setId(nextId++);
        books.add(book);
        return book;
    }

    public static List<Book> getAllBooks() {
        return new ArrayList<>(books);
    }

    public static List<Book> searchByTitle(String titlePattern) {
        String lower = titlePattern == null ? "" : titlePattern.toLowerCase();
        List<Book> result = new ArrayList<>();
        for (Book b : books) {
            if (b.getTitle().toLowerCase().contains(lower)) {
                result.add(b);
            }
        }
        return result;
    }
}
