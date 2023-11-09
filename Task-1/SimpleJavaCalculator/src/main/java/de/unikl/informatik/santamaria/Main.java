package de.unikl.informatik.santamaria;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("======================================================\n" +
                "A simple Java console-based Calculator\n" +
                "======================================================");
        dashboard();
    }

    public static void dashboard(){

        Scanner scanner = new Scanner(System.in);
        int var;

        System.out.print("\n\nChose function:\n" +
                "[1] Add/Subtract\n" +
                "[2] Multiplication\n" +
                "[3] Division\n" +
                "[4] Exponential Calculation\n" +
                "[5] Logarithm\n" +
                "\n" +
                "[6] Exit\n" +
                "\n" +
                "Input: ");
        var = scanner.nextInt();

        if (var == 1) {
            System.out.println(addsub.addsuber());
            dashboard();
        } else if (var == 2) {
            System.out.println(mult.multiplier());
            dashboard();
        } else if (var == 3) {
            System.out.println(div.divider());
            dashboard();
        } else if (var == 4) {
            System.out.println(exp.expo());
            dashboard();
        } else if (var == 5) {
            System.out.println(log.logger());
            dashboard();
        } else {
            return;
        }

    }
}
