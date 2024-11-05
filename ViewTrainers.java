import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewTrainers implements Card{
    private JTable trainersTable;
    private JPanel panel;
    private JButton Close;

    public ViewTrainers(Utils utils) {
        utils.fillTable(trainersTable , utils.RecordsToData(utils.getAdminRole().getListOfTrainers()), new String[]{
                "Trainer ID",
                "Name",
                "Email",
                "Speciality",
                "phone"
        } );

        Close.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                utils.goToPage(new AdminPanel(utils));
            }
        });
    }

    @Override
    public JPanel getPanel() {
        return panel;
    }
}
