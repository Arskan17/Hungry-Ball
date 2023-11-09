package de.unikl.informatik.santamaria;

import java.util.Scanner;

public class log {

    public static double logger() {
        Scanner scanner = new Scanner(System.in);
        double op1, op2, ans;
        System.out.print("- Value: ");
        op1 = scanner.nextDouble();
        System.out.print("- Basis: ");
        op2 = scanner.nextDouble();
        ans = Math.log(op1) / Math.log(op2);
        System.out.print("==> log_" + op2 + "(" + op1 + ") = ");
        return ans;
    }

}
