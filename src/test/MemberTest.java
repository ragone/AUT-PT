package test;

import aut.model.HealthCheck;
import aut.model.Member;
import aut.model.Program;
import org.junit.*;

import java.time.LocalDate;

/**
 * TODO: Description of MemberTest.
 *
 * @author ragone.
 * @version 9/12/15
 */
public class MemberTest {

    private Member member;

    @Before
    public void setUp() throws Exception {
        member = new Member("John", "Doe");
    }

    @After
    public void tearDown() throws Exception {
        member = null;
    }

    @Test
    public void testAddProgram() throws Exception {
        Program program = new Program("My first Program");
        member.addProgram(program);

        Assert.assertFalse(member.getPrograms().isEmpty());
    }

    @Test
    public void testDeleteProgram() throws Exception {
        Program program = new Program("My first Program");
        member.addProgram(program);
        member.deleteProgram(program);

        Assert.assertTrue(member.getPrograms().isEmpty());
    }

    @Test
    public void testAddHealthCheck() throws Exception {
        HealthCheck healthCheck = new HealthCheck();
        member.addHealthCheck(healthCheck);

        Assert.assertFalse(member.getHealthChecks().isEmpty());
    }

    @Test
    public void testDeleteHealthCheck() throws Exception {
        HealthCheck healthCheck = new HealthCheck();
        member.addHealthCheck(healthCheck);
        member.deleteHealthCheck(healthCheck);

        Assert.assertTrue(member.getHealthChecks().isEmpty());
    }

    @Test
    public void testGetLastHealthCheckDate() throws Exception {
        HealthCheck healthCheck = new HealthCheck();
        member.addHealthCheck(healthCheck);
        LocalDate date = member.getLastHealthCheckDate();

        Assert.assertEquals(healthCheck.getDateAdded(), date);
    }

    @Test
    public void testHaveActiveProgram() throws Exception {
        Program program = new Program("My first Program");
        member.addProgram(program);

        Assert.assertTrue(member.haveProgram());
    }
}