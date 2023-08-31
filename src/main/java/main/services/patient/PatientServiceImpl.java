package main.services.patient;

import main.pojo.Measurement;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class PatientServiceImpl implements PatientService {

    private main.pojo.Patient patient;

    public PatientServiceImpl(main.pojo.Patient patient) {
        this.patient = patient;
    }

    @Override
    public List<Integer> checkLastMeasurements(int range) {
        return patient.getLinkedDevice().getMeasurements().stream()
                .filter(
                        measurement -> isDateOfMeasurementWithinThisRange(measurement.getDate(), range))
                .map(Measurement::getPressure)
                .collect(Collectors.toList());
    }

    public boolean areLastMeasurementsEmpty() {
        int measurementInTheLastFiveDays =
                (int) patient.getLinkedDevice().getMeasurements().stream()
                .filter(
                        measurement -> isDateOfMeasurementWithinThisRange(measurement.getDate(), 5))
                .count();
        return measurementInTheLastFiveDays == 0;
    }

    private boolean isDateOfMeasurementWithinThisRange(LocalDate date, int range) {
        for (int x = 0; x <= range; x++) {
            if (date.isAfter(date.minusDays(range))) {
                return true;
            }
        }
        return false;
    }
}
