package ru.gdgkazan.githubmvp.utils;

import android.text.*;

import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Constructor;

import static org.junit.Assert.*;

/**
 * Created by vladimir.masyuk on 9/13/2017.
 */
public class TextUtilsTest {
    @Test
    public void isEmpty() throws Exception {
        Assert.assertTrue(TextUtils.isEmpty(""));
    }

    @Test
    public  void isnEmpty() throws Exception{
        Assert.assertFalse(TextUtils.isEmpty("gfddd"));
    }

    @Test
    public void notNull()throws Exception{
        Constructor<TextUtils> c = TextUtils.class.getDeclaredConstructor();
        c.setAccessible(true);
        Assert.assertNotNull(c.newInstance());
    }

}