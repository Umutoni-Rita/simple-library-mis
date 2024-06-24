import java.util.ArrayList;
import java.util.List;

public class Member {
    private String id;
    private String name;
    private List<Book> borrowedBooks;

    public Member(String id, String name) {
        this.id = id;
        this.name = name;
        this.borrowedBooks = new ArrayList<>();
    }

    // Getters
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    // Borrow a book
    public boolean borrowBook(Book book) {
        // a member cannot borrow more than five books
        if (borrowedBooks.size() < 5 && !book.isBorrowed()) {
            borrowedBooks.add(book);
            book.setBorrowed(true);
            return true;
        }
        return false;
    }

    // Return a book
    public boolean returnBook(Book book) {
        if (borrowedBooks.remove(book)) {
            book.setBorrowed(false);
            return true;
        }
        return false;
    }
}
