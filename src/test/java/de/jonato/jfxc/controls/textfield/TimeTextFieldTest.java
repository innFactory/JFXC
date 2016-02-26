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


public class TimeTextFieldTest extends ApplicationTest {

    private TimeTextField timeTextField;
    private TimeTextField timeTextField2;

    @Override
    public void start(Stage stage) throws Exception {

        timeTextField = TimeTextFieldFactory.getHourMinuteSecondTextFieldInstance();
        timeTextField2 = TimeTextFieldFactory.getHourMinuteTextFieldInstance();

        Scene scene = new Scene(new VBox(5.0, timeTextField, timeTextField2), 300, 200);
        stage.setScene(scene);
        stage.show();
    }

    @Test
    public void testHMSTextField() throws Exception {
        clickOn(timeTextField);
        type(KeyCode.LEFT, 8);
        write("123456");
        assertTrue(
                ((HourMinSecTextField) timeTextField).getHours() == 12 &&
                        ((HourMinSecTextField) timeTextField).getMinutes() == 34 &&
                        ((HourMinSecTextField) timeTextField).getSeconds() == 56
        );
    }

    @Test
    public void testHMSTextField2() throws Exception {
        clickOn(timeTextField);
        type(KeyCode.LEFT, 8);
        write("12a34b56");
        assertTrue(
                ((HourMinSecTextField) timeTextField).getHours() == 12 &&
                        ((HourMinSecTextField) timeTextField).getMinutes() == 3 &&
                        ((HourMinSecTextField) timeTextField).getSeconds() == 40
        );
    }

    @Test
    public void testHMTextField() throws Exception {
        clickOn(timeTextField2);
        type(KeyCode.LEFT, 8);
        write("1234");
        assertTrue(
                ((HourMinTextField) timeTextField2).getHours() == 12 &&
                        ((HourMinTextField) timeTextField2).getMinutes() == 34
        );
    }

    @Test
    public void testHM2TextField() throws Exception {
        clickOn(timeTextField2);
        type(KeyCode.LEFT, 8);
        write("12a34");
        assertTrue(
                ((HourMinTextField) timeTextField2).getHours() == 12 &&
                        ((HourMinTextField) timeTextField2).getMinutes() == 3
        );
    }
}