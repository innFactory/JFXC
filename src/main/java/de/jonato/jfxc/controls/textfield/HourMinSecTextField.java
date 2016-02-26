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

import javafx.beans.binding.IntegerBinding;
import javafx.beans.property.ReadOnlyIntegerProperty;
import javafx.beans.property.ReadOnlyIntegerWrapper;
import javafx.beans.property.SimpleLongProperty;
import javafx.scene.control.IndexRange;
import javafx.scene.control.TextField;

import java.util.regex.Pattern;

/**
 * HH:mm
 */
public class HourMinSecTextField extends TimeTextField {

    enum Unit {HOURS, MINUTES, SECONDS}

    public HourMinSecTextField() {
        this("00:00:00");
    }

    public HourMinSecTextField(String time) {
        super(time);
        this.time = new SimpleLongProperty();
        timePattern = Pattern.compile("\\d\\d:\\d\\d:\\d\\d");
        if (!validate(time)) {
            throw new IllegalArgumentException("Invalid time: " + time);
        }

        hours = new ReadOnlyIntegerWrapper(this, "hours");
        minutes = new ReadOnlyIntegerWrapper(this, "minutes");
        hours.bind(new TimeUnitBinding(Unit.HOURS));
        minutes.bind(new TimeUnitBinding(Unit.MINUTES));
        seconds = new ReadOnlyIntegerWrapper(this, "seconds");
        seconds.bind(new TimeUnitBinding(Unit.SECONDS));

        this.time.bind(seconds.add(minutes.multiply(60).add(hours.multiply(60))));
    }

    public ReadOnlyIntegerProperty secondsProperty() {
        return seconds.getReadOnlyProperty();
    }

    public int getSeconds() {
        return seconds.get();
    }


    protected boolean validate(String time) {
        if (!timePattern.matcher(time).matches()) {
            return false;
        }
        String[] tokens = time.split(":");
        assert tokens.length == 3;
        try {
            int hours = Integer.parseInt(tokens[0]);
            int mins = Integer.parseInt(tokens[1]);
            int secs = Integer.parseInt(tokens[2]);
            if (hours < 0 || hours > 23) {
                return false;
            }
            if (mins < 0 || mins > 59) {
                return false;
            }
            return !(secs < 0 || secs > 59);
        } catch (NumberFormatException nfe) {
            // regex matching should assure we never reach this catch block
            assert false;
            return false;
        }
    }
}
