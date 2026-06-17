// Loan class - represents a borrowing transaction

public class Loan {
    // Private fields
    private Member member;
    private Book book;
    private String borrowDate;  // Using String instead of LocalDate
    private String dueDate;
    
    // Constructor 1 - takes all details
    public Loan(Member member, Book book, String borrowDate, String dueDate) {
        this.member = member;
        this.book = book;
        this.borrowDate = borrowDate;
        this.dueDate = dueDate;
    }
    
    // Constructor 2 - use current date 
    public Loan(Member member, Book book) {
        this.member = member;
        this.book = book;
        // date using today's date in dd/MM/yyyy format
        java.util.Date today = new java.util.Date();
        this.borrowDate = today.toString();
        // due date: 14 days later 
        long millisecondsInDay = 24 * 60 * 60 * 1000;
        long dueMilliseconds = today.getTime() + (14 * millisecondsInDay);
        java.util.Date dueDateObj = new java.util.Date(dueMilliseconds);
        this.dueDate = dueDateObj.toString();
    }
    
    // GETTERS
    public Member getMember() {
        return member;
    }
    
    public Book getBook() {
        return book;
    }
    
    public String getBorrowDate() {
        return borrowDate;
    }
    
    public String getDueDate() {
        return dueDate;
    }
    
    // toString method
    public String toString() {
        return "Loan[Member='" + member.getName() + "', Book='" + book.getTitle() + "', Borrowed=" + borrowDate + ", Due=" + dueDate + "]";
    }
}
