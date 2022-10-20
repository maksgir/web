package com.maksgir.util;

import java.io.PrintWriter;

public class ParamsValidator {
    private final int X_MIN = -4;
    private final int X_MAX = 4;
    private final int Y_MIN = -3;
    private final int Y_MAX = 3;
    private final float R_MIN = 1;
    private final float R_MAX = 3;

    public boolean validate(String x_str, String y_str, String r_str, String timezone_str, PrintWriter writer) {
        Double x = null;
        Double y = null;
        Double r = null;
        Integer timezone = null;
        try {
            x = Double.parseDouble(x_str);
            y = Double.parseDouble(y_str);
            r = Double.parseDouble(r_str);
            timezone = Integer.parseInt(timezone_str);
        } catch (Exception e) {
            writer.write("Ошибка преобразования переданного параметра: " + "\n\t" + e.getMessage());
            return false;
        }

        if (!(x >= X_MIN && x <= X_MAX)) {
            writer.write("Значение х вне заданного диапазона");
            return false;
        }

        if (!(y >= Y_MIN && y <= Y_MAX)) {
            writer.write("Значение х вне заданного диапазона");
            return false;
        }

        if (!(r >= R_MIN && r <= R_MAX)) {
            writer.write("Значение х вне заданного диапазона");
            return false;
        }

        return true;
    }
}
