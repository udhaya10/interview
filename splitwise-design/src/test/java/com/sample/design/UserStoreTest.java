package com.sample.design;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.util.ArrayList;
import java.util.List;

/**
 * UserStore Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>10/24/2017</pre>
 */
public class UserStoreTest extends TestCase {

    public UserStore us = new UserStore();

    public UserStoreTest(String name) {
        super(name);
    }

    public void setUp() throws Exception {

        List<String> input = new ArrayList<String>();

        input.add("ajay");
        input.add("vani");
        input.add("ravi");
        input.add("uday");

        for (String str : input) {
            us.addNewUser(str);
        }

        super.setUp();
    }

    public void tearDown() throws Exception {
        super.tearDown();
    }

    public void testGetUserId() throws Exception {
        assertEquals(us.getUserId("ajay") == 0, true);
        assertEquals(us.getUserId("vani") == 1, true);
        assertEquals(us.getUserId("ravi") == 2, true);
        assertEquals(us.getUserId("uday") == 3, true);

        assertEquals(us.getUserId("ajay") == 0, true);
        assertEquals(us.getUserId("ravi") == 2, true);
    }

    public void testGetUserName() throws Exception {
        assertEquals(us.getUserName(0).equals("ajay"), true);
        assertEquals(us.getUserName(3).equals("uday"), true);
    }

    public static Test suite() {
        return new TestSuite(UserStoreTest.class);
    }
}
