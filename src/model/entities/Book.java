package model.entities;

public class Book {
    private int id;
    private String isbn;
    private String title;
    private String edition;
    private String version;
    private int yearPublished;
    private int totalCopies;
    private int availableCopies;

    public Book() {}

    public Book(int id, String isbn, String title, String edition, String version, int yearPublished, int totalCopies, int availableCopies) {
        this.id = id;
        this.isbn = isbn;
        this.title = title;
        this.edition = edition;
        this.version = version;
        this.yearPublished = yearPublished;
        this.totalCopies = totalCopies;
        this.availableCopies = availableCopies;
    }

    public Book(String isbn, String title, String edition, String version, int yearPublished, int totalCopies, int availableCopies) {
        this.isbn = isbn;
        this.title = title;
        this.edition = edition;
        this.version = version;
        this.yearPublished = yearPublished;
        this.totalCopies = totalCopies;
        this.availableCopies = availableCopies;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEdition() {
        return edition;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public int getYearPublished() {
        return yearPublished;
    }

    public void setYearPublished(int yearPublished) {
        this.yearPublished = yearPublished;
    }

    public int getTotalCopies() {
        return totalCopies;
    }

    public void setTotalCopies(int totalCopies) {
        this.totalCopies = totalCopies;
    }

    public int getAvailableCopies() {
        return availableCopies;
    }

    public void setAvailableCopies(int availableCopies) {
        this.availableCopies = availableCopies;
    }

    @Override
    public String toString() {
        return String.format("%s by %s (ISBN:%s)", title, edition, isbn);
    }
}
