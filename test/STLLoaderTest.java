import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.IOException;
import java.nio.file.Paths;

import static org.junit.Assert.assertNotNull;


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
        StlLoader.getSurroundedCube(null);
    }

    @Test(expected = IOException.class)
    public void testCantReadExeption() throws Exception {
        StlLoader.getSurroundedCube(Paths.get("./missingFolder"));
    }

    @Test(expected = IOException.class)
    public void testNotFileExeption() throws IOException {
        StlLoader.getSurroundedCube(Paths.get("./"));
    }
}
