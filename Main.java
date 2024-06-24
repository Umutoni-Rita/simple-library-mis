import java.util.List;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();

        // Add books
        Book book1 = new Book("978", "Effective Java", List.of("Joshua Bloch", "John Doe"), 2008);
        Book book2 = new Book("977", "Python Clean Code", List.of("Danielle C. Martin"), 2018);
        Book book3 = new Book("976", "Java Clean Code", List.of("Robert C. Kiyosaki"), 2020);
        Book book4 = new Book("975", "JS Clean Code", List.of("John M. Martha"), 2023);
        Book book5 = new Book("974", "PHP Clean Code", List.of("Robert C. Martin"), 1995);
        Book book6 = new Book("973", "C++ Clean Code", List.of("Robert C. Martin"), 2010);
        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);
        library.addBook(book4);
        library.addBook(book5);
        library.addBook(book6);

        // Register members
        Member member1 = new Member("1", "Hubert Ganza");
        Member member2 = new Member("2", "Leslie Doe");
        library.registerMember(member1);
        library.registerMember(member2);

        // Display available books before borrowing
        System.out.println("\nAvailable books:");
        for (Book book : library.getAvailableBooks()) {
            System.out.println(book.getTitle());
        }

        // Borrow books
        library.borrowBook("1", "111"); // this will give an error message
        library.borrowBook("2", "978");
        library.borrowBook("2", "977");
        library.borrowBook("2", "976");
        library.borrowBook("2", "975");
        library.borrowBook("2", "974");
        // this book will not be included since a member can only borrow 5 books at a
        // time
        library.borrowBook("2", "973");

        // Display available books after borrowing
        System.out.println("\nAvailable books:");
        for (Book book : library.getAvailableBooks()) {
            System.out.println(book.getTitle());
        }

        // Display books borrowed by member1
        System.out.println("\nBooks borrowed by Hubert Ganza:");
        for (Book book : library.getBooksBorrowedByMember("1")) {
            System.out.println(book.getIsbn() + ": " + book.getTitle());
        }

        // Display books borrowed by member2
        System.out.println("\nBooks borrowed by Leslie Doe:");
        for (Book book : library.getBooksBorrowedByMember("2")) {
            System.out.println(book.getIsbn() + ": " + book.getTitle());
        }

        // Return a book
        library.returnBook("2", "976");
        library.returnBook("2", "977");

        // Display available books after return
        System.out.println("\nAvailable books after return:");
        for (Book book : library.getAvailableBooks()) {
            System.out.println(book.getTitle());
        }
    }
}
