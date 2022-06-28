package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormCadastroView extends JDialog{
    private JTextField tfUser;
    private JButton voltarButton;
    private JPanel cadastroPanel;
    private JPasswordField pfPassword;
    private JButton salvarButton;

    public FormCadastroView(String parent) {
        super();
        setTitle("Cadastro");
        setContentPane(cadastroPanel);
        setMinimumSize(new Dimension(450, 474));
        setModal(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
        salvarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String user = tfUser.getText();
                String password = String.valueOf(pfPassword.getPassword());
            }
        });
    }

    public static void main(String[] args) {
        FormCadastroView telaCadastro = new FormCadastroView(null);
    }
}
