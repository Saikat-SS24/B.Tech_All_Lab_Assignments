class Employee
{
    private int id, salary;
    private String name, department;
    public void setValue(int id, String name, String department, int salary)
    {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }
    Employee(){}
    Employee(int id, String name, String department, int salary)
    {
        setValue(id, name, department, salary);
    }
    public void display()
    {
        System.out.println("Name: "+this.name+", Dept: "+this.department+", Salary: "+this.salary);
    }
    public int getSalary()
    {
        return this.salary;
    }
}

class Manager extends Employee
{
    private int bonus;
    Manager(){}
    Manager(int id, String name, String department, int salary, int bonus)
    {
        super(id, name, department, salary);
        this.bonus = bonus;
    }
    public int getTotalSalary()
    {
        return this.getSalary()+this.bonus;
    }
}

class Office
{
    public static void main(String args[])
    {
        Manager employeeList[] = new Manager[3];
        employeeList[0] = new Manager(1, "Saikat Sheet", "AI-ML", 25000, 5000);
        employeeList[1] = new Manager(2, "Suman Chatterjee", "Software Dev", 40000, 2500);
        employeeList[2] = new Manager(2, "Toni Stark", "CEO", 80000, 20000);
        int maxSal = 0;
        int highestIndex = -1;
        for(int i = 0; i<3; i++)
        {
            if(employeeList[i].getTotalSalary()>maxSal)
            {
                highestIndex = i;
            }
        }
        System.out.println("The highest paid employee: ");
        employeeList[highestIndex].display();
    }
}