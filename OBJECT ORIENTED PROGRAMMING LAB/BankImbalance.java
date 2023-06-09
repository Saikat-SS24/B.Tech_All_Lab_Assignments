import java.lang.Math;

class WithdrawalNotPossible extends Exception {
    private double x, y;
    WithdrawalNotPossible(double x, double y) {
        this.x = x;
        this.y = y;
    }
    public String toString() {
        return "Cannot withdraw Rupees " + this.x + ", account balance is Rupees " + this.y;
    }
}

class Account {
    String customerName, accountType;
    int accountNumber;
    Account(String customerName, int accountNumber) {
        this.customerName = customerName;
        this.accountNumber = accountNumber;
    }
}

class SavingsAccount extends Account {
    double balance, serviceCharge, rate, time;
    SavingsAccount(String customerName, int accountNumber, double balance, double rate, double time) {
        super(customerName, accountNumber);
        this.accountType = "Savings";
        this.balance = balance;
        this.serviceCharge = 500;
        this.time = time;
        this.rate = rate;
    }
    void display() {
        System.out.println("Account no: " + this.accountNumber + ", Owner: " + this.customerName + ", Balance: " + this.balance + ", Account type: " + this.accountType);
    }
    void withdraw(double amount) {
        try {
            if (amount > this.balance) {
                throw new WithdrawalNotPossible(amount, this.balance);
            }
            this.balance -= amount;
        } catch (WithdrawalNotPossible e) {
            System.out.println(e);
        }
    }

    void deposit(double amount) {
        this.balance += amount;
    }

    void update() {
        this.balance += this.balance * (Math.pow((1 + this.rate / 100), this.time));
    }
}

class CurrentAccount extends Account {
    double balance, serviceCharge, minimumbalance;
    CurrentAccount(String customerName, int accountNumber, double balance) {
        super(customerName, accountNumber);
        this.accountType = "Current";
        this.balance = balance;
        this.serviceCharge = 500;
        this.minimumbalance = 1000;
    }
    void display() {
        System.out.println("Account no: " + this.accountNumber + ", Owner: " + this.customerName + ", Balance: " + this.balance + ", Account type: " + this.accountType);
    }
    void withdraw(double amount) {
        try {
            if (amount > this.balance) {
                throw new WithdrawalNotPossible(amount, this.balance);
            }
            this.balance -= amount;
        } catch (WithdrawalNotPossible e) {
            System.out.println(e);
        }
    }

    void deposit(double amount) {
        this.balance += amount;
    }

    void update() {
        if (this.balance < this.minimumbalance) {
            this.balance -= this.serviceCharge;
        }
    }
}

class BankImbalance {
    public static void main(String[] args) {
        double balance = 5000;
        double rate = 5.7;
        double time = 2;
        double withdrawS = 6000;
        double withdrawC = 4100;
        double deposit = 5000;
        SavingsAccount savAcc = new SavingsAccount("Saikat Sheet", 123, balance, rate, time);
        savAcc.withdraw(withdrawS);
        savAcc.deposit(deposit);
        savAcc.update();
        savAcc.display();

        CurrentAccount currAcc = new CurrentAccount("Tuhin Bhowmik", 987, balance);
        currAcc.withdraw(withdrawC);
        currAcc.update();
        currAcc.display();
    }
}