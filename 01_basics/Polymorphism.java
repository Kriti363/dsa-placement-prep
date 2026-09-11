// Polymorphism in Java-: 
// Is a core Object-Oriented Programming (OOP) concept that allows a single entity (such as a method or an object) to take on multiple forms. Derived from the Greek words poly (many) and morph (forms), it enables you to perform a single action in different ways, making your code highly flexible, reusable, and maintainable. 

// Java supports two primary types of polymorphism: 
// Compile-Time (Static) Polymorphism- Method overloading
// Runtime-Time (Dynamic) Polymorphism- Method ovverriding

// Method overloading- Is a feature that allows a class to have multiple methods with the same name, but different parameter lists. Inheritance is not required.
// Method overriding- Is an object-oriented programming feature that lets a subclass provide a specific implementation of a method already defined in its parent class. Inheritance is compulsory.

// Example of Method overloading:

public class Polymorphism
{
    static int add (int a, int b)
    {
        return a + b;
    }
    static double add (double a, double b)
    {
        return a + b;
    } 
    static int add (int a, int b, int c)
    {
        return a + b + c;
    }

public static void main (String args[])
{
    System.out.println(add(10, 12, 6));
    System.out.println(add(5, 12));
    System.out.println(add(10.7, 12.5));
}
}


// Example of Method overriding:

class Payment
{
    void pay()
    {
        System.out.println("Making payment");
    }
}
class CreditCard extends Payment
{
    @Override
    void pay()
    {
        System.out.println("Making payment through credit card");
    }
}
class Upi extends Payment
{
    @Override 
    void pay()
    {
        System.out.println("Making payment through Upi");
    }
}
class Main
{
    public static void main (String args[])
    {
        CreditCard card = new CreditCard();
        card.pay();
        Upi obj = new Upi();
        obj.pay();
    }
}
