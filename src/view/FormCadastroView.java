package view;

import javax.swing.*;

public class FormCadastroView extends JFrame{
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JButton salvarButton;
    private JPanel cadastroPanel;

    public FormCadastroView(String title) {
        super(title);

        setLocationRelativeTo(null);

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setContentPane(cadastroPanel);
        this.pack();
    }


    public static void main(String[] args) {
        JFrame cadastroFrame = new FormCadastroView("Home");
        cadastroFrame.setVisible(true);
    }
}
