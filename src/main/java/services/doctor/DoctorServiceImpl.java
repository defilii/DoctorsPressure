package services.doctor;

import pojo.Doctor;
import pojo.Measurement;
import pojo.Patient;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class DoctorServiceImpl implements DoctorService {

    private Doctor doctor;

    public DoctorServiceImpl(Doctor doctor) {
        this.doctor = doctor;
    }

    @Override
    public void addPatient(Patient patient) {
        if (canDoctorHaveThisPatient(doctor.getPatients())) {
            doctor.getPatients().add(patient);
        }
    }

    @Override
    public boolean canDoctorHaveThisPatient(Set<Patient> patients) {
        int averageAge = patients.stream()
                .map(Patient::getAge)
                .reduce(0, Integer::sum);
        if (averageAge <= 50) {
            return patients.size() <= 80;
        }
        if (averageAge <= 60) {
            return patients.size() <= 70;
        }
        if (averageAge <= 70) {
            return patients.size() <= 60;
        } else {
            return patients.size() <= 50;
        }
    }

    @Override
    public List<Integer> checkLastMeasurements(Patient patient, int range) {
        return patient.getLinkedDevice().getMeasurements().stream()
                .filter(
                        measurement -> isDateWithingThisRange(measurement.getDate(), range))
                .map(Measurement::getPressure)
                .collect(Collectors.toList());
    }

    private boolean isDateWithingThisRange(LocalDate date, int range) {
        for (int x = 0; x <= range; x++) {
            if (date.isAfter(date.minusDays(range))) {
                return true;
            }
        }
        return false;
    }

    @Override
    public List<Patient> getPatientsWithBadPressureOverLastThreeDays() {
        doctor.getPatients().stream()
                .flatMap(patient -> checkLastMeasurements(patient, 3).stream())
                .map()

        ;
    }

    @Override
    public List<Patient> getPatientsWithNoPressureMeasurementsOverLastFiveDays() {
        return null;
    }

    @Override
    public void sendEmailtoNoMeasurementesPatients() {

    }
}
