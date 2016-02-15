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
 * TextFields for time values.
 */
public class TimeTextFieldFactory
{
    /**
     * Get a TextField for hours and minutes.
     * @return new instance
     */
    public static HourMinTextField getHourMinuteTextFieldInstance(){
        return getHourMinuteTextFieldInstance("");
    }


    /**
     * Get a TextField instance for hours and minutes.
     * @param value inital value HH:mm
     * @return new instance
     */
    public static HourMinTextField getHourMinuteTextFieldInstance(String value){
        return new HourMinTextField(value);
    }

    /**
     * Get a TextField instance for hours, minutes and seconds.
     * @return new instance
     */
    public static HourMinSecTextField getHourMinuteSecondTextFieldInstance(){
        return getHourMinuteSecondTextFieldInstance("");
    }

    /**
     * Get a TextField instance for hours, minutes and seconds.
     * @param value initial value HH:mm:ss
     * @return new instance
     */
    public static HourMinSecTextField getHourMinuteSecondTextFieldInstance(String value){
        return new HourMinSecTextField(value);
    }
}