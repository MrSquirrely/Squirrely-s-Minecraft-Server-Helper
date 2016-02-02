/*
 * Copyright (C) 2016 mrsqu
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

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author mrsqu
 */
public class StartScreenController implements Initializable {

    @FXML
    private Button StartButton, DownloadButton, PropertiesButton, PortForwardButton;
    
    private Thread start, download, property, portForward;
    
    private String MCVersion = "1.8.9";
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
    @FXML
    public void startClick(MouseEvent event){
        
    }
    
    @FXML
    public void downloadClick(MouseEvent event){
        download = new Thread(() -> {
            try {
            URL website = new URL("https://s3.amazonaws.com/Minecraft.Download/versions/" + MCVersion + "/minecraft_server."+ MCVersion + ".jar");
            ReadableByteChannel rbc = Channels.newChannel(website.openStream());
            FileOutputStream fos = new FileOutputStream("MCServer"+MCVersion+".jar");
            fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
        } catch (IOException ex) {
            
        }
        }, "download");
        download.start();
        System.out.println("Done!");
    }
    
    @FXML
    public void propertiesClick(MouseEvent event){
        property = new Thread(new ShowPropertyScreen());
        property.run();
        /*
        property = new Thread(() -> {
            try {
                    Stage propsStage = new Stage();
                    Parent propsRoot = FXMLLoader.load(getClass().getClassLoader().getResource("PropertiesScreen.fxml"));
                    Scene propsScene = new Scene(propsRoot);
                    propsStage.setScene(propsScene);
                    propsStage.show();
                } catch (IOException ex) {
                    Logger.getLogger(StartScreenController.class.getName()).log(Level.SEVERE, null, ex);
                }
            
        }, "properties");
        property.start();
        */
    }
    
    /*
    Parent root;
        Parent root = FXMLLoader.load(getClass().getResource("StartScreen.fxml"));

        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();
        
        try {
            root = FXMLLoader.load(getClass().getClassLoader().getResource("path/to/other/view.fxml"), resources);
            Stage stage = new Stage();
            stage.setTitle("My New Stage Title");
            stage.setScene(new Scene(root, 450, 450));
            stage.show();

            //hide this current window (if this is whant you want
            ((Node)(event.getSource())).getScene().getWindow().hide();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    */
    
    @FXML
    public void portForwardClick(MouseEvent event){
        
    }
    
}
