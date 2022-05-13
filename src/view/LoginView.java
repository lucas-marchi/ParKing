package view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginView extends JFrame{
    private JPanel mainPanel;
    private JLabel user;
    private JTextField textField1;
    private JLabel password;
    private JButton entrarButton;
    private JButton cadastrarButton;
    private JPasswordField passwordField1;

    public LoginView(String title) {
        super(title);

        setSize(450, 300);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.pack();
        entrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                HomeView telaHome = new HomeView(title);
                telaHome.setVisible(true);

            }
        });
        cadastrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FormCadastroView telaCadastro = new FormCadastroView(title);
                telaCadastro.setVisible(true);
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new LoginView("ParKing's Systems");
        frame.setVisible(true);
    }
}
