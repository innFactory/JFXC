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

import de.jonato.jfxc.controls.combobox.FilterComboBox;
import de.jonato.jfxc.controls.textfield.HourMinSecTextField;
import de.jonato.jfxc.controls.textfield.HourMinTextField;
import de.jonato.jfxc.controls.textfield.TextFieldValidator;
import de.jonato.jfxc.controls.textfield.TypedTextField;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class ControlsSampleApp extends Application {

    private VBox vbox;

    @Override
    public void start(Stage primaryStage) throws Exception {
        vbox = new VBox();
        vbox.setSpacing(15.0);
        Scene scene = new Scene(vbox, 800, 600);

        /**LongTextField**/
        TypedTextField typedTextField = new TypedTextField();
        typedTextField.setValidator(TextFieldValidator.BIG_INT);

        /**HourMinTextField**/
        HourMinTextField timeTextField = new HourMinTextField();

        /**HourMinTextField**/
        HourMinSecTextField fullTimeTextField = new HourMinSecTextField();

        /**FilterComboBox**/
        String[] data =  {"Hallo" , " Welt", "Anfangsbuchstaben", "eines", "Wort", "tippen"};

        FilterComboBox<String> filterComboBox = new FilterComboBox<>(FXCollections.observableArrayList(data));


        Button close = new Button("Close"); close.setOnAction(e -> primaryStage.close());
        vbox.getChildren().addAll(typedTextField, timeTextField,fullTimeTextField,filterComboBox,close);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
