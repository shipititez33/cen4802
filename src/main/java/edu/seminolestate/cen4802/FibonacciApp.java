package edu.seminolestate.cen4802;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class FibonacciApp {

    private static final Logger logger = Logger.getLogger(FibonacciApp.class.getName());

    public static void main(String[] args) {
        configureLogging();

        System.out.println("CEN4802 application version 2 started.");

        logger.info("Application started.");

        int term = 10;
        int result = fibonacci(term);

        logger.info("Fibonacci calculation completed for term " + term + " with result " + result + ".");
        System.out.println("Logging assignment verified: the " + term
                + "th term of the Fibonacci sequence is " + result + ".");

        generateLogData();

        runProfilingWorkload();

        logger.info("Application finished.");
    }

    private static void configureLogging() {
        try {
            logger.setUseParentHandlers(false);
            logger.setLevel(Level.ALL);

            ConsoleHandler consoleHandler = new ConsoleHandler();
            consoleHandler.setLevel(Level.ALL);
            consoleHandler.setFormatter(new SimpleFormatter());

            FileHandler fileHandler = new FileHandler("application.log", false);
            fileHandler.setLevel(Level.ALL);
            fileHandler.setFormatter(new SimpleFormatter());

            logger.addHandler(consoleHandler);
            logger.addHandler(fileHandler);

        } catch (IOException e) {
            System.err.println("Logging setup failed: " + e.getMessage());
        }
    }

    private static void generateLogData() {
        logger.info("Beginning simulated application activity.");

        for (int i = 1; i <= 120; i++) {
            logger.info("Processing simulated transaction " + i + ".");

            if (i % 25 == 0) {
                logger.warning("Transaction checkpoint warning at transaction " + i + ".");
            }

            if (i % 50 == 0) {
                logger.severe("Simulated severe event at transaction " + i + ".");
            }
        }

        logger.info("Completed simulated application activity.");
    }

    /**
     * Runs a temporary CPU and memory workload so the application remains
     * active long enough to collect profiling data in VisualVM.
     */
    private static void runProfilingWorkload() {
        final long profilingDurationMillis = 300_000;
        final long endTime = System.currentTimeMillis() + profilingDurationMillis;

        List<byte[]> retainedMemory = new ArrayList<>();
        long accumulatedResult = 0;
        int iteration = 0;

        logger.info("Profiling workload started.");

        while (System.currentTimeMillis() < endTime) {
            accumulatedResult += fibonacci(35);
            iteration++;

            /*
             * Retain a limited amount of memory so VisualVM has meaningful
             * heap activity to display without risking excessive memory use.
             */
            if (iteration % 25 == 0 && retainedMemory.size() < 40) {
                retainedMemory.add(new byte[256 * 1024]);
            }

            if (iteration % 100 == 0) {
                logger.info("Profiling workload completed iteration " + iteration + ".");
            }
        }

        logger.info(
            "Profiling workload finished after "
                + iteration
                + " iterations. Accumulated result: "
                + accumulatedResult
                + ". Retained memory blocks: "
                + retainedMemory.size()
                + "."
        );
    }

    /**
     * Calculates the nth term in the Fibonacci sequence using recursion.
     *
     * @param n the position in the Fibonacci sequence to calculate
     * @return the Fibonacci value at the given position
     */
    public static int fibonacci(int n) {
        if (n <= 1) {
            return n;
        }

        return fibonacci(n - 1) + fibonacci(n - 2);
    }
}