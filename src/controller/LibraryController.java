package controller;

import dao.BookDao;
import model.entities.Book;

import java.sql.SQLException;
import java.util.List;

public class LibraryController {
    public Book addBook(String isbn, String title, String edition, String version, int yearPublished, int totalCopies) throws SQLException {
        Book book = new Book(isbn, title, edition, version, yearPublished, totalCopies, totalCopies);
        return BookDao.addBook(book);
    }

    public List<Book> listBooks() throws SQLException {
        return BookDao.getAllBooks();
    }

    public List<Book> searchBooks(String titleQuery) throws SQLException {
        return BookDao.searchByTitle(titleQuery);
    }
}
