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

import java.util.HashMap;
import java.util.Map;

/**
 * Current System infos from system property.
 */
public class CurrentSystem {

    /**
     * Java Major Version Strings
     */
    public enum JAVA_VERSION {

        JAVA9("1.9"),
        JAVA8("1.8"),
        JAVA7("1.7"),
        JAVA6("1.6"),
        JAVA5("1.5"),
        JAVA4("1.4"),
        JAVA3("1.3"),
        JAVA2("1.2"),
        JAVA1("1.1");

        private String version;

        JAVA_VERSION(String version){
            this.version = version;
        }

        public String get() {
            return version;
        }
    }


    private static String javaVersion;
    private static String fileSeparator;
    private static String javaHome;

    /**
     * Get java version from system property.
     * @return current version
     */
    public static String getJavaVersion()
    {
        if(javaVersion == null) { javaVersion = System.getProperty("java.version"); }
        return javaVersion;
    }

    /**
     * Compare the current java version with a given version.
     * @param version needed version
     * @return true if system version is newer
     */
    public static boolean hasJavaVersion(JAVA_VERSION version){
        return (Version.compareVersions(getJavaVersion(),version.get()) > 0) ? true : false;
    }

    /**
     * Get file seperator from system property.
     * @return file seperator
     */
    public static String getSeparator()
    {
        if(fileSeparator == null) { fileSeparator = System.getProperty("file.separator"); }
        return fileSeparator;
    }

    /**
     * Get Java home from system property.
     * @return java home
     */
    public static String getJavaHome(){
        if(javaHome == null) { javaHome = System.getProperty("java.home"); }
        return javaHome;
    }

    /**
     * Set a proxy server in java.
     *
     * @param host     proxy host
     * @param port     proxy port
     * @param user     proxy user
     * @param password proxy password
     */
    public static void setProxy(String host, String port, String user, String password) {
        System.getProperties().put("http.proxyHost", host);
        System.getProperties().put("http.proxyPort", port);
        System.getProperties().put("http.proxyUser", user);
        System.getProperties().put("http.proxyPassword", password);
    }


    /**
     * Get a Map with Proxy settings as map.
     *
     * @return map contains the keys host|port|user|password from System properties.
     */
    public static Map<String, String> getProxy() {
        Map<String, String> proxy = new HashMap<>();
        proxy.put("host", System.getProperties().getProperty("http.proxyHost"));
        proxy.put("port", System.getProperties().getProperty("http.proxyPort"));
        proxy.put("user", System.getProperties().getProperty("http.proxyUser"));
        proxy.put("password", System.getProperties().getProperty("http.proxyPassword"));
        return proxy;
    }

    /**
     * Clear Proxy host settings in System property.
     */
    public static void removeProxy() {
        System.clearProperty("http.proxyHost");
    }



}
