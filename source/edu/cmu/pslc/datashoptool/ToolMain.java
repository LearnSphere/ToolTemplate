package edu.cmu.pslc.datashoptool;

import org.apache.log4j.Logger;

public class ToolMain {

    /** Debug logging. */
    private static Logger logger = Logger.getLogger("MAIN");

        public static void main(String[] args) {
            System.out.println("Running ToolMain.main");
            // Create a new ToolWrapper object which points to the R binary directory and the script to be executed
            ToolWrapper toolWrapper = new ToolWrapper("C:/R-3.2.1/bin", "extern/helloWorld.r");
            toolWrapper.run("2015-01-01", "imageOutputName", "100");
            System.out.println(toolWrapper.getResult());
        }

}
