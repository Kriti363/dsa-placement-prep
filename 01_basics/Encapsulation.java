// Encapsulation-:
// We use access modifier and protect our data. Wrappping of methods and protect it from external sources.
// Encapsulation in Java is a fundamental object-oriented programming (OOP) concept that bundles data (variables) and the methods that operate on that data into a single unit, typically a class. It is often referred to as data hiding because it isolates an object's internal state from direct external modification.


// Encapsulation in Java is a fundamental object-oriented programming (OOP) concept that bundles data (variables) and the methods that operate on that data into a single unit.

// Encapsulation in Java is a fundamental object-oriented programming (OOP) concept
// that bundles data (variables) and the methods that operate on that data into a single unit.
// We use access modifiers to protect data from external access.

public class Encapsulation {
    public static void main(String[] args)
    {
        Account acc = new Account("Kriti", 14123211, 5000);
        System.out.println(acc.getBalance());     // 5000
        acc.setBalance(7000);
        System.out.println(acc.getBalance());    //  7000
    }
}

class Account
{
    private String name;
    private int accNo;
    private int balance;

    Account(String name, int accNo, int balance)
    {
        this.name = name;
        this.accNo = accNo;
        this.balance = balance;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
}


// Here we used setter and getter used.

// Funtion doesn't depend on any object.
// Methods are dependent on object.