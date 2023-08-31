package pojo;

import java.time.LocalDate;
import java.time.Year;

public class Patient {

    private String name;
    private LocalDate birthDate;
    private char gender;
    private String email;
    private PressureDevice linkedDevice;

    public Patient(String name, LocalDate birthDate, char gender, String email) {
        this.name = name;
        this.birthDate = birthDate;
        this.gender = gender;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    private LocalDate getBirthDate() {
        return birthDate;
    }

    public char getGender() {
        return gender;
    }

    public int getAge(){
        return Year.now().getValue() - getBirthDate().getYear();
    }

    public String getEmail() {
        return email;
    }

    public PressureDevice getLinkedDevice() {
        return linkedDevice;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setLinkedDevice(PressureDevice linkedDevice) {
        this.linkedDevice = linkedDevice;
    }

    @Override
    public String toString() {
        return  name +
                '\t' + "born in: " + birthDate +
                '\t' + "gender: " + gender;
    }
}
