package test;

import aut.model.Member;
import aut.model.PersonalTrainer;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * TODO: Description of PersonTest.
 *
 * @author ragone.
 * @version 10/12/15
 */
public class PersonTest {

    private PersonalTrainer pt;
    private Member member;

    @Before
    public void setUp() throws Exception {
        pt = new PersonalTrainer("John", "Doe");
        member = new Member("Jane", "Doe");
    }

    @After
    public void tearDown() throws Exception {
        pt = null;
        member = null;
    }

    @Test
    public void testIsPersonalTrainer() throws Exception {
        Assert.assertTrue(pt.isPersonalTrainer());
        Assert.assertFalse(member.isPersonalTrainer());
    }

    @Test
    public void testToString() throws Exception {
        Assert.assertEquals("John Doe", pt.toString());
    }
}