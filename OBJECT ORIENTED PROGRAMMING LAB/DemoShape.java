class Shape
{
    int x,y;
    Shape(){}
    Shape(int x,int y)
    {
        this.x = x;
        this.y = y;
    }
}
class Rectangle extends Shape
{
    int l,b;
    Rectangle(int l, int b)
    {
        super(l,b);
    }
    void area()
    {
        System.out.println(x*y);
    }
    void area(int m,int n)
    {
        System.out.println(m*n);
    }
}
class Square extends Shape
{
    int l;
    Square(int l)
    {
        x = l;
    }
    void area()
    {
        System.out.println(x*x);
    }
    void area(int l)
    {
        System.out.println(l*l);
    }
}
class Triangle extends Shape
{
    int l,b;
    Triangle(int l, int b)
    {
        super(l,b);
    }
    void area()
    {
        System.out.println(1/2*l*b);
    }
    void area(int x,int y)
    {
        System.out.println(1/2*x*y);
    }
}

class DemoShape
{
    public static void main(String args[])
    {
        Square obj1 = new Square(2);
        obj1.area();
    }
}