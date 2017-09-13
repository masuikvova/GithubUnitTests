package ru.gdgkazan.githubmvp.utils;

import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Constructor;

import ru.gdgkazan.githubmvp.BuildConfig;

/**
 * Created by vladimir.masyuk on 9/13/2017.
 */
public class AuthorizationUtilsTest {


    @Test
    public void createAuthorizationParam() throws Exception {
        String template = "{\"client_id\":\"" + BuildConfig.CLIENT_ID +
                "\",\"client_secret\":\"" + BuildConfig.CLIENT_SECRET + "\"}";
        String json = AuthorizationUtils.createAuthorizationParam().toString();
        Assert.assertEquals(template, json);
    }

    @Test
    public void notNull() throws Exception {
        Constructor<AuthorizationUtils> c = AuthorizationUtils.class.getDeclaredConstructor();
        c.setAccessible(true);
        Assert.assertNotNull(c.newInstance());
    }

}