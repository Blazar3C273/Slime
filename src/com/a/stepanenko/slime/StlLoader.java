package com.a.stepanenko.slime;

import com.sun.istack.internal.NotNull;
import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;


/**
 * Project S.L.I.M.E.
 * Created by Anatoliy on 11.05.2015.
 */
public class StlLoader {
    private static final Logger log = Logger.getLogger(StlLoader.class);

    /**
     * @return Polygon vertices indexes is (3n+0,3n+1,3n+2), n = [0..array.size()/3]
     */
    public static ArrayList<Dot> getVertices(@NotNull Path stlPath) throws IOException, WrongFileFormat {
        if (!Files.isReadable(stlPath) || Files.isDirectory(stlPath)) {
            IOException exception = new IOException("Path is not readable or this is not File");
            log.error(exception.getMessage(), exception);
            throw exception;
        }
        try (BufferedReader reader = Files.newBufferedReader(stlPath, StandardCharsets.US_ASCII)) {
            String line;
            boolean isFirstString = true;
            boolean wasCloseString = false;
            ArrayList<Dot> vertexes = new ArrayList<>();
            while ((line = reader.readLine()) != null) {
                if (isFirstString && !line.startsWith("solid "))
                    throw new WrongFileFormat("this file not valid ASCII STL file");
                if (isFirstString) {
                    isFirstString = false;
                }

                if (line.startsWith("endsolid "))
                    wasCloseString = true;

                if (line.startsWith("      vertex")) {//TODO: fix this. why regexp not working!?
                    final Double x, y, z;

                    int firstIndex = line.lastIndexOf("x") + 1;
                    int secondLastIndex = line.indexOf(" ", firstIndex + 1);
                    int thirdLastIndex = line.indexOf(" ", secondLastIndex + 1);
                    x = Double.parseDouble(line.substring(firstIndex, secondLastIndex));
                    y = Double.parseDouble(line.substring(secondLastIndex, thirdLastIndex));
                    z = Double.parseDouble(line.substring(thirdLastIndex));
                    vertexes.add(new Dot(x, y, z));
                }

            }
            if (!wasCloseString)
                throw new WrongFileFormat("this file not valid ASCII STL");
            if (vertexes.isEmpty()) {
                throw new WrongFileFormat("in file no vertices");
            } else {

                return vertexes;
            }

        }
    }

}
