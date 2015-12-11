package test;

import aut.model.Exercise;
import aut.model.Program;
import org.junit.*;

import java.time.LocalDate;
import java.util.HashMap;

/**
 * TODO: Description of ProgramTest.
 *
 * @author ragone.
 * @version 10/12/15
 */
public class ProgramTest {

    private Program program;

    @Before
    public void setUp() throws Exception {
        program = new Program("Test");
    }

    @After
    public void tearDown() throws Exception {
        program = null;
    }

    @Test
    public void texstGetDateCreated() throws Exception {
        Assert.assertEquals(program.getDateAdded(), LocalDate.now());
    }

    @Test
    public void testGetDescription() throws Exception {
        Assert.assertEquals("Test", program.getDescription());
    }

    @Test
    public void testSetDateCreated() throws Exception {
        Assert.assertEquals(program.getDateAdded(), LocalDate.now());
        program.setDateAdded(LocalDate.of(2014, 12, 24));
        Assert.assertEquals(program.getDateAdded(), LocalDate.of(2014, 12, 24));
    }

    @Test
    public void testSetDescription() throws Exception {
        Assert.assertEquals("Test", program.getDescription());
        program.setDescription("New description");
        Assert.assertEquals("New description", program.getDescription());
    }

    @Test
    public void testSetExercises() throws Exception {
        Assert.assertTrue(program.getExercises().isEmpty());
        Exercise exercise = new Exercise(6, 3);
        HashMap<String, Exercise> exercises = new HashMap<>();
        exercises.put(exercise.getId(), exercise);
        program.setExercises(exercises);

        Assert.assertFalse(program.getExercises().isEmpty());
        Assert.assertEquals(program.getExercises().get(exercise.getId()), exercise);
    }

    @Test
    public void testSetId() throws Exception {
        program.setId("123");
        Assert.assertEquals("123", program.getId());
    }

    @Test
    public void testSetLastModified() throws Exception {
        Assert.assertEquals(program.getLastModified(), LocalDate.now());
        program.setLastModified(LocalDate.of(2014, 12, 24));
        Assert.assertEquals(program.getLastModified(), LocalDate.of(2014, 12, 24));
    }

    @Test
    public void testAddExercise() throws Exception {
        Assert.assertTrue(program.getExercises().isEmpty());
        Exercise exercise = new Exercise(6, 3);
        program.addExercise(exercise);

        Assert.assertFalse(program.getExercises().isEmpty());
    }

    @Test
    public void testDeleteExercise() throws Exception {
        Exercise exercise = new Exercise(6, 3);
        program.addExercise(exercise);
        Assert.assertFalse(program.getExercises().isEmpty());
        program.deleteExercise(exercise);
        Assert.assertTrue(program.getExercises().isEmpty());

    }
}