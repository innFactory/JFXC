package de.jonato.jfxc.keyboard;

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

import javafx.scene.input.KeyCode;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Copyright (c) maptra.net
 * Backend JEE Server
 * Created by t.jonas on 26.02.16.
 */
public class KeyStrokeTest {

    private KeyStroke keyStroke;

    @Before
    public void setUp() {
        keyStroke = new KeyStroke();
    }

    @Test
    public void testAddKey() throws Exception {
        keyStroke = new KeyStroke();
        keyStroke.addKey(KeyCode.T);
        keyStroke.addKey(KeyCode.E);
        keyStroke.addKey(KeyCode.S);
        keyStroke.addKey(KeyCode.T);

        assertTrue(
                keyStroke.getKeyStrokes().contains(KeyCode.T) &&
                        keyStroke.getKeyStrokes().contains(KeyCode.E) &&
                        keyStroke.getKeyStrokes().contains(KeyCode.S) &&
                        keyStroke.getKeyStrokes().size() == 3
        );
    }

    @Test
    public void testRemoveKey() throws Exception {
        keyStroke = new KeyStroke();
        keyStroke.addKey(KeyCode.T);
        keyStroke.addKey(KeyCode.E);
        keyStroke.addKey(KeyCode.S);
        keyStroke.addKey(KeyCode.T);

        keyStroke.removeKey(KeyCode.E);

        assertTrue(
                keyStroke.getKeyStrokes().contains(KeyCode.T) &&
                        !keyStroke.getKeyStrokes().contains(KeyCode.E) &&
                        keyStroke.getKeyStrokes().contains(KeyCode.S) &&
                        keyStroke.getKeyStrokes().size() == 2
        );
    }
}