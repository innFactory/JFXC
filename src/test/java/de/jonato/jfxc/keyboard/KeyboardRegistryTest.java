package de.jonato.jfxc.keyboard;

import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;

import static org.junit.Assert.assertTrue;


public class KeyboardRegistryTest extends ApplicationTest {

    private TextField textfield;
    private Stage stage;
    private Scene scene;

    @Override
    public void start(Stage stage) throws Exception {
        textfield = new TextField();
        VBox vBox = new VBox();
        textfield.setId("textfield");

        vBox.getChildren().addAll(textfield);
        scene = new Scene(vBox, 300, 300);
        stage.setScene(scene);
        this.stage = stage;
        this.stage.show();
    }

    @Test
    public void testRegistry() {
        IKeyboard keyboard = KeyboardFactory.getKeyboardForScene(scene);
        KeyboardRegistry.add("test", keyboard);

        IKeyboard keyboard2 = KeyboardRegistry.get("test");

        assertTrue(keyboard2 != null && keyboard2 instanceof IKeyboard);
    }

}