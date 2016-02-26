package de.jonato.jfxc.samples;

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


import de.jonato.jfxc.info.CurrentSystem;
import de.jonato.jfxc.info.CurrentUser;
import de.jonato.jfxc.info.OS;

public class InfoGen {
    public static void main(String[] args) {
        System.out.println("INFOS");

        System.out.println("System has min Java7: " + CurrentSystem.hasJavaVersion(CurrentSystem.JAVA_VERSION.JAVA7));
        System.out.println("System has min Java8: " + CurrentSystem.hasJavaVersion(CurrentSystem.JAVA_VERSION.JAVA8));
        System.out.println("System has min Java9: " + CurrentSystem.hasJavaVersion(CurrentSystem.JAVA_VERSION.JAVA9));
        System.out.println("JAVA Home: " + CurrentSystem.getJavaHome());
        System.out.println("JAVA Version: " + CurrentSystem.getJavaVersion());

        System.out.println("OS: " + OS.getOsName());
        System.out.println("Version: " + OS.getVersion());

        System.out.println("Username: " + CurrentUser.getUsername());
        System.out.println("Userhome: " + CurrentUser.getUserhome());
        System.out.println("Country: " + CurrentUser.getCountry());
        System.out.println("Language: " + CurrentUser.getLanguage());

    }
}
