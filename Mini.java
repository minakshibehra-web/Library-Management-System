class Book {
    private String title;
    private String author;
    private boolean isAvailable;

    // Constructor
    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.isAvailable = true;
    }

    // Getter methods
    public String getTitle() {
        return title;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean status) {
        isAvailable = status;
    }

    public void displayBook() {
        System.out.println(title + " by " + author + " | Available: " + isAvailable);
    }
}

class Library {
    private Book[] books;

    // Constructor
    public Library() {
        books = new Book[3];

        books[0] = new Book("Java Basics", "James Gosling");
        books[1] = new Book("Data Structures", "Mark Allen");
        books[2] = new Book("Operating System", "Galvin");
    }

    // Search book
    public void searchBook(String title) {
        for (Book b : books) {
            if (b.getTitle().equalsIgnoreCase(title)) {
                System.out.println("Book Found:");
                b.displayBook();
                return;
            }
        }
        System.out.println("Book not found");
    }

    // Issue book
    public void issueBook(String title) {
        for (Book b : books) {
            if (b.getTitle().equalsIgnoreCase(title)) {
                if (b.isAvailable()) {
                    b.setAvailable(false);
                    System.out.println("Book issued successfully");
                } else {
                    System.out.println("Book already issued");
                }
                return;
            }
        }
        System.out.println("Book not found");
    }

    // Return book
    public void returnBook(String title) {
        for (Book b : books) {
            if (b.getTitle().equalsIgnoreCase(title)) {
                b.setAvailable(true);
                System.out.println("Book returned successfully");
                return;
            }
        }
        System.out.println("Book not found");
    }

    // Display all books
    public void displayBooks() {
        System.out.println("\nLibrary Books:");
        for (Book b : books) {
            b.displayBook();
        }
    }
}

public class Mini {   // ✅ Fixed class name
    public static void main(String[] args) {

        Library lib = new Library();

        lib.displayBooks();

        System.out.println("\nSearching for Java Basics:");
        lib.searchBook("Java Basics");

        System.out.println("\nIssuing Java Basics:");
        lib.issueBook("Java Basics");

        System.out.println("\nIssuing Java Basics again:");
        lib.issueBook("Java Basics");

        System.out.println("\nReturning Java Basics:");
        lib.returnBook("Java Basics");

        System.out.println("\nFinal Book Status:");
        lib.displayBooks();
    }
}