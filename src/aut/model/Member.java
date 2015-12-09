package aut.model;

import java.time.LocalDate;
import java.util.LinkedList;

/**
 * Member class to hold entries for each member
 *
 * @author ragone.
 * @version 9/12/15
 */
public class Member extends Person {

    private LinkedList<HealthCheck> healthChecks;
    private LinkedList<Program> programs;

    /** Constructor **/

    public Member(String firstName,String lastName) {
        super(firstName, lastName, false);

        this.programs = new LinkedList<>();
        this.healthChecks = new LinkedList<>();
    }

    /** Getters **/

    public LinkedList<Program> getPrograms() {
        return programs;
    }

    /** Methods **/

    public void addProgram(Program program) {
        programs.push(program);
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

    public LocalDate getLastHealthCheckDate() {
        return healthChecks.peek().getDateAdded();
    }

    public boolean haveProgram() {
        return !programs.isEmpty();
    }
}
