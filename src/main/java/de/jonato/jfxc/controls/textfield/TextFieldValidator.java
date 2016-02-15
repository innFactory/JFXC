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


import java.math.BigInteger;

public enum TextFieldValidator {

    LONG(Long.class),
    INT(Integer.class),
    DOUBLE(Double.class),
    FLOAT(Float.class),
    STRING(String.class),
    BOOLEAN(Boolean.class),
    BIG_INT(BigInteger.class)
    ;

    private Class<?> clazz;

    TextFieldValidator(Class<?> clazz) {
        this.clazz = clazz;
    }

    public String validate(String value) throws IllegalAccessException, InstantiationException {


        if (clazz.equals(Long.class)) {
            value = Long.valueOf(value).toString();
        } else if (clazz.equals(Integer.class)) {
            value = Integer.valueOf(value).toString();
        } else if (clazz.equals(Float.class)) {
            value = Float.valueOf(value).toString();
        } else if (clazz.equals(Double.class)) {
            value = Double.valueOf(value).toString();
        } else if (clazz.equals(Boolean.class)) {
            value = Boolean.valueOf(value).toString();
        } else if (clazz.equals(BigInteger.class)) {
            value = new BigInteger(value).toString();
        }

        return value;
    }
}
