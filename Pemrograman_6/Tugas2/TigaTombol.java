package Pemrograman_6.Tugas2;
import javax.swing.*;
import java.awt.*;

public class TigaTombol {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Tiga Tombol");
        frame.setSize(400, 150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        // GridLayout 1 x 3 :
        frame.setLayout(new GridLayout(1, 3, 10, 10));

        JButton btn1 = new JButton("Tombol 1");
        JButton btn2 = new JButton("Tombol 2");
        JButton btn3 = new JButton("Tombol 3");

        frame.add(btn1);
        frame.add(btn2);
        frame.add(btn3);

        frame.setVisible(true);
    }
}
