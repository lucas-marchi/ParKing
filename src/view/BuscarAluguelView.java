package view;

import javax.swing.*;

public class BuscarAluguelView extends JFrame{
    private JTextField textField1;
    private JTextField textField2;
    private JButton buscarButton;
    private JButton voltarButton;
    private JPanel pnlBuscarAluguel;

    public BuscarAluguelView(String title) {
        super(title);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(pnlBuscarAluguel);
        this.pack();

    }
}
