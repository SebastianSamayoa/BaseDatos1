/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.basedatos1.Utilidades;

import java.io.StringReader;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;

/**
 *
 * @author root
 */
public class Utilidades {

    public Utilidades() {
    }
    
    
    
    public Object ObtenerValor(Object json, String variable, int tipo) {

        try {
            JsonReader reader = Json.createReader(new StringReader(json.toString()));

            JsonObject usu = reader.readObject();

            reader.close();

            switch (tipo) {
                case 1:
                    return usu.getInt(variable);
                case 2:
                    return usu.getString(variable);
                case 3:
                    return usu.getJsonArray(variable);
                default:
                    return null;
            }
        } catch (Exception e) {
            return "verificar el json enviado";
        }
    }
    
}
