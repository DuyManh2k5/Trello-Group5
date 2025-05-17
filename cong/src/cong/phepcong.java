package cong;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class phepcong extends JFrame {
    private JTextField txtSo1;
    private JTextField txtSo2;
    private JButton btnCong;
    private JLabel lblKetQua;

    public phepcong() {
        setTitle("Phép cộng đơn giản");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(5, 1));

        txtSo1 = new JTextField();
        txtSo2 = new JTextField();
        btnCong = new JButton("Cộng");
        lblKetQua = new JLabel("Kết quả: ", SwingConstants.CENTER);

        add(new JLabel("Nhập số thứ nhất:"));
        add(txtSo1);
        add(new JLabel("Nhập số thứ hai:"));
        add(txtSo2);
        add(btnCong);
        add(lblKetQua);

        btnCong.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double so1 = Double.parseDouble(txtSo1.getText());
                    double so2 = Double.parseDouble(txtSo2.getText());
                    double tong = so1 + so2;
                    lblKetQua.setText("Kết quả: " + tong);
                } catch (NumberFormatException ex) {
                    lblKetQua.setText("Vui lòng nhập số hợp lệ!");
                }
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new phepcong().setVisible(true);
        });
    }
}
