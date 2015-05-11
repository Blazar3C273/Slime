import com.a.stepanenko.slime.Cube;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * com.a.stepanenko.slime.Cube Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>мая 11, 2015</pre>
 */
@RunWith(JUnit4.class)
public class CubeTest {
    private Cube testCube;

    @Before
    public void before() throws Exception {

    }

    @Test
    public void readWriteTest() {
        Cube.Dot zeroDot = new Cube.Dot(0.0, 0.0, 0.0);
        testCube = new Cube(zeroDot, zeroDot);
        assertNotNull(testCube);
        assertEquals(zeroDot, testCube.max);
        assertEquals(zeroDot, testCube.min);
    }

    @Test(expected = NullPointerException.class)
    public void nullDotPointerExeptionTest() {
        new Cube(null, null);
    }

    @Test(expected = NullPointerException.class)
    public void nullDimensionPointerExeptionTest() {
        new Cube(new Cube.Dot(null, 0.0, 0.0), new Cube.Dot(0.0, 0.0, 0.0));
    }

    @After
    public void after() throws Exception {
    }


} 
