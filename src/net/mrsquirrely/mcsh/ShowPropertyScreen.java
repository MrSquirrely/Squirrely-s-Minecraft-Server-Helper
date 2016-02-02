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

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author mrsqu
 */
public class ShowPropertyScreen extends Application implements Runnable {

    @Override
    public void run() {
        try {
            Stage propsStage = new Stage();
            this.start(propsStage);
        } catch (Exception ex) {
            Logger.getLogger(ShowPropertyScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void start(Stage propsStage) throws Exception {
        //Stage propsStage = new Stage();
        Parent propsRoot = FXMLLoader.load(getClass().getResource("PropertiesScreen.fxml"));
        Scene propsScene = new Scene(propsRoot);
        propsStage.setScene(propsScene);
        propsStage.show();
    }

}
