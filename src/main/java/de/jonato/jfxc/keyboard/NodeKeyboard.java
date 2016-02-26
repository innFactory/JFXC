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

import javafx.scene.Node;
import javafx.scene.input.KeyCombination;
import javafx.stage.Stage;

public class NodeKeyboard extends AbstractKeyboard {
    private Node target;

    /**
     * Get a new NodeKeyboard.
     * @param node Override the key down and key up event of the node.
     */
    public NodeKeyboard(Node node) {
        target = node;
        node.setOnKeyPressed(key -> setKeyDownEvent(key));
        node.setOnKeyReleased(key -> setKeyUpEvent(key));
    }

    @Override
    public void addKeyStroke(KeyStroke keyStroke, KeyboardCallback keyboardCallback) {
        putAction(keyStroke, keyboardCallback);
    }

    @Override
    public void removeKeyStroke(KeyStroke keyStroke) {
        removeAllActions(keyStroke);
    }

    @Override
    public void removeKeyStrokeCall(KeyStroke keyStroke, KeyboardCallback keyboardCallback) {
        removeAction(keyStroke, keyboardCallback);
    }

    @Override
    public void addKeyCombination(KeyCombination keyCombination, CombinationCallback combinationCallback) {
        putCombination(keyCombination, combinationCallback);
    }

    @Override
    public void removeKeyCombinationCall(KeyCombination keyCombination, CombinationCallback combinationCallback) {
        removeCombination(keyCombination,combinationCallback);
    }

    @Override
    public void removeKeyCombination(KeyCombination keyCombination) {
        removeAllCombinations(keyCombination);
    }
    
    public Node getTarget() {
        return target;
    }
}
