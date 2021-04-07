package CourseJava.Online;

import java.util.Random;
import java.util.Scanner;

public class Kristina3 {

    public static final int Size = 5;
    public static final int Win = 4;

    public static final char Empty = '.';
    public static final char Player1 = 'X';
    public static final char Player2 = 'O';

    public static Scanner input = new Scanner(System.in);
    public static char[][] gameField;

    public static void gameField() {
        gameField = new char[Size][Size];
        for (int i = 0; i < Size; i++) {
            for (int j = 0; j < Size; j++) {
                gameField[i][j] = Empty;
            }
        }
    }

    public static void printField() {
        for (int i = 0; i <= gameField.length; i++) {
            System.out.print(i == 0 ? "  " : i + " ");
        }
        System.out.println();
        for (int i = 0; i < gameField.length; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < gameField.length; j++) {
                System.out.print(gameField[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static boolean available(int x, int y) {
        return x >= 0 && x < Size && y >= 0 && y < Size && gameField[y][x] == Empty;
    }

    public static void player1Move() {
        int x, y;
        do {
            System.out.printf("Введите координаты через пробел X Y:\n", Size, Size);
            x = Integer.valueOf(input.next()) - 1;
            y = Integer.valueOf(input.next()) - 1;
        } while (!available(x, y));
        gameField[y][x] = Player1;
    }

    public static void player2Move() {
        int x, y;
        do {
            x = new Random().nextInt(Size);
            y = new Random().nextInt(Size);
        } while (!available(x, y));
        System.out.println("ИИ походил " + (x + 1) + " " + (y + 1));
        gameField[y][x] = Player2;
    }

    public static boolean isWin(char playerDot) {
        int hor, ver;
        int diagMain, diagReverse;
        for (int i = 0; i < Size; i++) {
            hor = 0;
            ver = 0;
            for (int j = 0; j < Size; j++) {
                if (gameField[i][j] == playerDot) {
                    hor++;
                } else if (gameField[i][j] != playerDot && hor < Win) {
                    hor = 0;
                }
                if (gameField[j][i] == playerDot) {
                    ver++;
                }   else if (gameField[j][i] != playerDot && ver < Win) {
                    ver = 0;
                }
            }
            if (hor >= Win || ver >= Win) {
                System.out.println("По горизонтали или вертикали " + hor + " " + ver);
                return true;
            }
        }

        for (int j = 0; j < Size; j++) {
            diagMain = 0;
            for (int i = 0; i < Size; i++) {
                int k = j + i;
                if (k < Size) {
                    if (gameField[i][k] == playerDot) {
                        diagMain++;
                    } else if (gameField[i][k] != playerDot && diagMain < Win) {
                        diagMain = 0;
                    }
                }
                if (diagMain >= Win) {
                    System.out.println("По диагонали " + diagMain);
                    return true;
                }
            }
        }
        for (int j = 1; j < Size; j++) {
            diagMain = 0;
            for (int i = 0; i < Size; i++) {
                int k = j + i;
                if (k < Size) {
                    if (gameField[k][i] == playerDot) {
                        diagMain++;
                    } else if (gameField[k][i] != playerDot && diagMain < Win) {
                        diagMain = 0;
                    }
                }
                if (diagMain >= Win) {
                    System.out.println("По диагонали " + diagMain);
                    return true;
                }
            }
        }
        for (int j = 0; j < Size; j++) {
            diagReverse = 0;
            for (int i = 0; i < Size; i++) {
                int k = (Size - 1) - i;
                int l = j + i;
                if (k >= 0 && l < Size) {
                    if (gameField[l][k] == playerDot) {
                        diagReverse++;
                    } else if (gameField[l][k] != playerDot && diagReverse < Win) {
                        diagReverse = 0;
                    }
                }
                if (diagReverse >= Win) {
                    System.out.println("По диагонали " + diagReverse);
                    return true;
                }
            }
        }
        for (int j = 1; j < Size; j++) {
            diagReverse = 0;
            for (int i = 0; i < Size; i++) {
                int k = (Size) - 1 - j - i;
                if (k >= 0) {
                    if (gameField[i][k] == playerDot) {
                        diagReverse++;
                    } else if (gameField[i][k] != playerDot && diagReverse < Win) {
                        diagReverse = 0;
                    }
                }
                if (diagReverse >= Win) {
                    System.out.println("По диагонали " + diagReverse);
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isDraw() {
        for (char[] aGameField : gameField) {
            for (int j = 0; j < gameField.length; j++) {
                if (aGameField[j] == Empty) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        gameField();
        System.out.printf ("Цель игры - заполнить подряд линию по вертикали, горизонтали или диагонали из %d Ваш%s символ%s.\n", Win, (Win % 10 == 1 && Win % 100 != 11) ? "его" : "их", (Win % 10 == 1 && Win % 100 != 11) ? "а" : "ов");
        printField();

        switch (new Random().nextInt(2)) {
            case 0: {
                System.out.println("Ваш ход первый");
                while (true) {
                    player1Move();
                    printField();
                    if (isWin(Player1)) {
                        System.out.println("Победил Игрок");
                        break;
                    }
                    if (isDraw()) {
                        System.out.println("Ничья");
                        break;                    }
                    player2Move();
                    printField();
                    if (isWin(Player2)) {
                        System.out.println("Победил ИИ");
                        break;
                    }
                    if (isDraw()) {
                        System.out.println("Ничья");
                        break;
                    }
                }
                break;
            }
            case 1: {
                System.out.println("Первый ход ИИ");
                while (true) {
                    player2Move();
                    printField();
                    if (isWin(Player2)) {
                        System.out.println("Победил ИИ");
                        break;
                    }
                    if (isDraw()) {
                        System.out.println("Ничья");
                        break;
                    }
                    player1Move();
                    printField();
                    if (isWin(Player1)) {
                        System.out.println("Победил Игрок");
                        break;
                    }
                    if (isDraw()) {
                        System.out.println("Ничья");
                        break;
                    }
                }
            }
        }
    }
}
