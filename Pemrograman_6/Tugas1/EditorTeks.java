package Pemrograman_6.Tugas1;

import javax.swing.*;
import java.awt.*;
import java.io.*;

public class EditorTeks {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Editor Teks");
        frame.setSize(600, 450);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        // Area Teks + ScrollPane
        JTextArea textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea);
        frame.add(scrollPane, BorderLayout.CENTER);

        // Menu Bar
        JMenuBar menuBar = new JMenuBar();
        JMenu menuFile = new JMenu("File");
        JMenuItem itemBaru = new JMenuItem("Baru");
        JMenuItem itemBuka = new JMenuItem("Buka");
        JMenuItem itemSimpan = new JMenuItem("Simpan");
        JMenuItem itemKeluar = new JMenuItem("Keluar");

        menuFile.add(itemBaru);
        menuFile.add(itemBuka);
        menuFile.add(itemSimpan);
        menuFile.addSeparator();
        menuFile.add(itemKeluar);

        JMenu menuEdit = new JMenu("Edit");
        JMenuItem itemPotong = new JMenuItem("Potong");
        JMenuItem itemSalin = new JMenuItem("Salin");
        JMenuItem itemTempel = new JMenuItem("Tempel");

        menuEdit.add(itemPotong);
        menuEdit.add(itemSalin);
        menuEdit.add(itemTempel);

        menuBar.add(menuFile);
        menuBar.add(menuEdit);
        frame.setJMenuBar(menuBar);

        // Toolbar
        JToolBar toolBar = new JToolBar();
        JButton btnBaru = new JButton("Baru");
        JButton btnBuka = new JButton("Buka");
        JButton btnSimpan = new JButton("Simpan");
        JButton btnPotong = new JButton("Potong");
        JButton btnSalin = new JButton("Salin");
        JButton btnTempel = new JButton("Tempel");

        toolBar.add(btnBaru);
        toolBar.add(btnBuka);
        toolBar.add(btnSimpan);
        toolBar.addSeparator();
        toolBar.add(btnPotong);
        toolBar.add(btnSalin);
        toolBar.add(btnTempel);
        frame.add(toolBar, BorderLayout.NORTH);

        JFileChooser fileChooser = new JFileChooser();

        // Aksi Baru
        itemBaru.addActionListener(e -> textArea.setText(""));
        btnBaru.addActionListener(e -> textArea.setText(""));

        // Aksi Buka
        itemBuka.addActionListener(e -> {
            if (fileChooser.showOpenDialog(frame) == JFileChooser.APPROVE_OPTION) {
                try {
                    File file = fileChooser.getSelectedFile();
                    BufferedReader br = new BufferedReader(new FileReader(file));
                    textArea.read(br, null);
                    br.close();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(frame, "Gagal membuka file!");
                }
            }
        });
        btnBuka.addActionListener(e -> itemBuka.doClick()); 

        // Aksi Simpan
        itemSimpan.addActionListener(e -> {
            if (fileChooser.showSaveDialog(frame) == JFileChooser.APPROVE_OPTION) {
                try {
                    File file = fileChooser.getSelectedFile();
                    BufferedWriter bw = new BufferedWriter(new FileWriter(file));
                    textArea.write(bw); 
                    bw.close();
                    JOptionPane.showMessageDialog(frame, "File tersimpan!");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(frame, "Gagal menyimpan file!");
                }
            }
        });
        btnSimpan.addActionListener(e -> itemSimpan.doClick());

        // Aksi Keluar
        itemKeluar.addActionListener(e -> {
            int pilih = JOptionPane.showConfirmDialog(frame, "Yakin ingin keluar?", "Keluar", JOptionPane.YES_NO_OPTION);
            if (pilih == JOptionPane.YES_OPTION) System.exit(0);
        });

        // Aksi Edit
        itemPotong.addActionListener(e -> textArea.cut());
        btnPotong.addActionListener(e -> textArea.cut());

        itemSalin.addActionListener(e -> textArea.copy());
        btnSalin.addActionListener(e -> textArea.copy());

        itemTempel.addActionListener(e -> textArea.paste());
        btnTempel.addActionListener(e -> textArea.paste());

        frame.setVisible(true);
    }
}