package com.a.stepanenko.slime;

public class Main {

    private static final String  HELP_STRING = "empty help string";

    public static void main(String[] args) {

        if (args[0].equals("-h")||args[0].equals("help"))
            System.out.println(HELP_STRING);
    /*
	*find file
	* read file-File
	* parse file-Schema
	* validate file dependencies-Schema
	* preparing GA:
	*  .parse GA configuration
	*  .generating new population or load from file
	*  .creating GA schema
	*  .creating GA operators
	*  .
	*
	* */
    }
}
