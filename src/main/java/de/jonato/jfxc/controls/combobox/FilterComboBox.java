package de.jonato.jfxc.controls.combobox;

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

import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

/**
 * Use it like a normal ComboBox.
 * Remember that onKeyReleased is used by the class constructor to find the key.
 * @see ComboBox
 */
public class FilterComboBox<T> extends ComboBox<T> {

    private KeyCode lastKey = null;
    private int lastKeyPosition = 0;
    private int i = 0;
    private T first = null;
    private T last = null;
    private boolean reset = false;


    public FilterComboBox(ObservableList<T> items) {
        super(items);
        setOnKeyReleased(e -> findKey(e));
    }


    public FilterComboBox() {
        super();
        setOnKeyReleased(e -> findKey(e));
    }

    protected void findKey(KeyEvent e) {
        if (!e.getCode().isArrowKey()) {
            if (!e.getCode().equals(lastKey)) {
                lastKeyPosition = 0;
            }
            i = 1;
            first = null;
            reset = false;
            for (T s : getItems()) {
                if (s.toString().startsWith(e.getText().toLowerCase()) || s.toString().startsWith(e.getText().toUpperCase())) {
                    if (first == null) {
                        first = s;
                    }
                    getSelectionModel().select(s);
                    if (s.equals(last)) {
                        reset = true;
                    } else {
                        reset = false;
                    }

                    if (i >= lastKeyPosition) {
                        if (reset) {
                            last = first;
                            lastKeyPosition = 0;
                            getSelectionModel().select(first);
                        } else {
                            last = s;
                            lastKeyPosition = i;
                            break;
                        }
                    }
                }
                i++;
            }
            lastKey = e.getCode();
        }
    }
}
