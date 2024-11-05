import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.List;

public class ViewMembers implements Card {
    private JTable membersTable;
    private JPanel panel;
    private JButton Close;

    public ViewMembers(Utils utils) {
        utils.fillTable(membersTable ,
                utils.RecordsToData(utils.getTrainerRole().getListOfMembers()) ,
                new String[]{"ID" , "Name" , "Type" , "email" , "phone" ,"status"});
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
