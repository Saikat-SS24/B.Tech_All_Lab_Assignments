import java.util.Scanner;

class Vehicle
{
    String companyName;
    int id, price;
    Vehicle(){}
    Vehicle(int id, String companyName, int price)
    {
        this.id = id;
        this.companyName = companyName;
        this.price = price;
    }
}

class LightMotorVehicle extends Vehicle
{
    float mileage;
    LightMotorVehicle(){}
    LightMotorVehicle(int id, String companyName, int price, float mileage)
    {
        super(id, companyName, price);
        this.mileage = mileage;
    }
    public String toString()
    {
        return ("ID: "+this.id+", Company Name: "+this.companyName+", Price: "+this.price+", Mileage: "+this.mileage+". ");
    }
}


class HeavyMotorVehicle extends Vehicle
{
    float capacity_in_tons;
    HeavyMotorVehicle(){}
    HeavyMotorVehicle(int id, String companyName, int price, float capacity_in_tons)
    {
        super(id, companyName, price);
        this.capacity_in_tons = capacity_in_tons;
    }
    public String toString()
    {
        return ("ID: "+this.id+", Company Name: "+this.companyName+", Price: "+this.price+", Capacity in tons: "+this.capacity_in_tons+". ");
    }
}

class Automobile
{
    public static void main(String args[])
    {
        Scanner io = new Scanner(System.in);
        System.out.println("Enter the number of vehicles:");
        int n = io.nextInt();
        Vehicle vehicles[] = new Vehicle[n];
        for(int i = 0; i<n; i++)
        {
            System.out.println("Enter 0 for LightWeight Vehicle, 1 for HeavyWeight Vehicle:");
            int choice = io.nextInt();
            if(choice == 0)
            {
                System.out.println("Enter Company name, Price and Mileage:");
                String cn = io.next();
                int p = io.nextInt();
                float m = io.nextFloat();
                vehicles[i] = new LightMotorVehicle(i+1000, cn, p, m);
            }
            else if(choice == 1)
            {
                System.out.println("Enter Company name, Price and Capacity in tons:");
                String cn = io.next();
                int p = io.nextInt();
                float cit = io.nextFloat();
                vehicles[i] = new HeavyMotorVehicle(i+1000, cn, p, cit);
            }
            else
            {
                System.out.println("Invalid choice!");
            }
        }
        for(int i = 0; i<n; i++)
        {
            System.out.println(vehicles[i]);
        }
    }
}