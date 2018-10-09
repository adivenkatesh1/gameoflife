/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameoflifeAdiVGRAPHICSSTUFF;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
/**
 *
 * @author Adi Venkatesh
 */
public class Images {
   
  //takes in string parameter of the image path
    /**
     * 
     * @param path is the path of the given image
     * @return null if there is an exception
     */
    public static BufferedImage loadImage(String path) {
        try {
            //gets the resource from the path and returns it
            return ImageIO.read(Images.class.getResource(path));
        } catch (IOException e) {
            //prevents program from running if there is an error
            System.exit(1);
        }
        //otherwise, return null if there is an exception
        return null;
    }   
    
    
    
    
    
}
