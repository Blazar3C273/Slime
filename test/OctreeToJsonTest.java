import com.a.stepanenko.slime.Dot;
import com.a.stepanenko.slime.DotSerializator;
import com.a.stepanenko.slime.StlLoader;
import com.a.stepanenko.slime.octree.*;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.BufferedWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


/**
 * Project S.L.I.M.E.
 * Created by Anatoliy on 16.05.2015.
 */
@RunWith(JUnit4.class)
public class OctreeToJsonTest {
    private static final Logger log = Logger.getLogger(OctreeToJsonTest.class);
    private static final String TEST_FILE = "./test/stl's/bunnyMidSTL.stl";
    private static final String TEST_FILE_LOG = "./octree.json";

    @Test
    public void testDumbestJsonSerialization() throws Exception {
        Gson gson = new GsonBuilder().registerTypeHierarchyAdapter(Node.class, new NodeSerialization()).
                setPrettyPrinting().
                registerTypeAdapter(Octree.class, new OctreeSerialization()).
                excludeFieldsWithModifiers().
                registerTypeAdapter(Dot.class, new DotSerializator()).create();
        Octree octree = OctreeFactory.makeOctree(StlLoader.getVertices(Paths.get(TEST_FILE)));
        String json = gson.toJson(octree);
        Path path = Paths.get(TEST_FILE_LOG);
        BufferedWriter writer = Files.newBufferedWriter(path, Charset.defaultCharset());
        writer.write(json);
        writer.flush();
        writer.close();
    }
}
