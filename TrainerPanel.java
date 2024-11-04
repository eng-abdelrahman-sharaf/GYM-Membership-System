import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TrainerPanel implements Card {
    private JPanel TrainerPanel;
    private JButton logoutButton1;
    private JButton addMemberButton;
    private JButton viewRegistrationsButton;
    private JButton cancelRegistrationButton;
    private JButton registerMemberForClassButton;
    private JButton addClassButton;
    private JButton viewMembersButton;
    private JButton viewClassesButton;

    @Override
    public JPanel getPanel() {
        return TrainerPanel;
    }

    public TrainerPanel(Utils utils) {
        addClassButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //AddClassPanel
                utils.goToPage(new AddClassPanel(utils));
            }
        });

        addMemberButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //AddMember
                utils.goToPage(null);
            }
        });

        logoutButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //initialpanel
                utils.goToPage(null);
                utils.getTrainerRole().logout();
            }
        });

    }
}
