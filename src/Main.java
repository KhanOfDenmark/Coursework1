import java.util.Random;

public class Main {

    public static final Employee[] EMPLOYEES = new Employee[10];

    public static final Random RANDOM = new Random();
    public static final String[] SURNAMES = {"Степанов","Ильин","Михалков","Владимиров","Аркадьев"};
    public static final String[] NAMES = {"Степан","Илья","Михаил","Владимир","Аркадий"};
    public static final String[] PATRONYMIC = {"Степанович","Ильичёв","Михайлович","Владимирович",
            "Аркадьевич"};

    public static void putASeparator(){
        System.out.println("***");
    }

    public static void println(Object text){
        System.out.println(text);
    }

    public static void initEmployees(){
        for(int i = 0; i < EMPLOYEES.length; i++){
            EMPLOYEES[i] = new Employee(
                    SURNAMES[RANDOM.nextInt(0,5)],
                    NAMES[RANDOM.nextInt(0,5)],
                    PATRONYMIC[RANDOM.nextInt(0,5)],
                    (byte) RANDOM.nextInt(1,6),
                    RANDOM.nextInt(50_000,100_000));
        }
    }

    public static void printAllEmployees(){
        for(Employee employee : EMPLOYEES){
            println(employee);
        }
    }

    public static int calculateTheCostAmount(){
        int sum = 0;
        for(Employee employee : EMPLOYEES){
            sum += employee.getSalary();
        }
        return sum;
    }

    public static Employee minimumWageForEmployees(){
        Employee min = EMPLOYEES[0];
        for(Employee employee : EMPLOYEES){
            if(min.getSalary() > employee.getSalary()) min = employee;
        }
        return min;
    }

    public static Employee maximumWageForEmployees(){
        Employee max = EMPLOYEES[0];
        for(Employee employee : EMPLOYEES){
            if(max.getSalary() < employee.getSalary()) max = employee;
        }
        return max;
    }

    public static double averageValueOfSalaries(){
        return (double)calculateTheCostAmount() /EMPLOYEES.length;
    }

    public static void printTheInitialsOfAllEmployees(){
        for(Employee employee : EMPLOYEES){
            println(employee.getFullName());
        }
    }

    public static void indexSalaries(int percent){
        for(Employee employee : EMPLOYEES){
            employee.setSalary(employee.getSalary() +(employee.getSalary() *percent /100));
        }
    }

    //Повышенная сложность

    public static Employee minimumWageForEmployeesSBD(int department){
        Employee min = new Employee("", 0,0);
        for(Employee employee : EMPLOYEES)
            if(employee.getDepartment()==(byte)department)
                if(min.getSalary() > employee.getSalary() || employee.getSalary() != 0)
                    min = employee;
        return min;
    }

    public static Employee maximumWageForEmployeesSBD(int department){
        Employee max = new Employee("", 0,0);
        for(Employee employee : EMPLOYEES)
            if(employee.getDepartment()==(byte)department)
                if(max.getSalary() < employee.getSalary())
                    max = employee;
        return max;
    }

    public static int calculateTheCostAmountSBD(int department){
        int sum = 0;
        for(Employee employee : EMPLOYEES)
            if(employee.getDepartment()==(byte)department)
                sum += employee.getSalary();
        return sum;
    }

    public static double averageValueOfSalariesSBD(int department){
        int employeesOfTheDepartment = 0;
        for(Employee employee : EMPLOYEES)
            if(employee.getDepartment()==(byte)department)
                employeesOfTheDepartment++;
        return (double)calculateTheCostAmountSBD((byte)department)
                /employeesOfTheDepartment;
    }

    public static void indexSalariesSBD(int department, int percent){
        for(Employee employee : EMPLOYEES)
            if(employee.getDepartment()==(byte)department)
                employee.setSalary(employee.getSalary() +(employee.getSalary() *percent /100));
    }

    public static void printDepartmentEmployees(int department){
        for(Employee employee : EMPLOYEES)
            if(employee.getDepartment()==(byte)department)
                println(employee.getFullName() +" | Зарплата: " +employee.getSalary());
    }

    public static void lessThanANumber(int salary){
        for(Employee employee : EMPLOYEES)
            if(employee.getSalary() < salary)
                println(employee.getId() +" " +employee.getFullName() +" Зарплата: " +employee.getSalary());
    }

    public static void moreThanANumber(int salary){
        for(Employee employee : EMPLOYEES)
            if(employee.getSalary() >= salary)
                println(employee.getId() +" " +employee.getFullName() +" | Зарплата: " +employee.getSalary());
    }

    public static void main(String[] args) {
        initEmployees();
        putASeparator();
        printAllEmployees();
        putASeparator();
        println("Затраты: " +calculateTheCostAmount());
        putASeparator();
        println("Сотрудник с минимальной зарплатой - " +minimumWageForEmployees());
        putASeparator();
        println("Сотрудник с максимальной зарплатой - " +maximumWageForEmployees());
        putASeparator();
        println("Среднее значение зарплат : " +averageValueOfSalaries());
        putASeparator();
        printTheInitialsOfAllEmployees();
        putASeparator();

        //Повышенная сложность
        indexSalaries(32);
        printAllEmployees();
        putASeparator();
        println("Сотрудник с минимальной зарплатой отдела - "
                +minimumWageForEmployeesSBD(2));
        putASeparator();
        println("Сотрудник с максимальной зарплатой отдела - "
                +maximumWageForEmployeesSBD(2));
        putASeparator();
        println("Затраты отдела: " +calculateTheCostAmountSBD(2));
        putASeparator();
        println("Среднее значение зарплат отдела: " + averageValueOfSalariesSBD(2));
        putASeparator();
        indexSalariesSBD(4,25);
        printDepartmentEmployees(4);
        putASeparator();
        lessThanANumber(100000);
        putASeparator();
        moreThanANumber(100000);
        putASeparator();
    }
}