class Person
{
    String name, address;
    int age;
    Person(){}
    Person(String name, String address, int age)
    {
        this.name = name;
        this.address = address;
        this.age = age;
    }
    public String toString()
    {
        return ("Name: "+this.name+", Age: "+this.age+", Address: "+this.address);
    }
}

class Teacher extends Person
{
    int staffId;
    String department;
    Teacher(){}
    Teacher(String name, String address, int age, int staffId, String department)
    {
        super(name, address, age);
        this.staffId = staffId;
        this.department = department;
    }
    public String toString()
    {
        return ("Name: "+this.name+", Age: "+this.age+", Address: "+this.address+", StaffID: "+this.staffId+", Department: "+this.department);
    }
}

class Student extends Person
{
    int studentId, studyYear;
    String department;
    Student(){}
    Student(String name, String address, int age, int studentId, String department, int studyYear)
    {
        super(name, address, age);
        this.studentId = studentId;
        this.department = department;
        this.studyYear = studyYear;
    }
    public String toString()
    {
        return ("Name: "+this.name+", Age: "+this.age+", Address: "+this.address+", StudentID: "+this.studentId+", Department: "+this.department+", Year of study: "+this.studyYear);
    }
}

class School
{
    public static void main(String args[])
    {
        Person gurukul[] = new Person[3];
        gurukul[0] = new Teacher("Dronacharya", "32 Kurukshetra main road, Hastinapur: 600098", 70, 765, "Weaponry");
        gurukul[1] = new Student("Arjun", "1-B Hastinapur palace, Hastinapur: 600012", 21, 12, "Weaponry", 1201);
        gurukul[2] = new Student("Eklavya", "87 Forest palace, Hastinapur: 601061", 17, 19, "Weaponry", 12);
        for(int i = 0; i<3; i++)
        {
            System.out.println(gurukul[i]);
        }
    }
}