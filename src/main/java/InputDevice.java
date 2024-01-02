import java.awt.*;
import java.util.Scanner;

public class InputDevice {
    public Book inputInformationAboutBook() {
        String name, author;
        int numberGenre = 0;
        double price;
        long ISBN;

        Scanner console = new Scanner(System.in);

        System.out.println("Enter the title of the book");
        name = console.nextLine();

        System.out.println("Enter the author of the book");
        author = console.nextLine();

        System.out.println("Enter the price of the book");
        price = console.nextDouble();

        System.out.println("Enter the ISBn of the book");
        ISBN = console.nextLong();


        System.out.println("Enter a number between 1-8 representing the following genres: \n 1. Chrime/Thriller \n 2. Classics \n 3. Fantasy \n" +
                " 4. Historical Fiction \n 5. Literary Fiction \n 6. Romance \n 7. Science Fiction \n 8. Young Adult");
        numberGenre = console.nextInt();

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
        int age, nr_category = 0;
        long ID;

        Scanner console = new Scanner(System.in);

        System.out.println("Write first name of the user");
        firstName = console.nextLine();

        System.out.println("Write name of the user");
        name = console.nextLine();

        System.out.println("Write the age of the user");
        age = console.nextInt();

        System.out.println("Write the ID of the user");
        ID = console.nextLong();


        System.out.println("Enter a number between 1-3 to chose with of the category the user belongs: \n 1. Student \n 2. Teacher \n 3. Regular Customer");
        nr_category = console.nextInt();

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
        long Isbn;

        Scanner console = new Scanner(System.in);
        Isbn = console.nextLong();

        return Isbn;
    }

    public long inputTheIdForUserYouSearchingAfter () {
        long Id;

        Scanner console = new Scanner(System.in);
        Id = console.nextLong();

        return Id;
    }
}
