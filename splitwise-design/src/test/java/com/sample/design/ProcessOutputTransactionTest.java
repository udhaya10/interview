package com.sample.design;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * ProcessOutputTransaction Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>10/24/2017</pre>
 */
public class ProcessOutputTransactionTest extends TestCase {
    public ProcessOutputTransactionTest(String name) {
        super(name);
    }

    ProcessOutputTransaction pOT = new ProcessOutputTransaction();

    public void setUp() throws Exception {
        super.setUp();
    }

    public void tearDown() throws Exception {
        super.tearDown();
    }

    public void testParseInput() throws Exception {
        assertEquals(pOT.constructOutput(new TransactionContainerImp("ajay", "ravi", 10)).equals("ajay give ravi 10"), true);
        assertEquals(pOT.constructOutput(new TransactionContainerImp("ajay", "vani", 20)).equals("ajay give vani 20"), true);
        assertEquals(pOT.constructOutput(new TransactionContainerImp("vani", "ravi", 30)).equals("vani give ravi 30"), true);
    }

    public static Test suite() {
        return new TestSuite(ProcessOutputTransactionTest.class);
    }
}
