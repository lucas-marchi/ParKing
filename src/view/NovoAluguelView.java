package view;

import javax.swing.*;

public class NovoAluguelView extends JFrame{
    private JTextField nomeTextField;
    private JTextField modeloTextField;
    private JTextField identidadeTextField;
    private JTextField placaTextField;
    private JTextField endereçoTextField;
    private JTextField telefoneTextField;
    private JTextField textField1;
    private JTextField textField2;
    private JRadioButton porHoraRadioButton;
    private JRadioButton porDiaRadioButton;
    private JButton realizarAluguelButton;
    private JButton voltarButton;
    private JPanel pnlNovoAluguel;

    public NovoAluguelView(String title) {
        super(title);

        setLocationRelativeTo(null);

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setContentPane(pnlNovoAluguel);
        this.pack();
    }

    public static void main(String[] args) {
        JFrame frame = new NovoAluguelView("ParKing's Systems");
        frame.setVisible(true);
    }
}
