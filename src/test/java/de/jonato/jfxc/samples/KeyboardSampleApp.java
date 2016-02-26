package de.jonato.jfxc.samples;

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

import de.jonato.jfxc.info.OS;
import de.jonato.jfxc.keyboard.IKeyboard;
import de.jonato.jfxc.keyboard.KeyStroke;
import de.jonato.jfxc.keyboard.KeyboardFactory;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class KeyboardSampleApp extends Application {

    private VBox vbox;

    @Override
    public void start(Stage primaryStage) throws Exception {
        System.out.println(OS.isWindows());
        System.out.println(OS.getOsName());
        vbox = new VBox();
        vbox.setSpacing(15.0);
        Scene scene = new Scene(vbox, 800, 600);

        TextField textField = new TextField();
        TextField textField2 = new TextField();

        IKeyboard iKeyboard = KeyboardFactory.getKeyboardForNode(textField);
        iKeyboard.addKeyStroke(new KeyStroke(KeyCode.COMMAND), (e,f) -> textField2.setText(e + " - " + f));
        iKeyboard.addKeyStroke(new KeyStroke(KeyCode.ALPHANUMERIC), (e,f) -> textField2.setText(e + " - " + f));


        Button close = new Button("Close"); close.setOnAction(e -> primaryStage.close());
        vbox.getChildren().addAll(textField,textField2, close);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
