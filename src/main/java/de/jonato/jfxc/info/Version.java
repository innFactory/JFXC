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


public class Version {
    public final static String VERSION_SPLIT = "\\.";

    /**
     * Compare two versions string, splitted by VERSION_SPLIT static var. Version 1 is old if -1.
     * @param version1 Version 1
     * @param version2 Version 2
     * @return VERSION1 IS OLD when -1
     */
    public static int compareVersions(String version1, String version2) {
        return compareVersions(version1, version2, VERSION_SPLIT);
    }


    /**
     * Compare two versions string, splitted by VERSION_SPLIT static var. Version 1 is old if -1.
     *
     * @param version1 Version 1
     * @param version2 Version 2
     * @param split    split for version string
     * @return VERSION1 IS OLD when -1
     */
    public static int compareVersions(String version1, String version2, String split) {
        String[] components1 = version1.split(split);
        String[] components2 = version2.split(split);
        int length = Math.min(components1.length, components2.length);
        for (int i = 0; i < length; i++) {
            int result = new Integer(components1[i]).compareTo(Integer.parseInt(components2[i]));
            if (result != 0) {
                return result;
            }
        }
        return Integer.compare(components1.length, components2.length);
    }
}
