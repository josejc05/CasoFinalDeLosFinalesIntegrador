package ej4;

import java.util.Scanner;

public class MainEj4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce un número:");
        int num = scanner.nextInt();
        int sum = ejercicio4.sumDigits(num);
        System.out.println("La suma de los dígitos de " + num + " es " + sum);
    }
}