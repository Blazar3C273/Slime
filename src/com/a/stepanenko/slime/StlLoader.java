package com.a.stepanenko.slime;

import com.sun.istack.internal.NotNull;
import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


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

                if (line.startsWith("endsolid"))
                    wasCloseString = true;
                Pattern pattern = Pattern.compile(".*vertex.*");
                Matcher matcher = pattern.matcher(line);
                if (matcher.find()) {
                    final Double x, y, z;
                    Matcher vertexMatcher = Pattern.compile("(-?\\d+\\.?\\d*\\w?\\p{Punct}*\\d*)").matcher(line);
                    vertexMatcher.find();
                    x = Double.parseDouble(vertexMatcher.group());
                    vertexMatcher.find();
                    y = Double.parseDouble(vertexMatcher.group());
                    vertexMatcher.find();
                    z = Double.parseDouble(vertexMatcher.group());
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
