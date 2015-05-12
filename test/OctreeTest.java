import com.a.stepanenko.slime.Cube;
import com.a.stepanenko.slime.octree.Octree;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertNotNull;


/**
 * Project S.L.I.M.E.
 * Created by Anatoliy on 12.05.2015.
 */
@RunWith(JUnit4.class)
public class OctreeTest {
    private static final Logger log = Logger.getLogger(OctreeTest.class);

    @Test
    public void testOctreeCreation() throws Exception {
        Cube cube = null;
        assertNotNull(new Octree(cube));

    }
}
