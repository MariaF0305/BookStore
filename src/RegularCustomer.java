import java.util.ArrayList;

public class RegularCustomer extends User implements Payable{

    public RegularCustomer(String pFirstName, String pName, String pCategory, int pAge, long pID) {
        super(pFirstName, pName, pCategory, pAge, pID, "regular");
    }

    @Override
    public void userPayCredit(int requiredCredit) throws NoCreditException{
        if ((this.credit - requiredCredit) < 0){
            throw new NoCreditException(("User " + getName() +
                    " only has " + this.credit +
                    " and needs at least " +(requiredCredit)));
        }
        this.credit = this.credit - requiredCredit;
    }
}
