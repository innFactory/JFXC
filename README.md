# JFXC
[![travis-ci.org](https://travis-ci.org/Jonato/JFXC.svg?branch=master)](https://travis-ci.org/Jonato/JFXC")
[![codecov.io](https://codecov.io/github/Jonato/JFXC/coverage.svg?branch=master)](https://codecov.io/github/Jonato/JFXC?branch=master)
[![shields.io](http://img.shields.io/badge/license-Apache2-blue.svg)](http://www.apache.org/licenses/LICENSE-2.0.txt)
[![jonato.de](https://img.shields.io/badge/Version-1.1-brightgreen.svg)](https://jonato.de)

Jonato JavaFX Controls - More Power for your JavaFX Gui

With Jonato JavaFX Controls you can extend your GUI with some new fresh controls. 

## Parts
1. Keyboard
2. Controls
3. Informations

### Keyboard(FX)
```
Keyboard event Framework for all JavaFX KeyUp and Down Events.
Has a registry class for saving your instance.
```

### Controls

```
>KeyValueTable
Display KeyValue data in a Table Control. You can hide keys from your items list with the skip list.

>Custom Combobox
FilterComboBox: Jump to your entry by entering the first letter.
AutoCompleteComboBox: Search your ComboBox by the given Text.

>BarcodeView
Generate and display a barcode and save it to a file (svg, eps, png, jpg, gif, bmp). It is bassed on woo-j/OkapiBarcode lib.


>Spacer
Add spaces between two javafx nodes in hbox and vbox

>TextFields
TimeTextField: Add a TextField for time (HH:mm) or (HH:mm:ss)
TypedTextField: TextFields for basic datatypes with validation (Long, Int, Double...)
```

### Informations
```
Get quickly infos about the operating system, the current system and the current user
```


##Maven
```
<dependency>
  <groupId>de.jonato</groupId>
  <artifactId>jfxc</artifactId>
  <version>1.1</version>
</dependency>
```

##Requirements
- Java >= 1.8
- JavaFX8

##Changelog

### 1.1
- First release on maven
- JavaFX BarcodeWrapper classes for Okapi Barcode
- BarcodeView

### 1.0.2
- Add Unit Tests
- Add Info Classes
- Add AutoCompleteCombobox
- Add Spacer Control
- Fix Validation

### 1.0.1
- Add with KeyboardFX
- Add KeyValueTable
- Add TimeTextField
- Add NumberTextField
- Add FilterComboBox

### 0.0.1
- Inital Commit



##Credits
![Jonato IT Solutions][logo]

Tobias Jonas <info@jonato.de>
(c) [Jonato IT Solutions](https://jonato.de "Jonato IT Solutions - Software Engineering")


[logo]: https://jonato.de/sites/all/themes/jonatoDE/logo.png "Jonato IT Solutions logo"

