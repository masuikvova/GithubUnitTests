package ru.gdgkazan.githubmvp.content;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


public class RepositoryTest {
    private Repository repository;
    private String name = "name";
    private String desripion = "some description";
    private String language = "java";
    private int stars = 1;
    private int forks = 2;
    private int watches = 3;

    @Before
    public void setUp() throws Exception {
        repository = new Repository(name,desripion,language,stars,forks,watches);
    }

    @Test
    public void getName() throws Exception {
        Assert.assertEquals(repository.getName(), name);
    }

    @Test
    public void setName() throws Exception {
        repository.setName(null);
        Assert.assertNotNull(repository.getName());
    }

    @Test
    public void getDescription() throws Exception {
        Assert.assertEquals(repository.getDescription(), desripion);
    }

    @Test
    public void setDescription() throws Exception {
        repository.setDescription(null);
        Assert.assertNotNull(repository.getDescription());
    }

    @Test
    public void getLanguage() throws Exception {
        Assert.assertEquals(repository.getLanguage(), language);
    }

    @Test
    public void setLanguage() throws Exception {
        repository.setLanguage(null);
        Assert.assertNotNull(repository.getLanguage());
    }

    @Test
    public void getStarsCount() throws Exception {
        Assert.assertEquals(repository.getStarsCount(), stars);
    }

    @Test
    public void setStarsCount() throws Exception {
        repository.setStarsCount(0);
        Assert.assertNotNull(repository.getStarsCount());
    }

    @Test
    public void getForksCount() throws Exception {
        Assert.assertEquals(repository.getForksCount(), forks);
    }

    @Test
    public void setForksCount() throws Exception {
        repository.setForksCount(0);
        Assert.assertNotNull(repository.getForksCount());
    }

    @Test
    public void getWatchersCount() throws Exception {
        Assert.assertEquals(repository.getWatchersCount(), watches);
    }

    @Test
    public void setWatchersCount() throws Exception {
        repository.setWatchersCount(0);
        Assert.assertNotNull(repository.getWatchersCount());
    }

    @Test
    public void notNull()throws Exception{
        Repository repository = new Repository();
        Assert.assertNotNull(repository);
    }
}