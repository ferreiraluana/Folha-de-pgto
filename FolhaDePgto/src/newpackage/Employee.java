package newpackage;

public class Employee
{
    String name;
    String address;
    String type; //hourly (with extra hour or not), salaried (commissioned or not)
    float salary, extra;
    int id;

    public void addEmployee(String nome, String address, String type, float salary, float extra, int id)
    {
        this.name = nome;
        this.address = address;
        this.type = type;
        this.salary = salary;
        this.extra = extra;
        this.id = id;
    }
}
