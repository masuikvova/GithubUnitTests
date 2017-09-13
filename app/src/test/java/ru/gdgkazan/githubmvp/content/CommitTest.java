package ru.gdgkazan.githubmvp.content;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by vladimir.masyuk on 9/13/2017.
 */
public class CommitTest {
    private Commit commit;
    private String repoName = "repo";
    private Author author = new Author();
    private String message = "message";

    @Before
    public void init(){
        author.setAuthorName("name");
        commit = new Commit();
        commit.setRepoName(repoName);
        commit.setAuthor(author);
        commit.setMessage(message);
    }

    @Test
    public void getRepoName() throws Exception {
        Assert.assertEquals(commit.getRepoName(), repoName);
    }

    @Test
    public void setRepoName() throws Exception {
        String repoName = "fsdfd";
        commit.setRepoName(repoName);
        Assert.assertEquals(commit.getRepoName(), repoName);
    }

    @Test
    public void getAuthor() throws Exception {
        Assert.assertEquals(commit.getAuthor(),author);
    }

    @Test
    public void setAuthor() throws Exception {
        author.setAuthorName("newName");
        commit.setAuthor(author);
        Assert.assertEquals(commit.getAuthor().getAuthorName(),author.getAuthorName());
    }

    @Test
    public void getMessage() throws Exception {
        Assert.assertEquals(commit.getMessage(),message);
    }

    @Test
    public void setMessage() throws Exception {
        String newMessage = "new_message";
        commit.setMessage(newMessage);
        Assert.assertEquals(commit.getMessage(),newMessage);
    }
}