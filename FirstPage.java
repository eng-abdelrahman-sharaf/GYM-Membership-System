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
    private JPanel AddClassPanel;
    private JTextField ClassIDfield;
    private JTextField TrainerIDField;
    private JTextField ClassNameField;
    private JSpinner DurationSpinner;
    private JSpinner MaxSpinner;
    private JButton ADD;
    private JPanel initialpanel;
    private JTextField TrainerSepciality;
    private JTextField trainerIDfield;
    private JTextField trainerName;
    private JTextField trainerEmail;
    private JTextField TrainerPhone;
    private JPanel AddTrainerPanel;
    private JButton ADDtrainer;
    private JPanel RemoveTrainer;
    private JButton removeButton;
    private JTextField TrainerIDtoRemove;

    private Validation v = new Validation();
    private TrainerRole tr = new TrainerRole();
    private AdminRole ar = new AdminRole();
    public FirstPage() {
        setVisible(true);
        setSize(new Dimension(400, 400));
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
        addClassButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainPanel.removeAll();
                MainPanel.add(AddClassPanel);
                MainPanel.repaint();
                MainPanel.revalidate();
            }
        });



        ADD.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String ClassID = ClassIDfield.getText();
                String ClassName = NameField.getText();
                int ClassDuration = (int)DurationSpinner.getValue();
                String TrainerID = TrainerIDField.getText();
                int Max = (int)MaxSpinner.getValue();
                if(v.validateName(ClassName)  && v.validateClassID(ClassID) && v.validateTrainerID(TrainerID) && (Max>0) && (ClassDuration>0) ) {
                    Class class_ = new Class(ClassID,ClassName,TrainerID,Max,ClassDuration);
                    JOptionPane.showMessageDialog(null, "Class was added.","", JOptionPane.INFORMATION_MESSAGE);
                    MainPanel.removeAll();
                    MainPanel.add(TrainerPanel);
                    MainPanel.repaint();
                    MainPanel.revalidate();
                }
                else{
                    JOptionPane.showMessageDialog(null, "Please enter all the fields correctly.");
                    MainPanel.removeAll();
                    MainPanel.add(TrainerPanel);
                    MainPanel.repaint();
                    MainPanel.revalidate();
                }

            }
        });
        logoutButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainPanel.removeAll();
                MainPanel.add(initialpanel);
                MainPanel.repaint();
                MainPanel.revalidate();
                tr.logout();
            }
        });
        addTrainerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainPanel.removeAll();
                MainPanel.add(AddTrainerPanel);
                MainPanel.repaint();
                MainPanel.revalidate();
            }
        });
        ADDtrainer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String ID = trainerIDfield.getText();
                String Phone = TrainerPhone.getText();
                String Email = trainerEmail.getText();
                String Name = trainerName.getText();
                String speciality = TrainerSepciality.getText();
                if (!(v.validateName(Name) && v.validateEmail(Email) && v.validatePhone(Phone) && v.validateTrainerID(ID))) {
                    JOptionPane.showMessageDialog(null, "Please enter all the fields correctly.");
                    MainPanel.removeAll();
                    MainPanel.add(AdminPanel);
                    MainPanel.repaint();
                    MainPanel.revalidate();
                } else if (!ar.addTrainer(ID,Name,Email,speciality,Phone)) {
                    JOptionPane.showMessageDialog(null, "Trainer already exists.");
                    MainPanel.removeAll();
                    MainPanel.add(AdminPanel);
                    MainPanel.repaint();
                    MainPanel.revalidate();
                } else {
                    JOptionPane.showMessageDialog(null, "Trainer with ID=" + ID + " Was added.", "", JOptionPane.INFORMATION_MESSAGE);
                    MainPanel.removeAll();
                    MainPanel.add(AdminPanel);
                    MainPanel.repaint();
                    MainPanel.revalidate();
                }

            }
        });
        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainPanel.removeAll();
                MainPanel.add(initialpanel);
                MainPanel.repaint();
                MainPanel.revalidate();
                ar.logout();
            }
        });
        removeTrainerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainPanel.removeAll();
                MainPanel.add(RemoveTrainer);
                MainPanel.repaint();
                MainPanel.revalidate();
                ar.logout();
            }
        });
        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String ID = trainerIDfield.getText();
                if(ar.removeTrainer(ID))
                    JOptionPane.showMessageDialog(null, "Trainer with ID=" + ID + " was deleted.", "", JOptionPane.INFORMATION_MESSAGE);
                else
                    JOptionPane.showMessageDialog(null, "Trainer does not exist.");
            }
        });
    }















}