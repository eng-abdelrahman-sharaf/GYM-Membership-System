import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminLogin implements Card {
    private JPanel panel;
    private JButton Login;
    private JTextField UserName;
    private JTextField Password;

    public AdminLogin(Utils utils) {

        Login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!UserName.getText().equals(LoginCredentials.ADMIN_USERNAME) || !Password.getText().equals(LoginCredentials.ADMIN_PASSWORD)) {
                    utils.displayErrorMessage("Wrong Username or Password");
                    utils.goToPage(new DefaultPage(utils));
                }
                else {
                    utils.goToPage(new AdminPanel(utils));
                }
            }
        });
    }

    @Override
    public JPanel getPanel() {
        return panel;
    }
}
