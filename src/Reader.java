import java.util.HashMap;
import java.util.Map;

public class Reader {
    private String name;
    private Map<String, Book> borrowedBooks = new HashMap<>();

    public Reader(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return this.getName();
    }

    public void borrowBook(Book book) {
        this.borrowedBooks.put(book.getName(), book);
        System.out.println("Book was successfully borrowed");
    }

    public boolean doesIhaveBook(String name) {
        return this.borrowedBooks.containsKey(name);
    }

    public void returnBook(String name) {
        this.borrowedBooks.remove(name);
    }

    public Map<String, Book> getBorrowedBooks() {
        return borrowedBooks;
    }
}
