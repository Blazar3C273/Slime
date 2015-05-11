package com.a.stepanenko.slime;

import org.apache.log4j.Logger;

public class Main {

    private static final String  HELP_STRING = "empty help string";
    public static final Logger log = Logger.getLogger(Main.class);

    public static void main(String[] args) {
        log.info(args);
        if (args!=null&&args.length>0)
            if (args[0].equals("-h")||args[0].equals("help")){
                System.out.println(HELP_STRING);
                log.info("Massage string in std-out"+HELP_STRING);
            }

        log.fatal("some fatal massage for testing");


    /*
	* find file
	* read file-File
	* parse file-Schema
	* validate file dependencies-Schema
	* preparing GA:
	*  .parse GA configuration
	*  .generating new population or load from file
	*       -how to generate new population?
	*       -how to place components?
	*       -how to calculate topology?-break case in to octree.
	*  .creating GA schema
	*  .creating GA operators
	*  .launch GA
	*  .watch logs
	*  .watch result
	*
	* tags: octree,A*,Алгоритм Дейкстры,Logging,GAasService(microservices),JUnit,SCAD file generator,Distributed GA,
	* */

     }
}
