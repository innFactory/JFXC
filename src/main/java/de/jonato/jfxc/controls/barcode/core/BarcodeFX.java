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

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;
import uk.org.okapibarcode.Settings;
import uk.org.okapibarcode.backend.*;
import uk.org.okapibarcode.output.Java2DRenderer;
import uk.org.okapibarcode.output.PostScriptRenderer;
import uk.org.okapibarcode.output.SvgRenderer;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class BarcodeFX {

    /**
     * Current BarcodeFX type.
     */
    private BarcodeEncoding type;

    /**
     * @see Symbol
     */
    private Symbol barcode;

    private String content;
    private Integer zoom;
    private Integer border;
    private Color foreground;
    private Color background;
    private BarcodeSettings barcodeSettings;


    public BarcodeFX(BarcodeEncoding type, String content) {
        this(type, content, Color.web("#ffffff"), Color.web("#000000"), 4, 20, BarcodeFactory.getDefaultSettings());
    }

    public BarcodeFX(BarcodeEncoding type, String content, Color background, Color foreground) {
        this(type, content, background, foreground, 4, 20, BarcodeFactory.getDefaultSettings());
    }

    /**
     * Create a new barcode from okapiBarcode with this JavaFX Wrapper Class.
     *
     * @param type            Barcode type e.g QR_CODE, EAN13
     * @param content         Data for the barcode
     * @param background      background color - most time ignored
     * @param foreground      barcode color
     * @param zoom            Zoomlevel
     * @param border          Border of image
     * @param barcodeSettings other Barcode Settings
     */
    public BarcodeFX(BarcodeEncoding type, String content, Color background, Color foreground, int zoom, int border, BarcodeSettings barcodeSettings) {
        this.type = type;
        this.setBarcodeSettings(barcodeSettings);
        this.setContent(content);
        this.setBackground(background);
        this.setForeground(foreground);
        this.setZoom(zoom);
        this.setBorder(border);
    }

    /**
     * Get an Image Instance for Use in JavaFX.
     *
     * @return javafx image
     */
    public WritableImage getImage() {
        Settings s = new Settings();

        java.awt.Color paper = fxToAWTColor(background);
        java.awt.Color ink = fxToAWTColor(foreground);

        BufferedImage image = new BufferedImage((barcode.getWidth() * zoom) + (2 * border),
                (barcode.getHeight() * zoom) + (2 * border), BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = image.createGraphics();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.fillRect(0, 0, (barcode.getWidth() * zoom) + (2 * border),
                (barcode.getHeight() * zoom) + (2 * border));

        Java2DRenderer renderer = new Java2DRenderer(g2d, zoom, border, paper, ink);
        renderer.render(barcode);

        return SwingFXUtils.toFXImage(image, null);
    }

    /**
     * save as svg image.
     *
     * @param file path and filenam
     * @throws IOException save fails
     */
    public void saveAsSVG(String file) throws IOException {
        java.awt.Color paper = fxToAWTColor(background);
        java.awt.Color ink = fxToAWTColor(foreground);
        SvgRenderer svg = new SvgRenderer(new FileOutputStream(file), zoom, border, paper, ink);
        svg.render(barcode);
    }

    /**
     * save as PostScript (eps)
     *
     * @param file path and filename
     * @throws IOException save fails
     */
    public void saveAsEPS(String file) throws IOException {
        java.awt.Color paper = fxToAWTColor(background);
        java.awt.Color ink = fxToAWTColor(foreground);
        PostScriptRenderer eps = new PostScriptRenderer(new FileOutputStream(file), zoom, border, paper, ink);
        eps.render(barcode);
    }

    /**
     * save as png.
     *
     * @param file path and filename
     * @throws IOException save fails
     */
    public void saveAsPNG(String file) throws IOException {
        save(file, "png");
    }

    /**
     * save as jpg.
     *
     * @param file path and filename
     * @throws IOException save fails
     */
    public void saveAsJPG(String file) throws IOException {
        save(file, "jpg");
    }

    /**
     * save as bmp.
     *
     * @param file path and filename
     * @throws IOException save fails
     */
    public void saveAsBMP(String file) throws IOException {
        save(file, "bmp");
    }

    /**
     * Save as gif.
     *
     * @param file path and filename
     * @throws IOException save fails
     */
    public void saveAsGIF(String file) throws IOException {
        save(file, "gif");
    }

    /**
     * Save a file temporary.
     *
     * @param tempName  name for temp file.
     * @param extension extension for tempfile png|gif|jpg|bmp
     * @return temp file instance
     * @throws IOException save fails
     */
    public File saveTemp(String tempName, String extension) throws IOException {
        File file = File.createTempFile(tempName, "." + extension);
        save(file, extension);
        return file;
    }

    /**
     * Save the barcode to a file.
     *
     * @param file      Path and filename
     * @param extension file extension for rendering png|gif|jpg|bmp
     * @throws IOException save fails
     */
    private void save(String file, String extension) throws IOException {
        save(new File(file), extension);
    }

    /**
     * Save the barcode to a file.
     *
     * @param file      file instance
     * @param extension file extension for rendering png|gif|jpg|bmp
     * @throws IOException save fails
     */
    private void save(File file, String extension) throws IOException {
        java.awt.Color paper = fxToAWTColor(background);
        java.awt.Color ink = fxToAWTColor(foreground);

        BufferedImage image = new BufferedImage((barcode.getWidth() * zoom) + (2 * border),
                (barcode.getHeight() * zoom) + (2 * border), BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = image.createGraphics();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setColor(paper);
        g2d.fillRect(0, 0, (barcode.getWidth() * zoom) + (2 * border),
                (barcode.getHeight() * zoom) + (2 * border));

        Java2DRenderer renderer = new Java2DRenderer(g2d, zoom, border, paper, ink);
        renderer.render(barcode);

        ImageIO.write(image, extension, file);
    }


    /**
     * @return Barcode Instance from Okapi Barcode.
     * @see Symbol
     */
    public Symbol getBarcode() {
        return barcode;
    }

    /**
     * Set you own symbol - BE CAREFUL WITH THAT!
     *
     * @param barcode symbol
     */
    public void setBarcode(Symbol barcode) {
        this.barcode = barcode;
    }

    /**
     * Get the content.
     *
     * @return barcode content as string.
     */
    public String getContent() {
        return content;
    }

    /**
     * Set the barcode content.
     *
     * @param content Content as string.
     */
    public void setContent(String content) {
        this.content = content;
        barcode.setContent(content);
    }

    /**
     * Get Zoom for image.
     *
     * @return image zoom
     */
    public Integer getZoom() {
        return zoom;
    }

    /**
     * Set zoom for image.
     *
     * @param zoom image zoom
     */
    public void setZoom(Integer zoom) {
        this.zoom = zoom;
    }

    /**
     * Get image border size.
     *
     * @return border size
     */
    public Integer getBorder() {
        return border;
    }

    /**
     * Set border size.
     *
     * @param border border size.
     */
    public void setBorder(Integer border) {
        this.border = border;
    }

    /**
     * Get foreground color.
     *
     * @return foreground
     */
    public Color getForeground() {
        return foreground;
    }

    /**
     * Set background color.
     *
     * @param foreground color
     */
    public void setForeground(Color foreground) {
        this.foreground = foreground;
    }

    /**
     * Get background color.
     *
     * @return background color
     */
    public Color getBackground() {
        return background;
    }

    /**
     * Set background color.
     *
     * @param background color
     */
    public void setBackground(Color background) {
        this.background = background;
    }

    /**
     * Get current barcode settings.
     *
     * @return settings
     */
    public BarcodeSettings getBarcodeSettings() {
        return barcodeSettings;
    }

    /**
     * Set current barcode settings.
     *
     * @param barcodeSettings settings
     */
    public void setBarcodeSettings(BarcodeSettings barcodeSettings) {
        this.barcodeSettings = barcodeSettings;
        initType();
    }

    /**
     * Get a AWT Color from JavaFX Color.
     *
     * @param color JavaFX color
     * @return AWT color
     */
    private java.awt.Color fxToAWTColor(Color color) {
        int r = ((int) color.getRed() * 255);
        int g = ((int) color.getGreen() * 255);
        int b = ((int) color.getBlue() * 255);
        int rgb = (r << 16) + (g << 8) + b;
        return new java.awt.Color(rgb);
    }

    /**
     * INIT BARCODE FROM TYPE
     */
    private void initType() {
        switch (type) {
            case CHANNEL_CODE:
                ChannelCode channelCode = new ChannelCode();
                channelCode.setNumberOfChannels(barcodeSettings.getChannelCodeChannels());
                barcode = channelCode;
                break;
            case CODABAR:
                Codabar codabar = new Codabar();
                barcode = codabar;
                break;
            case CODE_11:
                Code11 code11 = new Code11();
                barcode = code11;
                break;
            case CODE_2OF5_DEFAULT:
                Code2Of5 c25 = new Code2Of5();
                barcode = c25;
                break;
            case CODE_2OF5_IATA:
                Code2Of5 c25iata = new Code2Of5();
                c25iata.setIATAMode();
                barcode = c25iata;
                break;
            case CODE_2OF5_INDUSTRIAL:
                Code2Of5 c25ind = new Code2Of5();
                c25ind.setIndustrialMode();
                barcode = c25ind;
                break;
            case CODE_2OF5_INTERLEAVED:
                Code2Of5 c25inter = new Code2Of5();
                c25inter.setInterleavedMode();
                barcode = c25inter;
                break;
            case CODE_2OF5_DATA_LOGIC:
                Code2Of5 c25logic = new Code2Of5();
                c25logic.setDataLogicMode();
                barcode = c25logic;
                break;
            case CODE_2OF5_ITF_14:
                Code2Of5 itf14 = new Code2Of5();
                itf14.setITF14Mode();
                barcode = itf14;
                break;
            case CODE_CODE39_DEFAULT:
                Code3Of9 code3of9 = new Code3Of9();
                switch (barcodeSettings.getCode39CheckDigit().ordinal()) {
                    case 0:
                        code3of9.setCheckDigit(Code3Of9.CheckDigit.NONE);
                        break;
                    case 1:
                        code3of9.setCheckDigit(Code3Of9.CheckDigit.MOD43);
                        break;
                }
                barcode = code3of9;
                break;
            case CODE_CODE39_EXTENDED:
                Code3Of9Extended code3of9ext = new Code3Of9Extended();
                switch (barcodeSettings.getCode39CheckDigit().ordinal()) {
                    case 0:
                        code3of9ext.setCheckDigit(Code3Of9Extended.CheckDigit.NONE);
                        break;
                    case 1:
                        code3of9ext.setCheckDigit(Code3Of9Extended.CheckDigit.MOD43);
                        break;
                }
                barcode = code3of9ext;
                break;
            case CODE_93:
                Code93 code93 = new Code93();
                barcode = code93;
                break;
            case CODE_CODE39_LOGMARS:
                Logmars logmars = new Logmars();
                barcode = logmars;
                break;
            case CODE_CODE128:
                Code128 code128 = new Code128();
                code128.unsetCc();
                barcode = code128;
                break;
            case CODE_CODE128_NVE18:
                Nve18 nve18 = new Nve18();
                barcode = nve18;
                break;
            case EAN8:
                Ean ean8 = new Ean();
                ean8.setMode(Ean.Mode.EAN8);
                barcode = ean8;
                break;
            case EAN13:
                Ean ean13 = new Ean();
                ean13.setMode(Ean.Mode.EAN13);
                barcode = ean13;
                break;
            case MSI_PLESSEY:
                MsiPlessey msiPlessey = new MsiPlessey();
                switch (barcodeSettings.getMsiPlesseyCheckDigit().ordinal()) {
                    case 0:
                        msiPlessey.setCheckDigit(MsiPlessey.CheckDigit.NONE);
                        break;
                    case 1:
                        msiPlessey.setCheckDigit(MsiPlessey.CheckDigit.MOD10);
                        break;
                    case 2:
                        msiPlessey.setCheckDigit(MsiPlessey.CheckDigit.MOD10_MOD10);
                        break;
                    case 3:
                        msiPlessey.setCheckDigit(MsiPlessey.CheckDigit.MOD11);
                        break;
                    case 4:
                        msiPlessey.setCheckDigit(MsiPlessey.CheckDigit.MOD11_MOD10);
                        break;
                }
                barcode = msiPlessey;
                break;
            case TELEPEN_ALPHA:
                Telepen telepen = new Telepen();
                telepen.setNormalMode();
                barcode = telepen;
                break;
            case TELEPEN_NUMERIC:
                Telepen telepenNum = new Telepen();
                telepenNum.setNumericMode();
                barcode = telepenNum;
                break;
            case UPC_A:
                Upc upca = new Upc();
                upca.setMode(Upc.Mode.UPCA);
                upca.unsetLinkageFlag();
                barcode = upca;
                break;
            case UPC_E:
                Upc upce = new Upc();
                upce.setMode(Upc.Mode.UPCE);
                upce.unsetLinkageFlag();
                barcode = upce;
                break;
            case STACKED_CODABLOCK_F:
                CodablockF codablockF = new CodablockF();
                barcode = codablockF;
                break;
            case STACKED_CODE_16K:
                Code16k code16k = new Code16k();
                barcode = code16k;
                break;
            case STACKED_CODE_49:
                Code49 code49 = new Code49();
                barcode = code49;
                break;
            case AZTEC_CODE:
                AztecCode aztecCode = new AztecCode();
                if (barcodeSettings.isAztecEccModeEnabled()) {
                    aztecCode.setPreferredEccLevel(barcodeSettings.getAztecCodeEcc().ordinal() + 1);
                }
                barcode = aztecCode;
                break;
            case AZTEC_RUNES:
                AztecRune aztecRune = new AztecRune();
                barcode = aztecRune;
                break;
            case DATA_MATRIX:
                DataMatrix dataMatrix = new DataMatrix();
                dataMatrix.setDataType(Symbol.DataType.HIBC);
                dataMatrix.setPreferredSize(barcodeSettings.getDataMatrixSymbolSize());
                dataMatrix.forceSquare(barcodeSettings.isDataMatrixSupressRectSymbolsinAutoMode());
                barcode = dataMatrix;
                break;
            case CODE_ONE:
                CodeOne codeOne = new CodeOne();
                switch (barcodeSettings.getCodeOneVersion().ordinal()) {
                    case 0:
                        codeOne.setPreferredVersion(CodeOne.Version.NONE);
                        break;
                    case 1:
                        codeOne.setPreferredVersion(CodeOne.Version.A);
                        break;
                    case 2:
                        codeOne.setPreferredVersion(CodeOne.Version.B);
                        break;
                    case 3:
                        codeOne.setPreferredVersion(CodeOne.Version.C);
                        break;
                    case 4:
                        codeOne.setPreferredVersion(CodeOne.Version.D);
                        break;
                    case 5:
                        codeOne.setPreferredVersion(CodeOne.Version.E);
                        break;
                    case 6:
                        codeOne.setPreferredVersion(CodeOne.Version.F);
                        break;
                    case 7:
                        codeOne.setPreferredVersion(CodeOne.Version.G);
                        break;
                    case 8:
                        codeOne.setPreferredVersion(CodeOne.Version.H);
                        break;
                    case 9:
                        codeOne.setPreferredVersion(CodeOne.Version.S);
                        break;
                    case 10:
                        codeOne.setPreferredVersion(CodeOne.Version.T);
                        break;
                }
                barcode = codeOne;
            case GRID_MATRIX:
                GridMatrix gridMatrix = new GridMatrix();
                if (barcodeSettings.isGridMatrixEccModeEnabled()) {
                    gridMatrix.setPreferredEccLevel(barcodeSettings.getGridMatrixCodeEcc().ordinal());
                }
                barcode = gridMatrix;
                break;
            case MAXI_CODE:
                MaxiCode maxiCode = new MaxiCode();
                barcode = maxiCode;
                break;
            case QR_CODE:
                QrCode qrCode = new QrCode();
                if (barcodeSettings.isQrEccModeEnabled()) {
                    switch (barcodeSettings.getQrEccMode().ordinal()) {
                        case 0:
                            qrCode.setEccMode(QrCode.EccMode.L);
                            break;
                        case 1:
                            qrCode.setEccMode(QrCode.EccMode.M);
                            break;
                        case 2:
                            qrCode.setEccMode(QrCode.EccMode.Q);
                            break;
                        case 3:
                            qrCode.setEccMode(QrCode.EccMode.H);
                            break;
                    }
                }
                barcode = qrCode;
                break;
            case QR_CODE_MICRO:
                MicroQrCode microQrCode = new MicroQrCode();
                if (barcodeSettings.isQrEccModeEnabled()) {
                    switch (barcodeSettings.getQrEccMode().ordinal()) {
                        case 0:
                            microQrCode.setEccMode(MicroQrCode.EccMode.L);
                            break;
                        case 1:
                            microQrCode.setEccMode(MicroQrCode.EccMode.M);
                            break;
                        case 2:
                            microQrCode.setEccMode(MicroQrCode.EccMode.Q);
                            break;
                        case 3:
                            microQrCode.setEccMode(MicroQrCode.EccMode.H);
                            break;
                    }
                }
                barcode = microQrCode;
                break;
            case GS1_DATABAR_OMNIDIRECTIONAL:
                DataBar14 dataBar14 = new DataBar14();
                dataBar14.setLinearMode();
                barcode = dataBar14;
                break;
            case GS1_DATABAR_STACKED:
                DataBar14 dataBar14s = new DataBar14();
                dataBar14s.setStackedMode();
                barcode = dataBar14s;
                break;
            case GS1_DATABAR_STACKED_OMNIDIRECTIONAL:
                DataBar14 dataBar14so = new DataBar14();
                dataBar14so.setOmnidirectionalMode();
                barcode = dataBar14so;
                break;
            case GS1_DATABAR_LIMITED:
                DataBarLimited dataBarLimited = new DataBarLimited();
                barcode = dataBarLimited;
                break;
            case GS1_DATABAR_EXPANDED_OMNIDIRECTIONAL:
                DataBarExpanded dataBarE = new DataBarExpanded();
                dataBarE.setNotStacked();
                barcode = dataBarE;
                break;
            case GS1_DATABAR_EXPANDED_STACKED_OMNIDIRECTIONAL:
                DataBarExpanded dataBarES = new DataBarExpanded();
                dataBarES.setNoOfColumns(barcodeSettings.getDatabarColumns());
                dataBarES.setStacked();
                barcode = dataBarES;
                break;
            case POSTAL_AUSPOST:
                AustraliaPost auPost = new AustraliaPost();
                auPost.setPostMode();
                barcode = auPost;
            case POSTAL_AUSPOST_REPLY:
                AustraliaPost auReply = new AustraliaPost();
                auReply.setReplyMode();
                barcode = auReply;
            case POSTAL_DEUTSCHE_POST_LEITCODE:
                Code2Of5 dpLeit = new Code2Of5();
                dpLeit.setDPLeitMode();
                barcode = dpLeit;
                break;
            case POSTAL_DEUTSCHE_POST_IDENTCODE:
                Code2Of5 dpIdent = new Code2Of5();
                dpIdent.setDPIdentMode();
                barcode = dpIdent;
                break;
            case POSTAL_JAPAN_POST:
                JapanPost japanPost = new JapanPost();
                barcode = japanPost;
                break;
            case POSTAL_ROYAL_MAIL:
                RoyalMail4State royalMail = new RoyalMail4State();
                barcode = royalMail;
                break;
            case POSTAL_USPS_INTELLIGENT_MAIL:
                UspsOneCode uspsOneCode = new UspsOneCode();
                barcode = uspsOneCode;
                break;
            case POSTAL_USPS_IM_PACKAGE_BC:
                UspsPackage uspsPackage = new UspsPackage();
                barcode = uspsPackage;
                break;
            case POSTAL_BRAZIL_CEPNET:
            case POSTAL_USPS_POSTNET:
                Postnet postnet = new Postnet();
                postnet.setPostnet();
                barcode = postnet;
                break;
            case POSTAL_USPS_PLANET:
                Postnet planet = new Postnet();
                planet.setPlanet();
                barcode = planet;
                break;
            case MEDICAL_CODE32:
                Code32 code32 = new Code32();
                barcode = code32;
                break;
            case MEDICAL_HIBC_AZTEC:
                AztecCode aztecCodemed = new AztecCode();
                aztecCodemed.setDataType(Symbol.DataType.HIBC);
                if (barcodeSettings.isAztecEccModeEnabled()) {
                    aztecCodemed.setPreferredEccLevel(barcodeSettings.getAztecCodeEcc().ordinal() + 1);
                }
                barcode = aztecCodemed;
                break;
            case MEDICAL_HIBC_CODABLOCK_F:
                CodablockF codablockFmed = new CodablockF();
                codablockFmed.setDataType(Symbol.DataType.HIBC);
                barcode = codablockFmed;
                break;
            case MEDICAL_HIBC_CODE39:
                Code3Of9 code3of9med = new Code3Of9();
                code3of9med.setDataType(Symbol.DataType.HIBC);

                switch (barcodeSettings.getCode39CheckDigit().ordinal()) {
                    case 0:
                        code3of9med.setCheckDigit(Code3Of9.CheckDigit.NONE);
                        break;
                    case 1:
                        code3of9med.setCheckDigit(Code3Of9.CheckDigit.MOD43);
                        break;
                }
                barcode = code3of9med;
                break;
            case MEDICAL_HIBC_CODE128:
                Code128 hibcCode128 = new Code128();
                hibcCode128.unsetCc();
                hibcCode128.setDataType(Symbol.DataType.HIBC);
                barcode = hibcCode128;
                break;
            case MEDICAL_DATA_MATRIX:
                DataMatrix dataMatrixmed = new DataMatrix();
                dataMatrixmed.setDataType(Symbol.DataType.HIBC);
                dataMatrixmed.setPreferredSize(barcodeSettings.getDataMatrixSymbolSize());
                dataMatrixmed.forceSquare(barcodeSettings.isDataMatrixSupressRectSymbolsinAutoMode());
                barcode = dataMatrixmed;
                break;
            case MEDICAL_QR_CODE:
                QrCode qrCodeHibc = new QrCode();
                qrCodeHibc.setDataType(Symbol.DataType.HIBC);

                if (barcodeSettings.isQrEccModeEnabled()) {
                    switch (barcodeSettings.getQrEccMode().ordinal()) {
                        case 0:
                            qrCodeHibc.setEccMode(QrCode.EccMode.L);
                            break;
                        case 1:
                            qrCodeHibc.setEccMode(QrCode.EccMode.M);
                            break;
                        case 2:
                            qrCodeHibc.setEccMode(QrCode.EccMode.Q);
                            break;
                        case 3:
                            qrCodeHibc.setEccMode(QrCode.EccMode.H);
                            break;
                    }
                }
                barcode = qrCodeHibc;
                break;
            case MEDICAL_PHARMACODE_ONE_TRACK:
                Pharmacode pharmacode = new Pharmacode();
                barcode = pharmacode;
                break;
            case MEDICAL_PHARMACODE_TWO_TRACK:
                Pharmacode2Track pharmacode2t = new Pharmacode2Track();
                barcode = pharmacode2t;
                break;
            case MEDICAL_PZN8:
                Pharmazentralnummer pzn = new Pharmazentralnummer();
                barcode = pzn;
                break;
        }
        if (barcode == null) {
            return;
        }
        barcode.setHumanReadableLocation(barcodeSettings.getHumanReadableLocation());
    }

}
