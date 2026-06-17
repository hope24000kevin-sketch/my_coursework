// Book class: represents a book in the library
public class Book {
    // Private fields
    private String isbn;
    private String title;
    private String author;
    private boolean available;
    private Loan activeLoan;  // Track current loan if any
    
    // Constructor 1 - takes ISBN and title only
    public Book(String isbn, String title) {
        this.isbn = isbn;
        this.title = title;
        this.author = "Unknown Author";
        this.available = true;
        this.activeLoan = null;
    }
    
    // Constructor 2 - takes all details 
    public Book(String isbn, String title, String author) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.available = true;
        this.activeLoan = null;
    }
    
    // GETTERS
    public String getIsbn() {
        return isbn;
    }
    
    public String getTitle() {
        return title;
    }
    
    public String getAuthor() {
        return author;
    }
    
    public boolean isAvailable() {
        return available;
    }
    
    public Loan getActiveLoan() {
        return activeLoan;
    }
    
    // SETTERS
    public void setAvailable(boolean available) {
        this.available = available;
    }
    
    public void setActiveLoan(Loan activeLoan) {
        this.activeLoan = activeLoan;
    }
    
    // toString method
    public String toString() {
        String status;
        if (available == true) {
            status = "Yes";
        } else {
            status = "No";
        }
        return "Book[ISBN=" + isbn + ", Title='" + title + "', Author='" + author + "', Available=" + status + "]";
    }
}
