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
import de.jonato.jfxc.controls.barcode.core.BarcodeFactory;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;
import uk.org.okapibarcode.backend.DataMatrix;
import uk.org.okapibarcode.backend.OkapiException;

import java.io.File;
import java.time.LocalDateTime;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;


public class BarcodeFXTest extends ApplicationTest {

    private BarcodeFX barcodeFX;
    private VBox vbox;

    @Override
    public void start(Stage stage) throws Exception {
        vbox = new VBox(5);
        Scene scene = new Scene(new ScrollPane(vbox), 500, 500);
        stage.setScene(scene);
        stage.show();
    }

    @Test
    public void testAllGetterSetter() throws Exception {
        barcodeFX = new BarcodeFX(BarcodeEncoding.QR_CODE, "test", Color.WHITE, Color.BLACK);
        barcodeFX.setContent("a");
        barcodeFX.setBorder(1);
        barcodeFX.setZoom(2);
        barcodeFX.setForeground(Color.BEIGE);
        barcodeFX.setBackground(Color.GRAY);
        barcodeFX.setBarcode(new DataMatrix());

        assertTrue(
                barcodeFX.getContent().equals("a") &&
                        barcodeFX.getBorder().equals(1) &&
                        barcodeFX.getZoom().equals(2) &&
                        barcodeFX.getForeground().equals(Color.BEIGE) &&
                        barcodeFX.getBarcode() instanceof DataMatrix
        );
    }

    @Test
    public void testAllBarcodes() throws Exception {
        System.out.println("");
        String testData = "28";
        for (BarcodeEncoding encoding : BarcodeEncoding.values()) {
            System.out.print("Generate barcode: " + encoding.name());
            try {
                ImageView iv = new ImageView(BarcodeFactory.getBarcodeImage(encoding, testData));
                Platform.runLater(() -> vbox.getChildren().add(0, iv));
                System.out.println(" -> OK");

            } catch (Exception e) {
                if (!(e instanceof OkapiException)) {
                    e.printStackTrace();
                    fail();
                }
                System.out.println(" -> FAILED - BARCODE LIB EXCEPTON");
            }
        }

    }

    @Test
    public void testGenerateBarcodeView() throws Exception {
        BarcodeView barcodeView = new BarcodeView(BarcodeEncoding.QR_CODE, "TEST");
        assertTrue(barcodeView.getData().equals("TEST"));
        barcodeView.setData("TESTSTRING");
        assertTrue(barcodeView.getData().equals("TESTSTRING"));
    }


    @Test
    public void testSaveBarcode() throws Exception {
        barcodeFX = new BarcodeFX(BarcodeEncoding.QR_CODE, "jonato.de - Tobias Jonas");
        String tmpName = LocalDateTime.now().toString();

        File f = barcodeFX.saveTemp(tmpName, "png");
        assertTrue(f.exists());

        barcodeFX.saveAsBMP(tmpName + ".bmp");
        f = new File(tmpName + ".bmp");
        assertTrue(f.exists());
        f.delete();

        barcodeFX.saveAsEPS(tmpName + ".eps");
        f = new File(tmpName + ".eps");
        assertTrue(f.exists());
        f.delete();

        barcodeFX.saveAsPNG(tmpName + ".png");
        f = new File(tmpName + ".png");
        assertTrue(f.exists());
        f.delete();

        barcodeFX.saveAsGIF(tmpName + ".gif");
        f = new File(tmpName + ".gif");
        assertTrue(f.exists());
        f.delete();

        barcodeFX.saveAsJPG(tmpName + ".jpg");
        f = new File(tmpName + ".jpg");
        assertTrue(f.exists());
        f.delete();
    }


}