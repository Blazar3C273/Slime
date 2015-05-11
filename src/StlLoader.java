import com.a.stepanenko.slime.Cube;
import com.sun.istack.internal.NotNull;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;


/**
 * Project S.L.I.M.E.
 * Created by Anatoliy on 11.05.2015.
 */
public class StlLoader {
    private static final Logger log = Logger.getLogger(StlLoader.class);

    public static Cube getSurroundedCube(@NotNull Path stlPath) throws IOException {
        if (!Files.isReadable(stlPath) || Files.isDirectory(stlPath)) {
            IOException exception = new IOException("File is not readable");
            log.error(exception.getMessage(), exception);
            throw exception;
        }

        return null;
    }
}
