package com.company;

public class Sopernik implements CubicServic{
    @Override
    public int randomCubic() {
        int b = CubicServic.super.randomCubic();
        int a = CubicServic.super.randomCubic();
        return a + b;
    }
}
