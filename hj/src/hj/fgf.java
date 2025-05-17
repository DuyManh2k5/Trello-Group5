package hj;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class fgf extends JFrame {
    private JTextField txtSo1, txtSo2;
    private JButton btnChia;
    private JLabel lblKetQua;

    public fgf() {
        setTitle("Phép chia hai số");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(4, 2, 5, 5));

        txtSo1 = new JTextField();
        txtSo2 = new JTextField();
        btnChia = new JButton("Chia");
        lblKetQua = new JLabel("Kết quả: ");

        add(new JLabel("Số thứ nhất:"));
        add(txtSo1);
        add(new JLabel("Số thứ hai:"));
        add(txtSo2);
        add(btnChia);
        add(lblKetQua);

        btnChia.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    double so1 = Double.parseDouble(txtSo1.getText());
                    double so2 = Double.parseDouble(txtSo2.getText());

                    if (so2 == 0) {
                        lblKetQua.setText("Không thể chia cho 0");
                    } else {
                        double ketQua = so1 / so2;
                        lblKetQua.setText("Kết quả: " + ketQua);
                    }
                } catch (NumberFormatException ex) {
                    lblKetQua.setText("Vui lòng nhập số hợp lệ");
                }
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new fgf().setVisible(true);
        });
    }
}
