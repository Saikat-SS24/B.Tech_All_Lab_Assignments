class Commission
{
    int sales;
    Commission(){}
    Commission(int sales)
    {
        if(sales<0)
        {
            System.out.println("Invalid Input");
        }
        else
        {
            this.sales = sales;
        }
    }

    void getCommision()
    {
        System.out.println("The commission sale is: "+this.sales);
    }
}

class Commissions
{
    public static void main(String args[])
    {
        Commission c1 = new Commission(-3);
        Commission c2 = new Commission(3);
        c2.getCommision();
    }
}