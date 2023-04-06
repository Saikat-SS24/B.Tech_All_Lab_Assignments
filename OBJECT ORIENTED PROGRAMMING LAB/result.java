class Student
{
    String name, course; 
    int rollNo;
    int maths, english, physics, chemistry, biology;
    Student(){}
    Student(String name, String course, int rollNo, int maths, int english, int physics, int chemistry, int biology)
    {
        this.name = name;
        this.course = course;
        this.rollNo = rollNo;
        
        this.maths = maths;
        this.english = english;
        this.physics = physics;
        this.chemistry = chemistry;
        this.biology = biology;
    }
    float averageMarks()
    {
        return (this.maths+this.english+this.physics+this.chemistry+this.biology)/5;
    }
}

class StudentInfo
{
    int lastStudent = -1;
    Student studentList[] = new Student[10];

    StudentInfo(){}

    void add(Student newStudent)
    {
        boolean present = false;
        for(int i = 0; i<= lastStudent; i++)
        {
            if(studentList[i].name == newStudent.name)
            {
                studentList[i].maths = newStudent.maths;
                studentList[i].english = newStudent.english;
                studentList[i].physics = newStudent.physics;
                studentList[i].chemistry = newStudent.chemistry;
                studentList[i].biology = newStudent.biology;
                present = true;
            }
        }
        if(present == false)
        {
            studentList[++lastStudent] = newStudent;
        }
    }
    float studentWiseAvg()
    {
        int sum = 0;
        for(int i = 0; i<=lastStudent; i++)
        {
            sum += studentList[i].maths;
            sum += studentList[i].english;
            sum += studentList[i].physics;
            sum += studentList[i].chemistry;
            sum += studentList[i].biology;
        }
        return sum/(5+this.lastStudent+1);
    }

    float mathsAvg()
    {
        int sum = 0;
        for(int i = 0; i<=lastStudent; i++)
        {
            sum += studentList[i].maths;
        }
        return sum/5;
    }

    float englishAvg()
    {
        int sum = 0;
        for(int i = 0; i<=lastStudent; i++)
        {
            sum += studentList[i].english;
        }
        return sum/5;
    }

    float physicsAvg()
    {
        int sum = 0;
        for(int i = 0; i<=lastStudent; i++)
        {
            sum += studentList[i].physics;
        }
        return sum/5;
    }

    float chemistryAvg()
    {
        int sum = 0;
        for(int i = 0; i<=lastStudent; i++)
        {
            sum += studentList[i].chemistry;
        }
        return sum/5;
    }

    float biologyAvg()
    {
        int sum = 0;
        for(int i = 0; i<=lastStudent; i++)
        {
            sum += studentList[i].biology;
        }
        return sum/5;
    }
}

class Result
{
    public static void main(String args[])
    {
        Student s1 = new Student("Saikat", "BSH", 8, 98, 76, 45, 80, 100);
        Student s2 = new Student("Suman", "BSH", 2, 96, 56, 95, 100, 78);
        StudentInfo class2 = new StudentInfo();
        class2.add(s1);
        class2.add(s2);
        System.out.println("Average english marks: "+class2.englishAvg());
        System.out.println("Average student marks: "+class2.studentWiseAvg());
    }
}
