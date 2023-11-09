package de.unikl.informatik.santamaria;

import java.util.Scanner;

public class exp {

    public static double expo() {
        Scanner scanner = new Scanner(System.in);
        double base, ext, ans;
        System.out.print("- Basis: ");
        base = scanner.nextDouble();
        System.out.print("- Exponent: ");
        ext = scanner.nextDouble();
        ans = Math.pow(base, ext);
        System.out.print("==> " + base + " ^ " + ext + " = ");
        return ans;
    }

}
