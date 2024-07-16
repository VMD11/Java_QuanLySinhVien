/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UIControl;

import View.ViewClass;
import View.ViewDepartment;
import View.ViewHome;
import View.ViewMajor;
import View.ViewStudent;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseListener;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author 84362
 */
public class ViewTransfer {
    private String viewSelected = "";
    private JPanel root;
    private List<MenuList> list = null;
    public ViewTransfer() {
    }

    public ViewTransfer(JPanel jPRoot) {
        this.root = jPRoot;
    }

    public void setViewDefault(JPanel jPItem, JLabel jLItem){
        viewSelected = "Home";
        jPItem.setBackground(new Color(0, 0, 102));
        jLItem.setBackground(new Color(0, 0, 102));
        root.removeAll();
        root.setLayout(new BorderLayout());
        root.add(new ViewHome());
        root.validate();
        root.repaint();
    }
    
    public void setMouseEvent(List<MenuList> list){
        this.list = list;
        for(MenuList item : list){
            item.getjLB().addMouseListener(new MouseEvent(item.getSelected(),item.getjPL(),item.getjLB()));
        }
    }
    
    class MouseEvent implements MouseListener{
        private JPanel jP;
        private String selected;
        private JPanel jPItem;
        private JLabel jLItem;

        public MouseEvent(String selected, JPanel jPItem, JLabel jLItem) {
            this.selected = selected;
            this.jPItem = jPItem;
            this.jLItem = jLItem;
        }
        
        @Override
        public void mouseClicked(java.awt.event.MouseEvent e) {
            switch(selected){
                case "Home":
                    jP = new ViewHome();
                    break;
                case "Student":
                    jP = new ViewStudent();
                    break;
                case "Department":
                    jP = new ViewDepartment();
                    break;
                case "Major":
                    jP = new ViewMajor();
                    break;
                case "Class":
                    jP = new ViewClass();
                    break;
                default:
                    break;
            }
            root.removeAll();
            root.setLayout(new BorderLayout());
            root.add(jP);
            root.validate();
            root.repaint();
            setChangeBackgroud(selected);
        }

        @Override
        public void mousePressed(java.awt.event.MouseEvent e) {
            viewSelected = selected;
            jPItem.setBackground(new Color(0, 0, 102));
            jLItem.setBackground(new Color(0, 0, 102));
        }

        @Override
        public void mouseReleased(java.awt.event.MouseEvent e) {
        }

        @Override
        public void mouseEntered(java.awt.event.MouseEvent e) {
            jPItem.setBackground(new Color(0, 0, 102));
            jLItem.setBackground(new Color(0, 0, 102));
        }

        @Override
        public void mouseExited(java.awt.event.MouseEvent e) {
            if(!viewSelected.equalsIgnoreCase(selected)){
                jPItem.setBackground(new Color(51,102,255));
                jLItem.setBackground(new Color(51,102,255));
            }
        }
       
    }
    
    private void setChangeBackgroud(String selected){
        for(MenuList item : list){
            if(item.getSelected().equalsIgnoreCase(selected)){
                item.getjLB().setBackground(new Color(0,0,102));
                item.getjPL().setBackground(new Color(0,0,102));
            }else{
                item.getjLB().setBackground(new Color(51,102,255));
                item.getjPL().setBackground(new Color(51,102,255));
            }
        }
    }
}
