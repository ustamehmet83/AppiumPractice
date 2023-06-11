package utils;

import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Properties;

public class ConfigurationReader {

    //1- Create the object of Properties
    private static Properties properties= new Properties();
    public static HashMap<String,String> strings= new HashMap<String,String>();
    static InputStream stringsis;
    static TestUtils utils;
    static InputStream dataIs;
    public static JSONObject loginUsers;


  static {
      try {
          //2- We need to open file in java memory: FileInputStream
          //3- Load the properties object using FileInputStream object
          InputStream file=new FileInputStream("configuration.properties");
          properties.load(file);

          String xmlFileName="strings/strings.xml";
          stringsis= ConfigurationReader.class.getClassLoader().getResourceAsStream(xmlFileName);
          utils=new TestUtils();
          strings=utils.parseStringXML(stringsis);

          String dataFileName="data/loginUsers.json";
          dataIs= ConfigurationReader.class.getClassLoader().getResourceAsStream(dataFileName);
          JSONTokener tokener= new JSONTokener(dataIs);
          loginUsers= new JSONObject(tokener);

          //close the file
          file.close();
          stringsis.close();
          dataIs.close();
      } catch (Exception e) {
          System.out.println("Something happened in the ConfigurationReader class.");
          e.printStackTrace();
      }
  }

  public static String getProperty(String keyword){
      return properties.getProperty(keyword);
  }









}
