import java.util.ArrayList;

// Member class - represents a library member
public class Member {
    // Private fields
    private String memberId;
    private String name;
    private ArrayList<Loan> currentLoans;  // Using ArrayList directly
    
    // Constructor
    public Member(String memberId, String name) {
        this.memberId = memberId;
        this.name = name;
        this.currentLoans = new ArrayList<Loan>();  // Empty list
    }
    
    // GETTERS
    public String getMemberId() {
        return memberId;
    }
    
    public String getName() {
        return name;
    }
    
    // Returns the list of loans
    public ArrayList<Loan> getCurrentLoans() {
        return currentLoans;
    }
    
    // Adds a loan to member's list
    public void addLoan(Loan loan) {
        if (loan != null) {
            currentLoans.add(loan);
        }
    }
    
    // removes a loan from member's list
    public void removeLoan(Loan loan) {
        currentLoans.remove(loan);
    }
    
    // Count active loans
    public int getActiveLoanCount() {
        return currentLoans.size();
    }
    
    // toString method
    public String toString() {
        return "Member[ID=" + memberId + ", Name='" + name + "', Active Loans=" + currentLoans.size() + "]";
    }
}
