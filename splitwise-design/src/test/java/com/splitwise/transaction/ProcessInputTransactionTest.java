package com.splitwise.transaction;

import com.splitwise.IOProcessing.ProcessInputTransaction;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * ProcessInputTransaction Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>10/24/2017</pre>
 */
public class ProcessInputTransactionTest extends TestCase {
    public ProcessInputTransactionTest(String name) {
        super(name);
    }

    ProcessInputTransaction pIT = new ProcessInputTransaction();

    public void setUp() throws Exception {
        super.setUp();
    }

    public void tearDown() throws Exception {
        super.tearDown();
    }

    public void testParseInput() throws Exception {
        assertEquals(pIT.parseInput("ajay give ravi 10").from.equals("ajay"), true);
        assertEquals(pIT.parseInput("ajay give ravi 10").To.equals("ravi"), true);
        assertEquals(pIT.parseInput("ajay give ravi 10").Amount.equals(10), true);

        assertEquals(pIT.parseInput("ajay give ravi 10").from.equals("ajay"), true);
        assertEquals(pIT.parseInput("ajay give ravi 10").To.equals("ravi"), true);

        assertEquals(pIT.parseInput("vani give ravi 200").from.equals("vani"), true);
        assertEquals(pIT.parseInput("vani give ravi 200").To.equals("ravi"), true);

        assertEquals(pIT.parseInput("ajay give vani 500").from.equals("ajay"), true);
        assertEquals(pIT.parseInput("ajay give vani 500").To.equals("vani"), true);
    }

    public static Test suite() {
        return new TestSuite(ProcessInputTransactionTest.class);
    }
}
