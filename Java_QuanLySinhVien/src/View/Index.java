/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import Component.Dialog;
import UIControl.MenuList;
import UIControl.ViewTransfer;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

/**
 *
 * @author 84362
 */
public class Index extends javax.swing.JFrame {

    /**
     * Creates new form Home
     */
    public Index() {
        initComponents();
        
        acionTransfer();
        actionMouseLogout();
    }
    
    private void acionTransfer(){
        ViewTransfer viewTransfer = new ViewTransfer(jPView);
        viewTransfer.setViewDefault(jPView, jLHome);
        List<MenuList> list = new ArrayList<>();
        list.add(new MenuList("Home", jPHome, jLHome));
        list.add(new MenuList("Student", jPStudent, jLStudent));
        list.add(new MenuList("Department", jPDepartment, jLDepartment));
        list.add(new MenuList("Major", jPMajor, jLMajor));
        list.add(new MenuList("Class", jPClass, jLClass));
        viewTransfer.setMouseEvent(list);
    }
    
    private void actionMouseLogout(){
        jPLogout.addMouseListener(new MouseListener(){
            @Override
            public void mouseClicked(MouseEvent e) {
                int result = JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn đăng xuất", "Thông báo", JOptionPane.YES_NO_OPTION);
                if(result == JOptionPane.YES_OPTION){
                    Dialog.createDialog(1500, "Đang đăng xuất. Xin đợi...");
                    dispose();
                    new Login().setVisible(true);
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {
                jLLogout.setBackground(new Color(200, 0, 0));
                jPLogout.setBackground(new Color(200, 0, 0));
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                jLLogout.setBackground(new Color(200, 0, 0));
                jPLogout.setBackground(new Color(200, 0, 0));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                jLLogout.setBackground(new Color(255, 51, 51));
                jPLogout.setBackground(new Color(255, 51, 51));
            }

            
        });
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    //@SuppressWarnings("unchecked");
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPRoot = new javax.swing.JPanel();
        jPMenu = new javax.swing.JPanel();
        jPHome = new javax.swing.JPanel();
        jLHome = new javax.swing.JLabel();
        jPStudent = new javax.swing.JPanel();
        jLStudent = new javax.swing.JLabel();
        jPLogout = new javax.swing.JPanel();
        jLLogout = new javax.swing.JLabel();
        jPLogo = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPDepartment = new javax.swing.JPanel();
        jLDepartment = new javax.swing.JLabel();
        jPMajor = new javax.swing.JPanel();
        jLMajor = new javax.swing.JLabel();
        jPClass = new javax.swing.JPanel();
        jLClass = new javax.swing.JLabel();
        jPView = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Quản lý sinh viên");
        setBackground(new java.awt.Color(255, 255, 204));
        setPreferredSize(new java.awt.Dimension(1350, 760));
        setResizable(false);

        jPRoot.setBackground(new java.awt.Color(255, 255, 204));
        jPRoot.setPreferredSize(new java.awt.Dimension(1362, 760));

        jPMenu.setBackground(new java.awt.Color(255, 255, 204));
        jPMenu.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 1, new java.awt.Color(0, 0, 0)));
        jPMenu.setPreferredSize(new java.awt.Dimension(300, 760));

        jPHome.setBackground(new java.awt.Color(0, 0, 175));
        jPHome.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPHome.setPreferredSize(new java.awt.Dimension(275, 52));

        jLHome.setBackground(new java.awt.Color(0, 0, 175));
        jLHome.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLHome.setForeground(new java.awt.Color(255, 255, 255));
        jLHome.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/home.png"))); // NOI18N
        jLHome.setText("Trang chủ");
        jLHome.setPreferredSize(new java.awt.Dimension(250, 52));

        javax.swing.GroupLayout jPHomeLayout = new javax.swing.GroupLayout(jPHome);
        jPHome.setLayout(jPHomeLayout);
        jPHomeLayout.setHorizontalGroup(
            jPHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPHomeLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLHome, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPHomeLayout.setVerticalGroup(
            jPHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLHome, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPStudent.setBackground(new java.awt.Color(51, 102, 255));
        jPStudent.setPreferredSize(new java.awt.Dimension(275, 52));

        jLStudent.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLStudent.setForeground(new java.awt.Color(255, 255, 255));
        jLStudent.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLStudent.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/people_mini.png"))); // NOI18N
        jLStudent.setText("Danh sách Sinh viên");
        jLStudent.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLStudent.setPreferredSize(new java.awt.Dimension(245, 52));

        javax.swing.GroupLayout jPStudentLayout = new javax.swing.GroupLayout(jPStudent);
        jPStudent.setLayout(jPStudentLayout);
        jPStudentLayout.setHorizontalGroup(
            jPStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPStudentLayout.createSequentialGroup()
                .addGap(0, 30, Short.MAX_VALUE)
                .addComponent(jLStudent, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPStudentLayout.setVerticalGroup(
            jPStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLStudent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPLogout.setBackground(new java.awt.Color(255, 51, 51));
        jPLogout.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPLogout.setPreferredSize(new java.awt.Dimension(275, 52));

        jLLogout.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLLogout.setForeground(new java.awt.Color(255, 255, 255));
        jLLogout.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/logout.png"))); // NOI18N
        jLLogout.setText("Đăng xuất");
        jLLogout.setPreferredSize(new java.awt.Dimension(86, 25));

        javax.swing.GroupLayout jPLogoutLayout = new javax.swing.GroupLayout(jPLogout);
        jPLogout.setLayout(jPLogoutLayout);
        jPLogoutLayout.setHorizontalGroup(
            jPLogoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPLogoutLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLLogout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPLogoutLayout.setVerticalGroup(
            jPLogoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPLogoutLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLLogout, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPLogo.setBackground(new java.awt.Color(255, 255, 204));
        jPLogo.setPreferredSize(new java.awt.Dimension(285, 92));

        jLabel1.setBackground(new java.awt.Color(255, 255, 204));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 19)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/user.png"))); // NOI18N
        jLabel1.setText("QUẢN LÝ SINH VIÊN");

        javax.swing.GroupLayout jPLogoLayout = new javax.swing.GroupLayout(jPLogo);
        jPLogo.setLayout(jPLogoLayout);
        jPLogoLayout.setHorizontalGroup(
            jPLogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPLogoLayout.setVerticalGroup(
            jPLogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPLogoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPDepartment.setBackground(new java.awt.Color(51, 102, 255));
        jPDepartment.setPreferredSize(new java.awt.Dimension(275, 52));

        jLDepartment.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLDepartment.setForeground(new java.awt.Color(255, 255, 255));
        jLDepartment.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLDepartment.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/school_mini.png"))); // NOI18N
        jLDepartment.setText("Danh sách Khoa");
        jLDepartment.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLDepartment.setPreferredSize(new java.awt.Dimension(245, 52));

        javax.swing.GroupLayout jPDepartmentLayout = new javax.swing.GroupLayout(jPDepartment);
        jPDepartment.setLayout(jPDepartmentLayout);
        jPDepartmentLayout.setHorizontalGroup(
            jPDepartmentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPDepartmentLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLDepartment, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPDepartmentLayout.setVerticalGroup(
            jPDepartmentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLDepartment, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPMajor.setBackground(new java.awt.Color(51, 102, 255));
        jPMajor.setPreferredSize(new java.awt.Dimension(275, 52));

        jLMajor.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLMajor.setForeground(new java.awt.Color(255, 255, 255));
        jLMajor.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLMajor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/major_mini.png"))); // NOI18N
        jLMajor.setText("Danh sách Ngành");
        jLMajor.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLMajor.setPreferredSize(new java.awt.Dimension(245, 52));

        javax.swing.GroupLayout jPMajorLayout = new javax.swing.GroupLayout(jPMajor);
        jPMajor.setLayout(jPMajorLayout);
        jPMajorLayout.setHorizontalGroup(
            jPMajorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPMajorLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLMajor, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPMajorLayout.setVerticalGroup(
            jPMajorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLMajor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPClass.setBackground(new java.awt.Color(51, 102, 255));
        jPClass.setPreferredSize(new java.awt.Dimension(275, 52));

        jLClass.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLClass.setForeground(new java.awt.Color(255, 255, 255));
        jLClass.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLClass.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/room_mini.png"))); // NOI18N
        jLClass.setText("Danh sách Lớp");
        jLClass.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLClass.setPreferredSize(new java.awt.Dimension(245, 52));

        javax.swing.GroupLayout jPClassLayout = new javax.swing.GroupLayout(jPClass);
        jPClass.setLayout(jPClassLayout);
        jPClassLayout.setHorizontalGroup(
            jPClassLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPClassLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLClass, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPClassLayout.setVerticalGroup(
            jPClassLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLClass, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPMenuLayout = new javax.swing.GroupLayout(jPMenu);
        jPMenu.setLayout(jPMenuLayout);
        jPMenuLayout.setHorizontalGroup(
            jPMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPLogo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jPLogout, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPStudent, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPHome, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPDepartment, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPMajor, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPClass, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(8, Short.MAX_VALUE))
        );
        jPMenuLayout.setVerticalGroup(
            jPMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPMenuLayout.createSequentialGroup()
                .addComponent(jPLogo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addComponent(jPHome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(jPStudent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(jPDepartment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(jPMajor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(jPClass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 104, Short.MAX_VALUE)
                .addComponent(jPLogout, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(72, 72, 72))
        );

        jPView.setPreferredSize(new java.awt.Dimension(1050, 760));

        javax.swing.GroupLayout jPViewLayout = new javax.swing.GroupLayout(jPView);
        jPView.setLayout(jPViewLayout);
        jPViewLayout.setHorizontalGroup(
            jPViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1050, Short.MAX_VALUE)
        );
        jPViewLayout.setVerticalGroup(
            jPViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 760, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPRootLayout = new javax.swing.GroupLayout(jPRoot);
        jPRoot.setLayout(jPRootLayout);
        jPRootLayout.setHorizontalGroup(
            jPRootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPRootLayout.createSequentialGroup()
                .addComponent(jPMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPView, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPRootLayout.setVerticalGroup(
            jPRootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPRootLayout.createSequentialGroup()
                .addGroup(jPRootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPRoot, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPRoot, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

//    public static void main(String[] args) {
//        new Index().setVisible(true);
//    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLClass;
    private javax.swing.JLabel jLDepartment;
    private javax.swing.JLabel jLHome;
    private javax.swing.JLabel jLLogout;
    private javax.swing.JLabel jLMajor;
    private javax.swing.JLabel jLStudent;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPClass;
    private javax.swing.JPanel jPDepartment;
    private javax.swing.JPanel jPHome;
    private javax.swing.JPanel jPLogo;
    private javax.swing.JPanel jPLogout;
    private javax.swing.JPanel jPMajor;
    private javax.swing.JPanel jPMenu;
    private javax.swing.JPanel jPRoot;
    private javax.swing.JPanel jPStudent;
    private javax.swing.JPanel jPView;
    // End of variables declaration//GEN-END:variables
}
