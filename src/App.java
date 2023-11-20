import java.util.Scanner;

public class App {
    BookLoanManager manager = new BookLoanManager();
    InputDevice id = new InputDevice();
    OutputDevice od = new OutputDevice();
    int choose = 0;

    public void run (String[] args) {
        if (args[0].equalsIgnoreCase("admin")) {
            Scanner console = new Scanner(System.in);
            System.out.println("Choose a number from 1 to 7");
            System.out.println("1. Prints all Books from the library");
            System.out.println("2. Add a book to the library");
            System.out.println("3. Print all the users");
            System.out.println("4. Add an user the library");
            System.out.println("5. Add a loaned book to the users loaned book list");
            System.out.println("6. Remove a loaned book from the users loaned book list");
            System.out.println("7. Print the all the users who had borrowed somthing and their list of books");
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
                        manager.saveDB();
                }
                System.out.println();
                System.out.println("Choose a number from 1 to 7 or 0 to exit");
                choose = console.nextInt();
                System.out.println();
            }
        } else if (args[0].equalsIgnoreCase("user")) {

        } else {

        }
    }
}
