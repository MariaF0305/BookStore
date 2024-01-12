package myapp;

public interface Payable {
    public void userPayCredit (int requiredCredit) throws NoCreditException;
}
