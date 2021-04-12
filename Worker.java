package CourseJava.Online;

public class Worker {

    private static int Year = 2021;

    String surname;
    private String name;
    private int birth;
    private String phone;
    private float salary;
    boolean change;
    private String job;
    private int nr;

    private static int id = 0;


    public Worker(String surname,
                 String name,
                 String phone,
                 String job,
                 float salary,
                 int birth) {
        this.surname = surname;
        this.birth = birth;
        this.name = name;
        this.job = job;
        this.phone = phone;
        this.salary = salary;
        this.nr = ++id;
    }

    int getAge() {
        return Year - birth;
    }

    int getSalary() {
        return (int) salary;
    }

    void setSalary(float difference) {
        this.salary = this.salary + difference;
    }

    void setSalary(int salary) {
        this.salary = salary;
    }


    public String getName() {
        return name;
    }

    String getSurname() {
        return surname;
    }

    String getPosition() {
        return job;
    }

    String getPhone() {
        return phone;
    }


    String getFullInfo() {
        return this.nr + " " +
                this.name + " " +
                this.surname + " - " +
                this.getAge() + " лет " +
                this.getSalary() + " руб. " +
                this.job + ". Номер телефона: " +
                this.phone + "";


    }
}

