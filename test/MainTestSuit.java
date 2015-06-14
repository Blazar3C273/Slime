import org.junit.runner.RunWith;
import org.junit.runners.Suite;


/**
 * Project S.L.I.M.E.
 * Created by Anatoliy on 11.05.2015.
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({

        BoxTriangleOverlapTest.class,
        CubeTest.class,
        STLLoaderTest.class,
        OctreeTest.class,
        BoxTriangleOverlapTest.class,
        OctreeFactoryTest.class,
        OctreeToJsonTest.class,
        OctreeToScadGeneratorTest.class

})
public class MainTestSuit {
}
