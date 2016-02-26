package de.jonato.jfxc.samples;

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

import de.jonato.jfxc.controls.table.KeyValueTableView;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.Pair;

import java.util.ArrayList;


public class TableSampleApp extends Application {

    private KeyValueTableView<String, ArrayList<String>> keyValueTableView;

    @Override
    public void start(Stage primaryStage) throws Exception {
        keyValueTableView = new KeyValueTableView<>();

        ArrayList<String> vornamen = new ArrayList<>();
        vornamen.add("Hans");
        vornamen.add("Tobias");
        vornamen.add("Peter");

        ArrayList<String> nachnamen = new ArrayList<>();
        nachnamen.add("Lahm");
        nachnamen.add("Ribery");
        nachnamen.add("Robben");


        ArrayList<Pair<String, ArrayList<String>>> data = new ArrayList<>();
        data.add(new Pair<>("vornamen", vornamen));
        data.add(new Pair<>("nachnamen", nachnamen));
        data.add(new Pair<>("Ausblenden", new ArrayList<>()));
        data.add(new Pair<>("Ausblenden 2", new ArrayList<>()));

        keyValueTableView.setAllItems(FXCollections.observableArrayList(data));

        ArrayList<String> skippedKeys = new ArrayList<>();
        skippedKeys.add("Ausblenden");
        skippedKeys.add("Ausblenden 2");

        keyValueTableView.setSkippedKeys(FXCollections.observableArrayList(skippedKeys));

        Scene scene = new Scene(keyValueTableView, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
