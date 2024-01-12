package myapp;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;


public class BookLoanManagerDB extends BookLoanManager {

  private Connection conn = null;

  private final String USERS_FILE_NAME = "Users.json";
  private final String BOOK_FILE_NAME = "Books.json";
  private final String LOAN_FILE_NAME = "Loan.json";

  protected BookLoanManagerDB() throws IOException {
    mUserAndLoanedBooksStorage = new HashMap<>();
    mAllBooksInStore = new ArrayList<>();
    mAllUsers = new ArrayList<>();
    mId = new InputDevice();

    loadDB();
  }

  private Connection connect() {
    try {
      if (conn == null || conn.isClosed()) {
        // db parameters
        // final URL dbURL = getClass().getClassLoader().getResource("BookStore");
        // create a connection to the database
        conn = DriverManager.getConnection("jdbc:sqlite:" + "C:/maria/PerioadaFacultatii/Anul_2/Semestrul1/Programing3/BookStoreOrig/BookStore.db");
      }
    } catch (final SQLException e) {
      e.printStackTrace();
    }

    return conn;
  }

  @Override
  public synchronized void saveDB() throws IOException {

    cleanUsers();
    for (final User user : mAllUsers) {
      insertUser(user);
    }

    cleanBooks();
    for (final Book book : mAllBooksInStore) {
      insertBook(book);
    }

    cleanBookLoans();
    for (final BookLoan loan : mUserAndLoanedBooksStorage.values()) {
      insertBookLoan(loan);
    }
  }

  public void cleanUsers() {
    final String sql = "delete from users";

    PreparedStatement pstmt = null;
    try (Connection conn = connect();) {
      pstmt = conn.prepareStatement(sql);
      pstmt.executeUpdate();
    } catch (final SQLException e) {
      System.out.println(e.getMessage());
    } finally {
      if (pstmt != null) {
        try {
          pstmt.close();
        } catch (final SQLException e) {
          e.printStackTrace();
        }
      }
    }
  }

  public void insertUser(final User user) {
    final String sql = "INSERT INTO users(first_name, name, category, credit, age, type, ID) VALUES(?,?,?,?,?,?,?)";

    PreparedStatement pstmt = null;
    try (Connection conn = connect()) {
      pstmt = conn.prepareStatement(sql);
      pstmt.setString(1, user.getFirstName());
      pstmt.setString(2, user.getLastName());
      pstmt.setString(3, user.getCategory());
      pstmt.setInt(4, user.getCredit());
      pstmt.setInt(5, user.getAge());
      pstmt.setString(6, user.getClass().getName());
      pstmt.setLong(7, user.getID());
      pstmt.executeUpdate();
    } catch (final SQLException e) {
      System.out.println(e.getMessage());
    } finally {
      if (pstmt != null) {
        try {
          pstmt.close();
        } catch (final SQLException e) {
          e.printStackTrace();
        }
      }
    }

  }

  public void cleanBooks() {
    final String sql = "delete from books";

    PreparedStatement pstmt = null;
    try (Connection conn = connect();) {
      pstmt = conn.prepareStatement(sql);
      pstmt.executeUpdate();
    } catch (final SQLException e) {
      System.out.println(e.getMessage());
    } finally {
      if (pstmt != null) {
        try {
          pstmt.close();
        } catch (final SQLException e) {
          e.printStackTrace();
        }
      }
    }
  }

  public void insertBook(final Book book) {
    final String sql = "INSERT INTO books(name, author, genre, price, type, ISBN) VALUES(?,?,?,?,?,?)";

    PreparedStatement pstmt = null;
    try (Connection conn = connect()) {
      pstmt = conn.prepareStatement(sql);
      pstmt.setString(1, book.getName());
      pstmt.setString(2, book.getAuthor());
      pstmt.setString(3, book.getGenre());
      pstmt.setDouble(4, book.getPrice());
      pstmt.setString(5, book.getClass().getName());
      pstmt.setLong(6, book.getISBN());
      pstmt.executeUpdate();
    } catch (final SQLException e) {
      System.out.println(e.getMessage());
    } finally {
      if (pstmt != null) {
        try {
          pstmt.close();
        } catch (final SQLException e) {
          e.printStackTrace();
        }
      }
    }

  }

  public void cleanBookLoans() {
    final String sql = "delete from bookloans";

    PreparedStatement pstmt = null;
    try (Connection conn = connect();) {
      pstmt = conn.prepareStatement(sql);
      pstmt.executeUpdate();
    } catch (final SQLException e) {
      System.out.println(e.getMessage());
    } finally {
      if (pstmt != null) {
        try {
          pstmt.close();
        } catch (final SQLException e) {
          e.printStackTrace();
        }
      }
    }
  }

  public void insertBookLoan(final BookLoan loan) {
    final String sql = "INSERT INTO bookloans(name, author, genre, price, type, ISBN, USER_ID) VALUES(?,?,?,?,?,?,?)";

    PreparedStatement pstmt = null;
    final User user = loan.getUser();
    try (Connection conn = connect()) {
      for (final Book book : loan.getListOfBooks()) {
        pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, book.getName());
        pstmt.setString(2, book.getAuthor());
        pstmt.setString(3, book.getGenre());
        pstmt.setDouble(4, book.getPrice());
        pstmt.setString(5, book.getClass().getName());
        pstmt.setLong(6, book.getISBN());
        pstmt.setLong(7, user.getID());
        pstmt.executeUpdate();
      }
    } catch (final SQLException e) {
      System.out.println(e.getMessage());
    } finally {
      if (pstmt != null) {
        try {
          pstmt.close();
        } catch (final SQLException e) {
          e.printStackTrace();
        }
      }
    }
  }

  @Override
  void loadDB() throws IOException {

    mAllUsers.clear();
    loadUsers();
    mAllBooksInStore.clear();
    loadBooks();
    mUserAndLoanedBooksStorage.clear();
    loadBookLoans();
  }

  private void loadUsers() {
    final String sql = "SELECT first_name, name, category, credit, age, type, ID FROM users";

    try (Connection conn = connect(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {

      // loop through the result set
      while (rs.next()) {
        final String firstName = rs.getString("first_name");
        final String name = rs.getString("name");
        final String category = rs.getString("category");
        final Integer credit = rs.getInt("credit");
        final Integer age = rs.getInt("age");
        final String type = rs.getString("type");
        final Long ID = rs.getLong("ID");

        try {
          final Class<?> userClazz = Class.forName(type);
          final User user = (User) userClazz.newInstance();
          user.setFirstName(firstName);
          user.setLastName(name);
          user.setCategory(category);
          user.setCredit(credit);
          user.setAge(age);
          user.setID(ID);

          mAllUsers.add(user);
        } catch (final ClassNotFoundException e) {
          e.printStackTrace();
        } catch (final InstantiationException e) {
          e.printStackTrace();
        } catch (final IllegalAccessException e) {
          e.printStackTrace();
        }
      }
    } catch (final SQLException e) {
      e.printStackTrace();
    }
  }

  private void loadBooks() {
    final String sql = "SELECT name, author, genre, price, type, ISBN FROM books";

    try (Connection conn = connect(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {

      // loop through the result set
      while (rs.next()) {
        final String author = rs.getString("author");
        final String name = rs.getString("name");
        final String genre = rs.getString("genre");
        final Integer price = rs.getInt("price");
        final String type = rs.getString("type");
        final Long ISBN = rs.getLong("ISBN");

        try {
          final Class<?> bookClazz = Class.forName(type);
          final Book book = (Book) bookClazz.newInstance();
          book.setAuthor(author);
          book.setName(name);
          book.setGenre(genre);
          book.setPrice(price);
          book.setISBN(ISBN);

          mAllBooksInStore.add(book);
        } catch (final ClassNotFoundException e) {
          e.printStackTrace();
        } catch (final InstantiationException e) {
          e.printStackTrace();
        } catch (final IllegalAccessException e) {
          e.printStackTrace();
        }
      }
    } catch (final SQLException e) {
      e.printStackTrace();
    }
  }

  private void loadBookLoans() {
    final String sql = "SELECT name, author, genre, price, type, ISBN, USER_ID FROM bookloans";

    try (Connection conn = connect(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {

      // loop through the result set
      while (rs.next()) {
        final String author = rs.getString("author");
        final String name = rs.getString("name");
        final String genre = rs.getString("genre");
        final Integer price = rs.getInt("price");
        final String type = rs.getString("type");
        final Long ISBN = rs.getLong("ISBN");
        final Long userID = rs.getLong("USER_ID");

        try {
          final Class<?> bookClazz = Class.forName(type);
          final Book book = (Book) bookClazz.newInstance();
          book.setAuthor(author);
          book.setName(name);
          book.setGenre(genre);
          book.setPrice(price);
          book.setISBN(ISBN);

          for (final User user : mAllUsers) {
            if (user.getID() == userID) {
              BookLoan loan = mUserAndLoanedBooksStorage.get(user);
              if (loan == null) {
                loan = new BookLoan(user);
              }
              loan.addBookToUsersList(book);
              mUserAndLoanedBooksStorage.put(user, loan);
            }
          }
        } catch (final ClassNotFoundException e) {
          e.printStackTrace();
        } catch (final InstantiationException e) {
          e.printStackTrace();
        } catch (final IllegalAccessException e) {
          e.printStackTrace();
        }
      }
    } catch (final SQLException e) {
      e.printStackTrace();
    }
  }
}