package CourseJava.Online;

import java.util.Arrays;

public class Kristina2 {
    public static void main(String[] args) {

        int[] array1 = {1, 0, 1, 0, 0, 0, 1, 1, 1, 0, 0};
        System.out.println("1 задание - До:\t" + Arrays.toString(array1));

        change(array1);
        System.out.println("1 задание - После:\t" + Arrays.toString(array1));


        int[] arrInt = new int[8];
        fill(arrInt);
        System.out.println("2 задание:\t" + Arrays.toString(arrInt));


        int[] mas = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println("3 задание - До:\t" + Arrays.toString(mas));
        two(mas);
        System.out.println("3 задание - После:\t" + Arrays.toString(mas));

        int[] minMaxArray = {10, 102, 4, 26, 55, 888, 74, 17, 125, 46, 197, 81 };
        System.out.println("4 задание - Минимум:\t" + minArray(minMaxArray));
        System.out.println("4 задание - Максимум:\t" + maxArray(minMaxArray));

    }

    private static void arraySize(int[][] inputArray) {
        for (int i = 0; i < inputArray.length; i++) {
            for (int j = 0; j < inputArray[i].length; j++) {
                System.out.print(inputArray[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void change(int[] array) {
        for (int i = 0; i < array.length; i++)
            if (array[i] == 1) {
                array[i] = 0;
            } else {
                array[i] = 1;
            }


    }

    private static void fill(int[] array) {
        for (int i = 0; i < array.length; i++)
            array[i] = i * 3 + 1;
    }

    private static void two(int[] array) {
        for (int i = 0; i < array.length; i++)
            if (array[i] < 6) {
                array[i] *= 2;
            }
    }
    public static int minArray(int[] array){
        int min = array[0];
        for(int i = 0; i < array.length; i++){
            if (min > array[i])
                min = array[i];
        }
        return min;
    }
    public static int maxArray(int[] array){
        int max = array[0];
        for(int i = 0; i < array.length; i++){
            if (max < array[i])
                max = array[i];
        }
        return max;
    }
}
