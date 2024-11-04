import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddMember {
    private JPanel AddMember;
    private JTextField IDfield;
    private JTextField PhoneField;
    private JTextField EmailField;
    private JTextField NameField;
    private JButton ADDButton;
    private JComboBox MembershipType;
    private JComboBox Status;


    public AddMember(Utils utils) {
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
                    JOptionPane.showMessageDialog(null, "Please enter all the fields correctly.");
                    //TrainerPanel
                    utils.goToPage(new TrainerPanel(utils));
                } else if (!utils.getTrainerRole().addMember(ID, Name, membershiptype, Email, Phone, status)) {
                    JOptionPane.showMessageDialog(null, "Member already exists.");
                    utils.goToPage(new TrainerPanel(utils));
                } else {
                    JOptionPane.showMessageDialog(null, "Member with ID=" + ID + " Was added.", "", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
    }

}
