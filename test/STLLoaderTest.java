import com.a.stepanenko.slime.Cube;
import com.a.stepanenko.slime.StlLoader;
import com.a.stepanenko.slime.WrongFileFormat;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.IOException;
import java.nio.file.Paths;

import static org.junit.Assert.*;


/**
 * Project S.L.I.M.E.
 * Created by Anatoliy on 11.05.2015.
 */
@RunWith(JUnit4.class)
public class STLLoaderTest {
    private static final Logger log = Logger.getLogger(STLLoaderTest.class);

    @Test
    public void TestStlLoader() {
        assertNotNull(new StlLoader());
    }

    @Test(expected = NullPointerException.class)
    public void testNullPointerPath() throws Exception, WrongFileFormat {
        StlLoader.getSurroundedCube(null);
    }

    @Test(expected = IOException.class)
    public void testCantReadExeption() throws Exception, WrongFileFormat {
        StlLoader.getSurroundedCube(Paths.get("./missingFolder"));
    }

    @Test(expected = IOException.class)
    public void testNotFileExeption() throws IOException, WrongFileFormat {
        StlLoader.getSurroundedCube(Paths.get("./"));
    }

    @Test(expected = WrongFileFormat.class)
    public void testStlParsing() throws IOException, WrongFileFormat {
        StlLoader.getSurroundedCube(Paths.get("./src/log4j.properties"));
    }

    @Test
    public void testValidStlParsing() throws IOException, WrongFileFormat {
        log.info(StlLoader.getSurroundedCube(Paths.get("./test/valid_test.stl")));
    }

    @Test(expected = WrongFileFormat.class)
    public void testInvalidStlParsing() throws IOException, WrongFileFormat {
        StlLoader.getSurroundedCube(Paths.get("./test/no_endsolid_test.stl"));
    }

    @Test(expected = WrongFileFormat.class)
    public void parsingVertex() throws IOException, WrongFileFormat {
        StlLoader.getSurroundedCube(Paths.get("./test/noVertex.stl"));
    }

    @Test
    public void gettingCubeFitalTest() throws IOException, WrongFileFormat {
        Cube.Dot dotA, dotB;
        dotB = new Cube.Dot(0.0, 0.0, 0.0);
        dotA = new Cube.Dot(5.0, 5.0, 5.0);
        Cube testCube = new Cube(dotA, dotB);
        Cube loadedCube = StlLoader.getSurroundedCube(Paths.get("./test/size5Cube.stl"));
        assertEquals("Cube must be equal", testCube, loadedCube);
    }

    @Test
    public void multipleFegureTest() throws WrongFileFormat, IOException {
        log.info(StlLoader.getSurroundedCube(Paths.get("./test/rotate_extrude.stl")));
    }

    @Test
    public void testIsCube() throws Exception, WrongFileFormat {
        Cube cube = StlLoader.getSurroundedCube(Paths.get("./test/parallelepiped.stl"));
        log.info(cube);
        double cubeV = Math.pow(cube.edgeLength, 3.0);
        log.info("cube volume is:" + cubeV);
        assertTrue("cube volume must be more, than parallelepiped's volume. cube volume is" + cubeV, cubeV > 4);

    }
}
