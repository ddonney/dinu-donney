package com.automation.api.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

/**
 * @author dinudonney
 * @Date 07/07/22
 */
public class CommonUtils {
    public static String getEndPointUrl(String resource, String endpoint){
        String endPoointUrl;
        if(System.getProperty("ENV.HOST")==null){
            endPoointUrl=endpoint+resource;
        }
        else
            endPoointUrl=System.getProperty("ENV.HOST")+resource;
        return endPoointUrl;
    }

    public static String getDatafromConfig(String strkey) throws IOException {
        String rootDirectory=null;
        Path  userDirectory = Paths.get(".").normalize().toAbsolutePath();
        rootDirectory=userDirectory.toString();
        Properties prop=new Properties();
        prop.load(new FileInputStream(rootDirectory+"/src/test/resources/Config.properties"));
        String strData=prop.getProperty(strkey);
        if(strData !=null && strData != ""){
            strData=strData.trim();
        }
        return strData;
    }

}
