package main.pojo;

import java.time.LocalDate;
import java.util.Date;

public class Measurement {
    private final int pressure;
    private final LocalDate date;

//    private boolean noMeasure;

    public Measurement(int pressure) {
        this.pressure = pressure;
        this.date = LocalDate.now();
//        if (pressure < 0) {
//            noMeasure = true;
//        } else noMeasure = false;
    }

    public int getPressure() {
        return pressure;
    }

    public LocalDate getDate() {
        return date;
    }
}
