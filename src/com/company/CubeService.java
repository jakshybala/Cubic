package com.company;

import java.util.Random;

public interface CubeService {

    Random random = new Random();

    default int randomCube() {
        int a = random.nextInt(1, 7);
        switch (a) {
            case 1 -> System.out.println("""
                    +-------+
                    |       |
                    |   #   |
                    |       |
                    +-------+
                    """);
            case 2 -> System.out.println("""
                    +-------+
                    | #     |
                    |       |
                    |     # |
                    +-------+
                    """);
            case 3 -> System.out.println("""
                    +-------+
                    | #     |
                    |   #   |
                    |     # |
                    +-------+
                    """);
            case 4 -> System.out.println("""
                    +-------+
                    | #   # |
                    |       |
                    | #   # |
                    +-------+
                    """);
            case 5 -> System.out.println("""
                    +-------+
                    | #   # |
                    |   #   |
                    | #   # |
                    +-------+
                    """);
            case 6 -> System.out.println("""
                    +-------+
                    | #   # |
                    | #   # |
                    | #   # |
                    +-------+
                    """);
        }
        return a;
    }
}
