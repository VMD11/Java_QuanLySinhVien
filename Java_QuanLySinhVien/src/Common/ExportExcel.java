/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Common;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.swing.*;
import javax.swing.table.TableModel;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *
 * @author 84362
 */
public class ExportExcel {
    public static void exportTable(JTable table, String filePath){
        try (Workbook workbook = new XSSFWorkbook(); FileOutputStream fileOut = new FileOutputStream(filePath)) {
            Sheet sheet = workbook.createSheet("Sheet1");

            // Get the table model
            TableModel model = table.getModel();
            
            // Create header row
            Row headerRow = sheet.createRow(0);
            for (int i = 0; i < model.getColumnCount(); i++) {
                Cell cell = headerRow.createCell(i);
                cell.setCellValue(model.getColumnName(i));
            }

            // Create data rows
            for (int rowIndex = 0; rowIndex < model.getRowCount(); rowIndex++) {
                Row row = sheet.createRow(rowIndex + 1);
                for (int colIndex = 0; colIndex < model.getColumnCount(); colIndex++) {
                    Cell cell = row.createCell(colIndex);
                    Object cellValue = model.getValueAt(rowIndex, colIndex);
                    if (cellValue != null) {
                        cell.setCellValue(cellValue.toString());
                    }
                }
            }

            // Write the output to the file
            workbook.write(fileOut);
            JOptionPane.showMessageDialog(null, "Xuất dữ liệu thành công!");

        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Lỗi xuất dữ liệu: " + e.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }
}
