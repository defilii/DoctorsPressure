package main.services.doctor;

import main.exceptions.InvalidAgeException;
import main.pojo.Doctor;
import main.pojo.Patient;
import main.pojo.PressureDevice;
import main.services.patient.PatientServiceImpl;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class DoctorServiceImpl implements DoctorService {

    private final Doctor doctor;

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
        int totalAge = patients.stream()
                .map(Patient::getAge)
                .reduce(0, Integer::sum);
        int averageAge = totalAge / patients.size();
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
    public List<Patient> getPatientsWithBadPressureOverLastThreeDays() {
        List<Patient> malePatients = doctor.getPatients().stream()
                .filter(patient -> Character.toUpperCase(patient.getGender()) == 'M')
                .filter(patient -> checkIfMeasureArentInRange(patient, 3))
                .collect(Collectors.toList());
        List<Patient> femalePatients = doctor.getPatients().stream()
                .filter(patient -> Character.toUpperCase(patient.getGender()) == 'F')
                .collect(Collectors.toList());
    }

    private boolean checkIfMeasureArentInRange(Patient patient, int range) throws InvalidAgeException {
        PatientServiceImpl patientService = new PatientServiceImpl(patient);
        int badMeasures = patientService.checkLastMeasurements(range).stream()
                .filter(measure -> isThisInRange(measure, patient))
                .count();
        return badMeasures >= 3;
    }

    private boolean isThisInRange(Integer measure, Patient patient) throws InvalidAgeException {
        int age = patient.getAge();
        if (age > 71) {
            return (measure < 80 || measure > 120);
        }
        switch (Character.toUpperCase(patient.getGender())) {
            case 'M':
                if (age > 61) {
                    return (measure < 85 || measure > 120);
                }
                if (age > 51) {
                    return (measure < 75 || measure > 125);
                } else {
                    return (measure < 70 || measure > 130);
                }
            case 'F':
                if (age > 61) {
                    return (measure < 85 || measure > 125);
                }
                if (age > 51) {
                    return (measure < 70 || measure > 130);
                } else {
                    return (measure < 60 || measure > 140);
                }
        }
        throw new InvalidAgeException();
    }

    @Override
    public List<Patient> getPatientsWithNoPressureMeasurementsOverLastFiveDays() {
        return doctor.getPatients().stream()
                .filter(this::doesPatientHaveEmptyMeasures)
                .collect(Collectors.toList());
    }

    private boolean doesPatientHaveEmptyMeasures(Patient patient) {
        PatientServiceImpl patientService = new PatientServiceImpl(patient);
        return patientService.areLastMeasurementsEmpty();
    }

    @Override
    public void sendEmailtoNoMeasurementesPatients() {

    }
}
