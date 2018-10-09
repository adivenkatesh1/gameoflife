/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameoflifeadivOTHER;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *Contains some useful methods which I thought would be useful for Game of Life
 * Took this from last year's ISU
 * @author Adi Venkatesh
 */
public class OtherElements {
    
    /**
     * Responsible for loading in a text file and returning it as a string
     * @param path is the location of the text file
     * @return Returns the file as a string
     */
    public static String fileToString(String path) {
        //creates StringBuilder class.
        StringBuilder build = new StringBuilder();
        
        //this try-catch block will read in the file at the parameter variable
        //path and appends it to the builder.
        try {
            //creates bufferedReader object which will read in the file.
            BufferedReader br = new BufferedReader(new FileReader(path));
            //temp variable for reading in lines
            String line;
            //this loop will read until there is no next line.
            while((line=br.readLine()) != null) {
                //appends the builder object with the line read in and adds
                //new line.
                build.append(line+"\n");
            }
            //closes the buffered reader.
            br.close();
        //catches the exception if there is no file.    
        } catch(IOException e) {
            //prints the error to the console
            e.printStackTrace();
        }
        
        //returns the builder object as a string.
        return build.toString();
    } //end of LoadFileAsString method.
    
    //parseInt method. Takes in the String we want to convert into an integer
    //as a parameter called number.
    /**
     * This method takes in a String that we want to convert into an integer and returns the converted integer.
     * @param number This is the string you want to convert into an integer.
     * @return This is the integer returned after converting the String, number, into an integer.
     */
    public static int parseInt(String number) {
        //try-catch loop to prevent fatal errors such as the inability to 
        //convert the string to an integer.
        try {
            //returns the string as an ineger with the Integer.parseInt method.
            return Integer.parseInt(number);
        //otherwise, the numberFormaatException is caught
        } catch (NumberFormatException e) {
            //prints error to console
            e.printStackTrace();
            //returns zero
            return 0;
        } 
    } 
} 
