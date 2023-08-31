package main.services.patient;

import main.pojo.Patient;

import java.util.List;

public interface PatientService {
    List<Integer> checkLastMeasurements(int range);
}
