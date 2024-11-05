import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RemoveTrainer implements Card {
    private JPanel RemoveTrainer;
    private JButton removeButton;
    private JTextField TrainerIDtoRemove;

    @Override
    public JPanel getPanel() {
        return RemoveTrainer;
    }

    public RemoveTrainer(Utils utils) {
        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String ID = TrainerIDtoRemove.getText();
                if(!utils.validateTrainerID(ID)){
                    utils.displayErrorMessage("Invalid Trainer ID");
                }
                else if(utils.getAdminRole().removeTrainer(ID))
                    utils.displaySuccessMessage("Trainer with ID=" + ID + " was deleted.");
                else
                    utils.displayErrorMessage( "Trainer does not exist.");
                utils.goToPage(new AdminPanel(utils));
            }
        });
    }
}
