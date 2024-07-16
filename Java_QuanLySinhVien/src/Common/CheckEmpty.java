/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Common;

import javax.swing.JTextField;

/**
 *
 * @author 84362
 */
public class CheckEmpty {
    public static boolean isEmptyTextField(JTextField jTextField){
        return jTextField.getText().isEmpty();
    }
}
