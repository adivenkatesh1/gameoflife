/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameoflifeAdiVGRAPHICSSTUFF;
import java.awt.image.BufferedImage;
import java.util.Stack;
/**
 *
 * @author Adi Venkatesh
 */
public class CrispyGraphics {
    private static int imgWidth;
    public static BufferedImage[][] imageTiles;
    public static BufferedImage black,white;
    
    
  /**
     * The initializes the assets inside the CrispyGraphics class. This is static, since these values are specific to its class,
     * not the object (and they should not change)
     * @param w this is the width dimension of the 2D array (in terms of tiles)
     * @param imgW this is the dimension of the image when cropped so that it can fit in one tile.
     */
    public static void init(int w,int imgW) {
        //sets the image width to the parameter, imageWidth
        CrispyGraphics.imgWidth=imgW;
        //initializes a new 2D buffered image array to store all the parts of the image
        imageTiles = new BufferedImage[w][w];
        //creates new Cropping object from the image path specified below.
        Cropping sheet = new Cropping(Images.loadImage("/res/textures/gradient.png"));
        Cropping bg = new Cropping(Images.loadImage("/res/textures/black.png"));
        
        //loops through the imageTiles array and assings the corresponding fragment of the overall image to the specific index
        //In this case, this specific index is the index of the corresponding tile inside the LifeEngine and LifeBkg class.
        for(int i=0;i<imageTiles.length;i++) {
            for(int j=0;j<imageTiles[0].length;j++) {
                imageTiles[i][j] = sheet.crop(j*imgWidth,i*imgWidth,imgWidth,imgWidth);
            }
        }
        
        black = sheet.crop(0, 0, imgWidth, imgWidth);
    }
}  
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

