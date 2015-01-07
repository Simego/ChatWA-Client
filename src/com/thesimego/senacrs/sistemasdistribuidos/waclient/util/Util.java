package com.thesimego.senacrs.sistemasdistribuidos.waclient.util;

import com.thesimego.senacrs.sistemasdistribuidos.waclient.entity.MessageEN;
import flexjson.JSONDeserializer;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Simego
 */
public class Util {

    private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
    
    /**
     * Busca o host
     * @return 
     */
    public static String getHost() {
        return System.getProperty("com.thesimego.waclient.host");
    }
    
    /**
     * Seta o host
     * @param value 
     */
    public static void setHost(Object value) {
        System.setProperty("com.thesimego.waclient.host", value.toString());
    }
    
    /**
     * Busca o login do usuário
     * @return 
     */
    public static String getLogin() {
        return System.getProperty("com.thesimego.waclient.login");
    }
    
    /**
     * Seta o login
     * @param value 
     */
    public static void setLogin(String value) {
        System.setProperty("com.thesimego.waclient.login", value);
    }
    
    /**
     * Busca se faz debug das requisições
     * @return 
     */
    public static Boolean getIsDebugRequest() {
        return Boolean.parseBoolean(System.getProperty("com.thesimego.waclient.debug.request"));
    }
    
    /**
     * Seta se faz debug das requisições
     * @param value 
     */
    public static void setDebugRequest(Boolean value) {
        System.setProperty("com.thesimego.waclient.debug.request", String.valueOf(value));
    }
    
    /**
     * Converte de Data para String
     * @param date
     * @return 
     */
    public static String formatDate(Date date) {
        return sdf.format(date);
    }
    
    /**
     * Converte de String para Data
     * @param date
     * @return 
     */
    public static Date parseDate(String date) {
        try {
            return sdf.parse(date);
        } catch (ParseException ex) {
            return null;
        }
    }
    
    /**
     * Deserializa as mensagens passadas por parâmetro que estão serializadas como JSON
     * @param json
     * @return 
     */
    public static List<MessageEN> DeserializeMessages(String json) {
        return new JSONDeserializer<List<MessageEN>>().use("group.members", ArrayList.class).use( "values", MessageEN.class ).deserialize(json);
    }
    
}
