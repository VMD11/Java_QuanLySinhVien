/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package View;

import Common.CheckEmpty;
import Component.ComboBox;
import Component.TableClass;
import Model.Classes;
import Service.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 *
 * @author 84362
 */
public class ViewClass extends javax.swing.JPanel {
    private ClassesService classService;
    private DepartmentService departmentService;
    private MajorService majorService;
    private TableClass tableClass;
    /**
     * Creates new form ViewDepartment
     */
    public ViewClass() {
        initComponents();
        classService = new ClassesService();
        departmentService = new DepartmentService();
        majorService = new MajorService();
        tableClass = new TableClass(new ClassesService());
        loadTable();
        loadCB();
        searchActionListener();
    }
    
    private void loadCB(){
        jCbDepartment.setModel(new ComboBox().loadComboBox(departmentService.getNameList()));
        jCbDepartment.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                jCbMajor.setModel(new ComboBox().loadComboBox(majorService.getNameList(jCbDepartment)));
            }
            
        });
        jCbDepartment.setSelectedIndex(0);
    }
    
    private void loadTable(){
        jTBClass.setModel(tableClass);
        jTBClass.setRowHeight(20);
        jTBClass.addMouseListener(new MouseListener() {
            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 1){
                    int selectedRow = jTBClass.getSelectedRow();
                    if (selectedRow != -1) {
                        String id = jTBClass.getValueAt(selectedRow, 0).toString();
                        String name = jTBClass.getValueAt(selectedRow, 1).toString();
                        String majorName = jTBClass.getValueAt(selectedRow, 2).toString();
                        String major_id = majorService.getIDByName(majorName);
                        String departmentName = departmentService.getNameByID(majorService.getDepartmentIDByID(major_id));
                        jTName.setText(name);
                        jCbDepartment.setSelectedItem(departmentName);
                        jCbMajor.setSelectedItem(majorName);
                        
                    }
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
            
        });
    }
    
    private void searchActionListener(){
        jTSearch.getDocument().addDocumentListener(new DocumentListener(){
            @Override
            public void insertUpdate(DocumentEvent e) {
                updatTable();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                updatTable();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                updatTable();
            }
            
            void updatTable(){
                tableClass.search(jTSearch.getText());
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTBClass = new javax.swing.JTable();
        jTSearch = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jBtnExport = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jTName = new javax.swing.JTextField();
        jBtnAdd = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jBtnUpdate = new javax.swing.JButton();
        jBtnDelete = new javax.swing.JButton();
        jCbDepartment = new javax.swing.JComboBox<>();
        jCbMajor = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 204));
        setPreferredSize(new java.awt.Dimension(1050, 760));

        jPanel1.setBackground(new java.awt.Color(255, 255, 204));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setText("DANH SÁCH LỚP");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 204));
        jPanel2.setPreferredSize(new java.awt.Dimension(1038, 430));

        jScrollPane1.setPreferredSize(new java.awt.Dimension(1026, 350));

        jTBClass.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTBClass.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTBClass);

        jTSearch.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTSearch.setPreferredSize(new java.awt.Dimension(250, 40));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("Tìm kiếm:");

        jBtnExport.setBackground(new java.awt.Color(51, 204, 0));
        jBtnExport.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jBtnExport.setForeground(new java.awt.Color(255, 255, 255));
        jBtnExport.setText("Xuất Excel");
        jBtnExport.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBtnExport.setPreferredSize(new java.awt.Dimension(150, 40));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jTSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBtnExport, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtnExport, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 204));
        jPanel3.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 1, 0, new java.awt.Color(0, 0, 0)));

        jTName.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTName.setPreferredSize(new java.awt.Dimension(250, 40));

        jBtnAdd.setBackground(new java.awt.Color(51, 102, 255));
        jBtnAdd.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jBtnAdd.setForeground(new java.awt.Color(255, 255, 255));
        jBtnAdd.setText("Thêm mới");
        jBtnAdd.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBtnAdd.setPreferredSize(new java.awt.Dimension(150, 40));
        jBtnAdd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBtnAddMouseClicked(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("Tên lớp");
        jLabel2.setToolTipText("");

        jBtnUpdate.setBackground(new java.awt.Color(255, 51, 51));
        jBtnUpdate.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jBtnUpdate.setForeground(new java.awt.Color(255, 255, 255));
        jBtnUpdate.setText("Sửa");
        jBtnUpdate.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBtnUpdate.setPreferredSize(new java.awt.Dimension(150, 40));
        jBtnUpdate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBtnUpdateMouseClicked(evt);
            }
        });

        jBtnDelete.setBackground(new java.awt.Color(255, 204, 0));
        jBtnDelete.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jBtnDelete.setForeground(new java.awt.Color(255, 255, 255));
        jBtnDelete.setText("Xóa");
        jBtnDelete.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBtnDelete.setPreferredSize(new java.awt.Dimension(150, 40));
        jBtnDelete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBtnDeleteMouseClicked(evt);
            }
        });

        jCbDepartment.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jCbDepartment.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jCbDepartment.setPreferredSize(new java.awt.Dimension(250, 40));

        jCbMajor.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jCbMajor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jCbMajor.setPreferredSize(new java.awt.Dimension(250, 40));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setText("Khoa");
        jLabel4.setToolTipText("");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setText("Ngành");
        jLabel5.setToolTipText("");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jBtnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jBtnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jBtnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTName, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(50, 50, 50)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCbDepartment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(50, 50, 50)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jCbMajor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addGap(10, 10, 10)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCbDepartment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCbMajor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(47, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnAddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBtnAddMouseClicked
        if(CheckEmpty.isEmptyTextField(jTName))
            JOptionPane.showMessageDialog(null, "Không được để trống");
        else{
            String name = jTName.getText();
            String majorName = jCbMajor.getSelectedItem().toString();
            String major_id = majorService.getIDByName(majorName);
            classService.add(new Classes(name, major_id));
            jTName.setText(null);
            loadCB();
            loadTable();
        }
    }//GEN-LAST:event_jBtnAddMouseClicked

    private void jBtnUpdateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBtnUpdateMouseClicked
        int selectedRow = jTBClass.getSelectedRow();
        if(selectedRow==-1)
            JOptionPane.showMessageDialog(null, "Vui lòng chọn lớp để sửa");            
        else if(CheckEmpty.isEmptyTextField(jTName))
            JOptionPane.showMessageDialog(null, "Không được để trống");
        else{
            String id = jTBClass.getValueAt(selectedRow, 0).toString();
            String name = jTName.getText();
            String majorName = jCbMajor.getSelectedItem().toString();
            String major_id = majorService.getIDByName(majorName);
            classService.update(new Classes(id, name, major_id));
            loadTable();
        }
    }//GEN-LAST:event_jBtnUpdateMouseClicked

    private void jBtnDeleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBtnDeleteMouseClicked
        int selectedRow = jTBClass.getSelectedRow();
        if(selectedRow==-1)
            JOptionPane.showMessageDialog(null, "Vui lòng chọn lớp để xóa");            
        else{
            String id = jTBClass.getValueAt(selectedRow, 0).toString();            
            String name = jTName.getText();
            String majorName = jCbMajor.getSelectedItem().toString();
            String major_id = majorService.getIDByName(majorName);
            int result = JOptionPane.showConfirmDialog(null, "Hành động này sẽ xóa tất cả các sinh viên thuộc lớp này. Bạn có chắc chắn muốn xóa không", "Cảnh báo", JOptionPane.YES_NO_OPTION);
            if(result==JOptionPane.YES_OPTION){
                classService.delete(new Classes(id, name, major_id));
                loadTable();
            }
        }
    }//GEN-LAST:event_jBtnDeleteMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnAdd;
    private javax.swing.JButton jBtnDelete;
    private javax.swing.JButton jBtnExport;
    private javax.swing.JButton jBtnUpdate;
    private javax.swing.JComboBox<String> jCbDepartment;
    private javax.swing.JComboBox<String> jCbMajor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTBClass;
    private javax.swing.JTextField jTName;
    private javax.swing.JTextField jTSearch;
    // End of variables declaration//GEN-END:variables
}
