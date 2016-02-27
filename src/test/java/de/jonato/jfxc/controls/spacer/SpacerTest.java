package de.jonato.jfxc.controls.spacer;

import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;

import static org.junit.Assert.assertTrue;

public class SpacerTest extends ApplicationTest {


    private TextField textfield;
    private Scene scene;
    private Stage stage;
    VBox vBox;

    @Override
    public void start(Stage stage) throws Exception {
        vBox = new VBox();
        scene = new Scene(vBox, 300, 300);
        stage.setScene(scene);
        this.stage = stage;
        this.stage.show();
    }

    @Test
    public void testCreateSpacer() {
        HGrowSpace hGrowSpace = new HGrowSpace();
        HFixedSpace hFixedSpace = new HFixedSpace(15);
        VGrowSpace vGrowSpace = new VGrowSpace();

        assertTrue(true);
    }


}