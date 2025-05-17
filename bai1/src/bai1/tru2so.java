package bai1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class tru2so extends JFrame {
    private JTextField txtA, txtB, txtResult;

    public tru2so() {
        setTitle("Tính toán đơn giản");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(350, 300);
        setLocationRelativeTo(null); // căn giữa màn hình

        // Panel chính
        JPanel panel = new JPanel();
        panel.setLayout(null); // sử dụng absolute layout

        // Tiêu đề
        JLabel lblTitle = new JLabel("Trừ 2 số");
        lblTitle.setFont(new Font("Arial", Font.ITALIC, 18));
        lblTitle.setForeground(Color.RED);
        lblTitle.setBounds(132, 11, 80, 30);
        panel.add(lblTitle);

        // Nhãn và ô nhập Số a
        JLabel lblA = new JLabel("Số a :");
        lblA.setBounds(30, 50, 60, 25);
        panel.add(lblA);

        txtA = new JTextField();
        txtA.setBounds(100, 50, 150, 25);
        panel.add(txtA);

        // Nhãn và ô nhập Số b
        JLabel lblB = new JLabel("Số b :");
        lblB.setBounds(30, 90, 60, 25);
        panel.add(lblB);

        txtB = new JTextField();
        txtB.setBounds(100, 90, 150, 25);
        panel.add(txtB);

        // Nhãn và ô hiển thị kết quả
        JLabel lblResult = new JLabel("Kết quả :");
        lblResult.setBounds(30, 130, 60, 25);
        panel.add(lblResult);

        txtResult = new JTextField();
        txtResult.setEditable(false);
        txtResult.setBounds(100, 130, 150, 25);
        panel.add(txtResult);

        // Nút Trừ
        JButton btnSubtract = new JButton("Tính");
        btnSubtract.setBounds(80, 170, 80, 30);
        panel.add(btnSubtract);

        // Nút Thoát
        JButton btnExit = new JButton("Thoát");
        btnExit.setForeground(Color.RED);
        btnExit.setBounds(180, 170, 80, 30);
        panel.add(btnExit);

        // Sự kiện nút "Trừ"
        btnSubtract.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    double a = Double.parseDouble(txtA.getText());
                    double b = Double.parseDouble(txtB.getText());
                    double result = a - b;
                    txtResult.setText(String.valueOf(result));
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null,
                        "Vui lòng nhập số hợp lệ!",
                        "Lỗi",
                        JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Sự kiện nút "Thoát"
        btnExit.addActionListener(e -> System.exit(0));

        getContentPane().add(panel);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(tru2so::new);
    }
}
