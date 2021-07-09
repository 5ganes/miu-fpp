package homework12exceptionhandling;

// user defined exception for minimum balance
class MinimumBalanceOfAccount extends Exception {
    public MinimumBalanceOfAccount(String s) {
        super(s);
    }
    @Override
    public String getMessage(){
        return super.getMessage();
    }
}

// user defined exception for Withdraw amount exceeding
class WithdrawAmountExceededException extends Exception {
    public WithdrawAmountExceededException(String s) {
        super(s);
    }
    public String getMessage(){
        return super.getMessage();
    }
}

class CustomerAccount{

    private String Cus_name;
    private long Acc_No;
    private double Balance;

    CustomerAccount(String Cus_name, long Acc_No, double Balance){
        this.Cus_name = Cus_name;
        this.Acc_No = Acc_No;
        this.Balance = Balance;
    }

    public boolean deposit(double amount){
        if(amount < 0) return false;
        this.Balance += amount;
        return true;
    }

    public boolean withdraw(double amount) throws WithdrawAmountExceededException{
        if(amount > this.Balance)
            throw new WithdrawAmountExceededException("Withdraw amount can not exceed current balance");
        this.Balance -= amount;
        return true;
    }

    public double getBalance() throws MinimumBalanceOfAccount{
        if(this.Balance < 100)
            throw new MinimumBalanceOfAccount("Balance can not be less than 100$");
        return this.Balance;
    }

}

public class Problem2 {
    public static void main(String[] args){
        CustomerAccount a1 = new CustomerAccount("Thomas Butler", 1000055564, 100);
        a1.deposit(80);

        try {
            double currentBalance = a1.getBalance(); // this will throw exception if current balance is less than 100%
            System.out.println("Current Balance : " + currentBalance);

            double amount = 10000;
            a1.deposit(amount);
            System.out.println("Current balance after depositing " + amount + " : " + a1.getBalance());

            a1.withdraw(120000);
            System.out.println("Current balance after withdraw " + a1.getBalance()); // this will throw exception if current balance is less than withdraw amount

        }
        catch (MinimumBalanceOfAccount e){
            System.out.println(e.getMessage());
        }
        catch (WithdrawAmountExceededException e){
            System.out.println(e.getMessage());
        }
    }
}
