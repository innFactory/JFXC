package de.jonato.jfxc.controls.spacer;

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

public class SpacerTest extends ApplicationTest {


    private TextField textfield;
    private Scene scene;
    private Stage stage;
    VBox vBox;

    @Override
    public void start(Stage stage) throws Exception {
        vBox = new VBox();
        scene = new Scene(vBox, 300, 300);
        stage.setScene(scene);
        this.stage = stage;
        this.stage.show();
    }

    @Test
    public void testCreateSpacer() {
        HGrowSpace hGrowSpace = new HGrowSpace();
        HFixedSpace hFixedSpace = new HFixedSpace(15);
        VGrowSpace vGrowSpace = new VGrowSpace();

        assertTrue(true);
    }


}