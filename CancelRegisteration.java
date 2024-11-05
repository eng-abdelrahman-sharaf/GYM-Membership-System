import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CancelRegisteration implements Card{
    private JPanel panel;
    private JTextField memberID;
    private JTextField classID;
    private JButton cancelRegisterationButton;

    public CancelRegisteration(Utils utils) {
        cancelRegisterationButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!utils.validateMemberID(memberID.getText())) {
                    utils.displayErrorMessage("Invalid Member ID");
                }
                else if(!utils.validateClassID(classID.getText())) {
                    utils.displayErrorMessage("Invalid Class ID");
                }
                else if(!utils.getTrainerRole().cancelRegistration(memberID.getText(), classID.getText())) {
                    utils.displayErrorMessage("Registration can't be cancelled [Not Found or more than 3 days ago]");
                }
                else{
                    utils.displaySuccessMessage("Registration cancelled successfully");
                }
                utils.goToPage(new TrainerPanel(utils));
            }
        });
    }

    @Override
    public JPanel getPanel() {
        return panel;
    }
}
