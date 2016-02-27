package de.jonato.jfxc.controls.textfield;

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
import javafx.scene.input.KeyCode;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;

import static org.junit.Assert.assertTrue;

public class TypedTextFieldTest extends ApplicationTest {
    private TypedTextField doubleTextField;
    private TypedTextField floatTextField;
    private TypedTextField intTextField;
    private TypedTextField bigIntTextField;
    private TypedTextField longTextField;

    @Override
    public void start(Stage stage) throws Exception {

        doubleTextField = TypedTextFieldFactory.getDoubleTextField("");
        floatTextField = TypedTextFieldFactory.getFloatTextField("");
        intTextField = TypedTextFieldFactory.getIntTextField("");
        bigIntTextField = TypedTextFieldFactory.getBigIntTextField("");
        longTextField = TypedTextFieldFactory.getLongTextField("");


        Scene scene = new Scene(new VBox(5.0, doubleTextField, floatTextField, intTextField, bigIntTextField, longTextField), 300, 200);
        stage.setScene(scene);
        stage.show();
    }

    @Test
    public void testDoubleTextField() throws Exception {
        clickOn(doubleTextField);
        write("123ab.ba123");
        push(KeyCode.TAB);
        assertTrue(
                doubleTextField.getText().equals("123.123")
        );
    }

    @Test
    public void testFloatField() throws Exception {
        clickOn(floatTextField);
        write("44ab.ba55");
        push(KeyCode.TAB);
        assertTrue(
                floatTextField.getText().equals("44.55")
        );
    }

    @Test
    public void testIntField() throws Exception {
        clickOn(intTextField);
        write("44ab.ba55");
        push(KeyCode.TAB);
        assertTrue(
                intTextField.getText().equals("4455")
        );
    }

    @Test
    public void testLongField() throws Exception {
        clickOn(longTextField);
        write("442ab.ba55");
        push(KeyCode.TAB);
        assertTrue(
                longTextField.getText().equals("44255")
        );
    }

    @Test
    public void testBigIntField() throws Exception {
        clickOn(bigIntTextField);
        write("446ab.ba55");
        push(KeyCode.TAB);
        assertTrue(
                bigIntTextField.getText().equals("44655")
        );
    }

}
