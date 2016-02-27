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
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;

import static org.junit.Assert.assertTrue;


public class KeyboardRegistryTest extends ApplicationTest {

    private TextField textfield;
    private Stage stage;
    private Scene scene;

    @Override
    public void start(Stage stage) throws Exception {
        textfield = new TextField();
        VBox vBox = new VBox();
        textfield.setId("textfield");

        vBox.getChildren().addAll(textfield);
        scene = new Scene(vBox, 300, 300);
        stage.setScene(scene);
        this.stage = stage;
        this.stage.show();
    }

    @Test
    public void testRegistry() {
        IKeyboard keyboard = KeyboardFactory.getKeyboardForScene(scene);
        KeyboardRegistry.add("test", keyboard);

        IKeyboard keyboard2 = KeyboardRegistry.get("test");

        assertTrue(keyboard2 != null && keyboard2 instanceof IKeyboard);
    }

}