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
import javafx.scene.input.KeyCode;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;

import static junit.framework.TestCase.fail;

public class KeyboardTest extends ApplicationTest {


    private boolean pressed = false;
    private boolean pressed2 = false;

    private TextField textfield;
    private Scene scene;
    private Stage stage;

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
    public void testNodeKeyboard() {
        IKeyboard keyboard = KeyboardFactory.getKeyboardForNode(textfield);
        pressed = false;
        keyboard.addKeyStroke(new KeyStroke(KeyCode.ALT, KeyCode.T), (e, f) -> pressed = true);

        clickOn(textfield);
        push(KeyCode.ALT, KeyCode.T);
        if (!pressed)
            fail();
    }

    @Test
    public void testSceneKeyboard() {
        IKeyboard keyboard = KeyboardFactory.getKeyboardForScene(scene, stage);
        pressed = false;
        keyboard.addKeyStroke(new KeyStroke(KeyCode.CONTROL, KeyCode.E), (e, f) -> pressed = true);

        clickOn(scene);

        push(KeyCode.CONTROL, KeyCode.E);

        if (!pressed)
            fail();
    }


    @Test
    public void test2KeyCodes() {
        IKeyboard keyboard = KeyboardFactory.getKeyboardForScene(scene, stage);
        pressed = false;
        pressed2 = false;
        keyboard.addKeyStroke(new KeyStroke(KeyCode.ALT, KeyCode.CONTROL, KeyCode.F), (e, f) -> pressed = true);
        keyboard.addKeyStroke(new KeyStroke(KeyCode.CONTROL, KeyCode.A), (e, f) -> pressed2 = true);

        clickOn(scene);

        push(KeyCode.ALT, KeyCode.CONTROL, KeyCode.F);
        push(KeyCode.CONTROL, KeyCode.A);

        if (!pressed && !pressed2)
            fail();
    }



}