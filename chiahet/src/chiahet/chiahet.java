package chiahet;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class chiahet extends JFrame {
    private JTextField txtA, txtB;
    private JButton btnCheck;
    private JLabel lblResult;

    public chiahet() {
        // Thiết lập frame
        setTitle("Kiểm Tra Chia Hết");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        // Panel đầu vào
        JPanel inputPanel = new JPanel(new GridLayout(2, 2, 10, 10));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        inputPanel.add(new JLabel("Nhập số a:"));
        txtA = new JTextField();
        inputPanel.add(txtA);
        
        inputPanel.add(new JLabel("Nhập số b:"));
        txtB = new JTextField();
        inputPanel.add(txtB);

        // Panel button
        JPanel buttonPanel = new JPanel();
        btnCheck = new JButton("Kiểm tra chia hết");
        buttonPanel.add(btnCheck);

        // Panel kết quả
        JPanel resultPanel = new JPanel();
        lblResult = new JLabel("Kết quả sẽ hiển thị ở đây");
        lblResult.setFont(new Font("Arial", Font.BOLD, 14));
        resultPanel.add(lblResult);

        // Thêm các panel vào frame
        add(inputPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
        add(resultPanel, BorderLayout.NORTH);

        // Xử lý sự kiện nút kiểm tra
        btnCheck.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkDivisible();
            }
        });
    }

    private void checkDivisible() {
        try {
            int a = Integer.parseInt(txtA.getText());
            int b = Integer.parseInt(txtB.getText());
            
            if (b == 0) {
                lblResult.setText("Không thể chia cho 0!");
                lblResult.setForeground(Color.RED);
                return;
            }
            
            if (a % b == 0) {
                lblResult.setText(a + " chia hết cho " + b);
                lblResult.setForeground(Color.GREEN);
            } else {
                lblResult.setText(a + " KHÔNG chia hết cho " + b);
                lblResult.setForeground(Color.RED);
            }
        } catch (NumberFormatException ex) {
            lblResult.setText("Vui lòng nhập số nguyên hợp lệ!");
            lblResult.setForeground(Color.RED);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new chiahet().setVisible(true);
            }
        });
    }
}
