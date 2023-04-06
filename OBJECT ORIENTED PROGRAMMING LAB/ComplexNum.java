class Complex
{
    int x, y;
    Complex(){}
    Complex(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    void add(Complex c2)
    {
        int xComponent = c2.x+this.x;
        int yComponent = c2.y+this.y;
        this.x = xComponent;
        this.y = yComponent;
        System.out.println("The result is: " + xComponent + "+" + yComponent + "i");
    }

    void sub(Complex c2)
    {
        int xComponent = this.x-c2.x;
        int yComponent = this.y-c2.y;
        this.x = xComponent;
        this.y = yComponent;
        if(yComponent>0) System.out.println("The result is: " + xComponent + "+" + yComponent + "i");
        else if(yComponent<0) System.out.println("The result is: " + xComponent + yComponent + "i");
        else System.out.println("The result is: " + xComponent);
    }
    void mul(Complex c2)
    {
        int xComponent = c2.x*this.x;
        int yComponent = c2.y*this.y;
        this.x = xComponent;
        this.y = yComponent;
        System.out.println("The result is: " + (xComponent-yComponent));
    }





    Complex add(Complex c1, Complex c2)
    {
        int xComponent = c2.x+c1.x;
        int yComponent = c2.y+c1.y;
        Complex newComp = new Complex(xComponent, yComponent);
        System.out.println("The result is: " + xComponent + "+" + yComponent + "i");
        return newComp;
    }

    Complex sub(Complex c1, Complex c2)
    {
        int xComponent = c1.x-c2.x;
        int yComponent = c1.y-c2.y;
        Complex newComp = new Complex(xComponent, yComponent);
        if(yComponent>0) System.out.println("The result is: " + xComponent + "+" + yComponent + "i");
        else if(yComponent<0) System.out.println("The result is: " + xComponent + yComponent + "i");
        else System.out.println("The result is: " + xComponent);
        return newComp;
    }
    Complex mul(Complex c1, Complex c2)
    {
        int xComponent = c2.x*c1.x;
        int yComponent = c2.y*c1.y;
        Complex newComp = new Complex(xComponent, yComponent);
        System.out.println("The result is: " + (xComponent-yComponent));
        return newComp;
    }
}

class ComplexNum
{
    public static void main(String[] args)
    {
        Complex num1 = new Complex(20, 10);
        Complex num2 = new Complex(5, 7);
        num1.add(num2);
        num1.sub(num2);
        num1.mul(num2);
    }
}