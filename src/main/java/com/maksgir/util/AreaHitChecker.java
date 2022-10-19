package com.maksgir.util;

public class AreaHitChecker {
    public boolean checkHit(int x, int y, double r) {
        boolean triangle_hit = (x <= 0 && x >= -r / 2) && (y <= x + r / 2) && (y >= 0 && y <= r / 2);
        boolean circle_hit = ((x * x + y * y) <= r * r / 4) && (x <= 0 && x >= -r / 2) && (y <= 0 && y >= -r / 2);
        boolean square_hit = (x >= 0 && x <= r) && (y <= 0 && y >= -r / 2);

        return triangle_hit || circle_hit || square_hit;
    }
}
