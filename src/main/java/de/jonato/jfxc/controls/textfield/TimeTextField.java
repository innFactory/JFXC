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
 * Creates a timeformat textfield
 */
public abstract class TimeTextField extends TextField {

    protected Pattern timePattern;
    protected ReadOnlyIntegerWrapper hours;
    protected ReadOnlyIntegerWrapper minutes;
    protected ReadOnlyIntegerWrapper seconds;
    protected SimpleLongProperty time;

    public TimeTextField(String time) {
        super(time);
    }

    @Override
    public void appendText(String text) {    }

    @Override
    public boolean deleteNextChar() {
        boolean success = false;

        // If there's a selection, delete it:
        final IndexRange selection = getSelection();
        if (selection.getLength() > 0) {
            int selectionEnd = selection.getEnd();
            this.deleteText(selection);
            this.positionCaret(selectionEnd);
            success = true;
        } else {
            // If the caret preceeds a digit, replace that digit with a zero and move the caret forward. Else just move the caret forward.
            int caret = this.getCaretPosition();
            if (caret % 3 != 2) { // not preceeding a colon
                String currentText = this.getText();
                setText(currentText.substring(0, caret) + "0" + currentText.substring(caret + 1));
                success = true;
            }
            this.positionCaret(Math.min(caret + 1, this.getText().length()));

        }
        return success;
    }

    @Override
    public boolean deletePreviousChar() {
        boolean success = false;
        // If there's a selection, delete it:
        final IndexRange selection = getSelection();
        if (selection.getLength() > 0) {
            int selectionStart = selection.getStart();
            this.deleteText(selection);
            this.positionCaret(selectionStart);
            success = true;
        } else {
            // If the caret is after a digit, replace that digit with a zero and move the caret backward. Else just move the caret back.
            int caret = this.getCaretPosition();
            if (caret % 3 != 0) { // not following a colon
                String currentText = this.getText();
                setText(currentText.substring(0, caret - 1) + "0" + currentText.substring(caret));
                success = true;
            }
            this.positionCaret(Math.max(caret - 1, 0));

        }
        return success;
    }

    @Override
    public void deleteText(IndexRange range) {
        this.deleteText(range.getStart(), range.getEnd());
    }

    @Override
    public void deleteText(int begin, int end) {
        StringBuilder builder = new StringBuilder(this.getText());
        for (int c = begin; c < end; c++) {
            if (c % 3 != 2) { // Not at a colon:
                builder.replace(c, c + 1, "0");
            }
        }
        this.setText(builder.toString());
    }

    @Override
    public void insertText(int index, String text) {
        StringBuilder builder = new StringBuilder(this.getText());
        builder.replace(index, index + text.length(), text);
        final String testText = builder.toString();
        if (validate(testText)) {
            this.setText(testText);
        }
        if (index != 0 && index % 3 == 1) {
            index++;
        }
        this.positionCaret(index + text.length());
    }

    @Override
    public void replaceSelection(String replacement) {
        final IndexRange selection = this.getSelection();
        if (selection.getLength() == 0) {
            this.insertText(selection.getStart(), replacement);
        } else {
            this.replaceText(selection.getStart(), selection.getEnd(), replacement);
        }
    }

    @Override
    public void replaceText(IndexRange range, String text) {
        this.replaceText(range.getStart(), range.getEnd(), text);
    }

    @Override
    public void replaceText(int begin, int end, String text) {
        if (begin == end) {
            this.insertText(begin, text);
        } else {
            // only handle this if text.length() is equal to the number of characters being replaced, and if the replacement results in a valid string:
            if (text.length() == end - begin) {
                StringBuilder builder = new StringBuilder(this.getText());
                builder.replace(begin, end, text);
                String testText = builder.toString();
                if (validate(testText)) {
                    this.setText(testText);
                }
                this.positionCaret(end);
            }
        }
    }


    /**
     * Validate the current string as a time string. e.g HH:mm:ss
     * @param time
     * @return
     */
    protected abstract boolean validate(String time);

    protected final class TimeUnitBinding<E extends Enum<E>> extends IntegerBinding {

        E unit;

        TimeUnitBinding(E unit) {
            this.bind(textProperty());
            this.unit = unit;
        }

        @Override
        protected int computeValue() {
            String token = getText().split(":")[unit.ordinal()];
            return Integer.parseInt(token);
        }

    }

    public SimpleLongProperty timeProperty() {
        return time;
    }


}
