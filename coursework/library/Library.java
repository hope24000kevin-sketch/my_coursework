
import java.util.ArrayList;
//  Library class - manages books, members, and loans
    
    public class Library {
        // Private fields
        private ArrayList<Book> books;    // COMPOSITION - Library owns these
        private ArrayList<Member> members;  // AGGREGATION - Library references these
        
        // Constructor
        public Library() {
            books = new ArrayList<Book>();
            members = new ArrayList<Member>();
        }
        
        // Add a book 
        public void addBook(Book book) {
            if (book != null) {
                books.add(book);
                System.out.println("Added: " + book.getTitle());
            }
        }
        
        // Register a member
        public void registerMember(Member member) {
            if (member != null) {
                members.add(member);
                System.out.println("Registered: " + member.getName());
            }
        }
        
        // Lend a book, enforces business rule
        public void lendBook(String memberId, String isbn) {
            // Find the member
            Member member = findMemberById(memberId);
            if (member == null) {
                System.out.println("ERROR: Member not found with ID: " + memberId);
                return;
            }
            
            // Find the book
            Book book = findBookByIsbn(isbn);
            if (book == null) {
                System.out.println("ERROR: Book not found with ISBN: " + isbn);
                return;
            }
            
            // enforces business rule, Book must be available
            if (book.isAvailable() == false) {
                System.out.println("REJECTED: Book '" + book.getTitle() + "' is currently on loan to another member!");
                return;
            }
            
            // Create the loan
            Loan newLoan = new Loan(member, book);
            
            //  Update book status
            book.setAvailable(false);
            book.setActiveLoan(newLoan);
            
            //  Add loan to member
            member.addLoan(newLoan);
            
            System.out.println("SUCCESS: '" + book.getTitle() + "' lent to " + member.getName() + ". Due: " + newLoan.getDueDate());
        }
        
        // Return a book
        public void returnBook(String isbn) {
            // Find the book
            Book book = findBookByIsbn(isbn);
            if (book == null) {
                System.out.println("ERROR: Book not found with ISBN: " + isbn);
                return;
            }
            
            // Check if it's actually on loan
            if (book.isAvailable() == true) {
                System.out.println("NOTICE: Book '" + book.getTitle() + "' is already available (not on loan)");
                return;
            }
            
            // Get the active loan and remove from member
            Loan activeLoan = book.getActiveLoan();
            if (activeLoan != null) {
                Member borrower = activeLoan.getMember();
                borrower.removeLoan(activeLoan);
                System.out.println("Returned: '" + book.getTitle() + "' from " + borrower.getName());
            }
            
            //  Update book status
            book.setAvailable(true);
            book.setActiveLoan(null);
        }
        
        // Search for book by title (using simple loop)
        public ArrayList<Book> searchByTitle(String titleKeyword) {
            ArrayList<Book> result = new ArrayList<Book>();
            
            for (int i = 0; i < books.size(); i++) {
                Book book = (Book) books.get(i);
                String bookTitle = book.getTitle();
                // Convert both to lowercase for case-insensitive search
                String lowerBookTitle = bookTitle.toLowerCase();
                String lowerKeyword = titleKeyword.toLowerCase();
                
                if (lowerBookTitle.indexOf(lowerKeyword) >= 0) {
                    result.add(book);
                }
            }
            
            return result;
        }
        
        // Helper: Find member by ID (using simple loop)
        private Member findMemberById(String memberId) {
            for (int i = 0; i < members.size(); i++) {
                Member member = (Member) members.get(i);
                if (member.getMemberId().equals(memberId)) {
                    return member;
                }
            }
            return null;
        }
        
        // Helper: Find book by ISBN (using simple loop)
        private Book findBookByIsbn(String isbn) {
            for (int i = 0; i < books.size(); i++) {
                Book book = (Book) books.get(i);
                if (book.getIsbn().equals(isbn)) {
                    return book;
                }
            }
            return null;
        }
        
        // Display all books
        public void displayAllBooks() {
            System.out.println("\n=== LIBRARY CATALOG ===");
            if (books.size() == 0) {
                System.out.println("No books in library.");
            } else {
                for (int i = 0; i < books.size(); i++) {
                    Book book = (Book) books.get(i);
                    System.out.println(book);
                }
            }
        }
        
        // Display all members
        public void displayAllMembers() {
            System.out.println("\n=== LIBRARY MEMBERS ===");
            if (members.size() == 0) {
                System.out.println("No members registered.");
            } else {
                for (int i = 0; i < members.size(); i++) {
                    Member member = (Member) members.get(i);
                    System.out.println(member);
                }
            }
        }
        
        // Display active loans
        public void displayActiveLoans() {
            System.out.println("\n=== ACTIVE LOANS ===");
            boolean hasLoans = false;
            
            for (int i = 0; i < members.size(); i++) {
                Member member = (Member) members.get(i);
                ArrayList<Loan> loans = member.getCurrentLoans();
                
                for (int j = 0; j < loans.size(); j++) {
                    Loan loan = (Loan) loans.get(j);
                    System.out.println("  " + loan);
                    hasLoans = true;
                }
            }
            
            if (hasLoans == false) {
                System.out.println("No active loans.");
            }
        }
    }
    

