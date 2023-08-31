package pojo;

import java.util.List;

public class PressureDevice {
    private List<Measurement> measurements;
    private Patient patient;

    private PressureDevice(List<Measurement> measurements, Patient patient) {
        this.measurements = measurements;
        this.patient = patient;
    }

    public void createPressureDevice(List<Measurement> measurements, Patient patient) {
        PressureDevice pressureDevice = new PressureDevice(measurements, patient);
        patient.setLinkedDevice(pressureDevice);
    }

    public List<Measurement> getMeasurements() {
        return measurements;
    }
}
