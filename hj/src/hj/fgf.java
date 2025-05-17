package hj;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class fgf extends JFrame {
    private JTextField txtChieuDai, txtChieuRong, txtDienTich;
    private JButton btnTinh, btnThoat;

    public fgf() {
        setTitle("Tính diện tích hình chữ nhật");
        setSize(400, 250);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(5, 2, 10, 10));

        // Tạo các thành phần
        JLabel lblChieuDai = new JLabel("Chiều dài:");
        JLabel lblChieuRong = new JLabel("Chiều rộng:");
        JLabel lblDienTich = new JLabel("Diện tích:");

        txtChieuDai = new JTextField();
        txtChieuRong = new JTextField();
        txtDienTich = new JTextField();
        txtDienTich.setEditable(false);

        btnTinh = new JButton("Tính");
        btnThoat = new JButton("Thoát");

        // Thêm sự kiện cho nút "Tính"
        btnTinh.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    double dai = Double.parseDouble(txtChieuDai.getText());
                    double rong = Double.parseDouble(txtChieuRong.getText());
                    double dientich = dai * rong;
                    txtDienTich.setText(String.valueOf(dientich));
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(fgf.this, "Vui lòng nhập số hợp lệ!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Thêm sự kiện cho nút "Thoát"
        btnThoat.addActionListener(e -> System.exit(0));

        // Thêm thành phần vào JFrame
        add(lblChieuDai); add(txtChieuDai);
        add(lblChieuRong); add(txtChieuRong);
        add(lblDienTich); add(txtDienTich);
        add(btnTinh); add(btnThoat);

        setVisible(true);
    }

    public static void main(String[] args) {
        new fgf();
    }
}
