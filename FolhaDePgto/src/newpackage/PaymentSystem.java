package newpackage;
import java.util.Scanner;
public class PaymentSystem
{
    static String[] name = new String[100];
    static String[] address = new String[100];
    static String[] type = new String[100]; //hourly (with extra hour or not), salaried (commissioned or not)
    static float[] salary = new String[100];
    static float[] extra = new float[100];
    static int[] id = new int[100];

    Scanner data = new Scanner(System.in);

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
        int op = data.nextInt();
        String buffer = data.nextLine();

        if(op == 1)
        {
//            int i;
//            int id = -1;
//            for(i = 1; i < person.length; i++)
//            {
//                if(person[i] == null)
//                {
//                    id = i;
//                    break;
//                }
//            }
//            if(id != -1)
//            {
                readData(data, 1);
                printData();
//            }
//            else System.out.println("System Capacity Overflow");
        }
    }

    private static void readData(Scanner data, int id)
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

        addEmployee(name,address,type,salary,extra,id);
    }

    private static void printData()
    {
        System.out.println("\nEmployee succesfully registered!");
        System.out.println(this.name);
        System.out.println(this.address);
        System.out.println(this.type);
        System.out.println(this.salary);
        System.out.println(this.extra);
        System.out.println(this.id);
        System.out.println("\n***   Thank you for using our services   ***");
    }

    public static void addEmployee(String name, String address, String type, float salary, float extra, int id)
    {
        this.name = name;
        this.address = address;
        this.type = type;
        this.salary = salary;
        this.extra = extra;
        this.id = id;
    }

    public static void setName(String name)
    {
        name = name;
    }

    public static void setAddress(String address)
    {
        address = address;
    }

    public static void setType(String type)
    {
        type = type;
    }

    public static void setSalary(float salary)
    {
        salary = salary;
    }

    public static void setExtra(float extra)
    {
        extra = extra;
    }

    public static void setId(int id)
    {
        id = id;
    }

}
