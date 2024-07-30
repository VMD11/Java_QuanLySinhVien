/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package View;

import Common.DataUpdateListener;
import Common.ExportExcel;
import Component.ComboBox;
import Component.Dialog;
import Service.*;
import Component.TableStudent;
import Model.Student;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 *
 * @author 84362
 */
public class ViewStudent extends javax.swing.JPanel implements DataUpdateListener{
    private StudentService studentService;
    private DepartmentService departmentService;
    private MajorService majorService;
    private ClassesService classService;
    private TableStudent tableStudent;
    private Student student;
    /**
     * Creates new form MainHome
     */
    public ViewStudent() {
        initComponents();
        studentService = new StudentService();
        departmentService = new DepartmentService();
        majorService = new MajorService();
        classService = new ClassesService();
        tableStudent = new TableStudent(new StudentService());
        loadCB();
        loadTable();
        tableMouseListener();
        searchDocumentListener();
        export();
    }
    
    private void loadTable(){
        jTStudent.setModel(tableStudent);
    }
    
    private void loadCB(){
        jCbDepartment.setModel(new ComboBox().loadComboBox(departmentService.getNameList()));
        jCbDepartment.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                jCbMajor.setModel(new ComboBox().loadComboBox(majorService.getNameList(jCbDepartment)));
                jCbClass.setModel(new ComboBox().loadComboBox(classService.getNameList(jCbMajor)));
                tableStudent.filter(jCbClass.getSelectedItem().toString());
            }
        });
        jCbDepartment.setSelectedIndex(0);
        jCbMajor.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                jCbClass.setModel(new ComboBox().loadComboBox(classService.getNameList(jCbMajor)));
                tableStudent.filter(jCbClass.getSelectedItem().toString());
            }
        });
        jCbMajor.setSelectedIndex(0);
        jCbClass.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                tableStudent.filter(jCbClass.getSelectedItem().toString());
            }
        });
    }
    
    private void searchDocumentListener(){
        jTSearch.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                updateTable();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                updateTable();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                updateTable();
            }

            private void updateTable() {
                tableStudent.search(jTSearch.getText());
            }
        });
    }
    
    private void tableMouseListener(){
        
        jTStudent.setRowHeight(20);
        jTStudent.addMouseListener(new MouseListener() {
            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 1){
                    int selectedRow = jTStudent.getSelectedRow();
                    if (selectedRow != -1) {
                        String id = jTStudent.getValueAt(selectedRow, 0).toString();
                        String name = jTStudent.getValueAt(selectedRow, 1).toString();
                        String birthday = jTStudent.getValueAt(selectedRow, 3).toString();
                        String homeland = jTStudent.getValueAt(selectedRow, 6).toString();
                        int gender = 0;
                        if(jTStudent.getValueAt(selectedRow, 2).toString().equalsIgnoreCase("Nữ"))
                            gender = 1;
                        String className = jTStudent.getValueAt(selectedRow, 5).toString();
                        double GPA = Double.parseDouble(jTStudent.getValueAt(selectedRow, 4).toString());
                        String class_id = classService.getIDByName(className);
                        student = new Student(id, name, birthday, homeland, gender, class_id, GPA);
                        studentService.setDetail(student);
                        new DetailStudent(ViewStudent.this).setVisible(true);
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
    
    private void export(){
        jBtnExport.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                String filePath = "student_sheet.xlsx";
                Dialog.createDialog(1500, "Xin chờ...");
                ExportExcel.exportTable(jTStudent, filePath);
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
        jCbDepartment = new javax.swing.JComboBox<>();
        jCbMajor = new javax.swing.JComboBox<>();
        jCbClass = new javax.swing.JComboBox<>();
        jBtnNewStudent = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTStudent = new javax.swing.JTable();
        jTSearch = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jBtnExport = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 204));
        setPreferredSize(new java.awt.Dimension(1038, 760));

        jPanel1.setBackground(new java.awt.Color(255, 255, 204));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setText("DANH SÁCH SINH VIÊN");

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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(10, 10, 10))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 204));
        jPanel2.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 1, 0, new java.awt.Color(0, 0, 0)));

        jCbDepartment.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jCbDepartment.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jCbDepartment.setPreferredSize(new java.awt.Dimension(300, 40));

        jCbMajor.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jCbMajor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jCbClass.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jCbClass.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jBtnNewStudent.setBackground(new java.awt.Color(51, 102, 255));
        jBtnNewStudent.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jBtnNewStudent.setForeground(new java.awt.Color(255, 255, 255));
        jBtnNewStudent.setText("Thêm mới");
        jBtnNewStudent.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBtnNewStudent.setPreferredSize(new java.awt.Dimension(150, 40));
        jBtnNewStudent.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBtnNewStudentMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBtnNewStudent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jCbDepartment, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jCbMajor, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jCbClass, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCbDepartment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCbMajor, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCbClass, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(jBtnNewStudent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 204));

        jScrollPane1.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jScrollPane1.setPreferredSize(new java.awt.Dimension(1026, 350));

        jTStudent.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jTStudent.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTStudent);

        jTSearch.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTSearch.setPreferredSize(new java.awt.Dimension(300, 40));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("Tìm kiếm:");

        jBtnExport.setBackground(new java.awt.Color(51, 204, 0));
        jBtnExport.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jBtnExport.setForeground(new java.awt.Color(255, 255, 255));
        jBtnExport.setText("Xuất Excel");
        jBtnExport.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBtnExport.setPreferredSize(new java.awt.Dimension(150, 40));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jTSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBtnExport, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(33, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jBtnExport, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(67, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnNewStudentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBtnNewStudentMouseClicked
        NewStudent newStudent = new NewStudent(ViewStudent.this);
        newStudent.setVisible(true);
    }//GEN-LAST:event_jBtnNewStudentMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnExport;
    private javax.swing.JButton jBtnNewStudent;
    private javax.swing.JComboBox<String> jCbClass;
    private javax.swing.JComboBox<String> jCbDepartment;
    private javax.swing.JComboBox<String> jCbMajor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTSearch;
    private javax.swing.JTable jTStudent;
    // End of variables declaration//GEN-END:variables

    @Override
    public void onDataUpdate() {
        loadTable();
    }

    
}
