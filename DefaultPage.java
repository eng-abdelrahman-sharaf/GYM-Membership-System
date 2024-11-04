import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DefaultPage implements Card {
    private JPanel initialpanel;
    private JButton Trainerbutton;
    private JButton Adminbutton;
    private JPanel defaultPanel;

    @Override
    public JPanel getPanel() {
        return initialpanel;
    }

    public DefaultPage(Utils utils) {
        Adminbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // adminPanel
                utils.goToPage(new AdminPanel(utils));
            }
        });

        Trainerbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //trainerPanel
                utils.goToPage(new TrainerPanel(utils));
            }
        });
    }

}
