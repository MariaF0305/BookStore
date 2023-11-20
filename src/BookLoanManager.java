import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class BookLoanManager {
    private HashMap<User,BookLoan> mUserAndLoanedBooksStorage;
    private ArrayList<Book> mAllBooksInStore;
    private ArrayList<User> mAllUsers;
    private InputDevice mId;

    private final  String USERS_FILE_NAME = "Users.bin";
    private final  String BOOK_FILE_NAME = "Books.bin";
    private final  String LOAN_FILE_NAME = "Loan.bin";
    public BookLoanManager () {
        this.mUserAndLoanedBooksStorage = new HashMap<User,BookLoan>();
        this.mAllBooksInStore = new ArrayList<Book>();
        this.mAllUsers = new ArrayList<>();
        this.mId = new InputDevice();

        loadDB();
    }

    public void addBookToListOfBorrowedBooksFromAUser() {
        boolean isBookAdded = false;
        long isbn, id;
        Book book;
        User user;
        Scanner console = new Scanner(System.in);

        System.out.println("Write the ID of the User which wants to borrow a book");
        id = console.nextLong();

        user = this.searchUserAfterIdInTheLIsOfBooksInStore(id);

        System.out.println("Enter the ISBN of the book that is borrowed");
        isbn = console.nextLong();

        book = this.searchBookAfterIsbnInTheListOfBooksInStore(isbn);

        if (user == null){
            user = this.mId.inputInformationAboutUser();
            this.mAllUsers.add(user);
        }

        if (!this.mAllBooksInStore.contains(book)) {
            System.out.println("The book with the given ISBN doesn't exist");
            return;
        }

        try {
            BookLoan bl;

            if (!(this.mUserAndLoanedBooksStorage).containsKey(user)) {
                bl = new BookLoan(user);
                if (book instanceof Borrowable && user instanceof Payable) {
                    ((Payable) user).userPayCredit(((Borrowable) book).bookRequiresCredit());
                }

                this.mUserAndLoanedBooksStorage.put(user, bl);
            } else {
                bl = this.mUserAndLoanedBooksStorage.get(user);
            }
            bl.addBookToUsersList(book);
            isBookAdded = this.removingBorrowedBookFromStorage(book);
        }catch(NoCreditException e){
            System.out.println("Cannot borrow book: " + e.getMessage());
        }

    }

    public void printCurrentLoanersAndBookList() {
        for (BookLoan bl:this.mUserAndLoanedBooksStorage.values()){
            System.out.println(bl);
        }
    }

    // here I add a book for the store
    public void addABookToStore() {
        boolean isLoaned = false;
        Book pB = this.mId.inputInformationAboutBook();

        System.out.println("First check if this book is borrowed");
        for (BookLoan bl:this.mUserAndLoanedBooksStorage.values()){
            for (Book b : bl.getListOfBooks()) {
                if (b.equals(pB)) {
                    isLoaned = true;
                    this.mAllBooksInStore.add(pB);
                    bl.remove(pB);
                    System.out.println("The book is borrowed");
                    break;
                }
            }
        }

        if (!isLoaned) {
            System.out.println("The book is not borrowed. It will be added to the bookstore");
            int booleanAdd = 1;
            Scanner console = new Scanner(System.in);

            while (booleanAdd == 1) {
                //here can be added an exception handling
                System.out.println("Is there a new book in the bookstore? Then press 1. Otherwise press 0");
                booleanAdd = console.nextInt();
                this.mAllBooksInStore.add(pB);
                if (booleanAdd == 1) {
                    pB = mId.inputInformationAboutBook();
                }
            }
        }
    }

    public boolean removingBorrowedBookFromStorage (Book pBook) {
         boolean isBookRemoved = false;

         if (this.mAllBooksInStore.contains(pBook)) {
             isBookRemoved = true;
             this.mAllBooksInStore.remove(pBook);
         }

         return isBookRemoved;
    }

    public void addAUserToThisLibrary() {
        int booleanAdd = 1;
        User pU;

        Scanner console = new Scanner(System.in);
        pU = this.mId.inputInformationAboutUser();

        while (booleanAdd == 1) {
            //here can be added an exception handling
            this.mAllUsers.add(pU);
            System.out.println("Is there a new user in the bookstore? Then press 1. Otherwise press 0");
            booleanAdd = console.nextInt();
            if (booleanAdd == 1) {
                pU = this.mId.inputInformationAboutUser();
            }
        }
    }

    public void theUserBroughtTheLoanedBookBackToStore () {
        long Isbn, Id;

        Scanner console = new Scanner(System.in);
        System.out.println("Enter the ISBN from the book that was brought back");

        Book book;
        Isbn = mId.inputTheIdForUserYouSearchingAfter();
        book = this.searchBookAfterIsbnInTheWholeDictionary(Isbn);
        this.mAllBooksInStore.add(book);
        System.out.println("The book that was brought back was added back to the store");
        this.mUserAndLoanedBooksStorage.remove(book);
    }

    public Book searchBookAfterIsbnInTheWholeDictionary(long pIsbn) {
        for (BookLoan bl : this.mUserAndLoanedBooksStorage.values()) {
            for (Book b : bl.getListOfBooks()) {
                if (b.getISBN() == pIsbn) {
                    System.out.println("Book with the searched ISBN was found");
                    return b;
                }
            }
        }
        return null;
    }

    public Book searchBookAfterIsbnInTheListOfBooksInStore(long Isbn) {
        for (Book b : this.mAllBooksInStore) {
            if (b.getISBN() == Isbn) {
                return b;
            }
        }

        return null;
    }

    public User searchUserAfterIdInTheLIsOfBooksInStore (long Id) {
        for (User u : this.mAllUsers) {
            if (u.getID() == Id) {
                return u;
            }
        }

        return null;
    }

    public ArrayList<Book> getAllBooksFromStore() {
        return this.mAllBooksInStore;
    }

    public ArrayList<User> getAllUsers() {
        return this.mAllUsers;
    }
    public void saveDB(){

        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream(USERS_FILE_NAME));
            for (User user:this.mAllUsers){
                oos.writeObject(user);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        try {
            oos = new ObjectOutputStream(new FileOutputStream(BOOK_FILE_NAME));
            for (Book book:this.mAllBooksInStore){
                oos.writeObject(book);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        try {
            oos = new ObjectOutputStream(new FileOutputStream(LOAN_FILE_NAME));
            for (BookLoan loan:this.mUserAndLoanedBooksStorage.values()){
                oos.writeObject(loan);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void loadDB(){
        ObjectInputStream iis = null;
        try {
            iis = new ObjectInputStream(new FileInputStream(USERS_FILE_NAME));


            while (true){
                try {
                    User user = (User)iis.readObject();
                    this.mAllUsers.add(user);
                }catch (EOFException e){
                    break;
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (iis != null) {
                try {
                    iis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        try {
            iis = new ObjectInputStream(new FileInputStream(BOOK_FILE_NAME));

            while (true){
                try {
                    Book book = (Book)iis.readObject();
                    this.mAllBooksInStore.add(book);
                }catch (EOFException e){
                    break;
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (iis != null) {
                try {
                    iis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        try {
            iis = new ObjectInputStream(new FileInputStream(LOAN_FILE_NAME));

            while (true){
                try {
                    BookLoan loan = (BookLoan)iis.readObject();
                    this.mUserAndLoanedBooksStorage.put(loan.getUser(), loan);
                }catch (EOFException e){
                    break;
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (iis != null) {
                try {
                    iis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}