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

import java.util.Map;

import static org.junit.Assert.assertTrue;

public class CurrentSystemTest {

    @Test
    public void testGetProxy() throws Exception {
        String host = "localhost";
        String port = "1337";
        String user = "user";
        String pass = "pass";
        CurrentSystem.setProxy(host, port, user, pass);

        Map<String, String> proxy = CurrentSystem.getProxy();
        assertTrue(
                proxy.get("host").equals(host) &&
                        proxy.get("port").equals(port) &&
                        proxy.get("user").equals(user) &&
                        proxy.get("password").equals(pass)
        );

        CurrentSystem.removeProxy();
    }

    @Test
    public void testSystemInfo() {
        assertTrue(
                CurrentSystem.getJavaHome().length() > 0 &&
                        CurrentSystem.getJavaVersion().length() > 0 &&
                        CurrentSystem.getIPv4Adress().length() > 0 &&
                        CurrentSystem.getIPv6Adress().length() > 0 &&
                        CurrentSystem.getHostname().length() > 0 &&
                        CurrentSystem.getSeparator().length() > 0
        );
    }

    @Test
    public void testSystemInfoRetry() {
        assertTrue(
                CurrentSystem.getJavaHome().length() > 0 &&
                        CurrentSystem.getJavaVersion().length() > 0 &&
                        CurrentSystem.getSeparator().length() > 0
        );
    }
}