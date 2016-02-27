package de.jonato.jfxc.info;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class OSTest {

    @Test
    public void testOSInfo() {
        assertTrue(
                OS.getOsName().length() > 0 &&
                        OS.getVersion().length() > 0
        );
    }

    @Test
    public void testOSInfoRetry() {
        assertTrue(
                OS.getOsName().length() > 0 &&
                        OS.getVersion().length() > 0
        );
    }


    @Test
    public void testValidSystem() {
        assertTrue(
                OS.isMacOSX() ||
                        OS.isSolaris() ||
                        OS.isUnix() ||
                        OS.isWindows()
        );
    }
}