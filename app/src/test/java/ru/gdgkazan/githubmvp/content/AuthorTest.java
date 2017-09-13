package ru.gdgkazan.githubmvp.content;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by vladimir.masyuk on 9/13/2017.
 */
public class AuthorTest {
    private Author author;
    private String name = "user";

    @Before
    public void create(){
        author = new Author();
        author.setAuthorName(name);
    }

    @Test
    public void notNull() throws Exception{
        Assert.assertNotNull(author);
    }

    @Test
    public void getAuthorName() throws Exception {
        Assert.assertEquals(author.getAuthorName(),name);
    }

    @Test
    public void setAuthorName() throws Exception {
        String newName ="qwerty";
        author.setAuthorName(newName);
        Assert.assertEquals(author.getAuthorName(),newName);

    }

}