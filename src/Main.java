import java.util.Random;

public class Main {

    public static Employee[] employees = new Employee[10];

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
        for(int i = 0; i < employees.length; i++){
            employees[i] = new Employee(
                    SURNAMES[RANDOM.nextInt(0,5)],
                    NAMES[RANDOM.nextInt(0,5)],
                    PATRONYMIC[RANDOM.nextInt(0,5)],
                    RANDOM.nextInt(1,6),
                    RANDOM.nextInt(50_000,100_000));
        }
    }

    public static void printAllEmployees(){
        for(Employee employee : employees)
            println(employee);
    }

    public static void calculateTheCostAmount(){
        int sum = 0;
        for(Employee employee : employees)
            sum += employee.getSalary();
        println("Затраты: " +sum);
    }

    public static void printMinimumWageForEmployees(){
        Employee min = employees[0];
        for(Employee employee : employees)
            if(min.getSalary() > employee.getSalary()) min = employee;
        println("Сотрудник с минимальной зарплатой - " +min);
    }

    public static void printMaximumWageForEmployees(){
        Employee max = employees[0];
        for(Employee employee : employees)
            if(max.getSalary() < employee.getSalary()) max = employee;
        println("Сотрудник с максимальной зарплатой - " +max);
    }

    public static void printAverageValueOfSalaries(){
        double sum = 0;
        for(Employee employee : employees)
            sum += employee.getSalary();
        println("Среднее значение зарплат : " +(sum /employees.length));
    }

    public static void printTheInitialsOfAllEmployees(){
        for(Employee employee : employees)
            println(employee.getFullName());
    }

    public static void indexSalaries(int percent){
        for(Employee employee : employees)
            employee.setSalary(employee.getSalary() +(employee.getSalary() *percent /100));
    }

    //Повышенная сложность

    public static void printMinimumWageForEmployeesSBD(int department){
        Employee min = new Employee("", 0,0);
        for(Employee employee : employees)
            if(employee.getDepartment()==department)
                if(min.getSalary() > employee.getSalary() || employee.getSalary() != 0)
                    min = employee;
        println("Сотрудник с минимальной зарплатой отдела #" +department +" - " +min);
    }

    public static void printMaximumWageForEmployeesSBD(int department){
        Employee max = new Employee("", 0,0);
        for(Employee employee : employees)
            if(employee.getDepartment()==department)
                if(max.getSalary() < employee.getSalary())
                    max = employee;
        println("Сотрудник с максимальной зарплатой отдела #" +department +" - " +max);
    }

    public static void calculateTheCostAmountSBD(int department){
        int sum = 0;
        for(Employee employee : employees)
            if(employee.getDepartment()==department)
                sum += employee.getSalary();
        println("Затраты отдела #" +department +": " +sum);
    }

    public static void printAverageValueOfSalariesSBD(int department){
        double sum = 0;
        int employeesOfTheDepartment = 0;
        for(Employee employee : employees)
            if(employee.getDepartment()==department){
                employeesOfTheDepartment++;
                sum += employee.getSalary();
            }
        println("Среднее значение зарплат отдела #" +department +": " +(sum /employeesOfTheDepartment));
    }

    public static void indexSalariesSBD(int department, int percent){
        for(Employee employee : employees)
            if(employee.getDepartment()==department)
                employee.setSalary(employee.getSalary() +(employee.getSalary() *percent /100));
    }

    public static void printDepartmentEmployees(int department){
        println("Отдел #" +department);
        for(Employee employee : employees)
            if(employee.getDepartment()==department)
                println(employee.getFullName() +" | Зарплата: " +employee.getSalary());
    }

    public static void printSalariesLessThanANumber(int salary){
        for(Employee employee : employees)
            if(employee.getSalary() < salary)
                println(employee.getId() +" " +employee.getFullName() +" Зарплата: " +employee.getSalary());
    }

    public static void printSalariesMoreThanANumber(int salary){
        for(Employee employee : employees)
            if(employee.getSalary() >= salary)
                println(employee.getId() +" " +employee.getFullName() +" | Зарплата: " +employee.getSalary());
    }

    public static void main(String[] args) {
        initEmployees();
        putASeparator();
        printAllEmployees();
        putASeparator();
        calculateTheCostAmount();
        putASeparator();
        printMinimumWageForEmployees();
        putASeparator();
        printMaximumWageForEmployees();
        putASeparator();
        printAverageValueOfSalaries();
        putASeparator();
        printTheInitialsOfAllEmployees();
        putASeparator();

        //Повышенная сложность
        indexSalaries(32);
        printAllEmployees();
        putASeparator();
        printMinimumWageForEmployeesSBD(2);
        putASeparator();
        printMaximumWageForEmployeesSBD(2);
        putASeparator();
        calculateTheCostAmountSBD(2);
        putASeparator();
        printAverageValueOfSalariesSBD(2);
        putASeparator();
        indexSalariesSBD(4,25);
        printDepartmentEmployees(4);
        putASeparator();
        printSalariesLessThanANumber(100000);
        putASeparator();
        printSalariesMoreThanANumber(100000);
        putASeparator();
    }
}