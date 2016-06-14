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

import com.eclipsesource.json.Json;
import com.eclipsesource.json.JsonArray;
import com.eclipsesource.json.JsonObject;
import com.eclipsesource.json.JsonValue;


/**
 *
 * @author James <MrSquirrely.net>
 */
public class ReadMCVersions {
    //private static final JsonValue value = Json.parse("res/MCVersions.json");

    static JsonArray getVersions() {
        JsonArray items = Json.parse("res/MCVersions.json").asObject().get("Versions").asArray();
        return items.asArray();
    }
    /*
    JsonObject object = Json.parse(input).asObject();
String name = object.get("name").asString();
int quantity = object.get("quantity").asInt();
    */
}