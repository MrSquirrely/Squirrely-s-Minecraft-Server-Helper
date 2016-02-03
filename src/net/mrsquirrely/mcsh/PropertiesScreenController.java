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

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Control;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author James <MrSquirrely.net>
 */
public class PropertiesScreenController implements Initializable {
    
    //My Things
    private final Properties props = new Properties();
    private static Stage thisStage;
    private File config = new File("server.properties");
    
    //FXML Things.
    @FXML
    private ToggleButton AllowFlight;
    @FXML
    private ToggleButton AllowNether;
    @FXML
    private ToggleButton AnnouncePlayerAchivements;
    @FXML
    private ToggleButton EnableQuery;
    @FXML
    private ComboBox<String> Difficulty;
    @FXML
    private ToggleButton EnableRCON;
    @FXML
    private ToggleButton EnableCommandBLock;
    @FXML
    private ToggleButton ForceGamemode;
    @FXML
    private ToggleButton GenerateStructures;
    @FXML
    private ToggleButton Hardcore;
    @FXML
    private ToggleButton OnlineMode;
    @FXML
    private ToggleButton PVP;
    @FXML
    private ToggleButton SNooperEnabled;
    @FXML
    private ToggleButton SpawnAnimals;
    @FXML
    private ToggleButton SpawnMonsters;
    @FXML
    private ToggleButton SpawnNPCs;
    @FXML
    private ToggleButton UserNativeTransport;
    @FXML
    private ToggleButton WhiteList;
    @FXML
    private ComboBox<String> Gamemode;
    @FXML
    private TextField GeneratorSettings;
    @FXML
    private TextField LevelName;
    @FXML
    private TextField LevelSeed;
    @FXML
    private ComboBox<String> LevelType;
    @FXML
    private ComboBox<String> OpPermissionLevel;
    @FXML
    private TextField MaxBuildHeight;
    @FXML
    private TextField MaxPlayers;
    @FXML
    private TextField MaxTickTime;
    @FXML
    private TextField MaxWorldSize;
    @FXML
    private TextField MOTD;
    @FXML
    private TextField NetworkCompressionThreshold;
    @FXML
    private TextField PlayeridleTimeout;
    @FXML
    private TextField QueryPort;
    @FXML
    private TextField RCONPassword;
    @FXML
    private TextField RCONPort;
    @FXML
    private TextField ResourcePack;
    @FXML
    private TextField ResourcePackHash;
    @FXML
    private TextField ServerIP;
    @FXML
    private TextField ServerPort;
    @FXML
    private TextField SpawnProtection;
    @FXML
    private TextField ViewDistance;
    @FXML
    private Button ResetButton;
    @FXML
    private Button SaveButton;

    /**
     * Initializes the controller class.
     * @author James <MrSquirrely.net>
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        populate();
        populateComboBoxs();
    }    
    
    /**
     *
     * @author James <MrSquirrely.net>
     * Used to populate the combo boxes and set the default choice.
     * To be replaced with populate for current settings selection.
     */
    private void populateComboBoxs(){
        //Difficulty
        Difficulty.getItems().add("Peaceful");
        Difficulty.getItems().add("Easy");
        Difficulty.getItems().add("Normal");
        Difficulty.getItems().add("Hard");
        Difficulty.setValue("Normal");
        
        //GameMode
        Gamemode.getItems().add("Survival");
        Gamemode.getItems().add("Creative");
        Gamemode.getItems().add("Adventure");
        Gamemode.getItems().add("Spectator");
        Gamemode.setValue("Survival");
        
        //Level Type
        LevelType.getItems().add("Default");
        LevelType.getItems().add("Flat");
        LevelType.getItems().add("Largebiomes");
        LevelType.getItems().add("Amplified");
        LevelType.getItems().add("Cusomized");
        LevelType.setValue("Default");
        
        //OP Permission Level
        OpPermissionLevel.getItems().add("1");
        OpPermissionLevel.getItems().add("2");
        OpPermissionLevel.getItems().add("3");
        OpPermissionLevel.getItems().add("4");
        OpPermissionLevel.setValue("4");
    }
    
    /**
     *
     * This is used to save the chosen properties.
     * @author James <MrSquirrely.net>
     * @errpr The UserNativeTransport is supposed to be UseNativeTransport
     */
    @FXML
    private void saveConfigs(MouseEvent event) throws IOException{
        String difficulty, gamemode, levelType, opPermissionLevel;
        int difficultyInt, gamemodeInt, levelTypeInt, opPermissionLevelInt;
        if(!config.exists()){
            config.createNewFile();
        }
        
        difficulty = Difficulty.getValue();
        difficultyInt = Difficulty.getItems().indexOf(difficulty);
        gamemode = Gamemode.getValue();
        gamemodeInt = Gamemode.getItems().indexOf(gamemode);
        levelType = LevelType.getValue();
        levelTypeInt = LevelType.getItems().indexOf(levelType);
        opPermissionLevel = OpPermissionLevel.getValue();
        opPermissionLevelInt = OpPermissionLevel.getItems().indexOf(opPermissionLevel);
         
        props.setProperty("Allow-Flight", AllowFlight.getText());
        props.setProperty("Allow-Nether", AllowNether.getText());
        props.setProperty("Announce-Player-Achivements", AnnouncePlayerAchivements.getText());
        props.setProperty("Enable-Query", EnableQuery.getText());        
        props.setProperty("Difficulty", Integer.toString(difficultyInt));
        props.setProperty("Enable-RCON", EnableRCON.getText());
        props.setProperty("Enable-CommandBLock", EnableCommandBLock.getText());
        props.setProperty("Force-Gamemode", ForceGamemode.getText());
        props.setProperty("Generate-Structures", GenerateStructures.getText());
        props.setProperty("Hardcore", Hardcore.getText());
        props.setProperty("Online-Mode", OnlineMode.getText());
        props.setProperty("PVP", PVP.getText());
        props.setProperty("SNooper-Enabled", SNooperEnabled.getText());
        props.setProperty("Spawn-Animals", SpawnAnimals.getText());
        props.setProperty("Spawn-Monsters", SpawnMonsters.getText());
        props.setProperty("Spawn-NPCs", SpawnNPCs.getText());
        props.setProperty("Use-Native-Transport", UserNativeTransport.getText());
        props.setProperty("WhiteList", WhiteList.getText());
        props.setProperty("Game-mode", Integer.toString(gamemodeInt));
        props.setProperty("Generator-Settings", GeneratorSettings.getText());
        props.setProperty("Level-Name", LevelName.getText());
        props.setProperty("Level-Seed", LevelSeed.getText());
        props.setProperty("Level-Type", Integer.toString(levelTypeInt));
        props.setProperty("Op-Permission-Level", Integer.toString(opPermissionLevelInt));
        props.setProperty("Max-Build-Height", MaxBuildHeight.getText());
        props.setProperty("Max-Players", MaxPlayers.getText());
        props.setProperty("Max-Tick-Time", MaxTickTime.getText());
        props.setProperty("Max-World-Size", MaxWorldSize.getText());
        props.setProperty("MOTD", MOTD.getText());
        props.setProperty("Network-Compression-Threshold", NetworkCompressionThreshold.getText());
        props.setProperty("Player-idle-Timeout", PlayeridleTimeout.getText());
        props.setProperty("Query.Port", QueryPort.getText());
        props.setProperty("RCON.Password", RCONPassword.getText());
        props.setProperty("RCON.Port", RCONPort.getText());
        props.setProperty("Resource-Pack", ResourcePack.getText());
        props.setProperty("Resource-Pack-Hash", ResourcePackHash.getText());
        props.setProperty("Server-IP", ServerIP.getText());
        props.setProperty("Server-Port", ServerPort.getText());
        props.setProperty("Spawn-Protection", SpawnProtection.getText());
        props.setProperty("View-Distance", ViewDistance.getText());
        props.store(new FileOutputStream("server.properties"), null);
    }
    
    /**
     *
     *Used to reset the current selected properties.
     * No use now, but in the future.
     * @author James <MrSquirrely.net>
     */
    @FXML
    private void resetProperties(MouseEvent event){
        config.delete();
        thisStage.close();
    }
    
    /**
     *
     * This is used to be able to close the stage.
     * @author James <MrSquirrely.net>
     * @param propsStage This is the the stage.
     */
    public static void setStage(Stage propsStage) {
        thisStage = propsStage;
    }
    
    /**
     *
     * Checks if the toggle button is selected to tell weather it should be false or not.
     * @author James <MrSquirrely.net>
     */
    @FXML
    private void toggleSwitch(MouseEvent event){
        String id = ((Control)event.getSource()).getId();
        //System.out.println(id);
        if(id.equals("AllowFlight")){
            if(AllowFlight.isSelected()){
                //System.out.println("Allow Flight Is Selected");
                AllowFlight.setText("False");
            }else{
                //System.out.println("Allow Flight Is Not Selected");
                AllowFlight.setText("True");
            }
        }
        
        if(id.equals("AllowNether")){
            if(AllowNether.isSelected()){
                AllowNether.setText("False");
            }else{
                AllowNether.setText("True");
            }
        }
        
        if(id.equals("AnnouncePlayerAchivements")){
            if(AnnouncePlayerAchivements.isSelected()){
                AnnouncePlayerAchivements.setText("False");
            }else{
                AnnouncePlayerAchivements.setText("True");
            }
        }
        
        if(id.equals("EnableQuery")){
            if(EnableQuery.isSelected()){
                EnableQuery.setText("False");
            }else{
                EnableQuery.setText("True");
            }
        }
        
        if(id.equals("EnableRCON")){
            if(EnableRCON.isSelected()){
                EnableRCON.setText("False");
            }else{
                EnableRCON.setText("True");
            }
        }
        
        if(id.equals("EnableCommandBLock")){
            if(EnableCommandBLock.isSelected()){
                EnableCommandBLock.setText("False");
            }else{
                EnableCommandBLock.setText("True");
            }
        }
        
        if(id.equals("ForceGamemode")){
            if(ForceGamemode.isSelected()){
                ForceGamemode.setText("False");
            }else{
                ForceGamemode.setText("True");
            }
        }
        
        if(id.equals("GenerateStructures")){
            if(GenerateStructures.isSelected()){
                GenerateStructures.setText("False");
            }else{
                GenerateStructures.setText("True");
            }
        }
        
        if(id.equals("Hardcore")){
            if(Hardcore.isSelected()){
                Hardcore.setText("False");
            }else{
                Hardcore.setText("True");
            }
        }
        
        if(id.equals("OnlineMode")){
            if(OnlineMode.isSelected()){
                OnlineMode.setText("False");
            }else{
                OnlineMode.setText("True");
            }
        }
        
        if(id.equals("PVP")){
            if(PVP.isSelected()){
                PVP.setText("False");
            }else{
                PVP.setText("True");
            }
        }
        
        if(id.equals("SNooperEnabled")){
            if(SNooperEnabled.isSelected()){
                SNooperEnabled.setText("False");
            }else{
                SNooperEnabled.setText("True");
            }
        }
        
        if(id.equals("SpawnAnimals")){
            if(SpawnAnimals.isSelected()){
                SpawnAnimals.setText("False");
            }else{
                SpawnAnimals.setText("True");
            }
        }
        
        if(id.equals("SpawnMonsters")){
            if(SpawnMonsters.isSelected()){
                SpawnMonsters.setText("False");
            }else{
                SpawnMonsters.setText("True");
            }
        }
        
        if(id.equals("SpawnNPCs")){
            if(SpawnNPCs.isSelected()){
                SpawnNPCs.setText("False");
            }else{
                SpawnNPCs.setText("True");
            }
        }
        
        if(id.equals("UserNativeTransport")){
            if(UserNativeTransport.isSelected()){
                UserNativeTransport.setText("False");
            }else{
                UserNativeTransport.setText("True");
            }
        }
        
        if(id.equals("WhiteList")){
            if(WhiteList.isSelected()){
                WhiteList.setText("False");
            }else{
                WhiteList.setText("True");
            }
        }
    }

    /**
     * This will be used to populate the options with what is currently the options of the user.properties is.
     * @author James <MrSquirrely.net>
     * @deprecated Not added yet.
     */
    private void populate() {
        //ToDo : Add pupulation code.
    }
    
}
