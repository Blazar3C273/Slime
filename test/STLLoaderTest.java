import com.a.stepanenko.slime.Cube;
import com.a.stepanenko.slime.Dot;
import com.a.stepanenko.slime.StlLoader;
import com.a.stepanenko.slime.WrongFileFormat;
import com.a.stepanenko.slime.octree.Octree;
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
    public void testNullPointerPath() throws Exception {
        StlLoader.getVertices(null);
    }

    @Test(expected = IOException.class)
    public void testCantReadExeption() throws Exception {
        StlLoader.getVertices(Paths.get("./missingFolder"));
    }

    @Test(expected = IOException.class)
    public void testNotFileExeption() throws IOException, WrongFileFormat {
        StlLoader.getVertices(Paths.get("./"));
    }

    @Test(expected = WrongFileFormat.class)
    public void testStlParsing() throws Exception {
        StlLoader.getVertices(Paths.get("./src/log4j.properties"));
    }

    @Test
    public void testValidStlParsing() throws Exception {
        StlLoader.getVertices(Paths.get("./test/stl's/valid_test.stl"));
    }

    @Test(expected = WrongFileFormat.class)
    public void testInvalidStlParsing() throws Exception {
        StlLoader.getVertices(Paths.get("./test/stl's/no_endsolid_test.stl"));
    }

    @Test(expected = WrongFileFormat.class)
    public void parsingVertex() throws Exception {
        StlLoader.getVertices(Paths.get("./test/stl's/noVertex.stl"));
    }

    @Test
    public void gettingCubeFitalTest() throws Exception {
        Dot dotA, dotB;
        dotB = new Dot(0.0, 0.0, 0.0);
        dotA = new Dot(5.0, 5.0, 5.0);
        Cube testCube = new Cube(dotA, dotB);
        Cube loadedCube = Octree.getSurroundingCube(StlLoader.getVertices(Paths.get("./test/stl's/size5Cube.stl")));
        assertEquals("Cube must be equal", testCube, loadedCube);
    }

    @Test
    public void multipleFegureTest() throws WrongFileFormat, IOException {
        StlLoader.getVertices(Paths.get("./test/stl's/rotate_extrude.stl"));
    }

    @Test
    public void testIsCube() throws Exception, WrongFileFormat {
        Cube cube = Octree.getSurroundingCube(StlLoader.getVertices(Paths.get("./test/stl's/parallelepiped.stl")));
        log.info(cube);
        double cubeV = Math.pow(cube.edgeLength, 3.0);
        log.info("cube volume is:" + cubeV);
        assertTrue("cube volume must be more, than parallelepiped's volume. cube volume is" + cubeV, cubeV > 4);

    }

}
