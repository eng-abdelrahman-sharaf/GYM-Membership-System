import jdk.jshell.Snippet;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FirstPage extends JFrame {
    private JButton adminRoleButton;
    private JPanel MainPanel;
    private JButton Adminbutton;
    private JButton logoutButton;
    private JButton addTrainerButton;
    private JButton removeTrainerButton;
    private JButton viewTrainerButton;
    private JButton Trainerbutton;
    private JPanel AdminPanel;
    private JPanel TrainerPanel;
    private JButton logoutButton1;
    private JButton addMemberButton;
    private JButton viewRegistrationsButton;
    private JButton cancelRegistrationButton;
    private JButton registerMemberForClassButton;
    private JButton addClassButton;
    private JButton viewMembersButton;
    private JButton viewClassesButton;
    private JPanel AddMember;
    private JTextField IDfield;
    private JTextField PhoneField;
    private JTextField EmailField;
    private JTextField NameField;
    private JButton ADDButton;
    private JComboBox MembershipType;
    private JComboBox Status;
    private Validation v = new Validation();
    public FirstPage() {
        setVisible(true);
        setSize(new Dimension(400,400));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(MainPanel);
        Adminbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainPanel.removeAll();
                MainPanel.add(AdminPanel);
                MainPanel.repaint();
                MainPanel.revalidate();
            }
        });
        Trainerbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainPanel.removeAll();
                MainPanel.add(TrainerPanel);
                MainPanel.repaint();
                MainPanel.revalidate();
            }
        });
        addMemberButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainPanel.removeAll();
                MainPanel.add(AddMember);
                MainPanel.repaint();
                MainPanel.revalidate();
            }
        });
        ADDButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TrainerRole tr = new TrainerRole();
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
                }
                else if (!tr.addMember(ID,Name,membershiptype, Email, Phone,status)) {
                    JOptionPane.showMessageDialog(null, "Member already exists.");
                    MainPanel.removeAll();
                    MainPanel.add(TrainerPanel);
                    MainPanel.repaint();
                    MainPanel.revalidate();
                }
                else {
                        JOptionPane.showMessageDialog(null, "Member with ID=" + ID + " Was added.","", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
        addClassButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

}
