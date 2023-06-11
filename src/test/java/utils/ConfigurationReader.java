package utils;

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


  static {
      try {
          //2- We need to open file in java memory: FileInputStream
          InputStream file=new FileInputStream("configuration.properties");
          String xmlFileName="strings/strings.xml";
          stringsis= ConfigurationReader.class.getClassLoader().getResourceAsStream(xmlFileName);


          utils=new TestUtils();
          strings=utils.parseStringXML(stringsis);
          //3- Load the properties object using FileInputStream object
          properties.load(file);


          //close the file
          file.close();
      } catch (Exception e) {
          System.out.println("Something happened in the ConfigurationReader class.");
          e.printStackTrace();
      }finally {
          if (stringsis!=null){
              try {
                  stringsis.close();
              } catch (IOException e) {
                  throw new RuntimeException(e);
              }
          }
      }
  }

  public static String getProperty(String keyword){
      return properties.getProperty(keyword);
  }









}
