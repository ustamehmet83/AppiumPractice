package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigurationReader {

    //1- Create the object of Properties
    private static Properties properties= new Properties();

  static {
      try {
          //2- We need to open file in java memory: FileInputStream
          InputStream file=new FileInputStream("configuration.properties");

          //3- Load the properties object using FileInputStream object
          properties.load(file);

          //close the file
          file.close();
      } catch (IOException e) {
          System.out.println("Something happened in the ConfigurationReader class.");
          e.printStackTrace();
      }
  }

  public static String getProperty(String keyword){
      return properties.getProperty(keyword);
  }









}
