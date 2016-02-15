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
import javafx.scene.input.KeyCombination;
import javafx.scene.input.KeyEvent;

import java.util.HashMap;
import java.util.HashSet;


//TODO Refactor, test & comment

public abstract class AbstractKeyboard implements IKeyboard {
    private KeyStroke currentKeyStroke = new KeyStroke();
    protected HashMap<KeyStroke, HashSet<KeyboardCallback>> actions = new HashMap<>();
    protected HashMap<KeyCombination, HashSet<CombinationCallback>> combinations = new HashMap<>();

    protected void putCombination(KeyCombination keyCombination, CombinationCallback combinationCallback){
        synchronized (combinations){
            if(!combinations.containsKey(keyCombination)){
                combinations.put(keyCombination, new HashSet<>());
            }
            synchronized (combinations.get(keyCombination)){
                combinations.get(keyCombination).add(combinationCallback);
            }
        }
    }

    protected void putAction(KeyStroke keyStroke, KeyboardCallback keyboardCallback){
        synchronized (actions) {
            if (!actions.containsKey(keyStroke)) {
                actions.put(keyStroke, new HashSet<>());
            }
            synchronized (actions.get(keyStroke)) {
                actions.get(keyStroke).add(keyboardCallback);
            }
        }
    }

    protected void removeAllCombinations(KeyCombination keyCombination){
        synchronized (combinations){
            if(combinations.containsKey(keyCombination)){
                combinations.remove(keyCombination);
            }
        }
    }

    protected void removeAllActions(KeyStroke keyStroke){
        synchronized (actions) {
            if (actions.containsKey(keyStroke)) {
                actions.remove(keyStroke);
            }
        }
    }

    protected  void removeCombination(KeyCombination keyCombination, CombinationCallback combinationCallback){
        synchronized (combinations){
            if(combinations.containsKey(keyCombination) && combinations.get(keyCombination).contains(combinationCallback)){
                synchronized (combinations.get(keyCombination)){
                    combinations.get(keyCombination).remove(combinationCallback);
                }
            }
        }
    }
    protected void removeAction(KeyStroke keyStroke, KeyboardCallback keyboardCallback){
        synchronized (actions) {
            if (actions.containsKey(keyStroke) && actions.get(keyStroke).contains(keyboardCallback)) {
                synchronized (actions.get(keyStroke)) {
                    actions.get(keyStroke).remove(keyboardCallback);
                }
            }
        }
    }

    public KeyStroke getCurrentKeyStroke() {
        return currentKeyStroke;
    }

    public void setCurrentKeyStroke(KeyStroke currentKeyStroke) {
        this.currentKeyStroke = currentKeyStroke;
    }

    public void setKeyDownEvent(KeyEvent keyEvent) {

        synchronized (currentKeyStroke) {
            currentKeyStroke.addKey(keyEvent.getCode());
            if(keyEvent.isAltDown()){
                currentKeyStroke.addKey(KeyCode.ALT);
            }else{
                currentKeyStroke.removeKey(KeyCode.ALT);
            }
            if(keyEvent.isControlDown()){
                currentKeyStroke.addKey(KeyCode.CONTROL);
            }else{
                currentKeyStroke.removeKey(KeyCode.CONTROL);
            }
            if(keyEvent.isShiftDown()){
                currentKeyStroke.addKey(KeyCode.SHIFT);
            }else{
                currentKeyStroke.removeKey(KeyCode.SHIFT);
            }
            if(keyEvent.isMetaDown()){
                currentKeyStroke.addKey(KeyCode.META);
            }else{
                currentKeyStroke.removeKey(KeyCode.META);
            }
            if(keyEvent.isShortcutDown()){
                currentKeyStroke.addKey(KeyCode.SHORTCUT);
            }else{
                currentKeyStroke.removeKey(KeyCode.SHORTCUT);
            }
            synchronized (actions) {
                if (actions.containsKey(currentKeyStroke)) {
                    synchronized (actions.get(currentKeyStroke)) {
                        actions.get(currentKeyStroke).forEach(inv -> inv.keyboardAction(currentKeyStroke, keyEvent));
                    }
                }
            }

            synchronized (combinations) {
                combinations.forEach((keyCombination, keyboardCallbacks) -> {
                    if(keyCombination.match(keyEvent)){
                        synchronized (keyboardCallbacks){
                            keyboardCallbacks.forEach(inv -> inv.keyboardCombination(keyCombination, keyEvent));
                        }
                    }
                });
            }
        }
    }

    public void setKeyUpEvent(KeyEvent keyEvent){
        synchronized (currentKeyStroke) {
            if(keyEvent.isAltDown()){
                currentKeyStroke.removeKey(KeyCode.ALT);
            }
            if(keyEvent.isControlDown()){
                currentKeyStroke.removeKey(KeyCode.CONTROL);
            }
            if(keyEvent.isShiftDown()){
                currentKeyStroke.removeKey(KeyCode.SHIFT);
            }
            if(keyEvent.isMetaDown()){
                currentKeyStroke.removeKey(KeyCode.META);
            }
            if(keyEvent.isShortcutDown()){
                currentKeyStroke.removeKey(KeyCode.SHORTCUT);
            }
            currentKeyStroke.removeKey(keyEvent.getCode());
        }
    }
}
