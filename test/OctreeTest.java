import com.a.stepanenko.slime.StlLoader;
import com.a.stepanenko.slime.octree.Node;
import com.a.stepanenko.slime.octree.Octree;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.nio.file.Paths;

import static org.junit.Assert.assertNotNull;


/**
 * Project S.L.I.M.E.
 * Created by Anatoliy on 12.05.2015.
 */
@RunWith(JUnit4.class)
public class OctreeTest {
    private static final Logger log = Logger.getLogger(OctreeTest.class);
    private Node whiteNode;
    private Node blackNode;
    private Node grayNode;
    @Test
    public void testOctreeCreation() throws Exception {
        assertNotNull(new Octree(StlLoader.getVertices(Paths.get("./test/stl's/valid_test.stl"))));
    }

    @Before
    public void setUp() throws Exception {
//        whiteNode = new Node(Node.NodeType.WHITE);
//        blackNode = new Node(Node.NodeType.BLACK);
//        Node[] childNodes = new Node[8];
//        grayNode = new Node(Node.NodeType.GRAY);

    }

    @Test
    public void test() throws Exception {

    }
}
