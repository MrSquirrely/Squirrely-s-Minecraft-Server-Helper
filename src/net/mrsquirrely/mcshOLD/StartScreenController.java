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
package net.mrsquirrely.mcshOLD;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author James <MrSquirrely.net>
 */
public class StartScreenController implements Initializable {

    
    @FXML
    private Button StartButton, DownloadButton, PropertiesButton, PortForwardButton;
    
    private Thread start, download, property, portForward;
    
    public static String MCVersion = "1.8.9";
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
    /**
     *
     * This starts the server
     */
    @FXML
    public void startClick(MouseEvent event){
        System.out.println("You just started the server!");
        start = new Thread(new StartServer());
        start.start();
    }
    
    /**
     *
     * This downloads the server of your choice, currently only 1.8.9
     */
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
    
    /**
     *
     * Show the properties screen
     */
    @FXML
    public void propertiesClick(MouseEvent event){
        property = new Thread(new ShowPropertyScreen());
        property.run();
    }
    
    /**
     *
     * @deprecated This is not currently an options and is planned to be removed. There is no real reason to need this.
     */
    @FXML
    public void portForwardClick(MouseEvent event){
        
    }
    
}
