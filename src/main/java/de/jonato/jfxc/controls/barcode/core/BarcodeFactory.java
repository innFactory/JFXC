package de.jonato.jfxc.controls.barcode.core;

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


import javafx.scene.image.WritableImage;
import uk.org.okapibarcode.backend.Code3Of9;
import uk.org.okapibarcode.backend.CodeOne;
import uk.org.okapibarcode.backend.HumanReadableLocation;
import uk.org.okapibarcode.backend.MsiPlessey;

public class BarcodeFactory {


    /**
     * Get a Barcode Settings instance with default values.
     *
     * @return settings
     */
    public static BarcodeSettings getDefaultSettings() {

        /*
         private HumanReadableLocation humanReadableLocation;
         private MsiPlessey.CheckDigit msiPlesseyCheckDigit;
         private Code3Of9.CheckDigit code39CheckDigit;
         private CodeOne.Version codeOneVersion;
         private QrCode.EccMode qrEccMode;
         private boolean qrEccModeEnabled;
         private boolean aztecEccModeEnabled;
         private QrCode.EccMode aztecCodeEcc;
         private boolean gridMatrixEccModeEnabled;
         private QrCode.EccMode gridMatrixCodeEcc;
         private Integer channelCodeChannels;
         private Integer databarColumns;
         private Integer dataMatrixSymbolSize;
         private boolean dataMatrixSupressRectSymbolsinAutoMode;
         */

        BarcodeSettings barcodeSettings = new BarcodeSettings();
        barcodeSettings.setHumanReadableLocation(HumanReadableLocation.BOTTOM);
        barcodeSettings.setAztecEccModeEnabled(false);
        barcodeSettings.setChannelCodeChannels(0);
        barcodeSettings.setCodeOneVersion(CodeOne.Version.A);
        barcodeSettings.setCode39CheckDigit(Code3Of9.CheckDigit.MOD43);
        barcodeSettings.setDataMatrixSupressRectSymbolsinAutoMode(false);
        barcodeSettings.setQrEccModeEnabled(false);
        barcodeSettings.setDataMatrixSymbolSize(0);
        barcodeSettings.setDatabarColumns(0);
        barcodeSettings.setGridMatrixEccModeEnabled(false);
        barcodeSettings.setMsiPlesseyCheckDigit(MsiPlessey.CheckDigit.MOD10);

        return barcodeSettings;
    }

    /**
     * Create a Barcode image for use in javafx.
     *
     * @param encoding Barcode Type
     * @param data     Barcode Data
     * @return Barcode image
     */
    public static WritableImage getBarcodeImage(BarcodeEncoding encoding, String data) {
        BarcodeFX barcode = new BarcodeFX(encoding, data);
        return barcode.getImage();
    }
}
