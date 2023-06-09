import java.lang.Math;
import java.util.Scanner;

class Calculator {
    double add(double i, double j) {
        return i + j;
    }

    double sub(double i, double j) {
        return i - j;
    }

    double mul(double i, double j) {
        return i * j;
    }

    double div(double i, double j) {
        return i / j;
    }

    double mod(double i, double j) {
        return i % j;
    }

    void runDefault() {
        while (true) {
            System.out.println("Enter 1 for addition");
            System.out.println("Enter 2 for subtraction");
            System.out.println("Enter 3 for multiplication");
            System.out.println("Enter 4 for division");
            System.out.println("Enter 5 for modulo");
            System.out.println("Enter 6 to exit");

            Scanner io = new Scanner(System.in);
            int choice = io.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter input(s)");
                    double i1 = io.nextDouble();
                    double j1 = io.nextDouble();
                    System.out.println(this.add(i1, j1));

                case 2:
                    System.out.println("Enter input(s)");
                    double i2 = io.nextDouble();
                    double j2 = io.nextDouble();
                    System.out.println(this.sub(i2, j2));

                case 3:
                    System.out.println("Enter input(s)");
                    double i3 = io.nextDouble();
                    double j3 = io.nextDouble();
                    System.out.println(this.mul(i3, j3));

                case 4:
                    System.out.println("Enter input(s)");
                    double i4 = io.nextDouble();
                    double j4 = io.nextDouble();
                    System.out.println(this.div(i4, j4));

                case 5:
                    System.out.println("Enter input(s)");
                    double i5 = io.nextDouble();
                    double j5 = io.nextDouble();
                    System.out.println(this.mod(i5, j5));
                case 6:
                    System.exit(1);
            }
            io.close();
        }
    }


    void runA() {
        while (true) {
            System.out.println("Enter 1 for addition");
            System.out.println("Enter 2 for subtraction");
            System.out.println("Enter 3 to exit");

            Scanner io = new Scanner(System.in);
            int choice = io.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter input(s)");
                    double i1 = io.nextDouble();
                    double j1 = io.nextDouble();
                    System.out.println(this.add(i1, j1));

                case 2:
                    System.out.println("Enter input(s)");
                    double i2 = io.nextDouble();
                    double j2 = io.nextDouble();
                    System.out.println(this.sub(i2, j2));
                case 3:
                    System.exit(1);
            }
            io.close();
        }
    }
}

class ScientificCalculator extends Calculator {
    double exp(double i, double j) {
        return Math.pow(i, j);
    }

    double sqrt(double i) {
        return Math.sqrt(i);
    }

    double log(double i) {
        return Math.log10(i);
    }

    void runS() {
        while (true) {
            System.out.println("Enter 1 for addition");
            System.out.println("Enter 2 for subtraction");
            System.out.println("Enter 3 for exponential");
            System.out.println("Enter 4 to exit");

            Scanner io = new Scanner(System.in);
            int choice = io.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter input(s)");
                    double i1 = io.nextDouble();
                    double j1 = io.nextDouble();
                    System.out.println(this.add(i1, j1));

                case 2:
                    System.out.println("Enter input(s)");
                    double i2 = io.nextDouble();
                    double j2 = io.nextDouble();
                    System.out.println(this.sub(i2, j2));

                case 3:
                    System.out.println("Enter input(s)");
                    double i3 = io.nextDouble();
                    double j3 = io.nextDouble();
                    System.out.println(this.exp(i3, j3));
                case 4:
                    System.exit(1);
            }
            io.close();
        }
    }
}

class Calculation {

    public static void main(String[] args) {
        Scanner finScan = new Scanner(System.in);
        System.out.println("Enter your initials");
        String choice = finScan.next();
        if (choice.equals("A")) {
            Calculator calc = new Calculator();
            calc.runA();
        } else if (choice.equals("S")) {
            ScientificCalculator calc = new ScientificCalculator();
            calc.runS();
        } else {
            Calculator calc = new Calculator();
            calc.runDefault();
        }
        finScan.close();
    }
}