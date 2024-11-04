import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminPanel implements Card {

    private JPanel AdminPanel;
    private JButton addTrainerButton;
    private JButton removeTrainerButton;
    private JButton viewTrainerButton;
    private JButton logoutButton;

    @Override
    public JPanel getPanel() {
        return AdminPanel;
    }

    public AdminPanel(Utils utils) {
        addTrainerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //AddTrainerPanel
                utils.goToPage(new AddTrainerPanel(utils));
            }
        });

        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //initialpanel
                utils.goToPage(new DefaultPage(utils));
                utils.getAdminRole().logout();
            }
        });
        removeTrainerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //RemoveTrainer
                utils.goToPage(new RemoveTrainer(utils));
                utils.getAdminRole().logout();
            }
        });
    }

}
