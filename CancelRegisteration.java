import backend.MemberClassRegistration;
import backend.MemberClassRegistrationDatabase;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CancelRegisteration implements Card{
    private JPanel panel;
    private JTextField memberID;
    private JTextField classID;
    private JButton cancelRegisterationButton;

    public CancelRegisteration(MemberClassRegistrationDatabase db) {

        cancelRegisterationButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String memID = memberID.getText();
                String clsID = classID.getText();
                if(Validation.validateMemberID(memID)){

                }
            }
        });
    }
    public JPanel getPanel() {
        return panel;
    }

}
