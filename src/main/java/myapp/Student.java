package myapp;

public class Student extends User{
    public Student(){

    }

    public Student(String pFirstName, String pName, String pCategory, int pAge, long pID) {
        super(pFirstName, pName, pCategory, pAge, pID, "student");
    }

}
