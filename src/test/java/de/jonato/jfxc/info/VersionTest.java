package de.jonato.jfxc.info;

/*
 * #%L
 * JFXC
 * %%
 * Copyright (C) 2016 Jonato IT Solutions
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class VersionTest {
    @Test
    public void testCompareVersionNewMajor() throws Exception {
        String Version1 = "1.1.1";
        String Version2 = "2.1.1";
        assertTrue(Version.compareVersions(Version1, Version2) < 0);
    }

    @Test
    public void testCompareVersionFalse() throws Exception {
        String Version1 = "1.1.1";
        String Version2 = "2.1.1";
        assertFalse(Version.compareVersions(Version1, Version2) > 0);
    }

    @Test
    public void testCompareVersionEqual() throws Exception {
        String Version1 = "2.2.3";
        String Version2 = "2.2.3";
        assertTrue(Version.compareVersions(Version1, Version2) == 0);
    }

    @Test
    public void testCompareNewerMinor() throws Exception {
        String Version1 = "2.2.3";
        String Version2 = "2.3.3";
        assertTrue(Version.compareVersions(Version1, Version2) < 0);
    }

    @Test
    public void testCompareNewerBuild() throws Exception {
        String Version1 = "2.2.3";
        String Version2 = "2.3.3";
        assertTrue(Version.compareVersions(Version1, Version2) < 0);
    }
}