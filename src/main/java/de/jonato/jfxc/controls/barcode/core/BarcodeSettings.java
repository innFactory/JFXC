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

import uk.org.okapibarcode.backend.*;

/**
 * Stores all settings for different Barcode types.
 * Use the BarcodeFactory to generate a instance with default values.
 */
public class BarcodeSettings {

    /**
     * Location for the human readable text
     */
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

    public HumanReadableLocation getHumanReadableLocation() {
        return humanReadableLocation;
    }

    public void setHumanReadableLocation(HumanReadableLocation humanReadableLocation) {
        this.humanReadableLocation = humanReadableLocation;
    }

    public MsiPlessey.CheckDigit getMsiPlesseyCheckDigit() {
        return msiPlesseyCheckDigit;
    }

    public void setMsiPlesseyCheckDigit(MsiPlessey.CheckDigit msiPlesseyCheckDigit) {
        this.msiPlesseyCheckDigit = msiPlesseyCheckDigit;
    }

    public Code3Of9.CheckDigit getCode39CheckDigit() {
        return code39CheckDigit;
    }

    public void setCode39CheckDigit(Code3Of9.CheckDigit code39CheckDigit) {
        this.code39CheckDigit = code39CheckDigit;
    }

    public Integer getChannelCodeChannels() {
        return channelCodeChannels;
    }

    public void setChannelCodeChannels(Integer channelCodeChannels) {
        this.channelCodeChannels = channelCodeChannels;
    }

    public Integer getDatabarColumns() {
        return databarColumns;
    }

    public void setDatabarColumns(Integer databarColumns) {
        this.databarColumns = databarColumns;
    }

    public QrCode.EccMode getQrEccMode() {
        return qrEccMode;
    }

    public void setQrEccMode(QrCode.EccMode qrEccMode) {
        this.qrEccMode = qrEccMode;
    }

    public boolean isQrEccModeEnabled() {
        return qrEccModeEnabled;
    }

    public void setQrEccModeEnabled(boolean qrEccModeEnabled) {
        this.qrEccModeEnabled = qrEccModeEnabled;
    }

    public Integer getDataMatrixSymbolSize() {
        return dataMatrixSymbolSize;
    }

    public void setDataMatrixSymbolSize(Integer dataMatrixSymbolSize) {
        this.dataMatrixSymbolSize = dataMatrixSymbolSize;
    }

    public boolean isDataMatrixSupressRectSymbolsinAutoMode() {
        return dataMatrixSupressRectSymbolsinAutoMode;
    }

    public void setDataMatrixSupressRectSymbolsinAutoMode(boolean dataMatrixSupressRectSymbolsinAutoMode) {
        this.dataMatrixSupressRectSymbolsinAutoMode = dataMatrixSupressRectSymbolsinAutoMode;
    }

    public CodeOne.Version getCodeOneVersion() {
        return codeOneVersion;
    }

    public void setCodeOneVersion(CodeOne.Version codeOneVersion) {
        this.codeOneVersion = codeOneVersion;
    }

    public QrCode.EccMode getAztecCodeEcc() {
        return aztecCodeEcc;
    }

    public void setAztecCodeEcc(QrCode.EccMode aztecCodeEcc) {
        this.aztecCodeEcc = aztecCodeEcc;
    }

    public boolean isAztecEccModeEnabled() {
        return aztecEccModeEnabled;
    }

    public void setAztecEccModeEnabled(boolean aztecEccModeEnabled) {
        this.aztecEccModeEnabled = aztecEccModeEnabled;
    }

    public boolean isGridMatrixEccModeEnabled() {
        return gridMatrixEccModeEnabled;
    }

    public void setGridMatrixEccModeEnabled(boolean gridMatrixEccModeEnabled) {
        this.gridMatrixEccModeEnabled = gridMatrixEccModeEnabled;
    }

    public QrCode.EccMode getGridMatrixCodeEcc() {
        return gridMatrixCodeEcc;
    }

    public void setGridMatrixCodeEcc(QrCode.EccMode gridMatrixCodeEcc) {
        this.gridMatrixCodeEcc = gridMatrixCodeEcc;
    }
}
