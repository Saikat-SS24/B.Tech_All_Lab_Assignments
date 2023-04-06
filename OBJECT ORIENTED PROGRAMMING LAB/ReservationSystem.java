class Reservation
{
    int capacity;
    int availableSeats[];
    Reservation(){};
    Reservation(int capacity)
    {
        this.capacity = capacity;
        this.availableSeats = new int[capacity];
        for(int i = 0; i<capacity; i++)
        {   
            availableSeats[i] = i;
        }
    }
    void assign(int seatNo)
    {
        if(seatNo>=this.capacity)
        {
            System.out.println("Invalid seat number!");
        }
        else if(this.availableSeats[seatNo]!=-1)
        {
            this.availableSeats[seatNo] = -1;
            System.out.println("Assignment successful!");
        }
        else
        {
            System.out.println("Assignment successful!");
        }
    }
    void displayAvailableSeats()
    {
        for(int i = 0; i<this.capacity; i++)
        {   
            if(this.availableSeats[i]!=-1)
            {
                System.out.print(this.availableSeats[i]+", ");
            };
        }
    }
}

class ReservationSystem
{
    public static void main(String args[])
    {
        Reservation r1 = new Reservation(5);
        r1.assign(2);
        r1.assign(6);
        r1.assign(3);
        r1.displayAvailableSeats();
    }
}