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

import java.util.HashSet;

public class KeyStroke {

    HashSet<KeyCode> keyStrokes;

    public KeyStroke(){
        keyStrokes = new HashSet<>();
    }

    /**
     * Create a KeyStroke with Keys.
     * @param keyCodes Keys
     */
    public KeyStroke(KeyCode... keyCodes){
        this();
        addKeys(keyCodes);
    }

    /**
     * Add a key to KeyStroke.
     * @param keyCode Key
     */
    public void addKey(KeyCode keyCode){
        keyStrokes.add(keyCode);
    }

    /**
     * Remove a key from KeyStroke.
     * @param keyCode Key
     */
    public void removeKey(KeyCode keyCode){
        keyStrokes.removeIf(key -> key.equals(keyCode));
    }


    /**
     * Add multiple Keys to KeyStroke.
     * @param keyCodes Keys
     */
    public void addKeys(KeyCode... keyCodes){
        for(KeyCode key : keyCodes){
            addKey(key);
        }
    }

    /**
     * Remove multiple Keys to KeyStroke.
     * @param keyCodes Keys
     */
    public void removeKeys(KeyCode... keyCodes){
        for(KeyCode key : keyCodes){
            removeKey(key);
        }
    }

    public HashSet<KeyCode> getKeyStrokes() {
        return keyStrokes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof KeyStroke)) return false;

        KeyStroke keyStroke = (KeyStroke) o;

        if (keyStrokes != null ? !keyStrokes.equals(keyStroke.keyStrokes) : keyStroke.keyStrokes != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return keyStrokes != null ? keyStrokes.hashCode() : 0;
    }

}
