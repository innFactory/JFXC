package de.jonato.jfxc.info;

import org.junit.Test;

import static org.junit.Assert.assertTrue;


public class CurrentUserTest {


    @Test
    public void testSystemInfo() {
        assertTrue(
                CurrentUser.getCountry().length() > 0 &&
                        CurrentUser.getLanguage().length() > 0 &&
                        CurrentUser.getUserhome().length() > 0 &&
                        CurrentUser.getUsername().length() > 0
        );
    }

    @Test
    public void testSystemInfoRetry() {
        assertTrue(
                CurrentUser.getCountry().length() > 0 &&
                        CurrentUser.getLanguage().length() > 0 &&
                        CurrentUser.getUserhome().length() > 0 &&
                        CurrentUser.getUsername().length() > 0
        );
    }

}