package de.jonato.jfxc.controls.textfield;

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


import javafx.geometry.Pos;
import javafx.scene.control.TextField;

public class TypedTextField extends TextField {

    private String numericLastKey;


    protected TextFieldValidator validator;


    public TypedTextField() {
        this("", TextFieldValidator.STRING);
    }

    public TypedTextField(String value) {
        this(value, TextFieldValidator.STRING);
    }

    public TypedTextField(String value, TextFieldValidator textFieldValidator) {
        super();
        this.validator = textFieldValidator;
        this.setAlignment(Pos.BASELINE_RIGHT);

        textProperty().addListener((observable, oldValue, newValue) -> {
            String validatedValue = "";
            if (!newValue.equals(validatedValue)) {
                try {
                    validatedValue = validator.validate(newValue);
                } catch (Exception e) {
                    validatedValue = oldValue;
                } finally {
                    setText(validatedValue);
                }
            }
        });
    }


    public TextFieldValidator getValidator() {
        return validator;
    }

    public void setValidator(TextFieldValidator validator) {
        this.validator = validator;
    }
}