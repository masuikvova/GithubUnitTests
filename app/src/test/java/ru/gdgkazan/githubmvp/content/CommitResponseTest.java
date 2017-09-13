package ru.gdgkazan.githubmvp.content;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by vladimir.masyuk on 9/13/2017.
 */
public class CommitResponseTest {
    CommitResponse response;
    @Before
    public void setUp() throws Exception {
        response = new CommitResponse();
    }

    @Test
    public void getCommit() throws Exception {
        Assert.assertNotNull(response);
    }

}