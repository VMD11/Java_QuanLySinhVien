/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Component;

import java.util.List;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author 84362
 */
public class ComboBox {

    public ComboBox() {
    }
    
    public DefaultComboBoxModel<String> loadComboBox(List<String> list){
        DefaultComboBoxModel<String> cb = new DefaultComboBoxModel<>();
        for(String item : list){
            cb.addElement(item);
        }
        return cb;
    }
    
}
