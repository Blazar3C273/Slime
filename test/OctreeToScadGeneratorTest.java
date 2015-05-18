import com.a.stepanenko.slime.OctreeToScadGenerator;
import com.a.stepanenko.slime.StlLoader;
import com.a.stepanenko.slime.octree.OctreeFactory;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.BufferedWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Project S.L.I.M.E.
 * Created by Anatoliy on 18.05.2015.
 */
@RunWith(JUnit4.class)
public class OctreeToScadGeneratorTest {
    private static final Logger log = Logger.getLogger(OctreeToScadGeneratorTest.class);
    private static final String SCAD_FILE = "./bunny.scad";

    @Test
    public void testTemplater() throws Exception {
        String fileName = "./test/stl's/bunnyMidSTL.stl";
        String scad = OctreeToScadGenerator.generateToFile(OctreeFactory.makeOctree(StlLoader.getVertices(Paths.get(fileName)), fileName));
        BufferedWriter writer = Files.newBufferedWriter(Paths.get(SCAD_FILE), Charset.defaultCharset());
        writer.write(scad);
        writer.flush();
        writer.close();
    }
}
