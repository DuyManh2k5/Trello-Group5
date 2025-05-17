package hj;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class jgd extends JFrame {
    private JTextField txtChieuDai, txtChieuRong, txtDienTich;
    private JButton btnTinh;

    public jgd() {
        setTitle("Tính Diện Tích Hình Chữ Nhật");
        setSize(350, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(4, 2, 10, 10));

        JLabel lblChieuDai = new JLabel("Chiều dài:");
        JLabel lblChieuRong = new JLabel("Chiều rộng:");
        JLabel lblDienTich = new JLabel("Diện tích:");

        txtChieuDai = new JTextField();
        txtChieuRong = new JTextField();
        txtDienTich = new JTextField();
        txtDienTich.setEditable(false);

        btnTinh = new JButton("Tính");

        add(lblChieuDai); add(txtChieuDai);
        add(lblChieuRong); add(txtChieuRong);
        add(lblDienTich); add(txtDienTich);
        add(new JLabel()); add(btnTinh);

        btnTinh.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    double dai = Double.parseDouble(txtChieuDai.getText());
                    double rong = Double.parseDouble(txtChieuRong.getText());
                    double dientich = dai * rong;
                    txtDienTich.setText(String.valueOf(dientich));
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(jgd.this, "Vui lòng nhập số hợp lệ!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new jgd().setVisible(true));
    }
}