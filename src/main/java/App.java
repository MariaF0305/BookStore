import java.io.IOException;
import java.util.Scanner;

public class App {
    BookLoanManager manager = BookLoanManager.getInstance();
    InputDevice id = new InputDevice();
    OutputDevice od = new OutputDevice();
    int choose = 0;


    private static App instance = null;

    public App() throws IOException {
    }

    public static synchronized App getInstance() throws IOException {
        if (instance == null) {
            instance = new App();
        }

        return instance;
    }

    public void run (String[] args) throws NoBookException, IOException {
        SaveDBThread thread = new SaveDBThread();

        thread.start();

        if (args[0].equalsIgnoreCase("admin")) {
            Scanner console = new Scanner(System.in);
            System.out.println("What do you want to do as an admin. Choose a number from 1 to 10");
            System.out.println("1. Prints all Books from the library");
            System.out.println("2. Add a book to the library");
            System.out.println("3. Print all the users");
            System.out.println("4. Add an user the library");
            System.out.println("5. Add a loaned book to the users loaned book list");
            System.out.println("6. Remove a loaned book from the users loaned book list");
            System.out.println("7. Print the all the users who had borrowed somthing and their list of books");
            System.out.println("8. Show how much credit an user has");
            System.out.println("9. Save all the changes done in files");
            System.out.println("10. Print all the options an admin has");
            choose = console.nextInt();

            while (choose != 0) {
                switch (choose) {
                    case 1:
                        System.out.println("You chose to print all books from the library");
                        System.out.println("The following books are available in the library");
                        od.printListOfBooks(manager.getAllBooksFromStore());
                        break;
                    case 2:
                        System.out.println("You chose to add a book to the library");
                        System.out.println("First input the informations about the book");
                        manager.addABookToStore();
                        break;
                    case 3:
                        System.out.println("You chose to print all the users from the store");
                        od.printListOfUsers(manager.getAllUsers());
                        break;
                    case 4:
                        System.out.println("You chose to add a user to the library");
                        System.out.println("First input the information about the user");
                        manager.addAUserToThisLibrary();
                        break;
                    case 5:
                        System.out.println("You chose, that a user loaned a book and it should be added to the list");
                        manager.addBookToListOfBorrowedBooksFromAUser();
                        break;
                    case 6:
                        System.out.println("You chose that a user brought back a book and remove it from the loaned list");
                        manager.theUserBroughtTheLoanedBookBackToStore();
                        break;
                    case 7:
                        System.out.println("You chose print the user and their lists of loaned books");
                        manager.printCurrentLoanersAndBookList();
                        break;
                    case 8:
                        System.out.println("Show how much credit points a customer has");
                        System.out.println("Enter the ISBN of a customer");
                        long isbn = 0;
                        isbn = console.nextLong();
                        User user;
                        user = manager.searchUserAfterIdInTheLIsOfBooksInStore(isbn);
                        System.out.println(user + " has " + user.credit);
                    case 9:
                        manager.saveDB();
                        System.out.println("All information saved in files");
                    case 10:
                        System.out.println("You chose to print the options you can do as an admin");
                        System.out.println("What do you want to do as an admin. Choose a number from 1 to 10");
                        System.out.println("1. Prints all Books from the library");
                        System.out.println("2. Add a book to the library");
                        System.out.println("3. Print all the users");
                        System.out.println("4. Add an user the library");
                        System.out.println("5. Add a loaned book to the users loaned book list");
                        System.out.println("6. Remove a loaned book from the users loaned book list");
                        System.out.println("7. Print the all the users who had borrowed somthing and their list of books");
                        System.out.println("8. Show how much credit an user has");
                        System.out.println("9. Save all the changes done in files");
                        System.out.println("10. Print all the options an admin has");
                    default:
                        choose = 0;
                }
                System.out.println();
                System.out.println("Choose a number from 1 to 10 or 0 to exit");
                choose = console.nextInt();
                System.out.println();
            }
        } else if (args[0].equalsIgnoreCase("user")) {
            Scanner console = new Scanner(System.in);
            System.out.println("Choose a number from 1 to 2 or 0 to exit");
            System.out.println("1.Print the books available in the store");
            System.out.println("2. Print information about a specific book");
            choose = console.nextInt();

            while (choose != 0) {
                switch (choose) {
                    case 1:
                        System.out.println("You chose to print all books from the library");
                        System.out.println("The following books are available in the library");
                        od.printListOfBooks(manager.getAllBooksFromStore());
                        break;
                    case 2:
                        System.out.println("You chose to print information about a specific book");
                        System.out.println("First input the ISBN of the book");
                        long isbn = id.inputTheIsbnFromBookYouSearchingAfter();
                        Book b = manager.searchBookAfterIsbnInTheListOfBooksInStore(isbn);
                        od.printDetailsAboutBook(b);
                        break;
                    default:
                        choose = 0;
                }
                System.out.println();
                System.out.println("Choose a number from 1 to 2 or 0 to exit");
                choose = console.nextInt();
                System.out.println();
            }
        }

        thread.stopThread();
    }

}
