package newpackage;
import java.util.Scanner;
public class PaymentSystem
{
    private final static int numberEmployee = 100;
    private static String[] name = new String[numberEmployee];
    private static String[] address = new String[numberEmployee];
    private static String[] type = new String[numberEmployee]; //hourly (with extra hour or not), monthly (commissioned or not)
    private static String[] paymentMethod = new String[numberEmployee];
    private static double[] salary = new double[numberEmployee];
    private static double[] hourPrice = new double[numberEmployee];
    private static int[] workedHours = new int[numberEmployee];
    private static int[] extraHours = new int[numberEmployee];
    private static String[] payPeriod = new String[numberEmployee];
    private static double[] extra = new double[numberEmployee];
    private static boolean[] comissioned = new boolean[numberEmployee];
    private static boolean[] union = new boolean[numberEmployee];
    private static double[] unionFee = new double[numberEmployee];
    private static int[] id = new int[numberEmployee];

    private static Scanner data = new Scanner(System.in);

    public static void main(String[] args)
    {
        System.out.println("***   Welcome to the Employee Payment System   ***");
        System.out.println("Available operations: [1]/[2]/[3]/[4]/[5]/[6]/[7]");
        System.out.print("Options:\n 1. Add a new employee\n 2. Remove an employee\n");
        System.out.println("3. Launch Frequency Information Card");
        System.out.println("4. Launch Selling Results");
        System.out.println("5. Launch Service Taxes"); // extra
        System.out.println("6. Change employee information");
        System.out.println("7. Run Payment System\n8. Undo/Redo");
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

        if(operation == 2)
        {
           operation2();
        }

        if(operation == 3)
        {
            operation3();
        }

        if(operation == 4)
        {
            operation4();
        }

        if(operation == 5)
        {
            operation5();
        }

        if(operation == 6)
        {
            operation6();
        }

        if(operation == 7)
        {
            operation7();
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
                addEmployee(i);
                //printData(i);
                break;
            }
        }
        if(i == numberEmployee - 1) System.out.println("System Capacity Overflow");
    }

    private static void operation2()
    {
        System.out.println("Enter the employee ID to remove it:");
        int i = data.nextInt();
        id[i] = -1;
        System.out.println("Employee "+i+" removed!");
    }

    private static void operation3()
    {
        System.out.println("Enter the employee ID to launch the card:");
        int id = data.nextInt();
        launchCard(id);
    }

    private static void operation4()
    {
        System.out.println("Enter the employee ID:");
        int id = data.nextInt();
        System.out.println("Enter the selling result:");
        double aux = data.nextDouble();
        salary[id] += aux;
    }

    private static void operation5()
    {
        System.out.println("Enter the employee ID:");
        int id = data.nextInt();
        System.out.println("Launch the service taxes:");
        double aux = data.nextDouble();
        salary[id] -= aux;
    }

    private static void operation6()
    {
        System.out.println("Enter the employee ID:");
        int i = data.nextInt();
        System.out.println("Information available:\n[N]ame | [A]ddress | [T]ype | [S]alary | [E]xtra | [I]d | [U]nion | Union [F]ee | [P]ayment Method");
        String detail = data.nextLine();

        switch (detail)
        {
            case "N": case "n": {
                System.out.println("Enter new name:");
                String aux1 = data.nextLine();
                setName(aux1, i);
                break;
            }
            case "A": case "a": {
                System.out.println("Enter new address:");
                String aux2 = data.nextLine();
                setAddress(aux2, i);
                break;
            }
            case "T": case "t": {
                System.out.println("Enter new type:");
                String aux3 = data.nextLine();
                setType(aux3, i);
                break;
            }
            case "S": case "s": {
                System.out.println("Enter new salary:");
                double aux4 = data.nextDouble();
                setSalary(aux4, i);
                break;
            }
            case "E": case "e": {
                System.out.println("Enter new extra:");
                double aux5 = data.nextDouble();
                setExtra(aux5, i);
                break;
            }
            case "U": case "u": {
                System.out.println("Enter new membership: 'true' or 'false'");
                String aux6 = data.nextLine();
                if(aux6.equals("true"))
                    setUnion(true,i);
                else if(aux6.equals("false"))
                    setUnion(false,i);
                break;
            }
            case "F": case "f": {
                System.out.println("Enter new union fee:");
                double aux7 = data.nextDouble();
                setUnionFee(aux7, i);
            }
            case "P": case "p": {
                System.out.println("Enter new payment method:");
                String aux8 = data.nextLine();
                setPaymentMethod(aux8, i);
                break;
            }

            default:
                System.out.println("INVALID INPUT");
        }
    }

    private static void operation7()
    {
        System.out.println("Enter the date:\nMonth: 1-12");
        int m = data.nextInt();

        System.out.println("Day: 1-31");
        int d = data.nextInt();

        System.out.println("Year:");
        int y = data.nextInt();

        int day0 = weekDay(m,d,y);
        String day = " "; //initialize
        switch (day0)
        {
            case 0: {day = "Saturday"; break;}
            case 1: {day = "Sunday"; break;}
            case 2: {day = "Monday"; break;}
            case 3: {day = "Tuesday"; break;}
            case 4: {day = "Wednesday"; break;}
            case 5: {day = "Thursday"; break;}
            case 6: {day = "Friday"; break;}
        }

        System.out.println("Running Payment System...");
        System.out.println("Found Employees:\n");

        for(int i=1; i<numberEmployee; i++)
        {
            if(id[i] != -1)
            {
                if(type[i].equals("h"))
                {
                    calculateHourlySalary(i);
                    if(day.equals("Friday"))
                        printData(i);
                }
                else if(type[i].equals("m"))
                {
                    calculateMonthlySalary(i);
                    if(day.equals(payPeriod[i]))
                        printData(i);
                }
            }

        }
    }

    private static int weekDay(int m, int d, int y)
    {
        //it works only for 21th century
        //https://pt.wikihow.com/Calcular-o-Dia-da-Semana-de-uma-Data-Qualquer

        int a = ((m+d)-((m+d)%7))/7;
        int b = ((y%100)%28) + ((y%100)/4);
        int c = bissexto(y);
        if((m == 1 || m == 2) && c == 1)
            b--;

        return ((a+b)%7);
    }

    private static int bissexto(int y)
    {
        if(y%400 == 0) return 1;
        else if(y%4 == 0)
        {
            if(y%100 == 0 && y%400 != 0) {return 0;}
            return 1;
        }
        return 0;
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
            workedHours[i] = 0;
            hourPrice[i] = 0;
            extraHours[i] = 0;
        }
    }

    private static void addEmployee(int id)
    {

        System.out.println("Enter the employee full name:");
        name[id] = data.nextLine();

        System.out.println("Enter the employee address:");
        address[id] = data.nextLine();

        System.out.println("Enter the type of employee: [H]OURLY or [C]OMMISSIONED");
        String type1 = data.nextLine();
        switch (type1)
        {
            case "Hourly": case "hourly": case "HOURLY": case "h": case "H":
            {
                hourlySalaried(id);
                type[id] = "h";
                break;
            }
            case "Commissioned": case "COMMISSIONED": case "commissioned": case "C": case "c":
            {
                monthlySalaried(id);
                type[id] = "m";
                break;
            }

        default:
            System.out.println("Invalid Type");
        }

        unionInfo(id);

        System.out.println("Enter the payment method: 'mail check', 'in hand check' or 'bank account':");
        paymentMethod[id] = data.nextLine();
    }

    private static void unionInfo(int id)
    {
        System.out.println("Union membership: [M]ember | [N]ot member");
        String u = data.nextLine();
        switch (u)
        {
            case "M": case "m":
            {
                union[id] = true;
                System.out.println("Enter the union fee:");
                unionFee[id] = data.nextDouble();
                break;
            }
            case "N": case "n":
            {
                union[id] = false;
                break;
            }

            default:
                System.out.println("Invalid input!");
        }

    }

    private static void hourlySalaried(int id)
    {
       System.out.println("Type the hour price:");
       hourPrice[id] = data.nextFloat();
       System.out.println("Type the payment period:");
       payPeriod[id] = data.nextLine();
    }

    private static void monthlySalaried(int id)
    {
        System.out.println("Enter the salary:");
        salary[id] = data.nextDouble();
        System.out.println("Is the employee commissioned? [Y]es | [N]o");
        String input = data.nextLine();
        switch (input)
        {
            case "Y": case "y":
            {
                comissioned[id] = true;
                System.out.println("Enter the employee extra commission:");
                extra[id] = data.nextDouble();
                break;
            }
            case "n": case "N":
            {
                comissioned[id] = false;
                break;
            }

            default:
                System.out.println("Invalid input!");
        }

        System.out.println("Type the payment period:");
        payPeriod[id] = data.nextLine();
    }

    private static void launchCard(int id)
    {
        System.out.println("Enter the entrance time:");
        int start = data.nextInt();
        System.out.println("Enter the exit time:");
        int end = data.nextInt();

        workedHours[id] = (end - start); //24h format
        if(workedHours[id] < 0) workedHours[id] += 24;

        if(type[id].equals("Hourly") || type[id].equals("HOURLY") || type[id].equals("hourly"))
        {
            if(workedHours[id] > 8)
                extraHours[id] -= 8;
        }
    }

    private static void calculateHourlySalary(int id)
    {
        salary[id] = hourPrice[id]*(workedHours[id] - extraHours[id]) + 1.5*hourPrice[id]*extraHours[id]
        + unionFee[id];
    }

    private static void calculateMonthlySalary(int id)
    {
        salary[id] += extra[id];
    }

    private static void printData(int i)
    {
        System.out.println("\nEmployee successfully registered!");
        System.out.println("Name: "+name[i]);
        System.out.println("Address: "+address[i]);
        System.out.println("Payment Method: "+paymentMethod[i]);
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

    private static void setSalary(double salary1, int i)
    {
        salary[i] = salary1;
    }

    private static void setExtra(double extra1, int i)
    {
        extra[i] = extra1;
    }

    private static void setUnion(boolean union1, int i)
    {
       union[i] = union1;
    }

    private static void setUnionFee(double unionFee1, int i)
    {
        unionFee[i] = unionFee1;
    }

    private static void setPaymentMethod(String paymentMethod1, int i)
    {
        paymentMethod[i] = paymentMethod1;
    }

}
