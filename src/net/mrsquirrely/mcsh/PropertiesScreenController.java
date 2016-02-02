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

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ToggleButton;

/**
 * FXML Controller class
 *
 * @author mrsqu
 */
public class PropertiesScreenController implements Initializable {

    @FXML
    private ToggleButton AllowFlight;
    @FXML
    private ToggleButton AllowNether;
    @FXML
    private ToggleButton AnnouncePlayerAchivements;
    @FXML
    private ToggleButton EnableQuery;
    @FXML
    private ComboBox Difficulty;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Difficulty.getItems().addAll(
                "Peaceful",
                "Easy",
                "Norml",
                "Hard"
        );
        Difficulty.setValue("Normal");
    }    
    
}