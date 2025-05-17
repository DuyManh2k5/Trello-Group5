package gydt;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class uigui extends JFrame {
    private JTextField txtChieuDai, txtChieuRong, txtKetQua;
    private JButton btnTinh;

    public uigui() {
        setTitle("Tính diện tích hình chữ nhật");
        setSize(350, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // căn giữa màn hình

        // Tạo các thành phần
        JLabel lblChieuDai = new JLabel("Chiều dài:");
        JLabel lblChieuRong = new JLabel("Chiều rộng:");
        JLabel lblKetQua = new JLabel("Diện tích:");

        txtChieuDai = new JTextField(10);
        txtChieuRong = new JTextField(10);
        txtKetQua = new JTextField(15);
        txtKetQua.setEditable(false);

        btnTinh = new JButton("Tính");

        // Bắt sự kiện
        btnTinh.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    double dai = Double.parseDouble(txtChieuDai.getText());
                    double rong = Double.parseDouble(txtChieuRong.getText());
                    double dt = dai * rong;
                    txtKetQua.setText(String.valueOf(dt));
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Vui lòng nhập số hợp lệ!");
                }
            }
        });

        // Thiết kế layout
        setLayout(new GridLayout(4, 2, 5, 5));
        add(lblChieuDai);
        add(txtChieuDai);
        add(lblChieuRong);
        add(txtChieuRong);
        add(lblKetQua);
        add(txtKetQua);
        add(new JLabel()); // khoảng trống
        add(btnTinh);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new uigui().setVisible(true);
        });
    }
}