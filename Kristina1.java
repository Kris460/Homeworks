package CourseJava.Online;

public class Kristina1 {
    public static void main(String[] args) {

        System.out.println("1- " + calculate(1, 2, 3, 7));

        System.out.println("2- " + checkNumbers(10, 2));

        System.out.println("3- " + ((isPositive(-10)) ? "positive" : "negative"));

        if (isPositive(-10)) {
        System.out.println("positive");
    } else {
        System.out.println("negative");
    }

        System.out.println("4- " + welcome("Kris"));


}

    private static float calculate(int a, int b, int c, float d) {
        System.out.println("");
        return a + (b + ( c / d));
    }

    private static boolean checkNumbers(int erste, int zweite) {

        return (erste + zweite <= 20) && (erste + zweite >= 10);
    }

    private static boolean isPositive(int variable) {
        return variable >= 0;
    }


    private static String welcome(String name) {
        return name + ", привет!";
    }

}