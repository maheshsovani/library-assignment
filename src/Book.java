public class Book {
    private String name;
    private boolean isBorrwed;
    private Reader reader;

    Book(String name) {
        this.name = name;
    }

     String getName() {
        return name;
    }

     void changeReader(Reader reader) {
        this.reader = reader;
    }

     void borrowBook(Reader reader) {
        this.isBorrwed = true;
        changeReader(reader);
    }

     void returnBook() {
        this.isBorrwed = false;
        this.reader = null;
    }

    @Override
    public String toString() {
        if (isBorrwed) {
            return "Name : " + this.getName() + "\nisBorrowed : " + this.isBorrwed + "\nReader :" + reader.getName();
        }
        return "Name : " + this.getName() + "\nisBorrowed : " + this.isBorrwed + "\nReader : Null";
    }

}
