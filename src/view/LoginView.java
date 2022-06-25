package view;

import infra.ConnectionFactory;
import model.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class LoginView extends JDialog{
    private JPanel mainPanel;
    private User user;
    private JTextField tfUsuario;
    private JLabel password;
    private JButton entrarButton;
    private JPasswordField pfSenha;
    private JButton Cancelar;

    public LoginView(JFrame parent) {

        setMinimumSize(new Dimension(450, 474));
        setLocationRelativeTo(parent);
        setModal(true);

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.pack();

        entrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String usuario = tfUsuario.getText();
                String senha = String.valueOf(pfSenha.getPassword());

                user = getAuthenticatedUser(usuario, senha);

                if (user != null) {
                    HomeView homeView = new HomeView(null);
                    homeView.setVisible(true);
                }else{
                    JOptionPane.showMessageDialog(LoginView.this,
                            "Login ou Senha inválidos!",
                            "Tente Novamente",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        Cancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        setVisible(true);
    }

    private User getAuthenticatedUser(String name, String password) {
        User usuario = null;

        try (Connection connection = ConnectionFactory.getConnection()) {

            Statement stmt = connection.createStatement();
            String sql = "SELECT * FROM users WHERE name=? AND password=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, password);

            ResultSet resultSet = preparedStatement.executeQuery();

            if(resultSet.next()) {
                user = new User();
                user.name = resultSet.getString("name");
                user.password = resultSet.getString("password");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }

    public static void main(String[] args) {
        LoginView loginView = new LoginView(null);
        User user = loginView.user;

        if (user != null) {
            System.out.println("Successful Authentication of: " + user.name);
            System.out.println("          Usuario: " + user.name);
        }
        else {
            System.out.println("Authentication canceled");
        }
    }
}
