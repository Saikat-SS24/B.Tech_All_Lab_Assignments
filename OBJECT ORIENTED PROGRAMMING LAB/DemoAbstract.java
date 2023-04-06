abstract class Shape
{
    int a,b;
    Shape(){}
    Shape(int a, int b)
    {
       this.a=a;
       this.b=b;
    }
    Shape(int a)
    {
        this.a=a;
    }
    abstract void area();
    abstract void display();
}

class Rectangle extends Shape
{
    int ar1;
    Rectangle(int a,int b)
    {
        super(a,b);
    }
    void area()
    {
        this.ar1=a*b;
    }
    void display()
    {
        System.out.println("Area of rectangle is "+this.ar1);
    }
}



class Triangle extends Shape
{
    double ar3;
    Triangle(int a,int b)
    {
        super(a,b);
    }
    void area()
    {
        this.ar3=0.5*a*b;
    }
    void display()
    {
        System.out.println("Area of Triangle is "+this.ar3);
    }
}

class DemoAbstract
{
    public static void main(String args[])
    {
        Shape ref;
        Rectangle ob1 = new Rectangle(2,4);
        Triangle ob3 = new Triangle(5,6);

        ref=ob1;
        ref.area();
        ref.display();

        ref=ob3;
        ref.area();
        ref.display();
    }
}