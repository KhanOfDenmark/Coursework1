import java.util.Random;

public class EmployeeBook {
    private static final Employee[] EMPLOYEES = new Employee[10];
    private static Employee[] SORTEDBYDEPARTMENT;

    public static final Random RANDOM = new Random();
    public static final String[] SURNAMES = {"Степанов","Ильин","Михалков","Владимиров","Аркадьев"};
    public static final String[] NAMES = {"Степан","Илья","Михаил","Владимир","Аркадий"};
    public static final String[] PATRONYMIC = {"Степанович","Ильичёв","Михайлович","Владимирович",
            "Аркадьевич"};
    public static int department;
    public static int salary;

    static void println(Object text){
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

    public static void sortByDepartment(int department1){
        int i = 0;
        department = department1;
        for(Employee employee : EMPLOYEES){
            if(employee.getDepartment()==(byte)department1) i++;
        }
        SORTEDBYDEPARTMENT = new Employee[i];
        i = 0;
        for(Employee employee : EMPLOYEES){
            if(employee.getDepartment()==(byte)department1) SORTEDBYDEPARTMENT[i++] = employee;
        }
    }

    public static Employee minimumWageForEmployeesSBD(){
        Employee min = new Employee("", 0,0);
        for(Employee employee : SORTEDBYDEPARTMENT){
            if(min.getSalary() > employee.getSalary() || employee.getSalary() != 0) min = employee;
        }
        return min;
    }

    public static Employee maximumWageForEmployeesSBD(){
        Employee max = new Employee("", 0,0);
        for(Employee employee : SORTEDBYDEPARTMENT){
            if(max.getSalary() < employee.getSalary()) max = employee;
        }
        return max;
    }

    public static int calculateTheCostAmountSBD(){
        int sum = 0;
        for(Employee employee : SORTEDBYDEPARTMENT){
            sum += employee.getSalary();
        }
        return sum;
    }

    public static double averageValueOfSalariesSBD(){
        return (double)calculateTheCostAmountSBD()
                /SORTEDBYDEPARTMENT.length;
    }

    public static void indexSalariesSBD(int percent){
        for(Employee employee : SORTEDBYDEPARTMENT){
            employee.setSalary(employee.getSalary() +(employee.getSalary() *percent /100));
        }
    }

    public static void printDepartmentEmployees(){
        for(Employee employee : SORTEDBYDEPARTMENT){
            println(employee.getFullName() +" | Зарплата: " +employee.getSalary());
        }
    }

    public static void sortBySalary(int number){
        salary = number;
    }

    public static void lessThanANumber(){
        for(Employee employee : EMPLOYEES){
            if(employee.getSalary() < salary)println(employee.getId() +" "
                    +employee.getFullName() +" | Зарплата: " +employee.getSalary());
        }
    }

    public static void moreThanANumber(){
        for(Employee employee : EMPLOYEES){
            if(employee.getSalary() >= salary)println(employee.getId() +" "
                    +employee.getFullName() +" | Зарплата: " +employee.getSalary());
        }
    }

    public static boolean addAnEmployee(Employee employee){
        for(int i = 0;i < EMPLOYEES.length;i++)
            if(EMPLOYEES[i] == null){
                EMPLOYEES[i] = employee;
                return true;
            }
        return false;
    }

    public static boolean addAnEmployee(String fullName, int department, int salary){
        for(int i = 0;i < EMPLOYEES.length;i++)
            if(EMPLOYEES[i] == null){
                EMPLOYEES[i] = new Employee(fullName, department, salary);
                return true;
            }
        return false;
    }
    public static boolean addAnEmployee(String surname, String name,
                    int department, int salary){
        for(int i = 0;i < EMPLOYEES.length;i++)
            if(EMPLOYEES[i] == null){
                EMPLOYEES[i] = new Employee(surname, name, department, salary);
                return true;
            }
        return false;
    }
    public static boolean addAnEmployee(String surname, String name, String patronymic,
                    int department, int salary){
        for(int i = 0;i < EMPLOYEES.length;i++)
            if(EMPLOYEES[i] == null){
                EMPLOYEES[i] = new Employee(surname, name, patronymic,
                        department, salary);
                return true;
            }
        return false;
    }

    public static void deleteAnEmployee(int id){
        for(int i = 0;i < EMPLOYEES.length;i++)
            if(EMPLOYEES[i].getId()==id)EMPLOYEES[i]=null;
    }

    public static Employee findAnEmployeeById(int id){
        for (Employee employee : EMPLOYEES)
            if (employee.getId() == id) {
                return employee;
            }
        throw new RuntimeException("Wrong ID");
    }
}