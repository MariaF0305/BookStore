package myapp;

public class Teacher extends User implements Payable{
    public Teacher(){}
    public Teacher(String pFirstName, String pName, String pCategory, int pAge, long pID) {
        super(pFirstName, pName, pCategory, pAge, pID, "teacher");
    }

    @Override
    public void userPayCredit(int requiredCredit) throws NoCreditException{
        if ((this.credit - requiredCredit/2) < 0){
            throw new NoCreditException(("myapp.User " + getLastName() +
                    " only has " + this.credit +
                    " and needs at least " + (requiredCredit/2)));
        }
        this.credit = this.credit - requiredCredit/2;
    }

}
