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
                utils.goToPage(new AddMember(utils));
            }
        });

        logoutButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //initialpanel
                utils.goToPage(new DefaultPage(utils));
                utils.getTrainerRole().logout();
            }
        });

        cancelRegistrationButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                utils.goToPage(new CancelRegisteration(utils));
            }
        });
        viewMembersButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                utils.goToPage(new ViewMembers(utils));
            }
        });
        viewClassesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                utils.goToPage(new ViewClasses(utils));
            }
        });
        viewRegistrationsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                utils.goToPage(new ViewRegistrations(utils));
            }
        });
    }
}
