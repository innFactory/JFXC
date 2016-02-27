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

/**
 * Factory for Java-typed TextFields.
 */
public class TypedTextFieldFactory {

    /**
     * Get a TextField for Long values.
     * @param value initial value
     * @return new instance
     */
    public static TypedTextField getLongTextField(String value){
        return new TypedTextField(value, TextFieldValidator.LONG);
    }

    /**
     * Get a TextField for Integer values.
     * @param value initial value
     * @return new instance
     */
    public static TypedTextField getIntTextField(String value){
        return new TypedTextField(value, TextFieldValidator.INT);
    }

    /**
     * Get a TextField for Float values.
     * @param value initial value
     * @return new instance
     */
    public static TypedTextField getFloatTextField(String value){
        return new TypedTextField(value, TextFieldValidator.FLOAT);
    }

    /**
     * Get a TextField for Double values.
     * @param value initial value
     * @return new instance
     */
    public static TypedTextField getDoubleTextField(String value){
        return new TypedTextField(value, TextFieldValidator.DOUBLE);
    }

    /**
     * Get a TextField for Big Integer values.
     * @param value initial value
     * @return new instance
     */
    public static TypedTextField getBigIntTextField(String value){
        return new TypedTextField(value, TextFieldValidator.BIG_INT);
    }
}
