package myapp;

import com.example.gui_bookloanmanager.SceneController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;


public abstract class BookLoanManager {

  protected HashMap<User, BookLoan> mUserAndLoanedBooksStorage = null;
  protected ArrayList<Book> mAllBooksInStore = null;
  protected ArrayList<User> mAllUsers = null;
  protected InputDevice mId = null;

  private final String USERS_FILE_NAME = "Users.json";
  private final String BOOK_FILE_NAME = "Books.json";
  private final String LOAN_FILE_NAME = "Loan.json";

  private static BookLoanManager instance = null;

  public static synchronized BookLoanManager getInstance() throws IOException {
    if (instance == null) {
      instance = new BookLoanManagerDB();
    }

    return instance;
  }

  public void addBookToListOfBorrowedBooksFromAUser() {
    boolean isBookAdded = false;
    long isbn, id;
    Book book;
    User user;
    final Scanner console = new Scanner(System.in);

    System.out.println("Write the ID of the User which wants to borrow a book");
    id = console.nextLong();

    user = searchUserAfterIdInTheLIsOfBooksInStore(id);

    System.out.println("Enter the ISBN of the book that is borrowed");
    isbn = console.nextLong();

    try {
      book = searchBookAfterIsbnInTheListOfBooksInStore(isbn);

      if (user == null) {
        user = mId.inputInformationAboutUser();
        mAllUsers.add(user);
      }

      try {
        BookLoan bl;

        if (!(mUserAndLoanedBooksStorage).containsKey(user)) {
          bl = new BookLoan(user);
          if (book instanceof Borrowable && user instanceof Payable) {
            ((Payable) user).userPayCredit(((Borrowable) book).bookRequiresCredit());
          }

          mUserAndLoanedBooksStorage.put(user, bl);
        } else {
          bl = mUserAndLoanedBooksStorage.get(user);
        }
        bl.addBookToUsersList(book);
        isBookAdded = removingBorrowedBookFromStorage(book);
      } catch (final NoCreditException e) {
        System.out.println("Cannot borrow book: " + e.getMessage());
      }
    } catch (final NoBookException e) {
      System.out.println("Book not in store: " + e.getMessage());
    }
  }

  public boolean addBookToListOfBorrowedBooksFromAUser_GUIVersion(long id, long isbn) throws NoBookException, NoCreditException {
    boolean isBookAdded = false, exist = true;
    Book book;
    User user;
    final Scanner console = new Scanner(System.in);

    user = searchUserAfterIdInTheLIsOfBooksInStore(id);
    if (user == null) {
      return false;
    }

    book = searchBookAfterIsbnInTheListOfBooksInStore(isbn);
    if (book == null) {
      return false;
    }

    BookLoan bl;

    if (!(mUserAndLoanedBooksStorage).containsKey(user)) {
      bl = new BookLoan(user);
      if (book instanceof Borrowable && user instanceof Payable) {
        ((Payable) user).userPayCredit(((Borrowable) book).bookRequiresCredit());
      }

      mUserAndLoanedBooksStorage.put(user, bl);
    } else {
      bl = mUserAndLoanedBooksStorage.get(user);
    }
    bl.addBookToUsersList(book);
    isBookAdded = removingBorrowedBookFromStorage(book);

    return isBookAdded;
  }


  public void printCurrentLoanersAndBookList() {
    for (final BookLoan bl : mUserAndLoanedBooksStorage.values()) {
      System.out.println(bl);
    }
  }

  // here I add a book for the store
  public void addABookToStore() {
    boolean isLoaned = false;
    Book pB = mId.inputInformationAboutBook();

    System.out.println("First check if this book is borrowed");
    for (final BookLoan bl : mUserAndLoanedBooksStorage.values()) {
      for (final Book b : bl.getListOfBooks()) {
        if (b.equals(pB)) {
          isLoaned = true;
          mAllBooksInStore.add(pB);
          bl.remove(pB);
          System.out.println("The book is borrowed");
          break;
        }
      }
    }

    if (!isLoaned) {
      System.out.println("The book is not borrowed. It will be added to the bookstore");
      int booleanAdd = 1;
      boolean checker;
      final Scanner console = new Scanner(System.in);

      while (booleanAdd == 1) {
        System.out.println("Is there a new book in the bookstore? Then press 1. Otherwise press 0");

        do {
          try {
            booleanAdd = console.nextInt();
            checker = true;
          } catch (InputMismatchException e) {
            System.out.println("You didn't enter a number. PLEASE enter a NUMBER");
            checker = false;
            console.nextLine();
          }

        } while (!checker);

        mAllBooksInStore.add(pB);
        if (booleanAdd == 1) {
          pB = mId.inputInformationAboutBook();
        }
      }
    }
  }

  public void addABookToStore_GuiVersion(String bookName, String authorName, String bookGenre, float bookPrice, long bookIsbn) {
    boolean isLoaned = false;
    Book book = null;


    switch(bookGenre) {
      case "Crime/Thriller":
        CrimeThriller book1 = new CrimeThriller(bookName, authorName, bookGenre, bookPrice, bookIsbn);
        book1.addToTheBookListOfThisGenre(book1);
        book = book1;
      case "Classics":
        Classics book2 = new Classics(bookName, authorName, "Classics", bookPrice, bookIsbn);
        book2.addToTheBookListOfThisGenre(book2);
        book = book2;
      case "Fantasy":
        Fantasy book3 = new Fantasy(bookName, authorName, "Fantasy", bookPrice, bookIsbn);
        book3.addToTheBookListOfThisGenre(book3);
        book = book3;
      case "Historical Fiction":
        HistoricalFiction book4 = new HistoricalFiction(bookName, authorName, "Historical Fiction", bookPrice, bookIsbn);
        book4.addToTheBookListOfThisGenre(book4);
        book = book4;
      case "Literary Fiction":
        LiteraryFiction book5 = new LiteraryFiction(bookName, authorName, "Literary Fiction", bookPrice, bookIsbn);
        book5.addToTheBookListOfThisGenre(book5);
        book = book5;
      case "Romance":
        Romance book6 = new Romance(bookName, authorName, "Romance", bookPrice, bookIsbn);
        book6.addToTheBookListOfThisGenre(book6);
        book = book6;
      case "Science Fiction":
        ScienceFiction book7 = new ScienceFiction(bookName, authorName, "Science Fiction", bookPrice, bookIsbn);
        book7.addToTheBookListOfThisGenre(book7);
        book = book7;
      case "Young Adult":
        YoungAdult book8 = new YoungAdult(bookName, authorName, "Young Adult", bookPrice, bookIsbn);
        book8.addToTheBookListOfThisGenre(book8);
        book = book8;
    }

//checking if the book is borrowed
    for (final BookLoan bl : mUserAndLoanedBooksStorage.values()) {
      for (final Book b : bl.getListOfBooks()) {
        if (b.equals(book)) {
          isLoaned = true;
          mAllBooksInStore.add(book);
          bl.remove(book);
          System.out.println("The book is borrowed");
          break;
        }
      }
    }

    if (!isLoaned) {
        mAllBooksInStore.add(book);
    }
  }

  public boolean removingBorrowedBookFromStorage(final Book pBook) {
    boolean isBookRemoved = false;

    if (mAllBooksInStore.contains(pBook)) {
      isBookRemoved = true;
      mAllBooksInStore.remove(pBook);
    }

    return isBookRemoved;
  }

  public void theUserBroughtTheLoanedBookBackToStore() {
    long Isbn;
    final long Id;

    final Scanner console = new Scanner(System.in);
    System.out.println("Enter the ISBN from the book that was brought back");

    Book book;
    Isbn = mId.inputTheIdForUserYouSearchingAfter();
    book = searchBookAfterIsbnInTheWholeDictionary(Isbn);

    for (BookLoan bl : mUserAndLoanedBooksStorage.values()) {
      for (Book b : bl.getListOfBooks()) {
        if (b.equals(book)) {
          this.mAllBooksInStore.add(book);
          System.out.println("The book that was brought back was added back to the store");
          bl.getListOfBooks().remove(book);
          if (bl.getListOfBooks().isEmpty()) {
            this.mUserAndLoanedBooksStorage.remove(bl.getUser());
          }
          break;
        }
      }
    }
  }

  public void addAUserToThisLibrary() {
    int booleanAdd = 1;
    User pU;

    final Scanner console = new Scanner(System.in);
    pU = mId.inputInformationAboutUser();

    while (booleanAdd == 1) {
      // here can be added an exception handling
      mAllUsers.add(pU);
      System.out.println("Is there a new user in the bookstore? Then press 1. Otherwise press 0");
      booleanAdd = console.nextInt();
      if (booleanAdd == 1) {
        pU = mId.inputInformationAboutUser();
      }
    }
  }

  public void addAUserToThisLibrary_GUIVersion(String userFirstName, String userName, String userType, int userAge, long userID) {
    int booleanAdd = 1;
    User user = null;

    switch(userType) {
      case "Student":
        user = new Student(userFirstName, userName, "Student", userAge, userID);
      case "Teacher":
        user = new Teacher(userFirstName, userName, "Teacher", userAge, userID);
      case "Regular Customer":
        user = new RegularCustomer(userFirstName, userName, "Regular Customer", userAge, userID);
    }

    mAllUsers.add(user);

  }


  public Book searchBookAfterIsbnInTheWholeDictionary(final long pIsbn) {
    for (final BookLoan bl : mUserAndLoanedBooksStorage.values()) {
      for (final Book b : bl.getListOfBooks()) {
        if (b.getISBN() == pIsbn) {
          System.out.println("Book with the searched ISBN was found");
          return b;
        }
      }
    }
    return null;
  }

  public Book searchBookAfterIsbnInTheListOfBooksInStore(final long Isbn) throws NoBookException {
    for (final Book b : mAllBooksInStore) {
      if (b.getISBN() == Isbn) {
        return b;
      }
    }

    return null;
  }

  public User searchUserAfterIdInTheLIsOfBooksInStore(final long Id) {
    for (final User u : mAllUsers) {
      if (u.getID() == Id) {
        return u;
      }
    }

    return null;
  }

  public ArrayList<Book> getAllBooksFromStore() throws IOException {
    if (mAllBooksInStore == null) {
      loadDB();
    }

    return mAllBooksInStore;
  }

  public HashMap<User, BookLoan> getUserAndLoanedBooksStorage () {
    return mUserAndLoanedBooksStorage;
  }

  public ArrayList<User> getAllUsers() {
    return mAllUsers;
  }

  abstract public void saveDB() throws IOException;

  abstract void loadDB() throws IOException;
}