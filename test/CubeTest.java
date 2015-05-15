import com.a.stepanenko.slime.Cube;
import com.a.stepanenko.slime.Dot;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.*;

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

    @Test
    public void testConstructor() throws Exception {
        double[] numbers = new double[]{1, 1, 1, 6, 6, 6};

        Cube cube = new Cube(new Dot(numbers[0], numbers[1], numbers[2]),
                new Dot(numbers[3], numbers[4], numbers[5]));

        double[] expected_numbers = new double[]{5, 3.5, 3.5, 3.5};
        double[] actual_numbers = new double[]{cube.edgeLength,
                cube.getCubeCenter().x,
                cube.getCubeCenter().y,
                cube.getCubeCenter().z};

        assertArrayEquals("Params must be equals", expected_numbers, actual_numbers, 0);

    }

    @Test
    public void readWriteTest() {
        Dot zeroDot = new Dot(0.0, 0.0, 0.0);
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
        new Cube(new Dot(null, 0.0, 0.0), new Dot(0.0, 0.0, 0.0));
    }

    @Test
    public void testGetCubeCenterTest() throws Exception {
        Dot[] dots = new Dot[]{

                new Dot(0d, 0d, 0d),
                new Dot(0d, 0d, 0d),
                new Dot(0d, 0d, 0d),

                new Dot(2d, 2d, 2d),
                new Dot(8d, 8d, 8d),
                new Dot(5d, 5d, 5d),


                new Dot(1d, 1d, 1d),
                new Dot(6d, 6d, 6d),
                new Dot(3.5d, 3.5d, 3.5d),

        };
        for (int i = 0; i < dots.length / 3; i++) {
            testCube = new Cube(dots[i * 3], dots[i * 3 + 1]);
            assertEquals("Center coordinates must be same.", dots[i * 3 + 2], testCube.getCubeCenter());
        }

    }
}
