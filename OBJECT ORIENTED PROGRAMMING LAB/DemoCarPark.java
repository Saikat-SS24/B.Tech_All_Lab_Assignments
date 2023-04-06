import java.util.Scanner;

class Car
{
    int carNumber, hoursOfBooking;
    Car(){}
    Car(int carNumber, int hoursOfBooking)
    {
        this.carNumber = carNumber;
        this.hoursOfBooking = hoursOfBooking;
    }
}
class CarParking
{
    int rate, totalCollection, cars;
    CarParking(){}
    CarParking (int rate)
    {
        this.rate = rate;
    }
    void parkCar(Car newCar)
    {
        this.totalCollection += (newCar.hoursOfBooking*this.rate);
        this.cars += 1;
    }
}

class DemoCarPark
{
    public static void main(String args[])
    {
        Scanner io= new Scanner(System.in);
        System.out.print("Enter car number and hours of parking: ");
        int c1Num = io.nextInt();
        int c1Hrs = io.nextInt();
        Car c1 = new Car(c1Num, c1Hrs);
        System.out.print("Enter car number and hours of parking: ");
        int c2Num = io.nextInt();
        int c2Hrs = io.nextInt();
        Car c2 = new Car(c2Num, c2Hrs);

        CarParking parking = new CarParking(40);
        parking.parkCar(c1);
        parking.parkCar(c2);
        System.out.println("Number of cars parked: "+parking.cars);
        System.out.println("Total parking charge collected: "+parking. totalCollection);
    }
}