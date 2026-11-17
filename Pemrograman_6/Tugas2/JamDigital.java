package Pemrograman_6.Tugas2;
import javax.swing.*;
import java.awt.*;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class JamDigital {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Jam Digital");
        frame.setSize(400, 220);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        // Menu Bar 
        JMenuBar menuBar = new JMenuBar();

        JMenu menuFile = new JMenu("File");
        JMenuItem itemKeluar = new JMenuItem("Keluar");
        menuFile.add(itemKeluar);

        JMenu menuBantuan = new JMenu("Bantuan");
        JMenuItem itemTentang = new JMenuItem("Tentang");
        menuBantuan.add(itemTentang);

        menuBar.add(menuFile);
        menuBar.add(menuBantuan);
        frame.setJMenuBar(menuBar);

        // Aksi Menu Keluar 
        itemKeluar.addActionListener(e -> {
            int konfirmasi = JOptionPane.showConfirmDialog(frame,
                "Yakin ingin keluar dari aplikasi?",
                "Konfirmasi Keluar", JOptionPane.YES_NO_OPTION);
            if (konfirmasi == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
        });

        // Aksi Menu Tentang 
        itemTentang.addActionListener(e -> {
            JOptionPane.showMessageDialog(frame,
                "Aplikasi Jam Digital v1.0\nDibuat untuk Tugas 2 Pemrograman GUI Java Swing.",
                "Tentang Aplikasi", JOptionPane.INFORMATION_MESSAGE);
        });

        // Jam Digital dengan javax.swing.Timer
        JLabel lblJam = new JLabel("", SwingConstants.CENTER);
        lblJam.setFont(new Font("SansSerif", Font.BOLD, 42));
        frame.add(lblJam, BorderLayout.CENTER);

        DateTimeFormatter formatWaktu = DateTimeFormatter.ofPattern("HH:mm:ss");
        lblJam.setText(LocalTime.now().format(formatWaktu)); 

        Timer timer = new Timer(1000, e -> {
            String waktuSekarang = LocalTime.now().format(formatWaktu);
            lblJam.setText(waktuSekarang);
        });
        timer.start();

        frame.setVisible(true);
    }
}
