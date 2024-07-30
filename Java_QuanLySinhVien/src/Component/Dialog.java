/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Component;

import java.awt.BorderLayout;
import javax.swing.BorderFactory;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

/**
 *
 * @author 84362
 */
public class Dialog {
    public static void createDialog(long time, String text) {
        JOptionPane jOP = new JOptionPane();
        jOP.setMessageType(JOptionPane.INFORMATION_MESSAGE);
        jOP.setMessage(text);

        JDialog dialog = jOP.createDialog(null, "Thông báo");

        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        dialog.setModal(true);
        dialog.setResizable(false);
        
        JLabel messageLabel = new JLabel(text, SwingConstants.CENTER);
        messageLabel.setBorder(BorderFactory.createEmptyBorder(40, 60, 40, 60));
        
        dialog.getContentPane().removeAll();
        dialog.getContentPane().add(messageLabel, BorderLayout.CENTER);

        // Hiển thị JDialog
        dialog.pack();
        new Thread(() ->{
            try{
                Thread.sleep(time);
            }catch(InterruptedException ex){

            }
            dialog.dispose();
        } ).start();
        dialog.setVisible(true);
    }
}
