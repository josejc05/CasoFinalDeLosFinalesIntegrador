package ej4;

public class ejercicio4 {
    public static int sumDigits(int num) {
        if (num == 0) {
            return 0;
        } else {
            return num % 10 + sumDigits(num / 10);
        }
    }
}