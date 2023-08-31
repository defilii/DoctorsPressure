package main.services.doctor;

import main.pojo.Patient;

import java.util.List;
import java.util.Set;

public interface DoctorService {

    void addPatient(Patient patient);
    boolean canDoctorHaveThisPatient(Set<Patient> patients);
    List<Patient> getPatientsWithBadPressureOverLastThreeDays();
    List<Patient> getPatientsWithNoPressureMeasurementsOverLastFiveDays();
    void sendEmailtoNoMeasurementesPatients();

}
