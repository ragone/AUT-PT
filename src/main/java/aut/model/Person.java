package aut.model;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.time.LocalDate;

/**
 * TODO: Description of Person.
 *
 * @author ragone.
 * @version 9/12/15
 */
@MappedSuperclass
public abstract class Person {
    @Id
    @GeneratedValue
    private long id;
    private String firstName;
    private String lastName;
    private Gender gender;
    private LocalDate dateOfBirth;
    private LocalDate dateAdded;
    private LocalDate lastModified;

    /** Constructors **/

    public Person() {
        this("","");
        // used by hibernate
    }

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = Gender.MALE;
        this.dateOfBirth = LocalDate.now();
        this.dateAdded = LocalDate.now();
        this.lastModified = LocalDate.now();
    }

    /** Getters **/

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public Gender getGender() {
        return gender;
    }

    public long getId() {
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

    public void setId(long id) {
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

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /** Methods **/

    @Override
    public String toString() {
        return getFirstName() + " " + getLastName();
    }
}
