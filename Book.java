import java.util.List;

public class Book {

    /**
     * Encapsulation is achieved through using
     * Private modifiers for fields
     */

    private String isbn;
    private String title;
    // A book can have one or more authors
    private List<String> authors;
    private int publicationYear;
    private boolean isBorrowed;

    public Book(String isbn, String title, List<String> authors, int publicationYear) {
        this.isbn = isbn;
        this.title = title;
        this.authors = authors;
        this.publicationYear = publicationYear;
        this.isBorrowed = false;
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

    public List<String> getAuthors() {
        return authors;
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    public boolean isBorrowed() {
        return isBorrowed;
    }

    public void setBorrowed(boolean isBorrowed) {
        this.isBorrowed = isBorrowed;
    }

    @Override
    public String toString() {
        return "Book [isbn=" + isbn + ", title=" + title + ", authors=" + authors + ", publicationYear="
                + publicationYear + "]";
    }

}
