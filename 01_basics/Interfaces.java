// Interface in Java-: 
// Is a reference type that acts as a behavioral contract or blueprint for classes. It is used to achieve abstraction, enable multiple inheritance, and promote loose coupling in software design.

// Interfaces cannot have constructors, and any variables declared within them are implicitly constant (final/read-only) and cannot be changed after definition.
// All the methods inside constructor are by default abstract.

interface Device
{
    void switchOn();
    void switchOff();
}
class Mobile implements Device
{
    @Override 
    public void switchOn()
    {
        System.out.println("Mobile switch on");
    }
    @Override 
    public void switchOff()
    {
        System.out.println("Mobile switch off");
    }
}
class Interfaces {
    public static void main(String[] args) {
        Device d = new Mobile();
        d.switchOn();
        d.switchOff();
    }
}