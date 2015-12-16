package aut.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

/**
 * Member class to hold entries for each member
 *
 * @author ragone.
 * @version 9/12/15
 */
@Entity
public class Member extends Person {

    @OneToMany(mappedBy = "member")
    private List<HealthCheck> healthChecks = new LinkedList<>();
    @OneToMany(mappedBy = "member")
    private List<Program> programs = new LinkedList<>();

    /** Constructors **/

    public Member() {
        this("","");
        // used by hibernate
    }

    public Member(String firstName,String lastName) {
        super(firstName, lastName);
    }

    /** Getters **/

    public List<Program> getPrograms() {
        return programs;
    }

    public List<HealthCheck> getHealthChecks() {
        return healthChecks;
    }

    /** Setters **/

    public void setPrograms(List<Program> programs) {
        this.programs = programs;
    }

    public void setHealthChecks(List<HealthCheck> healthChecks) {
        this.healthChecks = healthChecks;
    }

    /** Methods **/

    public void addProgram(Program program) {
        programs.add(program);
    }

    public void deleteProgram(Program program) {
        programs.remove(program);
    }

    public void addHealthCheck(HealthCheck healthCheck) {
        healthChecks.add(healthCheck);
    }

    public void deleteHealthCheck(HealthCheck healthCheck) {
        healthChecks.remove(healthCheck);
    }
}
