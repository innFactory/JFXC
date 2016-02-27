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
import java.util.regex.Pattern;

/**
 * Validator for TextFields
 */
public enum TextFieldValidator {

    LONG(Long.class),
    INT(Integer.class),
    DOUBLE(Double.class),
    FLOAT(Float.class),
    STRING(String.class),
    BIG_INT(BigInteger.class),;

    private Class<?> clazz;

    TextFieldValidator(Class<?> clazz) {
        this.clazz = clazz;
    }

    private int countChar(String input, char Chat) {
        int i = 0;
        for (char c : input.toCharArray()) {
            if (c == Chat)
                i++;
        }
        return i;
    }

    /**
     * Validate a String with valueOf or a pattern.
     *
     * @param value given value to validate
     * @return return the new value
     * @throws Exception Invalid if an Exception is thrown.
     */
    public String validate(String value) throws Exception {


        if (clazz.equals(Long.class)) {
            value = Long.valueOf(value).toString();
        } else if (clazz.equals(Integer.class)) {
            value = Integer.valueOf(value).toString();
        } else if (clazz.equals(Float.class)) {
            Pattern p = Pattern.compile("[0-9]*\\.?[0-9]+");
            if (!p.matcher(value).matches() && !value.endsWith(".") || countChar(value, '.') > 1) {
                throw new Exception("not a number");
            }
        } else if (clazz.equals(Double.class)) {
            Pattern p = Pattern.compile("[0-9]*\\.?[0-9]+");
            if (!p.matcher(value).matches() && !value.endsWith(".") || countChar(value, '.') > 1) {
                throw new Exception("not a number");
            }
        } else if (clazz.equals(BigInteger.class)) {
            value = new BigInteger(value).toString();
        }

        return value;
    }

    /**
     * Validate a String with valueOf. Invalid if an Exception is thrown.
     *
     * @param value given value to validate
     * @return return the new value
     * @throws Exception Invalid if an Exception is thrown.
     */
    public String validateHard(String value) throws Exception {
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

    public String defaultValue() {
        String value = "";

        if (clazz.equals(Long.class)) {
            value = "0";
        } else if (clazz.equals(Integer.class)) {
            value = "0";
        } else if (clazz.equals(Float.class)) {
            value = "0.0";
        } else if (clazz.equals(Double.class)) {
            value = "0.0";
        } else if (clazz.equals(BigInteger.class)) {
            value = "0";
        }

        return value;
    }
}
