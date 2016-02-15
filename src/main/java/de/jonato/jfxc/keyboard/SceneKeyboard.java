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

import javafx.scene.Scene;
import javafx.scene.input.KeyCombination;
import javafx.stage.Stage;

public class SceneKeyboard extends AbstractKeyboard {
    private Scene target;

    public SceneKeyboard(Scene scene){
        this(scene, null);
    }

    public SceneKeyboard(Scene scene, Stage stage) {
        target = scene;
        scene.setOnKeyPressed(key -> setKeyDownEvent(key));
        scene.setOnKeyReleased(key -> setKeyUpEvent(key));
        if(stage != null){
            stage.focusedProperty().addListener((o,ov,nv) -> {
                if(nv == false){
                    setCurrentKeyStroke(new KeyStroke());
                }
            });
        }
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
    public void addKeyCombination(KeyCombination keyCombination, CombinationCallback combinationCallback) {
        putCombination(keyCombination, combinationCallback);
    }

    @Override
    public void removeKeyCombinationCall(KeyCombination keyCombination, CombinationCallback combinationCallback) {
       removeCombination(keyCombination, combinationCallback);
    }

    @Override
    public void removeKeyCombination(KeyCombination keyCombination) {
        removeAllCombinations(keyCombination);
    }

    @Override
    public void removeKeyStrokeCall(KeyStroke keyStroke, KeyboardCallback keyboardCallback) {
        removeAction(keyStroke, keyboardCallback);
    }

    public Scene getTarget() {
        return target;
    }
}
