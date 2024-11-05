import backend.Member;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.List;

public class ViewMembers implements Card {
    private JTable membersTable;
    private JPanel panel;

    public ViewMembers(Utils utils) {
        Utils.fillTable(membersTable ,
                utils.getTrainerRole().getListOfMembers() ,
                new String[]{"ID" , "Name" , "Type" , "email" , "phone" ,"status"});
    }

    @Override
    public JPanel getPanel() {
        return panel;
    }
}
