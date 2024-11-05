import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddTrainerPanel implements Card {
    private JTextField trainerIDfield;
    private JTextField trainerName;
    private JTextField trainerEmail;
    private JPanel AddTrainerPanel;
    private JTextField TrainerSepciality;
    private JTextField TrainerPhone;
    private JButton ADDtrainer;

    @Override
    public JPanel getPanel() {
        return AddTrainerPanel;
    }

    public AddTrainerPanel(Utils utils) {
        ADDtrainer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String ID = trainerIDfield.getText();
                String Phone = TrainerPhone.getText();
                String Email = trainerEmail.getText();
                String Name = trainerName.getText();
                String speciality = TrainerSepciality.getText();
                if (!(utils.validateName(Name) && utils.validateEmail(Email) && utils.validatePhone(Phone) && utils.validateTrainerID(ID))) {
                    utils.displayErrorMessage("Please enter all the fields correctly.");
                } else if (!utils.getAdminRole().addTrainer(ID,Name,Email,speciality,Phone)) {
                    utils.displayErrorMessage("This trainer already exists.");
                } else {
                    utils.displaySuccessMessage("Trainer with ID=" + ID + " Was added.");
                }
                utils.goToPage(new AdminPanel(utils));

            }
        });
    }
}
