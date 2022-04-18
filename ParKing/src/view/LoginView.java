package view;

import javax.swing.*;

public class LoginView extends JFrame{
    private JPanel mainPanel;
    private JLabel user;
    private JTextField textField1;
    private JLabel password;
    private JTextField textField2;
    private JButton entrarButton;
    private JButton cadastrarButton;

    public LoginView(String title) {
        super(title);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.pack();
    }

    public static void main(String[] args) {
        JFrame frame = new LoginView("ParKing's Systems");
        frame.setVisible(true);
    }
}
