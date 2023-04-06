import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

class Account
{
    int acno;
    int balance;
    Account(int acno, int balance)
    {
        this.acno=acno;
        this.balance=balance ;
    }
}

class Transaction extends Account
{
    int amount;
    String transaction_type;
    Transaction(int a, int b)
    {
        super(a, b);
    }
    void accept(int b)
    {
        amount = b;
    }
    void transaction_type(int amount,String transaction_type)
    {
        if(transaction_type=="Withdraw")
        {
            if(amount>balance)
            {
                System.out.println("Account Number: " + acno);
                System.out.println("Transaction type: " + transaction_type);
                System.out.println("Not enough balance" );
                System.out.println(" current balance " + balance);
            }
            else
            {
                balance=balance-amount;
                System.out.println("Account Number: " + acno);
                System.out.println("Transaction type: " + transaction_type);
                System.out.println(" current balance " + balance);
                System.out.println("withdrawal amount" +amount);
            }
        }
        else if(transaction_type=="Deposit")
        {
            balance =balance+amount;
            System.out.println("Account Number: " + acno);
            System.out.println("Transaction type: " + transaction_type);
            System.out.println(" current balance " + balance);
            System.out.println(" Deposit amount " + amount);
        }
    }
}

class DemoAccount
{
    public static void main (String args[])
    {
        Transaction obj = new Transaction(6251671,100000);
        obj.transaction_type(4000,"Deposit");
        java.util.Date date=new java.util.Date();
        System.out.println(date);
    }
}