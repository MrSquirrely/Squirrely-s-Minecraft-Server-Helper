/*
 * Copyright (C) 2016 James <MrSquirrely.net>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package net.mrsquirrely.mcsh;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import java.awt.Desktop;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.input.MouseEvent;
import static javafx.scene.paint.Color.*;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author James <MrSquirrely.net>
 */
public class MPController implements Initializable {

    //No FXML Things go here.
    private static Stage thisStage;
    private static Scene thisScene;
    
    //FXML Things go here, each item has to be on a different line.
    //Put them where they fit, Label next to other labels, buttons next to other buttons.
    //If there is a JFX version of what you are using, use it.
    @FXML
    private Label VersionLabel;
    @FXML
    private JFXButton StartServerButton;
    @FXML
    private JFXButton DownloadServerButton;
    @FXML
    private JFXButton SettingsButton;
    @FXML
    private JFXButton PortForwardButton;
    @FXML
    private JFXButton ModsButton;
    @FXML
    private JFXButton ResourcePackButton;
    @FXML
    private JFXComboBox MCVersionCombo;
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // -- Setup Tooltips -------------------------------//
        VersionLabel.setTooltip(new Tooltip("Opens to Github repo."));
        StartServerButton.setTooltip(new Tooltip("Starts the selected server version."));
        DownloadServerButton.setTooltip(new Tooltip("Downloads the selected server version."));
        SettingsButton.setTooltip(new Tooltip("Opens the settings page to modify server properties and application settings."));
        PortForwardButton.setTooltip(new Tooltip("This is a beta feature and might not work."));
        ModsButton.setTooltip(new Tooltip("Opens mod manager to lod mods/plugins."));
        ResourcePackButton.setTooltip(new Tooltip("Opens world manager to load a world and a resource pack."));
        MCVersionCombo.setTooltip(new Tooltip("Select a Minecraft server version."));
        
        // -- Populate MC Version Combo box -----------------//
        try {
            //new FileReader("net/mrsquirrely/mcsh/res/MCVersions.json")
            InputStream in = MCSH.class.getResourceAsStream("res/MCVersions.json");
            Reader fr = new InputStreamReader(in, "utf-8");
            JsonElement JElement = new JsonParser().parse(fr);
            JsonObject JObject = JElement.getAsJsonObject();
            JsonArray JArray = JObject.getAsJsonArray("Versions");
            for(int i = 0; i < JArray.size(); i++){
                MCVersionCombo.getItems().add(JArray.get(i).getAsString());
            }
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(MPController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    
    //This sets the stage and scene so this class can use it, do not infer from main class ever!
    public static void stage(Stage stage, Scene scene){
        MPController.thisStage = stage;
        MPController.thisScene = scene;
    }
    
    //This changes the mouse cursor to a hand on objects that can be clicked.
    public void mouseIn(MouseEvent event){
        thisScene.setCursor(Cursor.HAND);
    }
    
    //This changes it back to normal.
    public void mouseOut(MouseEvent event){
        thisScene.setCursor(Cursor.DEFAULT);
    }
    
    //This sets the cursor and colour of the Version Label.
    public void versionIn(MouseEvent event){
        thisScene.setCursor(Cursor.HAND);
        VersionLabel.setTextFill(BLUE);
    }
    
    //This changes it back to normal.
    public void versonOut(MouseEvent event){
        thisScene.setCursor(Cursor.DEFAULT);
        VersionLabel.setTextFill(BLACK);
    }
    
    //This opens the url in the default browser so people can see the source.
    public void versionClick(MouseEvent event){
        try {
            Desktop.getDesktop().browse(new URL("https://github.com/MrSquirrely/Squirrely-s-Minecraft-Server-Helper").toURI());
        } catch (IOException | URISyntaxException ex) {
            Logger.getLogger(MPController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
