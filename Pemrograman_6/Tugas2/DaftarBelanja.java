package Pemrograman_6.Tugas2;
import javax.swing.*;
import java.awt.*;

public class DaftarBelanja {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Daftar Belanja");
        frame.setSize(400, 350);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new BorderLayout(10, 10));

        // Panel Atas: Input & Tombol Tambah
        JPanel panelAtas = new JPanel(new BorderLayout(5, 5));
        panelAtas.setBorder(BorderFactory.createEmptyBorder(10, 10, 0, 10));
        JTextField txtItem = new JTextField();
        JButton btnTambah = new JButton("Tambah");

        panelAtas.add(txtItem, BorderLayout.CENTER);
        panelAtas.add(btnTambah, BorderLayout.EAST);
        frame.add(panelAtas, BorderLayout.NORTH);
        DefaultListModel<String> listModel = new DefaultListModel<>();
        JList<String> listBelanja = new JList<>(listModel);
        frame.add(new JScrollPane(listBelanja), BorderLayout.CENTER);

        // Tombol Hapus Terpilih
        JButton btnHapus = new JButton("Hapus Terpilih");
        JPanel panelBawah = new JPanel();
        panelBawah.add(btnHapus);
        frame.add(panelBawah, BorderLayout.SOUTH);

        // Aksi Tambah
        btnTambah.addActionListener(e -> {
            String item = txtItem.getText().trim();
            if (item.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Masukkan nama barang terlebih dahulu!");
            } else {
                listModel.addElement(item);
                txtItem.setText("");
            }
        });

        // Aksi Hapus Terpilih
        btnHapus.addActionListener(e -> {
            int indexTerpilih = listBelanja.getSelectedIndex();
            if (indexTerpilih != -1) {
                listModel.remove(indexTerpilih);
            } else {
                JOptionPane.showMessageDialog(frame, "Pilih item di daftar yang ingin dihapus!");
            }
        });

        frame.setVisible(true);
    }
}
