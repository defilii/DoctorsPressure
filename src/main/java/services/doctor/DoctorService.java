package services.doctor;

import pojo.Patient;

import java.util.List;
import java.util.Set;

public interface DoctorService {

    void addPatient(Patient patient);
    boolean canDoctorHaveThisPatient(Set<Patient> patients);
    List<Integer> checkLastMeasurements(Patient patient, int range);
    List<Patient> getPatientsWithBadPressureOverLastThreeDays();
    List<Patient> getPatientsWithNoPressureMeasurementsOverLastFiveDays();
    void sendEmailtoNoMeasurementesPatients();



}
