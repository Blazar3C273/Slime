package com.a.stepanenko.slime;

import org.apache.log4j.Logger;


/**
 * Project S.L.I.M.E.
 * Created by Anatoliy on 11.05.2015.
 */
public class WrongFileFormat extends Exception {
    private static final Logger log = Logger.getLogger(WrongFileFormat.class);

    public WrongFileFormat(String s) {
        super(s);
    }
}
