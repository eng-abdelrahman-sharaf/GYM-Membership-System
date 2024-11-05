import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TrainerLogin implements Card {
    private JButton Login;
    private JTextField UserName;
    private JTextField Password;
    private JPanel panel;

    @Override
    public JPanel getPanel() {
        return panel;
    }

    public TrainerLogin(Utils utils) {
        Login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!UserName.getText().equals(LoginCredentials.TRAINER_USERNAME) || !Password.getText().equals(LoginCredentials.TRAINER_PASSWORD)) {
                    utils.displayErrorMessage("Wrong Username or Password");
                    utils.goToPage(new DefaultPage(utils));
                }
                else{
                    utils.goToPage(new TrainerPanel(utils));
                }
            }
        });
    }
}
