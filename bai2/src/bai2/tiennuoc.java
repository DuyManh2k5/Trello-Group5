package bai2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class tiennuoc extends JFrame {
    private JTextField txtStart, txtEnd, txtAmount;

    public tiennuoc() {
        setTitle("Tính Tiền Nước");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(360, 300);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        // Tiêu đề
        JLabel lblTitle = new JLabel("Tính Tiền Nước");
        lblTitle.setFont(new Font("Arial", Font.ITALIC, 18));
        lblTitle.setForeground(Color.RED);
        lblTitle.setBounds(100, 10, 200, 30);
        panel.add(lblTitle);

        // Số đầu
        JLabel lblStart = new JLabel("Số đầu :");
        lblStart.setBounds(30, 60, 80, 25);
        panel.add(lblStart);

        txtStart = new JTextField();
        txtStart.setBounds(120, 60, 160, 25);
        panel.add(txtStart);

        // Số cuối
        JLabel lblEnd = new JLabel("Số cuối :");
        lblEnd.setBounds(30, 100, 80, 25);
        panel.add(lblEnd);

        txtEnd = new JTextField();
        txtEnd.setBounds(120, 100, 160, 25);
        panel.add(txtEnd);

        // Thành tiền
        JLabel lblAmount = new JLabel("Thành tiền :");
        lblAmount.setBounds(30, 140, 80, 25);
        panel.add(lblAmount);

        txtAmount = new JTextField();
        txtAmount.setEditable(false);
        txtAmount.setBounds(120, 140, 160, 25);
        panel.add(txtAmount);

        // Nút Tính
        JButton btnCalc = new JButton("Tính");
        btnCalc.setBounds(80, 190, 80, 30);
        panel.add(btnCalc);

        // Nút Thoát
        JButton btnExit = new JButton("Thoát");
        btnExit.setForeground(Color.RED);
        btnExit.setBounds(180, 190, 80, 30);
        panel.add(btnExit);

        // Xử lý sự kiện tính tiền
        btnCalc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double start = Double.parseDouble(txtStart.getText());
                    double end   = Double.parseDouble(txtEnd.getText());
                    if (end < start) {
                        JOptionPane.showMessageDialog(
                            tiennuoc.this,
                            "Số cuối phải lớn hơn hoặc bằng số đầu!",
                            "Lỗi dữ liệu",
                            JOptionPane.ERROR_MESSAGE
                        );
                        return;
                    }
                    double amount = (end - start) * 10000;
                    txtAmount.setText(String.format("%.0f", amount));
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(
                        tiennuoc.this,
                        "Vui lòng nhập số hợp lệ!",
                        "Lỗi định dạng",
                        JOptionPane.ERROR_MESSAGE
                    );
                }
            }
        });

        // Xử lý thoát
        btnExit.addActionListener(e -> System.exit(0));

        add(panel);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(tiennuoc::new);
    }
}
