import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books;
    private List<Member> members;

    public Library() {
        books = new ArrayList<>();
        members = new ArrayList<>();
    }

    // Adds a book to the library
    public void addBook(Book book) {
        Book validateBook = findBookByIsbn(book.getIsbn());
        // Checks if the isbn is not already present
        if (validateBook != null) {
            System.out.println("CANNOT ADD BOOK. Book with ISBN: " + validateBook.getIsbn() + " already exists");
        } else {

            books.add(book);

        }

    }

    // Register a member to the library
    public void registerMember(Member member) {
        Member validateMember = findMemberById(member.getId());
        // Checks if the member is already registered
        if (validateMember != null) {
            System.out.println("CANNOT ADD MEMBER. Member with ID: " + validateMember.getId() + " already exists");
        } else {
            members.add(member);
        }
    }

    // List of available books
    public List<Book> getAvailableBooks() {
        List<Book> availableBooks = new ArrayList<>();
        for (Book book : books) {
            if (!book.isBorrowed()) {
                availableBooks.add(book);
            }
        }
        return availableBooks;
    }

    // Member borrows a book
    public boolean borrowBook(String memberId, String isbn) {
        Member member = findMemberById(memberId);
        Book book = findBookByIsbn(isbn);
        if (member == null) {
            System.out.println("Member not found: " + memberId);
        } else if (book == null) {
            System.out.println("\nISBN for borrowed book not found: " + isbn + " for member " + member.getName());
        } else {
            return member.borrowBook(book);
        }
        return false;

    }

    // Member returns a book
    public boolean returnBook(String memberId, String isbn) {
        Member member = findMemberById(memberId);
        Book book = findBookByIsbn(isbn);
        if (member == null) {
            System.out.println("Member not found: " + memberId);
        } else if (book == null) {
            System.out.println("ISBN not found: " + isbn + " for member " + member.getName());
        } else {
            return member.returnBook(book);
        }
        return false;
    }

    // List of books borrowed by a member
    public List<Book> getBooksBorrowedByMember(String memberId) {
        Member member = findMemberById(memberId);
        if (member != null) {
            return member.getBorrowedBooks();
        }
        return new ArrayList<>();
    }

    // Find a member by ID
    private Member findMemberById(String id) {
        for (Member member : members) {
            if (member.getId().equals(id)) {
                return member;
            }
        }
        return null;
    }

    // Finds book by ISBN
    private Book findBookByIsbn(String isbn) {
        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) {
                return book;
            }
        }
        return null;
    }
}
