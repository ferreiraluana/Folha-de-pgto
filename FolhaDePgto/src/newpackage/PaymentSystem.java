package newpackage;
import java.util.Scanner;
public class PaymentSystem
{
    public static void main(String[] args)
    {
        System.out.println("***   Welcome to the Employee Payment System   ***");
        System.out.println("Available operations:");
        System.out.print("Options:\n 1. Add a new employee\n 2. Remove an employee\n");
        System.out.println("3. Launch Frequency information"); // lançar cartão de ponto
        System.out.println("4. Launch Selling Results");
        System.out.println("5. Launch Service Taxes"); // extra
        System.out.println("6. Change employee information");
        System.out.println("7. Run Payrow\n8. Undo/Redo");
        System.out.println("9. Payment Schedule");
        System.out.println("10. Create new Payment Schedule\n");

        System.out.println("Enter the code to an operation:");
        Scanner data = new Scanner(System.in);
        int op = data.nextInt();
        String buffer = data.nextLine();
        Employee[] person = new Employee[100];

        if(op == 1)
        {
            int i;
            int id = -1;
            for(i = 1; i < person.length; i++)
            {
                if(person[i] == null)
                {
                    id = i;
                    break;
                }
            }
            if(id != -1)
            {
                readData(data, person, id);
                printData(person, id);
            }
            else System.out.println("System Capacity Overflow");
        }
    }

    private static void readData(Scanner data, Employee[] person, int id)
    {

        System.out.println("Enter the employee full name:");
        String name = data.nextLine();

        System.out.println("Enter the employee address:");
        String address = data.nextLine();

        System.out.println("Enter the type of employee: HOURLY or SALARIED");
        String type = data.nextLine();

        System.out.println("Enter the salary:");
        float salary = data.nextFloat();

        if(type.equals("hourly") || type.equals("HOURLY") || type.equals("Hourly"))
            System.out.println("Enter the number of extra hours:");
        else if(type.equals("salaried") || type.equals("SALARIED") || type.equals("Salaried"))
            System.out.println("Enter the value of the comission:");

        float extra = data.nextFloat();

        person[id].addEmployee(name,address,type,salary,extra,id);
    }

    private static void printData(Employee[] person, int id)
    {
        System.out.println("\nEmployee succesfully registered!");
        System.out.println(person[id].name);
        System.out.println(person[id].address);
        System.out.println(person[id].type);
        System.out.println(person[id].salary);
        System.out.println(person[id].extra);
        System.out.println(person[id].id);
        System.out.println("\n***   Thank you for using our services   ***");
    }
}
