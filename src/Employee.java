public class Employee {

    private static int idGenerator = 1;

    private final int id;
    private final String fullName;
    private byte department;
    private int salary;

    public Employee(String fullName, int department, int salary){
        this.department = (byte)department;
        this.salary = salary;
        this.fullName = fullName;
        this.id = idGenerator++;
    }
    public Employee(String surname, String name,
                    int department, int salary){
        this.department = (byte)department;
        this.salary = salary;
        this.fullName = surname +" " +name;
        this.id = idGenerator++;
    }
    public Employee(String surname, String name, String patronymic,
                    int department, int salary){
        this.id = idGenerator++;
        this.fullName = surname +" " +name +" " +patronymic;
        this.department = (byte)department;
        this.salary = salary;
    }


    public String getFullName(){
        return this.fullName;
    }
    public byte getDepartment(){
        return this.department;
    }
    public int getSalary(){
        return this.salary;
    }
    public int getId(){
        return this.id;
    }

    public void setDepartment(int department){
        this.department = (byte)department;
    }
    public void setSalary(int salary){
        this.salary = salary;
    }

    @Override
    public boolean equals(Object other){
        if (this.getClass() != other.getClass()) {
            return false;
        }
        Employee c2 = (Employee) other;
        return id == c2.id;
    }
    @Override
    public int hashCode(){
        return java.util.Objects.hash(id);
    }
    @Override
    public String toString(){
        return this.fullName +" | Отдел #" +this.department +" Зарплата: " +this.salary;
    }
}