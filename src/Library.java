import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Library {
    private String name;
    private Map<String, Book> books;
    private Set<Reader> readers;
    private Librarian librarian;
    private Map<String, Book> borrowedBooks = new HashMap<>();
    private Map<String, Book> removedBooks = new HashMap<>();

    public Library(String name, Map<String, Book> books, Set<Reader> readers, Librarian librarian) {
        this.name = name;
        this.books = new HashMap<>(books);
        this.readers = new HashSet<>(readers);
        this.librarian = librarian;
    }

    public Book searchBook(String name) {
        return this.books.get(name);
    }


    public void borrowBook(Reader reader, String name) {
        Book book = this.books.get(name);
        reader.borrowBook(book);
        book.borrowBook(reader);
        this.borrowedBooks.put(name, book);
    }

    public void returnBook(Reader reader, String name) {
        Book book = this.books.get(name);
        this.borrowedBooks.remove(book);
        reader.returnBook(name);
    }


    public void addBook(Librarian librarian, Book book) {
        this.books.put(book.getName(), book);
    }

    public Reader getBorrowerDetails(Librarian librarian, String name) {
        for (Reader reader : this.readers) {
            if (reader.getBorrowedBooks().containsKey(name)) {
                return reader;
            }
        }
        return null;
    }

    public Map<String, Book> getUserBooks(Librarian librarian, String name) {
        for (Reader reader : this.readers) {
            if (reader.getName() == name) {
                return reader.getBorrowedBooks();
            }
        }
        return null;
    }

    public void removeBook(Librarian librarian, String name) {
        Book book = this.books.get(name);
        this.books.remove(book);
        this.removedBooks.put(name, book);
    }

    public boolean isBookRemoved(Librarian librarian, String name) {
        return this.removedBooks.containsKey(name);
    }

    public void printBooks() {
        System.out.println(this.books);
    }


    public void printReaders() {
        System.out.println(this.readers);
    }


}
