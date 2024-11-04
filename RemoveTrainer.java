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
                if(utils.getAdminRole().removeTrainer(ID))
                    JOptionPane.showMessageDialog(null, "Trainer with ID=" + ID + " was deleted.", "", JOptionPane.INFORMATION_MESSAGE);
                else
                    JOptionPane.showMessageDialog(null, "Trainer does not exist.");
            }
        });
    }
}
