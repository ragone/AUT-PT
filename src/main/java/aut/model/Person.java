package aut.model;

import java.time.LocalDate;
import java.util.UUID;

/**
 * TODO: Description of Person.
 *
 * @author ragone.
 * @version 9/12/15
 */
public abstract class Person {
    private String id;
    private String firstName;
    private String lastName;
    private Gender gender;
    private LocalDate dateOfBirth;
    private LocalDate dateAdded;
    private LocalDate lastModified;
    private boolean isPersonalTrainer;

    public Person(String firstName, String lastName, boolean isPersonalTrainer) {
        this.id = UUID.randomUUID().toString();
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = Gender.MALE;
        this.dateOfBirth = LocalDate.now();
        this.dateAdded = LocalDate.now();
        this.lastModified = LocalDate.now();
        this.isPersonalTrainer = isPersonalTrainer;
    }

    /** Getters **/

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public Gender getGender() {
        return gender;
    }

    public String getId() {
        return id;
    }

    public LocalDate getDateAdded() {
        return dateAdded;
    }

    public LocalDate getLastModified() {
        return lastModified;
    }

    public String getFirstName() {
        return firstName;
    }

    public boolean isPersonalTrainer() {
        return isPersonalTrainer;
    }

    public String getLastName() {
        return lastName;
    }

    /** Setters **/

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setDateAdded(LocalDate dateAdded) {
        this.dateAdded = dateAdded;
    }

    public void setLastModified(LocalDate lastModified) {
        this.lastModified = lastModified;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setPersonalTrainer(boolean personalTrainer) {
        isPersonalTrainer = personalTrainer;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /** Methods **/

    @Override
    public String toString() {
        return getFirstName() + " " + getLastName();
    }
}
