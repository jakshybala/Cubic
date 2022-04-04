package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        game();
    }

    public static void gameM() {
        int vybor = scanner.nextInt();
        switch (vybor) {
            case 1 -> game();
            case 2 -> System.out.println("Not game");
        }

    }

    public static void game() {
        List<Integer> myNumUser = new ArrayList<>();
        List<Integer> predictedSopernik = new ArrayList<>();
        List<Integer> randomUser = new ArrayList<>();
        List<Integer> numSopernik = new ArrayList<>();
        List<Integer> pointsUser = new ArrayList<>();
        List<Integer> pointsSopernik = new ArrayList<>();


        Random random = new Random();
        CubicServic cubicServic = new Cubic();
        CubicServic cubicServic1 = new Sopernik();

        int x = 0;
        System.out.println("---       Strat game       ---");
        do {
            System.out.println();
            System.out.print("Predict amount of points (2..12) : ");
            int num = scanner.nextInt();
            myNumUser.add(num);
            System.out.println("\nUser rolls the dices...");
            int s = cubicServic.randomCubic();
            randomUser.add(s);
            int b = s - (Math.abs(s - num) * 2);
            pointsUser.add(b);
            int v = random.nextInt(2, 13);
            numSopernik.add(v);
            System.out.printf("""
                    On the dice fell %d points
                    Result is %d - abs(%d - %d) * 2: %d
                                
                    Sopernik predicted %d points
                    Sopernik rolls the dices
                    """, s, s, s, num, b, v);
            int m = cubicServic1.randomCubic();
            predictedSopernik.add(m);
            int k = m - (Math.abs(m - v) * 2);
            pointsSopernik.add(k);
            System.out.printf("""
                    On the dice fell %d points
                    Result is %d - abs(%d - %d) * 2: %d""", m, m, m, v, k);
            if (b > k) {
                int d = b - k;
                System.out.printf("""
                        
                        Users win %d points more
                        Congratulations!
                        """, d);
            } else {
                int g = k - b;
                System.out.printf("""
                        
                        Sopernik win %d points more
                        Congratulations!
                        
                        """, g);
            }
            int y = Math.abs(k - b);
            System.out.printf("""
                    ---------- Current score ----------
                    User       %d points
                    Sopernik   %d points
                    """, b, k);
            if (b > k) {
                System.out.printf("""
                        
                        Users is ahead by %d points!
                        -----------------------------------""", y);
            }
            x++;
        } while (x < 3);
        System.out.println("""
                
                -------------- Finish game --------------
                
                 Round |         User   |    Sopernik
                -------+----------------+----------------""");
        int count = 0;
        for (int i = 0; i < 3; i++) {
            count++;
            System.out.printf("""
                           | Predicted   %d  | Predicted  %d
                    - %d -  | Dice        %d  | Dice       %d
                           | Result      %d  | Result     %d
                    -------+----------------+----------------
                    """, randomUser.get(i), predictedSopernik.get(i),
                    count, myNumUser.get(i), numSopernik.get(i), pointsUser.get(i), pointsSopernik.get(i));
        }
        int corzinaUser = 0;
        int corzinaSopernik = 0;
        for (int i = 0; i < 3; i++) {
            corzinaUser += pointsUser.get(i);
            corzinaSopernik += pointsSopernik.get(i);
        }
        System.out.printf("""
                Total  | Points      %d | Points      %d
                """, corzinaUser, corzinaSopernik);
        int j = Math.abs(corzinaSopernik - corzinaUser);
        if (corzinaUser > corzinaSopernik) {
            System.out.printf("""
                    Users win %d points more. Congratulations!""", j);
        } else {
            System.out.printf("""
                    Sopernik win %d points more. Congratulations!""", j);
        }
        System.out.println("""
                
                Cotinium game?
                yes - 1
                not - 2""");
        gameM();
    }
}
