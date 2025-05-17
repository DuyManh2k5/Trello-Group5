package lambai;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Circle extends JFrame {
    private JTextField txtBanKinh;
    private JButton btnTinh;
    private JLabel lblKetQua;

    public Circle() {
        setTitle("Tính diện tích hình tròn");
        setSize(300, 180);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(4, 1));

        txtBanKinh = new JTextField();
        btnTinh = new JButton("Tính diện tích");
        lblKetQua = new JLabel("Diện tích: ", SwingConstants.CENTER);

        add(new JLabel("Nhập bán kính (r):"));
        add(txtBanKinh);
        add(btnTinh);
        add(lblKetQua);

        btnTinh.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double r = Double.parseDouble(txtBanKinh.getText());
                    if (r < 0) {
                        lblKetQua.setText("Bán kính không hợp lệ!");
                        return;
                    }
                    double dienTich = Math.PI * r * r;
                    lblKetQua.setText("Diện tích: " + String.format("%.2f", dienTich));
                } catch (NumberFormatException ex) {
                    lblKetQua.setText("Vui lòng nhập số hợp lệ!");
                }
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Circle().setVisible(true);
        });
    }
}
