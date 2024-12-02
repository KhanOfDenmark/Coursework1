public class Main {

    static void println(Object text){
        System.out.println(text);
    }

    static void putASeparator(){
        System.out.println("***");
    }

    public static void main(String[] args) {
        EmployeeBook.initEmployees();
        putASeparator();
        EmployeeBook.printAllEmployees();
        putASeparator();
        println("Затраты: " +EmployeeBook.calculateTheCostAmount());
        putASeparator();
        println("Сотрудник с минимальной зарплатой - " +EmployeeBook.minimumWageForEmployees());
        putASeparator();
        println("Сотрудник с максимальной зарплатой - " +EmployeeBook.maximumWageForEmployees());
        putASeparator();
        println("Среднее значение зарплат : " +EmployeeBook.averageValueOfSalaries());
        putASeparator();
        EmployeeBook.printTheInitialsOfAllEmployees();
        putASeparator();

        //Повышенная сложность
        EmployeeBook.indexSalaries(32);
        EmployeeBook.printAllEmployees();
        putASeparator();
        EmployeeBook.sortByDepartment(4);
        println("Сотрудник с минимальной зарплатой отдела - "
                +EmployeeBook.minimumWageForEmployeesSBD());
        putASeparator();
        println("Сотрудник с максимальной зарплатой отдела - "
                +EmployeeBook.maximumWageForEmployeesSBD());
        putASeparator();
        println("Затраты отдела #" +EmployeeBook.department +": " +EmployeeBook.calculateTheCostAmountSBD());
        putASeparator();
        println("Среднее значение зарплат отдела #" +EmployeeBook.department +": "
                +EmployeeBook.averageValueOfSalariesSBD());
        putASeparator();
        EmployeeBook.indexSalariesSBD(25);
        EmployeeBook.printDepartmentEmployees();
        putASeparator();
        EmployeeBook.sortBySalary(100000);
        EmployeeBook.lessThanANumber();
        putASeparator();
        EmployeeBook.moreThanANumber();
        putASeparator();
        EmployeeBook.deleteAnEmployee(4);
        println(EmployeeBook.addAnEmployee("Васнецов Степан", 2,120000));
        putASeparator();
        EmployeeBook.printAllEmployees();
        putASeparator();
        println(EmployeeBook.findAnEmployeeById(7));
        putASeparator();
    }
}