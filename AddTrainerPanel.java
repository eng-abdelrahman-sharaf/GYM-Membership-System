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
                    JOptionPane.showMessageDialog(null, "Please enter all the fields correctly.");
                    //AdminPanel
                    utils.goToPage(new AdminPanel(utils));
                } else if (!utils.getAdminRole().addTrainer(ID,Name,Email,speciality,Phone)) {
                    JOptionPane.showMessageDialog(null, "Trainer already exists.");
                    //AdminPanel
                    utils.goToPage(new AdminPanel(utils));
                } else {
                    JOptionPane.showMessageDialog(null, "Trainer with ID=" + ID + " Was added.", "", JOptionPane.INFORMATION_MESSAGE);
                    //AdminPanel
                    utils.goToPage(new AdminPanel(utils));
                }

            }
        });
    }
}
