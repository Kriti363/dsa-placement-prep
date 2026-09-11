// Abstraction in Java-:
// Is the process of hiding internal implementation details and exposing only the essential features to the user. It separates "what" an object does from "how" it does it.

public class Abstraction
{
    public static void main (String args[])
    {
        Payment card = new CreditCard();
        card.pay();
    }
}
abstract class Payment
{
    abstract void pay();
}
class CreditCard extends Payment
{
    @Override
    void pay()
    {
        System.out.println("Paying through credit card");
    } 
}