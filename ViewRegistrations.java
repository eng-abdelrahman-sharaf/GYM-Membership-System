import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewRegistrations implements Card{
    private JTable registrationsTable;
    private JPanel panel;
    private JButton Close;

    public ViewRegistrations(Utils utils) {
        utils.fillTable(registrationsTable , utils.RecordsToData(utils.getTrainerRole().getListOfRegistrations()) , new String[]{"Member ID" , "Class ID" , "Registration Date", "Status"});
        Close.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                utils.goToPage(new TrainerPanel(utils));
            }
        });
    }

    @Override
    public JPanel getPanel() {
        return panel;
    }
}
