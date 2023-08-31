package main.services.pressureDevice;

import main.pojo.Measurement;
import main.pojo.Patient;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class PressureDeviceImpl implements PressureDevice{

    private main.pojo.PressureDevice pressureDevice;
    public PressureDeviceImpl(main.pojo.PressureDevice pressureDevice) {
        this.pressureDevice = pressureDevice;
    }
}
