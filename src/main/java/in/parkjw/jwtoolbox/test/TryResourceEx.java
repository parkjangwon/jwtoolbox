package in.parkjw.jwtoolbox.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class TryResourceEx {
  public static void main(String[] args) {

    try (FileInputStream fis = new FileInputStream(new File("filepath"));) {
      int i = 0;
      while ((i = fis.read()) != -1) {
        System.out.write(i);
      }
    } catch (IOException ie) {
      System.out.println(ie.toString());
    }

  }
}