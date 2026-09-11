// Inheritance-:

// Inheritance in Java is a fundamental Object-Oriented Programming (OOP) mechanism that allows one class (the subclass or child class) to acquire the properties (fields) and behaviors (methods) of another class (the superclass or parent class). Implemented using the extends keyword, its primary purposes are to promote code reusability and to establish an "IS-A" relationship between related classes.
// Types: single, hierarchical, mutlilevel, multiple and hybrid.

public class Inheritance
{
    public static void main(String args[])
    {
        Laptop pc = new Laptop();
        gamingLaptop pc2 = new gamingLaptop();
        pc2.start();
        pc2.showBattery();
        pc2.playGame();
    }
}
class Computer 
{
    void start()
    {
        System.out.println("Started");
    }
}
class Laptop extends Computer
{
    void showBattery()
    {
        System.out.println("Showing battery percentage");
    }
}
class gamingLaptop extends Laptop
{
    void playGame()
    {
        System.out.println("Playing games");
    }
}
class Desktop extends Computer
{
    void showProcessor()
    {
        System.out.println("Showing Processor");
    }
}