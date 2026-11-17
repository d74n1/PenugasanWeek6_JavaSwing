package Pemrograman_6.Tugas1;



import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DataMahasiswa {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Data Mahasiswa");
        frame.setSize(600, 420);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new BorderLayout(10, 10));

        // Panel Form Input
        JPanel panelInput = new JPanel(new GridLayout(5, 2, 5, 5));
        panelInput.setBorder(BorderFactory.createEmptyBorder(10, 10, 0, 10));

        JTextField txtNim = new JTextField();
        JTextField txtNama = new JTextField();
        JTextField txtProdi = new JTextField();
        JTextField txtIpk = new JTextField();

        JButton btnTambah = new JButton("Tambah");
        JButton btnUbah = new JButton("Ubah");
        JButton btnHapus = new JButton("Hapus");

        JPanel panelTombol = new JPanel(new FlowLayout());
        panelTombol.add(btnTambah);
        panelTombol.add(btnUbah);
        panelTombol.add(btnHapus);

        panelInput.add(new JLabel("NIM:"));
        panelInput.add(txtNim);
        panelInput.add(new JLabel("Nama:"));
        panelInput.add(txtNama);
        panelInput.add(new JLabel("Prodi:"));
        panelInput.add(txtProdi);
        panelInput.add(new JLabel("IPK:"));
        panelInput.add(txtIpk);
        panelInput.add(new JLabel("Aksi:"));
        panelInput.add(panelTombol);

        frame.add(panelInput, BorderLayout.NORTH);

        // Tabel
        String[] kolom = {"NIM", "Nama", "Prodi", "IPK"};
        DefaultTableModel model = new DefaultTableModel(kolom, 0);
        JTable table = new JTable(model);
        frame.add(new JScrollPane(table), BorderLayout.CENTER);

        // Contoh data 
        model.addRow(new Object[]{"202601001", "Budi Santoso", "Informatika", "3.75"});

        // Data masuk ke TextField
        table.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                int baris = table.getSelectedRow();
                if (baris != -1) {
                    txtNim.setText(model.getValueAt(baris, 0).toString());
                    txtNama.setText(model.getValueAt(baris, 1).toString());
                    txtProdi.setText(model.getValueAt(baris, 2).toString());
                    txtIpk.setText(model.getValueAt(baris, 3).toString());
                }
            }
        });

        // Tombol Tambah
        btnTambah.addActionListener(e -> {
            String nim = txtNim.getText();
            String nama = txtNama.getText();
            String prodi = txtProdi.getText();
            String ipk = txtIpk.getText();

            if (nim.isEmpty() || nama.isEmpty() || prodi.isEmpty() || ipk.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Semua kolom harus diisi!");
                return;
            }

            try {
                double nilaiIpk = Double.parseDouble(ipk);
                if (nilaiIpk < 0 || nilaiIpk > 4.0) {
                    JOptionPane.showMessageDialog(frame, "IPK harus antara 0.0 - 4.0!");
                    return;
                }
                model.addRow(new Object[]{nim, nama, prodi, nilaiIpk});
                txtNim.setText(""); txtNama.setText(""); txtProdi.setText(""); txtIpk.setText("");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "IPK harus berupa angka!");
            }
        });

        // Tombol Ubah
        btnUbah.addActionListener(e -> {
            int baris = table.getSelectedRow();
            if (baris == -1) {
                JOptionPane.showMessageDialog(frame, "Pilih baris di tabel yang mau diubah!");
                return;
            }

            try {
                double nilaiIpk = Double.parseDouble(txtIpk.getText());
                if (nilaiIpk < 0 || nilaiIpk > 4.0) {
                    JOptionPane.showMessageDialog(frame, "IPK harus antara 0.0 - 4.0!");
                    return;
                }
                model.setValueAt(txtNim.getText(), baris, 0);
                model.setValueAt(txtNama.getText(), baris, 1);
                model.setValueAt(txtProdi.getText(), baris, 2);
                model.setValueAt(nilaiIpk, baris, 3);

                JOptionPane.showMessageDialog(frame, "Data berhasil diubah!");
                txtNim.setText(""); txtNama.setText(""); txtProdi.setText(""); txtIpk.setText("");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "IPK harus berupa angka!");
            }
        });

        // Tombol Hapus
        btnHapus.addActionListener(e -> {
            int baris = table.getSelectedRow();
            if (baris != -1) {
                model.removeRow(baris);
                txtNim.setText(""); txtNama.setText(""); txtProdi.setText(""); txtIpk.setText("");
            } else {
                JOptionPane.showMessageDialog(frame, "Pilih baris yang mau dihapus!");
            }
        });

        frame.setVisible(true);
    }
}