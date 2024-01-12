package myapp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import com.fasterxml.jackson.databind.ObjectMapper;


public class BookLoanManagerJSON extends BookLoanManager {

  private final String USERS_FILE_NAME = "Users.json";
  private final String BOOK_FILE_NAME = "Books.json";
  private final String LOAN_FILE_NAME = "Loan.json";

  protected BookLoanManagerJSON() throws IOException {
    mUserAndLoanedBooksStorage = new HashMap<>();
    mAllBooksInStore = new ArrayList<>();
    mAllUsers = new ArrayList<>();
    mId = new InputDevice();

    loadDB();
  }

  @Override
  public synchronized void saveDB() throws IOException {

    BufferedWriter myWriter = null;
    final ObjectMapper mapper = new ObjectMapper();

    try {
      myWriter = new BufferedWriter(new FileWriter(USERS_FILE_NAME));

      for (final User user : mAllUsers) {
        myWriter.write(mapper.writeValueAsString(user));
        myWriter.newLine();
      }
    } catch (final IOException e) {
      e.printStackTrace();
    } finally {
      if (myWriter != null) {
        try {
          myWriter.close();
        } catch (final IOException e) {
          e.printStackTrace();
        }
      }
    }

    try {
      myWriter = new BufferedWriter(new FileWriter(BOOK_FILE_NAME));

      for (final Book book : mAllBooksInStore) {
        myWriter.write(mapper.writeValueAsString(book));
        myWriter.newLine();
      }
    } catch (final IOException e) {
      e.printStackTrace();
    } finally {
      if (myWriter != null) {
        try {
          myWriter.close();
        } catch (final IOException e) {
          e.printStackTrace();
        }
      }
    }

    try {
      myWriter = new BufferedWriter(new FileWriter(LOAN_FILE_NAME));

      for (final BookLoan loan : mUserAndLoanedBooksStorage.values()) {
        myWriter.write(mapper.writeValueAsString(loan));
        myWriter.newLine();
      }
    } catch (final IOException e) {
      e.printStackTrace();
    } finally {
      if (myWriter != null) {
        try {
          myWriter.close();
        } catch (final IOException e) {
          e.printStackTrace();
        }
      }
    }
  }

  @Override
  void loadDB() throws IOException {

    final ObjectMapper mapper = new ObjectMapper();
    BufferedReader myReader = null;

    try {
      myReader = new BufferedReader(new FileReader(USERS_FILE_NAME));
      String json = null;

      while ((json = myReader.readLine()) != null) {

        final User user = mapper.readValue(json, User.class);
        mAllUsers.add(user);

      }
    } catch (final IOException e) {
      e.printStackTrace();
    } finally {
      if (myReader != null) {
        try {
          myReader.close();
        } catch (final IOException e) {
          e.printStackTrace();
        }
      }
    }

    try {
      myReader = new BufferedReader(new FileReader(BOOK_FILE_NAME));
      String json = null;

      while ((json = myReader.readLine()) != null) {

        final Book book = mapper.readValue(json, Book.class);
        mAllBooksInStore.add(book);
      }
    } catch (final IOException e) {
      e.printStackTrace();
    } finally {
      if (myReader != null) {
        try {
          myReader.close();
        } catch (final IOException e) {
          e.printStackTrace();
        }
      }
    }

    try {
      myReader = new BufferedReader(new FileReader(LOAN_FILE_NAME));
      String json = null;

      while ((json = myReader.readLine()) != null) {


        final BookLoan loan = mapper.readValue(json, BookLoan.class);
        mUserAndLoanedBooksStorage.put(loan.getUser(), loan);
      }
    } catch (final IOException e) {
      e.printStackTrace();
    } finally {
      if (myReader != null) {
        try {
          myReader.close();
        } catch (final IOException e) {
          e.printStackTrace();
        }
      }
    }
  }
}