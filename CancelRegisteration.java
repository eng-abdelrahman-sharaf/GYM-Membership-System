import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CancelRegisteration implements Card{
    private JPanel panel;
    private JTextField memberID;
    private JTextField classID;
    private JButton cancelRegisterationButton;

    public CancelRegisteration(Utils utils) {

    }

    @Override
    public JPanel getPanel() {
        return panel;
    }
}
