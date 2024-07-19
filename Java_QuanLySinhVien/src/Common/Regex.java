/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Common;

/**
 *
 * @author 84362
 */
public class Regex {
    public static String regexGPA(){
        return "\\d*\\.?\\d*";
    }
    
    public static String regexBirthday(){
        return "^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/\\d{4}$";
    }
}
