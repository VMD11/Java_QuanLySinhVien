/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UIControl;

import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author 84362
 */
public class MenuList {
    private String selected;
    private JPanel jPL;
    private JLabel jLB;

    public MenuList() {
    }

    public MenuList(String selected, JPanel jPL, JLabel jLB) {
        this.selected = selected;
        this.jPL = jPL;
        this.jLB = jLB;
    }

    public String getSelected() {
        return selected;
    }

    public void setSelected(String selected) {
        this.selected = selected;
    }

    public JPanel getjPL() {
        return jPL;
    }

    public void setjPL(JPanel jPL) {
        this.jPL = jPL;
    }

    public JLabel getjLB() {
        return jLB;
    }

    public void setjLB(JLabel jLB) {
        this.jLB = jLB;
    }
    
}
