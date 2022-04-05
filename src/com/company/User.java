package com.company;

public class User implements CubeService {

    @Override
    public int randomCubic() {
        int cube1 = CubeService.super.randomCube();
        int cube2 = CubeService.super.randomCube();
        return cube1 + cube2;
    }
}
