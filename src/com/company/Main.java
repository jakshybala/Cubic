package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    static Random random = new Random();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        game();
    }

    public static void newGames() {
        int newGame = scanner.nextInt();
        switch (newGame) {
            case 1 -> game();
            case 2 -> System.out.println("Game over");
        }
    }

    public static void game() {
        List<Integer> numberGuessedByUsers = new ArrayList<>();
        List<Integer> numberGuessedByTheComputer = new ArrayList<>();
        List<Integer> randomDieComputerNumber = new ArrayList<>();
        List<Integer> randomDieUserNumber = new ArrayList<>();
        List<Integer> customGlasses = new ArrayList<>();
        List<Integer> computerGlasses = new ArrayList<>();


        CubeService cubicServic = new User();
        CubeService cubicServic1 = new Computer();
        int wer = 2;
        int x = 0;
        System.out.println("---       Strat game       ---");
        do {
            System.out.println();
            System.out.print("Predict amount of points (2..12) : ");
            int sum = scanner.nextInt(); //7
            System.out.println("""
                    
                    Cheating - 1
                    Not cheating - 2""");
            int num = scanner.nextInt(); //1
            int s = cubicServic.randomCubic();
            boolean minus = true;
            if (num == 1) {
               int chance = random.nextInt(1,  wer + 1);
               int chance1 = random.nextInt(1, wer + 1);
                minus = false;
                System.out.println(chance + " - " + chance1 + " " + wer);
                if (chance == chance1) {
                    s = sum;
                    minus = true;
                }
            }
            numberGuessedByUsers.add(sum);
            System.out.println("\nUser rolls the dices...");
            randomDieUserNumber.add(s);
            int b = s - (Math.abs(s - sum) * 2);
            int ret = 0;
            if (!minus) {
                ret = b - 10;
            } else {
                ret = b;
            }
            customGlasses.add(ret);
            int v = random.nextInt(2, 13);
            numberGuessedByTheComputer.add(v);
            System.out.printf("""
                    On the dice fell %d points
                    Result is %d - abs(%d - %d) * 2: %d
                                
                    Sopernik predicted %d points
                    Sopernik rolls the dices
                    """, s, s, s, sum, ret, v);
            int m = cubicServic1.randomCubic();
            if (!minus) {
                int cheating = random.nextInt(1, wer + 1);
                int yesChi = random.nextInt(1, wer + 1);
                System.out.println(cheating + " - " + yesChi + " " + wer);
                if (cheating == yesChi) {
                    m = v;
                }
            }
            randomDieComputerNumber.add(m);
            int k = m - (Math.abs(m - v) * 2);
            computerGlasses.add(k);
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
            wer += 2;
        } while (x < 3);
        System.out.println("""
                                
                -------------- Finish game --------------
                                
                 Round |         User   |    Sopernik
                -------+----------------+----------------""");
        int counter = 0;
        for (int i = 0; i < 3; i++) {
            counter++;
            System.out.printf("""
                                   | Predicted   %d  | Predicted  %d
                            - %d -  | Dice        %d  | Dice       %d
                                   | Result      %d  | Result     %d
                            -------+-----------------+----------------
                            """, numberGuessedByUsers.get(i), numberGuessedByTheComputer.get(i),
                    counter, myNumUser.get(i), numSopernik.get(i), pointsUser.get(i), pointsSopernik.get(i));
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
                                
                Continue game?
                yes - 1
                not - 2""");
        newGames();
    }
}
