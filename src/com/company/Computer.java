package com.company;

public class Computer implements CubeService {

    @Override
    public int randomCube() {
        int cube1 = CubeService.super.randomCube();
        int cube2 = CubeService.super.randomCube();
        return cube1 + cube2;
    }

//    @Override
//    public int randomCubic() {
//        int cube1 = CubeService.super.randomCube();
//        int cube2 = CubeService.super.randomCube();
//        return cube1 + cube2;
//
//    }

}
