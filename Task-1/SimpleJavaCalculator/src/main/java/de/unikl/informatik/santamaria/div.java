package de.unikl.informatik.santamaria;

import java.util.Scanner;

public class div {

    public static double divider() {
        Scanner scanner = new Scanner(System.in);
        double op1, op2, ans;
        System.out.print("- Operand 1: ");
        op1 = scanner.nextDouble();
        System.out.print("- Operand 2: ");
        op2 = scanner.nextDouble();
        ans = op1 / op2;
        System.out.print("==> " + op1 + " / " + op2 + " = ");
        return ans;
    }

}
