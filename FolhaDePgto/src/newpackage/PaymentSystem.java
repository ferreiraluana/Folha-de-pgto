package newpackage;
import java.util.Scanner;
public class PaymentSystem
{
    private final static int numberEmployee = 100;
    private static String[] name = new String[numberEmployee];
    private static String[] address = new String[numberEmployee];
    private static String[] type = new String[numberEmployee]; //hourly (with extra hour or not), salaried (commissioned or not)
    private static float[] salary = new float[numberEmployee];
    private static float[] extra = new float[numberEmployee];
    private static boolean[] union = new boolean[numberEmployee];
    private static float[] unionFee = new float[numberEmployee];
    private static int[] id = new int[numberEmployee];

    private static Scanner data = new Scanner(System.in);

    public static void main(String[] args)
    {
        System.out.println("***   Welcome to the Employee Payment System   ***");
        System.out.println("Available operations: [1]/[6]");
        System.out.print("Options:\n 1. Add a new employee\n 2. Remove an employee\n");
        System.out.println("3. Launch Frequency information"); // lançar cartão de ponto
        System.out.println("4. Launch Selling Results");
        System.out.println("5. Launch Service Taxes"); // extra
        System.out.println("6. Change employee information");
        System.out.println("7. Run Payrow\n8. Undo/Redo");
        System.out.println("9. Payment Schedule");
        System.out.println("10. Create new Payment Schedule\n");

        setArray();

        System.out.println("Enter the code to an operation:");
        int operation = data.nextInt();
        String buffer = data.nextLine();

        if(operation == 1)
        {
            operation1();
        }

        if(operation == 6)
        {
            operation6();
        }
    }

    private static void operation1()
    {
        int i;
        for(i = 1; i < numberEmployee; i++)
        {
            if(id[i] == -1)
            {
                id[i] = i;
                readData(data, i);
                printData(i);
                break;
            }
        }
        if(i == numberEmployee - 1) System.out.println("System Capacity Overflow");
    }

    private static void operation6()
    {
        System.out.println("Enter the employee ID:");
        int i = data.nextInt();
        System.out.println("Information available:\n[N]ame | [A]ddress | [T]ype | [S]alary | [E]xtra | [I]d");
        String detail = data.nextLine();

        switch (detail)
        {
            case "N":
                System.out.println("Enter new name:");
                String aux1 = data.nextLine();
                setName(aux1, i);
            case "A":
                System.out.println("Enter new address:");
                String aux3 = data.nextLine();
                setAddress(aux3, i);
            case "T":
                System.out.println("Enter new type:");
                String aux5 = data.nextLine();
                setType(aux5, i);
            case "S":
                System.out.println("Enter new salary:");
                float aux7 = data.nextFloat();
                setSalary(aux7, i);
            case "E":
                System.out.println("Enter new extra:");
                float aux9 = data.nextFloat();
                setExtra(aux9, i);

            default:
                System.out.println("INVALID INPUT");
        }
    }

    private static void setArray()
    {
        int i;
        for(i=1; i<numberEmployee; i++)
        {
            id[i] = -1;
            salary[i] = 0;
            extra[i] = 0;
            unionFee[i] = 0;
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

        System.out.println("Union membership: [M]ember | [N]ot member");
        String membership1 = data.nextLine();

        float fee = 0;
        boolean membership = false;
        if(membership1.equals("M"))
        {
            membership = true;
            System.out.println("Enter union fee:");
            fee = data.nextFloat();
        }

        addEmployee(name,address,type,salary,extra,membership,fee,id);
    }

    private static void addEmployee(String name1, String address1, String type1, float salary1, float extra1, boolean union1, float fee, int i)
    {
        name[i] = name1;
        address[i] = address1;
        type[i] = type1;
        salary[i] = salary1;
        extra[i] = extra1;
        if(union1) union[i] = true;
        else union[i] = false;
        unionFee[i] = fee;
    }

    private static void printData(int i)
    {
        System.out.println("\nEmployee succesfully registered!");
        System.out.println("Name: "+name[i]);
        System.out.println("Address: "+address[i]);
        System.out.println("Type: "+type[i]);
        System.out.println("Salary: "+salary[i]);
        System.out.println("Extra: "+extra[i]);
        System.out.println("Union membership: "+union[i]);
        System.out.println("Union Fee: "+unionFee[i]);
        System.out.println("Id number: "+id[i]);
        System.out.println("\n***   Thank you for using our services   ***");
    }

    private static void setName(String name1, int i)
    {
        name[i] = name1;
    }

    private static void setAddress(String address1, int i)
    {
        address[i] = address1;
    }

    private static void setType(String type1, int i)
    {
        type[i] = type1;
    }

    private static void setSalary(float salary1, int i)
    {
        salary[i] = salary1;
    }

    private static void setExtra(float extra1, int i)
    {
        extra[i] = extra1;
    }

    private static void setUnion(boolean union1, int i)
    {
        if(union1) union[i] = true;
        else union[i] = false;
    }

    private static void setUnionFee(float unionFee1, int i)
    {
        unionFee[i] = unionFee1;
    }

}
