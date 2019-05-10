package newpackage;
import java.util.Scanner;
public class PaymentSystem
{
    public static void main(String[] args)
    {
        System.out.println("***   Welcome to the Employee Payment System   ***");
        System.out.println("Continue to add an employee");
        Scanner data = new Scanner(System.in);
        Employee person = new Employee();
        readData(data, person);
        printData(data, person);
    }

    public static void readData(Scanner data, Employee person)
    {

        System.out.println("Enter the employee full name:");
        String name = data.nextLine();

        System.out.println("Enter the employee address:");
        String address = data.nextLine();

        System.out.println("Enter the type of employee: HOURLY or SALARIED");
        String type = data.nextLine();

        //String getchar = data.nextLine();

        System.out.println("Enter the salary:");
        float salary = data.nextFloat();

        if(type.equals("hourly") || type.equals("HOURLY") || type.equals("Hourly"))
            System.out.println("Enter the number of extra hours:");
        else if(type.equals("salaried") || type.equals("SALARIED") || type.equals("Salaried"))
            System.out.println("Enter the value of the comission:");

        float extra = data.nextFloat();

        System.out.println("Enter the associated number to this employee:");
        int number = data.nextInt();

        person.addEmployee(name,address,type,salary,extra,number);
    }

    public static void printData(Scanner data, Employee person)
    {
        System.out.println();
        System.out.println("Employee succesfully registered!");
        System.out.println(person.name);
        System.out.println(person.address);
        System.out.println(person.type);
        System.out.println(person.salary);
        System.out.println(person.extra);
        System.out.println(person.number);
        System.out.println();
        System.out.println("***   Thank you for using our services   ***");
    }
}
