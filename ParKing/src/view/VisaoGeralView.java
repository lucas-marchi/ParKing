package view;

import javax.swing.*;

public class VisaoGeralView extends JFrame{
    private JPanel pnlVisaoGeral;

    public VisaoGeralView(String title) {
        super(title);

        setLocationRelativeTo(null);

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setContentPane(pnlVisaoGeral);
        this.pack();
    }
}
