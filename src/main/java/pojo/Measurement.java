package pojo;

import java.time.LocalDate;
import java.util.Date;

public class Measurement {
    private int pressure;
    private LocalDate date;

    public Measurement(int pressure) {
        this.pressure = pressure;
        this.date = LocalDate.now();
    }

    public int getPressure() {
        return pressure;
    }

    public LocalDate getDate() {
        return date;
    }
}
