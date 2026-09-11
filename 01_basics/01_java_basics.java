// JAVA Boilerplate-:

// class Main
// {
//    public static void main(String args[])
//    {
//
//    }
// }

// public- It is a access modifier. It defines the scope of variables, functions and methods.

// We have four types of modifier;
// 1) public, 
// 2) private(within a call), 
// 3) protected (inheritedn class)
// 4) default (within a package)

// static- When we want to access the functions of a class without making any object, we use the keyword static.
// It depends on class and not on object.
// We define it here cause it is a starting point, and if we don't then we have to create an object for the main class.
// Then complier won't be able to find the main, if don't define static.

// void- When function doesn't return anything then return type is void.

// main- It is a methods.

// String args[] - To read the command line inputs.

// Constructor- Used to initialize the data numbers. It is a special type of method, defined in the class and it's name is same as the class name.

// this- Current class reference. 



class Student
{
    String name;
    int rollNo;
    String course;

    Student (String name, int rollNo, String course)
    {
        this.name = name;
        this.course = course;
        this.rollNo = rollNo;
    }

    void study()
    {
        System.out.println("Study...");
    }
}
class Main
{
    public static void main(String args[])
    {
        Student stu1 = new Student("Kriti", 1001, "B.Tech");
        stu1.study();
    }
}





