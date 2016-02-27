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


import de.jonato.jfxc.controls.barcode.BarcodeView;
import de.jonato.jfxc.controls.barcode.core.BarcodeEncoding;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class BarcodeSampleApp extends Application {

    private VBox vbox;

    @Override
    public void start(Stage primaryStage) throws Exception {
        vbox = new VBox();
        vbox.setSpacing(15.0);
        Scene scene = new Scene(vbox, 800, 600);

        String initVal = "Tobias Jonas - Jonato IT Solutions";

        BarcodeView barcodeView = new BarcodeView(BarcodeEncoding.QR_CODE, initVal);
        TextField textfield = new TextField(initVal);

        barcodeView.dataProperty().bind(textfield.textProperty());

        Button close = new Button("Close");
        close.setOnAction(e -> primaryStage.close());
        vbox.getChildren().addAll(barcodeView, textfield, close);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
