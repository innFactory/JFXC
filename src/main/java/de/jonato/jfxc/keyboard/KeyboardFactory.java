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
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.HashMap;

public class KeyboardFactory {

    private static HashMap<Scene, SceneKeyboard> sceneKeyboards = new HashMap<>();
    private static HashMap<Node, NodeKeyboard> nodeKeyboards = new HashMap<>();

    /**
     * Create or get a KeyBoard instance for a JavaFX Scene.
     * @param scene JavaFX scene
     * @return IKeyboard for handling key events.
     */
    public static IKeyboard getKeyboardForScene(Scene scene){
        if(!sceneKeyboards.containsKey(scene)){
            sceneKeyboards.put(scene, new SceneKeyboard(scene));
        }
        return sceneKeyboards.get(scene);
    }

    /**
     * Create or get a KeyBoard instance for a JavaFX Scene. Addionally register a listener if focus is lost.
     * @param scene JavaFX scene
     * @param stage JavaFX stage
     * @return IKeyboard for handling key events.
     */
    public static IKeyboard getKeyboardForScene(Scene scene, Stage stage){
        if(!sceneKeyboards.containsKey(scene)){
            sceneKeyboards.put(scene, new SceneKeyboard(scene, stage));
        }
        return sceneKeyboards.get(scene);
    }

    /**
     * Create or get a KeyBoard instance for a JavaFX Node.
     * @param node JavaFX node
     * @return IKeyboard for handling key events.
     */
    public static IKeyboard getKeyboardForNode(Node node){
        if(!nodeKeyboards.containsKey(node)){
            nodeKeyboards.put(node, new NodeKeyboard(node));
        }
        return nodeKeyboards.get(node);
    }

}
