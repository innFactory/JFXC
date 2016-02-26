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
 * Current User infos from system property.
 */
public class CurrentUser{

    private static String username;
    private static String userhome;
    private static String country;
    private static String language;

    /**
     * get username from system property.
     * @return username
     */
    public static String getUsername(){
        if(username == null) { username = System.getProperty("user.name"); }
        return username;
    }

    /**
     * get userhome from system property.
     * @return userhome
     */
    public static String getUserhome(){
        if(userhome == null) { userhome = System.getProperty("user.home"); }
        return userhome;
    }

    /**
     * get country from system property.
     * @return country
     */
    public static String getCountry(){
        if(country == null) { country = System.getProperty("user.country"); }
        return country;
    }

    /**
     * Get language from system property.
     * @return language
     */
    public static String getLanguage(){
        if(language == null) { language = System.getProperty("user.language"); }
        return language;
    }
}
