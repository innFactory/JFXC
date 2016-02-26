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

import javafx.scene.input.KeyCombination;

public interface IKeyboard {

    /**
     * Route a KeyStroke to a KeyboardCallback event.
     * @param keyStroke Keys for listening
     * @param keyboardCallback Fired Event
     */
    void addKeyStroke(KeyStroke keyStroke, KeyboardCallback keyboardCallback);

    /**
     * Remove a event from a Key oder KeyStroke.
     * @param keyStroke Effected Keys
     * @param keyboardCallback Effected events
     */
    void removeKeyStrokeCall(KeyStroke keyStroke, KeyboardCallback keyboardCallback);

    /**
     * Remove all actions from a KeyStroke.
     * @param keyStroke Effected Keys
     */
    void removeKeyStroke(KeyStroke keyStroke);

    /**
     * Route a KeyCombination to a KeyboardCallback event.
     * @param keyCombination Keys for listening
     * @param combinationCallback Fired Event
     */
    void addKeyCombination(KeyCombination keyCombination, CombinationCallback combinationCallback);

    /**
     * Remove a event from a KeyCombination.
     * @param keyCombination Effected Keys
     * @param combinationCallback Effected events
     */
    void removeKeyCombinationCall(KeyCombination keyCombination, CombinationCallback combinationCallback);

    /**
     * Remove all actions from a Combination.
     * @param keyCombination Effected Combination
     */
    void removeKeyCombination(KeyCombination keyCombination);



}
