import backend.Class;

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

    public AddMember(JPanel MainPanel) {

        ADDButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String ID = IDfield.getText();
                String Phone = PhoneField.getText();
                String Email = EmailField.getText();
                String Name = NameField.getText();
                String status = Status.getSelectedItem().toString();
                String membershiptype = MembershipType.getSelectedItem().toString();
                if (!(v.validateName(Name) && v.validateEmail(Email) && v.validatePhone(Phone) && v.validateMemberID(ID))) {
                    JOptionPane.showMessageDialog(null, "Please enter all the fields correctly.");
                    MainPanel.removeAll();
                    MainPanel.add(TrainerPanel);
                    MainPanel.repaint();
                    MainPanel.revalidate();
                } else if (!tr.addMember(ID, Name, membershiptype, Email, Phone, status)) {
                    JOptionPane.showMessageDialog(null, "Member already exists.");
                    MainPanel.removeAll();
                    MainPanel.add(TrainerPanel);
                    MainPanel.repaint();
                    MainPanel.revalidate();
                } else {
                    JOptionPane.showMessageDialog(null, "Member with ID=" + ID + " Was added.", "", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
    }

}
