package Descent;

import java.util.Scanner;

/**
 * Created by Artem Konyukhov on 01.07.2016.
 */
public class Player {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);

        int[] mountainH = new int[8];
        // game loop
        while (true) {
            for (int i = 0; i < mountainH.length; i++) {
                mountainH[i] = in.nextInt(); // represents the height of one mountain, from 9 to 0.
            }

            int maximum = 0;
            for (int j = 0; j < mountainH.length; j++) {
                if (mountainH[maximum] < mountainH[j]) maximum = j;
            }

            // Write an action using System.out.println()
            // To debug: System.err.println("Debug messages...");

            System.out.println(maximum);
            // The number of the mountain to fire on.
        }
    }
}
