package de.jonato.jfxc.controls.barcode;

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

import de.jonato.jfxc.controls.barcode.core.BarcodeEncoding;
import de.jonato.jfxc.controls.barcode.core.BarcodeFX;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.image.ImageView;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Collections;


public class BarcodeView extends ImageView {

    private SimpleStringProperty data;
    private BarcodeFX barcodeFX;


    /**
     * Creates a new barcode view that represents an IMG element.
     *
     * @param encoding barcode type
     * @param value    barcode data
     */
    public BarcodeView(BarcodeEncoding encoding, String value) {
        super();

        barcodeFX = new BarcodeFX(encoding, value);
        data = new SimpleStringProperty(value);
        data.addListener((observable, oldValue, newValue) -> {
            barcodeFX.setContent(newValue);
            setImage(barcodeFX.getImage());
        });

        if (value.length() > 0) {
            this.setImage(barcodeFX.getImage());
        }

        setSmooth(true);
        setPreserveRatio(true);
        VBox.setVgrow(this, Priority.ALWAYS);
        HBox.setHgrow(this, Priority.ALWAYS);

        setOnDragDetected(event -> {
            Dragboard db = startDragAndDrop(TransferMode.COPY_OR_MOVE);
            ClipboardContent content = new ClipboardContent();
            try {
                File tmpFile = barcodeFX.saveTemp(LocalDateTime.now().toString(), "png");
                content.putFiles(Collections.singletonList(tmpFile));
                tmpFile.deleteOnExit();
            } catch (IOException e) {
                e.printStackTrace();
            }

            db.setContent(content);
            event.consume();
        });
        setOnDragDone(me -> me.consume());
    }

    /**
     * Get the barcode data.
     *
     * @return barcode data as string
     */
    public String getData() {
        return data.get();
    }

    /**
     * barcode data property
     *
     * @return data property
     */
    public SimpleStringProperty dataProperty() {
        return data;
    }

    /**
     * Set the barcode data and change the image.
     *
     * @param data barcode data as string
     */
    public void setData(String data) {
        this.data.set(data);
    }

    /**
     * Get barcode instance.
     *
     * @return barcode instance
     */
    public BarcodeFX getBarcodeFX() {
        return barcodeFX;
    }
}
