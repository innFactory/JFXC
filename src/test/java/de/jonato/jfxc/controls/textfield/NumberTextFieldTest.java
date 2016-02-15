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


import de.jonato.jfxc.controls.textfield.TypedTextField;
import javafx.stage.Stage;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;

public class NumberTextFieldTest extends ApplicationTest {
    TypedTextField typedTextField;

    @Override
    public void start(Stage stage) throws Exception {
        //typedTextField = new TypedTextField();
        //typedTextField.setId("typedTextField");
        //Scene scene = new Scene(typedTextField, 800, 600);
        //stage.setScene(scene);
        //stage.show();
    }

    @Test
    public void testValidNumber() throws Exception {
        //clickOn(typedTextField);
        //write("1234").push(KeyCode.ENTER);
        //verifyThat(typedTextField, NodeMatchers.hasText("1234"));
    }

    @Test
    public void testInValidNumber() throws Exception {
        //clickOn(typedTextField);
        //write("12a34b").push(KeyCode.ENTER);
        //verifyThat(typedTextField, NodeMatchers.hasText("1234"));
    }

    //TODO

}
