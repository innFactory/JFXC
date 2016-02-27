package de.jonato.jfxc.controls.table;

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

import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.Pair;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;

import java.util.ArrayList;

import static org.junit.Assert.assertTrue;

public class KeyValueTableViewTest extends ApplicationTest {

    private KeyValueTableView<String, String> keyValueTableView;
    private String[] values = {"Tobias", "Jonas", "UNIT", "Test", "IN", "FX"};
    private String[] keys = {"Tobias", "Jonas", "UNIT", "Test", "IN", "FX"};

    @Override
    public void start(Stage stage) throws Exception {
        keyValueTableView = new KeyValueTableView<>(null);

        Scene scene = new Scene(keyValueTableView, 300, 200);
        stage.setScene(scene);
        stage.show();
    }

    @Test
    public void testKeyValueTable() {
        ArrayList<Pair<String, String>> data = new ArrayList<>();
        data.add(new Pair<>(keys[0], values[0]));
        data.add(new Pair<>(keys[1], values[1]));
        data.add(new Pair<>(keys[2], values[2]));
        data.add(new Pair<>(keys[3], values[3]));
        data.add(new Pair<>(keys[4], values[4]));

        ArrayList<String> skippedKeys = new ArrayList<>();
        skippedKeys.add(keys[2]);
        skippedKeys.add(keys[3]);

        keyValueTableView = new KeyValueTableView<>(data, skippedKeys);
        System.out.println(keyValueTableView.getItems());
        assertTrue(keyValueTableView.getItems().size() == 3);
    }

    @Test
    public void testKeyValueTableNoSkip() {
        ArrayList<Pair<String, String>> data = new ArrayList<>();
        data.add(new Pair<>(keys[0], values[0]));
        data.add(new Pair<>(keys[1], values[1]));
        data.add(new Pair<>(keys[2], values[2]));
        data.add(new Pair<>(keys[3], values[3]));
        data.add(new Pair<>(keys[4], values[4]));

        keyValueTableView = new KeyValueTableView<>(data);
        System.out.println(keyValueTableView.getItems());
        assertTrue(keyValueTableView.getItems().size() == 5);
    }

    @Test
    public void testKeyValueTableObsFX() {
        ArrayList<Pair<String, String>> data = new ArrayList<>();
        data.add(new Pair<>(keys[0], values[0]));
        data.add(new Pair<>(keys[1], values[1]));
        data.add(new Pair<>(keys[2], values[2]));
        data.add(new Pair<>(keys[3], values[3]));
        data.add(new Pair<>(keys[4], values[4]));

        ArrayList<String> skippedKeys = new ArrayList<>();
        skippedKeys.add(keys[2]);
        skippedKeys.add(keys[3]);

        keyValueTableView = new KeyValueTableView<>(FXCollections.observableArrayList(data), FXCollections.observableArrayList(skippedKeys));
        System.out.println(keyValueTableView.getItems());
        assertTrue(keyValueTableView.getItems().size() == 3);
    }

    @Test
    public void testKeyValueTableObsFXwithWidthSettings() {
        ArrayList<Pair<String, String>> data = new ArrayList<>();
        data.add(new Pair<>(keys[0], values[0]));
        data.add(new Pair<>(keys[1], values[1]));
        data.add(new Pair<>(keys[2], values[2]));
        data.add(new Pair<>(keys[3], values[3]));
        data.add(new Pair<>(keys[4], values[4]));

        ArrayList<String> skippedKeys = new ArrayList<>();
        skippedKeys.add(keys[2]);
        skippedKeys.add(keys[3]);

        keyValueTableView = new KeyValueTableView<>(FXCollections.observableArrayList(data), FXCollections.observableArrayList(skippedKeys), 15.0, 20.0);
        System.out.println(keyValueTableView.getItems());
        assertTrue(keyValueTableView.getItems().size() == 3 && keyValueTableView.getValueMaxWidth() == 20.0 && keyValueTableView.getKeyMaxWidth() == 15.0);
    }

    @Test
    public void testKeyValueTableObsFXNoSkip() {
        ArrayList<Pair<String, String>> data = new ArrayList<>();
        data.add(new Pair<>(keys[0], values[0]));
        data.add(new Pair<>(keys[1], values[1]));
        data.add(new Pair<>(keys[2], values[2]));
        data.add(new Pair<>(keys[3], values[3]));
        data.add(new Pair<>(keys[4], values[4]));


        keyValueTableView = new KeyValueTableView<>(FXCollections.observableArrayList(data));
        System.out.println(keyValueTableView.getItems());
        assertTrue(keyValueTableView.getItems().size() == 5);
    }

}