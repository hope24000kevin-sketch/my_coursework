//  LibraryDemo: demonstrates the library system

public class LibraryDemo {
    public static void main(String[] args) {
        System.out.println("=== LIBRARY MANAGEMENT SYSTEM DEMO ===\n");
        
        // Create the library
        Library library = new Library();
        
        // Create books
        Book book1 = new Book("978-0134685991", "Effective Java", "Joshua Bloch");
        Book book2 = new Book("978-0596009205", "Head First Java", "Kathy Sierra");
        Book book3 = new Book("978-1617291999", "Java: A Beginner's Guide", "Herbert Schildt");
        
        // Create members
        Member member1 = new Member("M001", "Alice nantume");
        Member member2 = new Member("M002", "Muwanguzi kevin");
        
        // Add to library
        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);
        library.registerMember(member1);
        library.registerMember(member2);
        
        // Display initial state
        library.displayAllBooks();
        library.displayAllMembers();
        library.displayActiveLoans();
        
        System.out.println("\n==================================================");
        System.out.println("STARTING TRANSACTIONS");
        System.out.println("==================================================");
        
        // [1] Lend book1 to member1 - SUCCESS
        System.out.println("\n[1] Lending 'Effective Java' to Alice nantume...");
        library.lendBook("M001", "978-0134685991");
        
        // [2] Lend book2 to member2 - SUCCESS
        System.out.println("\n[2] Lending 'Head First Java' to Muwanguzi kevin..");
        library.lendBook("M002", "978-0596009205");
        
        // [3] Attempt to lend book1 to member2 - REJECTED Business Rule
        System.out.println("\n[3] Attempting to lend 'Effective Java' to Muwanguzi kevin(already on loan)...");
        library.lendBook("M002", "978-0134685991");
        
        // [4] Lend book3 to member1 - SUCCESS (member can have multiple)
        System.out.println("\n[4] Lending 'Java: A Beginner's Guide' to Alice nantume...");
        library.lendBook("M001", "978-1617291999");
        
        // Display state after lends
        library.displayAllBooks();
        library.displayActiveLoans();
        
        // [5] Return book1
        System.out.println("\n[5] Returning 'Effective Java'...");
        library.returnBook("978-0134685991");
        
        // [6] Now lend book1 to member2  will nbe SUCCESS now available
        System.out.println("\n[6] Lending 'Effective Java' to Muwanguzi kevin(now available)...");
        library.lendBook("M002", "978-0134685991");
        
        // Final state
        System.out.println("\n==================================================");
        System.out.println("FINAL STATE");
        System.out.println("==================================================");
        library.displayAllBooks();
        library.displayAllMembers();
        library.displayActiveLoans();
        
        }
    }


