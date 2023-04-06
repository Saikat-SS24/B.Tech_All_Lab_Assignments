class Time
{
    int hour;
    int min;
    int sec;
    Time(int hour, int min, int sec)
    {
        this.hour = hour;
        this.min = min;
        this.sec = sec;
    }
    void get_time()
    {
        if(hour>12)
        {
            System.out.println("Time-" +(hour-12)+ ":" +min+ ":" +sec+ "pm");
        }
        else
        {
            System.out.println("Time-" +(hour)+ ":" +min+ ":" +sec+ "pm");
        }
    }
}
class DemoTime
{
    public static void main(String args[])
    {
        Time obj = new Time(20,2,4);
        obj.get_time();
    }
}

