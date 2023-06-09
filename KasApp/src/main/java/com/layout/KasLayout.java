package com.layout;


import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;

import java.io.File;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.awt.Dialog;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.Properties;
import com.code.DataTransactionManagement;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author LENOVO
 */
public class KasLayout extends javax.swing.JFrame implements DataTransactionManagement {
    String currentDirectory = System.getProperty("user.dir");
    String fileName = "data-kas.txt";

    /**
     * Creates new form Mahasiswa
     */
    public KasLayout() {
        initComponents();
        
        this.printDataTransactions();
       
    }
    
    
    public void printDataTransactions() {
       File file = new File(currentDirectory,fileName);
       try(BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] words = line.split(",");
                tbl.addRow(new Object[]{
                 words[0], words[1], words[2], words[3]
                });
                tbl_kas.setModel(tbl);
            }
         } catch (IOException e) {
                e.printStackTrace();
         }
    }
    public void changeDataTransaction(){
    int selectedRow = tbl_kas.getSelectedRow();
        
        if (selectedRow != -1) {
             JPanel panel = new JPanel();
             panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

             
             JTextField noDataField = new JTextField(50);
             JTextField tanggalField = new JTextField(50);
             JTextField saldoField = new JTextField(50);
             
             String[] keteranganOptions = {"Pemasukan", "Pengeluaran"};
             JComboBox<String> keteranganComboBox = new JComboBox<>(keteranganOptions);
             JTextField keteranganField = new JTextField(50);
             
             keteranganComboBox.addActionListener(e -> {
                String selectedOption = (String) keteranganComboBox.getSelectedItem();
                keteranganField.setText(selectedOption);
            });


             File file = new File(currentDirectory,fileName);
             // Baca file dan simpan ke dalam list
             List<String> lines = new ArrayList<>();
             try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                 String line;
                 while ((line = br.readLine()) != null) {
                     lines.add(line);
                 }
             } catch (IOException e) {
                 e.printStackTrace();
                 return;
             }
             
              
            // Ubah baris sesuai dengan indeks
            if (selectedRow >= 0 && selectedRow < lines.size()) {
                String[] dataArray = lines.get(selectedRow).split(",");
                
                noDataField.setText(dataArray[0]);
                tanggalField.setText(dataArray[1]);
                saldoField.setText(dataArray[2]);
                keteranganField.setText(dataArray[3]);
                
            } else {
                System.out.println("Invalid line index");
                return;
            }


            
             panel.add(new JLabel("No Data :"));
             panel.add(noDataField);
             panel.add(new JLabel("Tanggal :"));
             panel.add(tanggalField);
             panel.add(new JLabel("Saldo :"));
             panel.add(saldoField);
             panel.add(new JLabel("Keterangan :"));
             panel.add(keteranganComboBox);
             
             int option = JOptionPane.showOptionDialog(null, panel, "Enter Information",
                     JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, null, null);

             if (option == JOptionPane.OK_OPTION) {
                 String noData = noDataField.getText();
                 String tanggal = tanggalField.getText();
                 String saldo = saldoField.getText();
                 String keterangan = keteranganField.getText();
                 
                 this.editDataTable(noData, tanggal, saldo, keterangan);
                 tbl.setRowCount(0);
                 this.printDataTransactions();
                 JOptionPane.showMessageDialog(null, "Data Berhasil Diubah!", "Berhasil!", JOptionPane.INFORMATION_MESSAGE);

             } else {
                 System.out.println("Input canceled.");
             }
        }
    }
    public void deleteDataTransaction(){
        // TODO add your handling code here:
        int selectedRow = tbl_kas.getSelectedRow();
        
        if (selectedRow != -1) {
            DefaultTableModel model = (DefaultTableModel) tbl_kas.getModel();
            model.removeRow(selectedRow);
        }
        
        int option = JOptionPane.showConfirmDialog(null, "Apakah Anda yakin ingin menghapus data?", "Konfirmasi Penghapusan", JOptionPane.YES_NO_OPTION);

        if (option == JOptionPane.YES_OPTION) {
            File file = new File(currentDirectory,fileName);
            // Baca file dan simpan ke dalam list
            List<String> lines = new ArrayList<>();
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = br.readLine()) != null) {
                    lines.add(line);
                }
            } catch (IOException e) {
                e.printStackTrace();
                return;
            }


            // Hapus baris sesuai dengan indeks
            if (selectedRow >= 0 && selectedRow < lines.size()) {
                lines.remove(selectedRow);
            } else {
                System.out.println("Invalid line index");
                return;
            }


            // Tulis ulang isi list ke file
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
                for (String line : lines) {
                    bw.write(line);
                    bw.newLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            
            JOptionPane.showMessageDialog(null, "Data Berhasil Dihapus!", "Berhasil!", JOptionPane.INFORMATION_MESSAGE);
             
        } else {
            // Pembatalan penghapusan
            System.out.println("Penghapusan dibatalkan.");
        }
        
        
       
        
    }
    public void  insertNewDataTransaction(){
    // TODO add your handling code here:
        tbl.addRow(new Object[]{
            noDatatxt.getText(), saldotxt.getText(), tgltransaksitxt.getText(), keterangantxt.getSelectedItem()
        });
        tbl_kas.setModel(tbl);
        
      
        try {
            File file = new File(currentDirectory,fileName);
            
            if(file.createNewFile()) {
                System.out.println("File berhasil dibuat");
            } else {
                System.out.println("File sudah ada");
            }
            
         
            FileWriter fileWriter = new FileWriter(file, true);
            fileWriter.write(noDatatxt.getText() + "," + tgltransaksitxt.getText() + "," + saldotxt.getText() + "," + keterangantxt.getSelectedItem() + "\n");
            fileWriter.close();
            
            
           
        }  catch (IOException e) {
            System.out.println("ada error");
            System.out.println(e);
        }

        //reset nilai pada field
        saldotxt.setText("");
        noDatatxt.setText("");
        tgltransaksitxt.setText("");
        keterangantxt.setSelectedIndex(0);
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        noDatatxt = new javax.swing.JTextField();
        saldotxt = new javax.swing.JTextField();
        tgltransaksitxt = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        keterangantxt = new javax.swing.JComboBox<>();
        simpanbtn = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_kas = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        hapusbtn = new javax.swing.JButton();
        backbtn = new javax.swing.JButton();
        editButton = new javax.swing.JButton();
        keluarbtn = new javax.swing.JButton();
        masukbtn = new javax.swing.JButton();

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(4, 25, 68));

        jPanel2.setBackground(new java.awt.Color(91, 104, 184));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 84, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLabel1.setFont(new java.awt.Font("Segoe UI Light", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Kas Mahasiswa");
        jLabel1.setToolTipText("");

        noDatatxt.setBackground(new java.awt.Color(188, 190, 250));
        noDatatxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                noDatatxtActionPerformed(evt);
            }
        });

        saldotxt.setBackground(new java.awt.Color(188, 190, 250));
        saldotxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saldotxtActionPerformed(evt);
            }
        });

        tgltransaksitxt.setBackground(new java.awt.Color(188, 190, 250));

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Nomor Data");

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Tanggal Transaksi");

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Keterangan");

        keterangantxt.setBackground(new java.awt.Color(188, 190, 250));
        keterangantxt.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pemasukan", "Pengeluaran" }));
        keterangantxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                keterangantxtActionPerformed(evt);
            }
        });

        simpanbtn.setBackground(new java.awt.Color(188, 190, 250));
        simpanbtn.setText("Simpan");
        simpanbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                simpanbtnActionPerformed(evt);
            }
        });

        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Saldo");

        tbl_kas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "No. Data", "Tanggal", "Saldo", "Keterangan"
            }
        ));
        jScrollPane1.setViewportView(tbl_kas);

        jPanel4.setBackground(new java.awt.Color(188, 190, 250));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 48, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Tabel Data Kas");

        hapusbtn.setBackground(new java.awt.Color(188, 190, 250));
        hapusbtn.setText("Hapus");
        hapusbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hapusbtnActionPerformed(evt);
            }
        });

        backbtn.setBackground(new java.awt.Color(188, 190, 250));
        backbtn.setText("Kembali");
        backbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backbtnActionPerformed(evt);
            }
        });

        editButton.setBackground(new java.awt.Color(188, 190, 250));
        editButton.setText("Edit");
        editButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editButtonActionPerformed(evt);
            }
        });

        keluarbtn.setBackground(new java.awt.Color(188, 190, 250));
        keluarbtn.setText("Pengeluaran");
        keluarbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                keluarbtnActionPerformed(evt);
            }
        });

        masukbtn.setBackground(new java.awt.Color(188, 190, 250));
        masukbtn.setText("Pemasukan");
        masukbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                masukbtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(noDatatxt, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel8)
                            .addComponent(tgltransaksitxt, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(81, 81, 81)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(keterangantxt, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(saldotxt, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(106, 106, 106)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(183, 183, 183)
                        .addComponent(simpanbtn)))
                .addGap(55, 55, 55)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addGap(203, 203, 203))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(hapusbtn)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(editButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(masukbtn)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(keluarbtn)
                                .addGap(12, 12, 12)
                                .addComponent(backbtn))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(64, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(jLabel1)
                        .addGap(38, 38, 38)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(noDatatxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(saldotxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(keterangantxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tgltransaksitxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(simpanbtn))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(jLabel3)
                        .addGap(27, 27, 27)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(hapusbtn)
                            .addComponent(backbtn)
                            .addComponent(editButton)
                            .addComponent(masukbtn)
                            .addComponent(keluarbtn))))
                .addContainerGap(64, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void editDataTable(String noData, String tanggal, String saldo, String keterangan) {
        int selectedRow = tbl_kas.getSelectedRow();
        
        File file = new File(currentDirectory,fileName);
        // Baca file dan simpan ke dalam list
        List<String> lines = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        
        
        // Ubah baris sesuai dengan indeks
        if (selectedRow >= 0 && selectedRow < lines.size()) {
            lines.set(selectedRow, noData + "," + tanggal + "," + saldo + "," + keterangan);
        } else {
            System.out.println("Invalid line index");
            return;
        }

       
        // Tulis ulang isi list ke file
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
            for (String line : lines) {
                bw.write(line);
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private void backbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backbtnActionPerformed
        // TODO add your handling code here:
        dispose();
        MenuLayout back = new MenuLayout();
        back.setVisible(true);
    }//GEN-LAST:event_backbtnActionPerformed

    private void hapusbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hapusbtnActionPerformed
        this.deleteDataTransaction();
    }//GEN-LAST:event_hapusbtnActionPerformed

    private void simpanbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simpanbtnActionPerformed
        this.insertNewDataTransaction();
    }//GEN-LAST:event_simpanbtnActionPerformed

    private void keterangantxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_keterangantxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_keterangantxtActionPerformed

    private void saldotxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saldotxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_saldotxtActionPerformed

    private void noDatatxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_noDatatxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_noDatatxtActionPerformed

    
    private void editButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editButtonActionPerformed
        this.changeDataTransaction();
        
    }//GEN-LAST:event_editButtonActionPerformed

    private void keluarbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_keluarbtnActionPerformed
        // TODO add your handling code here:
        dispose();
        LaporanKeluar keluar = new LaporanKeluar();
        keluar.setVisible(true);
    }//GEN-LAST:event_keluarbtnActionPerformed

    private void masukbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_masukbtnActionPerformed
        // TODO add your handling code here:
        dispose();
        LaporanMasuk masuk = new LaporanMasuk();
        masuk.setVisible(true);
    }//GEN-LAST:event_masukbtnActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(KasLayout.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(KasLayout.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(KasLayout.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(KasLayout.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new KasLayout().setVisible(true);
            }
        });
    }
    
    
    public class NonEditableTableModel extends DefaultTableModel {
    public NonEditableTableModel(Object[] columnNames, int rowCount) {
        super(columnNames, rowCount);
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
        }
    }
    
    int Baris =0;
    static Object kolom[]= {"No. Data", "Tanggal", "Saldo", "Keterangan"};
//    DefaultTableModel tbl = new DefaultTableModel(kolom,Baris);
    NonEditableTableModel tbl = new NonEditableTableModel(kolom, Baris);
//    JTable tbl = new JTable(model);
    
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backbtn;
    private javax.swing.JButton editButton;
    private javax.swing.JButton hapusbtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton keluarbtn;
    private javax.swing.JComboBox<String> keterangantxt;
    private javax.swing.JButton masukbtn;
    private javax.swing.JTextField noDatatxt;
    private javax.swing.JTextField saldotxt;
    private javax.swing.JButton simpanbtn;
    private javax.swing.JTable tbl_kas;
    private javax.swing.JTextField tgltransaksitxt;
    // End of variables declaration//GEN-END:variables
}
