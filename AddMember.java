import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddMember implements Card {
    private JPanel panel;
    private JTextField IDfield;
    private JTextField PhoneField;
    private JTextField EmailField;
    private JTextField NameField;
    private JButton ADDButton;
    private JComboBox MembershipType;
    private JComboBox Status;

    @Override
    public JPanel getPanel() {
        return panel;
    }

    public AddMember(Utils utils)  {
        ADDButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String ID = IDfield.getText();
                String Phone = PhoneField.getText();
                String Email = EmailField.getText();
                String Name = NameField.getText();
                String status = Status.getSelectedItem().toString();
                String membershiptype = MembershipType.getSelectedItem().toString();
                if (!(utils.validateName(Name) && utils.validateEmail(Email) && utils.validatePhone(Phone) && utils.validateMemberID(ID))) {
                    utils.displayErrorMessage("Please enter all the fields correctly.");
                } else if (!utils.getTrainerRole().addMember(ID, Name, membershiptype, Email, Phone, status)) {
                    utils.displayErrorMessage( "Member already exists.");
                } else {
                    utils.displaySuccessMessage("Member with ID=" + ID + " was added.");
                }
                utils.goToPage(new TrainerPanel(utils));
            }
        });
    }

}
