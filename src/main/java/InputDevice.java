import java.util.InputMismatchException;
import java.util.Scanner;

public class InputDevice {
    public Book inputInformationAboutBook() {
        String name, author;
        int numberGenre = 0;
        double price = 0;
        long ISBN = 0;

        boolean checker = false;

        Scanner console = new Scanner(System.in);

        do {
            System.out.println("Enter the title of the book");
            name = console.nextLine();

            checker = inputFrazeChecker(name);
        } while (!checker);

        do {
            System.out.println("Enter the author of the book");
            author = console.nextLine();

            checker = inputFrazeChecker(author);
        } while (!checker);


        do {

            try {

                System.out.println("Enter the price of the book");
                price = console.nextDouble();
                if (Double.isFinite(price)) {
                    checker = true;
                } else {
                    System.out.println("You didn't enter a valid number. PLEASE enter a NUMBER");
                    checker = false;
                    console.nextLine();
                }
            } catch (InputMismatchException e) {
                System.out.println("You didn't enter a number. PLEASE enter a NUMBER");
                checker = false;
                console.nextLine();
            }

        } while (!checker);


        do {

            try {
                System.out.println("Enter the ISBN of the book");
                ISBN = console.nextLong();
                checker = true;
            } catch (InputMismatchException e) {
                System.out.println("You didn't enter a number. PLEASE enter a NUMBER");
                checker = false;
                console.nextLine();
            }

        } while (!checker);

        System.out.println("Enter a number between 1-8 representing the following genres: \n 1. Crime/Thriller \n 2. Classics \n 3. Fantasy \n" +
                " 4. Historical Fiction \n 5. Literary Fiction \n 6. Romance \n 7. Science Fiction \n 8. Young Adult");
        do {

            try {
                numberGenre = console.nextInt();
                checker = true;
            } catch (InputMismatchException e) {
                System.out.println("You didn't enter a number. PLEASE enter a NUMBER");
                checker = false;
                console.nextLine();
            }

        } while (!checker);

        try {
            switch(numberGenre) {
                case 1:
                    CrimeThriller book = new CrimeThriller(name, author, "Crime/Thriller", price, ISBN);
                    book.addToTheBookListOfThisGenre(book);
                    return book;
                case 2:
                    Classics book1 = new Classics(name, author, "Classics", price, ISBN);
                    book1.addToTheBookListOfThisGenre(book1);
                    return book1;
                case 3:
                    Fantasy book2 = new Fantasy(name, author, "Fantasy", price, ISBN);
                    book2.addToTheBookListOfThisGenre(book2);
                    return book2;
                case 4:
                    HistoricalFiction book3 = new HistoricalFiction(name, author, "Historical Fiction", price, ISBN);
                    book3.addToTheBookListOfThisGenre(book3);
                    return book3;
                case 5:
                    LiteraryFiction book4 = new LiteraryFiction(name, author, "Literary Fiction", price, ISBN);
                    book4.addToTheBookListOfThisGenre(book4);
                    return book4;
                case 6:
                    Romance book5 = new Romance(name, author, "Romance", price, ISBN);
                    book5.addToTheBookListOfThisGenre(book5);
                    return book5;
                case 7:
                    ScienceFiction book6 = new ScienceFiction(name, author, "Science Fiction", price, ISBN);
                    book6.addToTheBookListOfThisGenre(book6);
                    return book6;
                case 8:
                    YoungAdult book7 = new YoungAdult(name, author, "Young Adult", price, ISBN);
                    book7.addToTheBookListOfThisGenre(book7);
                    return book7;
                default:
                    return null;
            }
        } catch (NumberFormatException e) {
            System.out.println("Error: You didn't enter a number");
            return null;
        }
    }

    public User inputInformationAboutUser() {
        String firstName, name;
        int age = 0, nr_category = 0;
        long ID = 0;

        boolean checker = false; 
        
        Scanner console = new Scanner(System.in);

        do {
            System.out.println("Write first name of the user");
            firstName = console.nextLine();

            checker = inputFrazeChecker(firstName);
        } while (!checker);

        do {
            System.out.println("Write name of the user");
            name = console.nextLine();

            checker = inputFrazeChecker(name);
        } while (!checker);

        do {

            try {
                System.out.println("Write the age of the user");
                age = console.nextInt();
                checker = true;
            } catch (InputMismatchException e) {
                System.out.println("You didn't enter a number. PLEASE enter a NUMBER");
                checker = false;
                console.nextLine();
            }

        } while (!checker);

        do {

            try {
                System.out.println("Write the ID of the user");
                ID = console.nextLong();
                checker = true;
            } catch (InputMismatchException e) {
                System.out.println("You didn't enter a number. PLEASE enter a NUMBER");
                checker = false;
                console.nextLine();
            }

        } while (!checker);

        System.out.println("Enter a number between 1-3 to chose with of the category the user belongs: \n 1. Student \n 2. Teacher \n 3. Regular Customer");

        do {

            try {
                nr_category = console.nextInt();
                checker = true;
            } catch (InputMismatchException e) {
                System.out.println("You didn't enter a number. PLEASE enter a NUMBER");
                checker = false;
                console.nextLine();
            }

        } while (!checker);

        try {
            switch (nr_category) {
                case 1:
                    Student user = new Student(firstName, name, "Student", age, ID);
                    return user;
                case 2:
                    Teacher user1 = new Teacher(firstName, name, "Teacher", age, ID);
                    return user1;
                case 3:
                    RegularCustomer user2 = new RegularCustomer(firstName, name, "Regular Customer", age, ID);
                    return user2;
                default:
                    return null;
            }
        } catch (NumberFormatException e){
            System.out.println("Error: You didn't enter a number");
            return null;
        }
    }

    public long inputTheIsbnFromBookYouSearchingAfter () {
        long Isbn = 0;
        boolean checker = false;

        Scanner console = new Scanner(System.in);

        do {

            try {
                Isbn = console.nextLong();
                checker = true;
            } catch (InputMismatchException e) {
                System.out.println("You didn't enter a number. PLEASE enter a NUMBER");
                checker = false;
                console.nextLine();
            }

        } while (!checker);


        return Isbn;
    }

    public long inputTheIdForUserYouSearchingAfter () {
        long Id = 0;
        boolean checker = false;

        Scanner console = new Scanner(System.in);

        do {

            try {
                Id = console.nextLong();
                checker = true;
            } catch (InputMismatchException e) {
                System.out.println("You didn't enter a number. PLEASE enter a NUMBER");
                checker = false;
                console.nextLine();
            }

        } while (!checker);

        return Id;
    }

    private boolean inputFrazeChecker(String fraze) {
        //Check if the array is not empty
        if (fraze.isEmpty()) {
            System.out.println("\nYou didn't enter anything. PLEASE enter LETTERS. Try again.\n");
            return false;
        }

        //Check if the array does not have only empty space
        if (fraze.trim().isEmpty()) {
            System.out.println("\nYou only entered empty spaces. PLEASE enter LETTERS. Try again.\n");
            return false;
        }

        return true;
    }

}
