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

/**
 * Current Os infos.
 */
public class OS {
    private static String OS = null;
    private static String VERSION = null;

    /**
     * get os name from system property.
     *
     * @return current os
     */
    public static String getOsName() {
        if (OS == null) {
            OS = java.lang.System.getProperty("os.name");
        }
        return OS;
    }

    /**
     * get os version from system property.
     *
     * @return current os version
     */
    public static String getVersion() {
        if (VERSION == null) {
            VERSION = java.lang.System.getProperty("os.version");
        }
        return VERSION;
    }

    public static boolean isWindows() {
        return getOsName().startsWith("Windows");
    }

    public static boolean isUnix() {
        return (getOsName().indexOf("nix") >= 0 || getOsName().indexOf("nux") >= 0 || getOsName().indexOf("aix") > 0);
    }

    public static boolean isSolaris() {
        return (getOsName().indexOf("sunos") >= 0);
    }

    public static boolean isMacOSX() {
        return getOsName().startsWith("Mac OS X");
    }
}
