package Pemrograman_6.Tugas1;


import javax.swing.*;
import java.awt.*;

public class FormRegistrasi {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Form Registrasi");
        frame.setSize(500,500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Komponen Input
        JTextField txtNama = new JTextField(15);
        JTextField txtEmail = new JTextField(15);
        JPasswordField txtSandi = new JPasswordField(15);

        JRadioButton rbLaki = new JRadioButton("Laki-laki");
        JRadioButton rbPerempuan = new JRadioButton("Perempuan");
        ButtonGroup bgGender = new ButtonGroup();
        bgGender.add(rbLaki);
        bgGender.add(rbPerempuan);

        JPanel panelGender = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
        panelGender.add(rbLaki);
        panelGender.add(rbPerempuan);

        String[] listProdi = {"Informatika", "Sistem Informasi", "Desain Komunikasi Visual", "Manajemen Rekayasa", "Manajemen", "Akuntansi", "Teknik Kimia", "Teknik Logistik", "Ekonomi Syariah"};
        JComboBox<String> cbProdi = new JComboBox<>(listProdi);

        JCheckBox cbCoding = new JCheckBox("Coding");
        JCheckBox cbGaming = new JCheckBox("Gaming");
        JCheckBox cbMembaca = new JCheckBox("Membaca");
        JCheckBox cbOlahraga = new JCheckBox("Olahraga");

        JPanel panelHobi = new JPanel(new GridLayout(2, 2));
        panelHobi.add(cbCoding);
        panelHobi.add(cbGaming);
        panelHobi.add(cbMembaca);
        panelHobi.add(cbOlahraga);

        JButton btnDaftar = new JButton("Daftar");

        // GridBagLayout?
        gbc.gridx = 0; gbc.gridy = 0; panel.add(new JLabel("Nama:"), gbc);
        gbc.gridx = 1; gbc.gridy = 0; panel.add(txtNama, gbc);

        gbc.gridx = 0; gbc.gridy = 1; panel.add(new JLabel("Email:"), gbc);
        gbc.gridx = 1; gbc.gridy = 1; panel.add(txtEmail, gbc);

        gbc.gridx = 0; gbc.gridy = 2; panel.add(new JLabel("Sandi:"), gbc);
        gbc.gridx = 1; gbc.gridy = 2; panel.add(txtSandi, gbc);

        gbc.gridx = 0; gbc.gridy = 3; panel.add(new JLabel("Gender:"), gbc);
        gbc.gridx = 1; gbc.gridy = 3; panel.add(panelGender, gbc);

        gbc.gridx = 0; gbc.gridy = 4; panel.add(new JLabel("Prodi:"), gbc);
        gbc.gridx = 1; gbc.gridy = 4; panel.add(cbProdi, gbc);

        gbc.gridx = 0; gbc.gridy = 5; panel.add(new JLabel("Hobi:"), gbc);
        gbc.gridx = 1; gbc.gridy = 5; panel.add(panelHobi, gbc);

        gbc.gridx = 0; gbc.gridy = 6; gbc.gridwidth = 2;
        panel.add(btnDaftar, gbc);

        // Aksi Tombol Daftar
        btnDaftar.addActionListener(e -> {
            String nama = txtNama.getText();
            String email = txtEmail.getText();
            String sandi = new String(txtSandi.getPassword());

            // Validasi sederhana
            if (nama.isEmpty() || email.isEmpty() || sandi.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Nama, Email, dan Sandi harus diisi!");
                return;
            }

            String gender = "";
            if (rbLaki.isSelected()) gender = "Laki-laki";
            else if (rbPerempuan.isSelected()) gender = "Perempuan";
            else {
                JOptionPane.showMessageDialog(frame, "Pilih gender terlebih dahulu!");
                return;
            }

            String prodi = cbProdi.getSelectedItem().toString();

            // Gabung hobi 
            String hobi = "";
            if (cbCoding.isSelected()) hobi += "Coding, ";
            if (cbGaming.isSelected()) hobi += "Gaming, ";
            if (cbMembaca.isSelected()) hobi += "Membaca, ";
            if (cbOlahraga.isSelected()) hobi += "Olahraga, ";
            if (hobi.isEmpty()) hobi = "Tidak ada";

            String hasil = "Nama: " + nama + "\n"
                         + "Email: " + email + "\n"
                         + "Sandi: " + sandi + "\n"
                         + "Gender: " + gender + "\n"
                         + "Prodi: " + prodi + "\n"
                         + "Hobi: " + hobi;

            JOptionPane.showMessageDialog(frame, hasil, "Ringkasan Registrasi", JOptionPane.INFORMATION_MESSAGE);
        });

        frame.add(panel);
        frame.setVisible(true);
    }
}


