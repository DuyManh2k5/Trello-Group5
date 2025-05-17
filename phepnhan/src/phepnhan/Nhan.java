package phepnhan;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Nhan extends JFrame {
    private JTextField txtSo1, txtSo2, txtKetQua;
    private JButton btnNhan;
    
    public Nhan() {
        // Thiết lập frame
        setTitle("Phép Nhân - VCL");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        // Tạo panel chính
        JPanel panel = new JPanel(new GridLayout(4, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        // Thêm các thành phần
        panel.add(new JLabel("Số thứ nhất:"));
        txtSo1 = new JTextField();
        panel.add(txtSo1);
        
        panel.add(new JLabel("Số thứ hai:"));
        txtSo2 = new JTextField();
        panel.add(txtSo2);
        
        panel.add(new JLabel("Kết quả:"));
        txtKetQua = new JTextField();
        txtKetQua.setEditable(false);
        panel.add(txtKetQua);
        
        btnNhan = new JButton("Nhân");
        btnNhan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                thucHienPhepNhan();
            }
        });
        panel.add(new JLabel()); // Placeholder
        panel.add(btnNhan);
        
        // Thêm panel vào frame
        add(panel);
    }
    
    private void thucHienPhepNhan() {
        try {
            double so1 = Double.parseDouble(txtSo1.getText());
            double so2 = Double.parseDouble(txtSo2.getText());
            double ketQua = so1 * so2;
            txtKetQua.setText(String.valueOf(ketQua));
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập số hợp lệ!", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Nhan().setVisible(true);
            }
        });
    }
}
