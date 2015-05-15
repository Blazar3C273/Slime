import com.a.stepanenko.slime.Cube;
import com.a.stepanenko.slime.Dot;
import com.a.stepanenko.slime.StlLoader;
import com.a.stepanenko.slime.octree.Node;
import com.a.stepanenko.slime.octree.Octree;
import com.a.stepanenko.slime.octree.OctreeFactory;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.nio.file.Paths;

import static org.junit.Assert.assertEquals;


/**
 * Project S.L.I.M.E.
 * Created by Anatoliy on 15.05.2015.
 */
@RunWith(JUnit4.class)
public class OctreeFactoryTest {
    private static final Logger log = Logger.getLogger(OctreeFactoryTest.class);
    public static final String TEST_FILE = "./test/stl's/boundingTest.stl";
    public static final String TEST_FILE2 = "./test/stl's/rotate_extrude.stl";

    @Test
    public void testMakeOctree() throws Exception {

        Octree octree = OctreeFactory.makeOctree(StlLoader.getVertices(Paths.get(TEST_FILE2)));
        log.debug(octree.toString());

    }

    @Test
    public void testTestGetSurroudingCube() throws Exception {
        Cube expectedCube = new Cube(new Dot(7.5, 8.5, 7.5), new Dot(-7.5, -8.5, -2.5));
        log.info("Expected cube params:" + expectedCube);
        assertEquals("Bounding cube must be equals to expected cube.", expectedCube, OctreeFactory.getSurroundingCube(StlLoader.getVertices(Paths.get(TEST_FILE))));
    }

    @Test
    public void testCalculateNodeCenter() throws Exception {
        float edgeLength = 6;
        Node rootTestNode = new Node(Node.NodeType.BLACK, null, ((short) 0), new Dot(5d, 5d, 5d), edgeLength * 4);
        Dot center = rootTestNode.center;
        Dot[] centerDots = new Dot[]{
                new Dot(center.x - edgeLength, center.y - edgeLength, center.z + edgeLength),//0
                new Dot(center.x + edgeLength, center.y - edgeLength, center.z + edgeLength),//1
                new Dot(center.x - edgeLength, center.y + edgeLength, center.z + edgeLength),//2
                new Dot(center.x + edgeLength, center.y + edgeLength, center.z + edgeLength),//3
                new Dot(center.x - edgeLength, center.y - edgeLength, center.z - edgeLength),//4
                new Dot(center.x + edgeLength, center.y - edgeLength, center.z - edgeLength),//5
                new Dot(center.x - edgeLength, center.y + edgeLength, center.z - edgeLength),//6
                new Dot(center.x + edgeLength, center.y + edgeLength, center.z - edgeLength) //7
        };
        for (short i = 0; i < 8; i++) {
            assertEquals("Node center must be equals", centerDots[i], OctreeFactory.calculateNodeCenter(rootTestNode, i));
        }
    }

    @Test
    public void testGetNodeType() throws Exception {


    }
}
