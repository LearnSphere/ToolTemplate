package edu.cmu.pslc.datashoptool;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;

import org.apache.log4j.Logger;

public class ToolWrapper {

    /** Path to the R executable. */
    String pathToRScriptExecutable;
    /** Path to the script executable. */
    String pathToScript;
    /** Results are stored here. */
    StringBuffer sbRunResult;

    /** Debug logging. */
    private Logger logger = Logger.getLogger(getClass().getName());

    /** Force the non-default constructor by making this one private. */
    private ToolWrapper() {

    }

    /**
     * A constructor that takes two parameters, the path to the R executable and the
     * path to the R script.
     * @param pathToRScriptExecutable the path to the R executable
     * @param pathToScript the path to the R script
     */
    public ToolWrapper(String pathToRScriptExecutable, String pathToScript) {
        sbRunResult = new StringBuffer();
        this.pathToRScriptExecutable = pathToRScriptExecutable;
        this.pathToScript = pathToScript;
    }

    public void run(String... parameters) {
        ArrayList<String> processBuilderParameters = new ArrayList<String>();
        processBuilderParameters.add(pathToRScriptExecutable + "/Rscript.exe");
        processBuilderParameters.add(pathToScript);
        processBuilderParameters.addAll(Arrays.asList(parameters));

        // Run the BKT for student stratified CV.
        Process process;
        try {
            logger.info("Executing process: " + processBuilderParameters.toString());

            process = new ProcessBuilder(processBuilderParameters).start();

            // The standard output of running the R script
            InputStream inStream = process.getInputStream();
            InputStreamReader inStreamReader = new InputStreamReader(inStream);
            BufferedReader bufferedReader = new BufferedReader(inStreamReader);

            // The error messages (if any) from running the R script
            InputStream errStream = process.getErrorStream();
            InputStreamReader errStreamReader = new InputStreamReader(errStream);
            BufferedReader bufferedErrorReader = new BufferedReader(errStreamReader);

            String line = null;
            // Whether or not the script resulted in error
            Boolean hasError = false;

            // Read the error stream first
            while ((line = bufferedErrorReader.readLine()) != null) {
                sbRunResult.append("ERROR: " + line + "\n");
                hasError = true;
            }

            // Read the standard output stream
            while ((line = bufferedReader.readLine()) != null) {
                sbRunResult.append(line + "\n");
            }

        } catch (IOException e) {
            logger.error(e.getMessage());
        }
    }

    public String getResult() {
        if (sbRunResult != null) {
            return sbRunResult.toString();
        }
        return null;
    }

}
