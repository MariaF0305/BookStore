import java.util.ArrayList;

public class OutputDevice {
    public void printListOfBooks(ArrayList<Book> books) {
        for (Book book:books) {
            System.out.println(book);
        }
    }

    public void printListOfUsers(ArrayList<User> users) {
        for (User user:users) {
            System.out.println(user.getName());
        }
    }

    public void printDetailsAboutBook(Book b) {
        System.out.println("Title: " + b.getName());
        System.out.println("Author: " + b.getPrice());
        System.out.println("Genre: " + b.getGenre());
        System.out.println("Price: " + b.getPrice());
    }

    public void printDetailsAboutUser(User u) {
        System.out.println("ID: " + u.getID());
        System.out.println("First name: " + u.getFirstName());
        System.out.println("Name: " + u.getName());
        System.out.println("Category: " + u.getCategory());
        System.out.println("Age: " + u.getAge());
    }
}
