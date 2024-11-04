import backend.Member;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;

public class ViewMembers implements Card {
    private JTable membersTable;
    private JPanel panel;

    public ViewMembers() {
        Utils.fillTable(membersTable , Utils.membersToData(List.of(new Member[]{new Member("1538", "michel", "good", "ang.awf", "01685452", "active") , new Member("1538", "michel", "good", "ang.awf", "01685452", "active") , new Member("1538", "michel", "good", "ang.awf", "01685452", "active") } )) , new String[]{"ID" , "Name" , "Type" , "email" , "phone" ,"status"});
    }

    @Override
    public JPanel getPanel() {
        return panel;
    }
}
