import com.a.stepanenko.slime.octree.TriangleCubeOverlapTester;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.Collection;

import static org.junit.Assert.assertEquals;


/**
 * J.
 * Created by Anatoliy on 14.05.2015.
 */
@RunWith(Parameterized.class)
public class BoxTriangleOverlapTest {
    private static final Logger log = Logger.getLogger(BoxTriangleOverlapTest.class);
    private float[] boxcenter;
    private float[] boxhalfsize;
    private float[][] triverts;
    private boolean result;

    public BoxTriangleOverlapTest(boolean result, float[] boxcenter, float[] boxhalfsize, float[][] triverts) {
        this.boxcenter = boxcenter;
        this.boxhalfsize = boxhalfsize;
        this.triverts = triverts;
        this.result = result;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        ArrayList<Object[]> temp = new ArrayList<Object[]>();
        //expected result,cube center coordinates,          cube edge half size, polygone vertex coordinates
        temp.add(new Object[]{true, new float[]{7.240014f, 0.9422916f, 4.853937f}, new float[]{5, 5, 5}, new float[][]{{1.6656119f, 4.822916f, 1.2002689f},
                {1.7147398f, 0.7709712f, 3.6267729f},
                {2.7616386f, 1.5362382f, 9.6705f}}});
        temp.add(new Object[]{true, new float[]{0.0f, 0.0f, 0.0f}, new float[]{5, 5, 5}, new float[][]{{10f, 5f, 0f},
                {10f, -5f, 0f},
                {0f, 0f, 0f}}});

        temp.add(new Object[]{true, new float[]{0.0f, 0.0f, 0.0f}, new float[]{5, 5, 5}, new float[][]{{10f, 5f, 0f},
                {10f, -5f, 0f},
                {0f, 0f, 9f}}});

        temp.add(new Object[]{true, new float[]{0.0f, 0.0f, 0.0f}, new float[]{5, 5, 5}, new float[][]{{10f, 5f, 0f},
                {10f, -5f, 0f},
                {0f, 0f, 10f}}});
        temp.add(new Object[]{false, new float[]{0.0f, 0.0f, 0.0f}, new float[]{5, 5, 5}, new float[][]{{10f, 5f, 0f},
                {10f, -5f, 0f},
                {0f, 0f, 11f}}});


        temp.add(new Object[]{true, new float[]{0.0f, 0.0f, 0.0f}, new float[]{5, 5, 5}, new float[][]{{10f, 5f, 0f},
                {10f, -5f, 0f},
                {0f, 10f, 0f}}});

        temp.add(new Object[]{true, new float[]{0.0f, 0.0f, 0.0f}, new float[]{5, 5, 5}, new float[][]{{4f, 4.999f, 0f},
                {-4f, -4f, 0f},
                {0f, 4f, 0f}}});

        /*Random ceedRandom1 = new Random(),random;
        long ceed = ceedRandom1.nextLong();
                random = new Random(ceed);

        log.info("ceed = "+ceed);

        for (int i = 0; i < 100; i++) {
            float[] randomFloat = new float[12];
            for (int j = 0; j < 12; j++) {
                randomFloat[j] = random.nextFloat()*10;
                log.info("test #"+(i)+" params#"+j+" = "+randomFloat[j]);
            }
            log.info("params end ");
            temp.add(new Object[] {1,new float[]{randomFloat[0],randomFloat[1],randomFloat[2]}, new float[]{5,5,5}, new float[][]{{randomFloat[3],randomFloat[4],randomFloat[5]},
                    {randomFloat[6],randomFloat[7],randomFloat[8]},
                    {randomFloat[9],randomFloat[10],randomFloat[11]}}});
        }*/

        return temp;

    }

    @Test
    public void testVariant1() throws Exception {


        assertEquals("Poly cross box. Output must be " + result + ". ", result, TriangleCubeOverlapTester.triBoxOverlap(boxcenter, boxhalfsize, triverts));
    }

}
