import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        Map<String, Book> books = new HashMap<>();
        Set<Reader> readers = new HashSet<>();

        Librarian librarian = new Librarian("Chandu");
        Library library = new Library("Granthalay", books, readers, librarian);


        System.out.println("Enter Your Choice ?");
        int choice = scanner.nextInt();

        if (choice == 1) {
            System.out.println("Enter Book name");
            String book = scanner.next();
            library.addBook(librarian, new Book(book));
            System.out.println("Book added!!!");

            System.out.println("\n\n\n");
            library.printBooks();
        }
    }
}