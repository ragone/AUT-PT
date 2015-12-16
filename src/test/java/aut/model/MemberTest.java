package aut.model;

import aut.model.HealthCheck;
import aut.model.Member;
import aut.model.Program;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

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
}