package CourseJava.Online;

public class Worker_a {
    public static void main(String[] args) {


        Worker a = new Worker("Иванов", "Иван", "+7 999 334 27 64" ,
                "Работник1", 10000, 1991);

        Worker b = new Worker("Дмитров", "Дмитрий", "+7 888 378 96 24",
                "Работник2", 15000, 1988);


        System.out.println(a.getName() + a.getPosition());

        System.out.println("Здесь находится - " + a.getPosition() + ", " +
                a.getName() + " " + a.getSurname() + ".");


        Worker[] slaves = {a, b,
                new Worker("Наталья", "Александрова","+7 963 521 75 63",
                        "Работник3", 12000, 1994),
                new Worker("Сергей", "Львов", "+7 157 369 54 23",
                        "Работник4", 100000, 1976),
                new Worker("Григорий", "Тимофеев", "+7 452 319 45 21",
                        "Работник5", 60000, 1993)
        };

        System.out.println("___________");

        for (int i = 0; i < slaves.length; i++)
            if (slaves[i].getAge() > 40) {
                System.out.println(slaves[i].getFullInfo());
            } else {
                System.out.println("Работнику меньше, чем 40 лет");
            }

        System.out.println("___________");

        for (int i = 0; i < slaves.length; i++)
            System.out.println(slaves[i].getFullInfo());

        increaseSalary(slaves, 35, 10000);

        System.out.println("___________");
        for (int i = 0; i < slaves.length; i++)
            if (slaves[i].change)
                System.out.println(slaves[i].getFullInfo());

    }

    private static void increaseSalary(Worker[] o, int age, float salary) {
        for (int i = 0; i < o.length; i++) {
            if (o[i].getAge() > age) {
                o[i].setSalary(salary);
                o[i].change = true;
            }
        }
    }
}
