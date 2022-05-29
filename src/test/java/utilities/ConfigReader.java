package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    public static Properties properties;

    static{
        String dosyaYolu="configuration.properties";
        try {
            FileInputStream fis=new FileInputStream(dosyaYolu);
            //fis dosyayolunu tanımladgmız configuration.properties dosyasını okudu
            properties=new Properties();
            properties.load(fis);  //fis'in okudugu bilgileri propertiesê yukledi
        }  catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static String getProperty(String key){

        /*
        test method'undan yolladıgmız string key degerini alip
        Properties classından getProperty() methodunu kullanarak
        bu key'e ait value'u bize getirdi.
         */


        return properties.getProperty(key);
    }
}
