import backend.Member;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class Utils {
    public static void fillTable (JTable table  , Object[][] data, String[] cols ) {
        table.setModel(new DefaultTableModel(data, cols));
    }
    public static Object[][] membersToData(List<Member> members) {
        Object[][] data = new Object[members.size()][6];
        for (int i = 0; i < members.size(); i++) {
            String [] values = members.get(i).linerepresentation().split(",");
            System.arraycopy(values, 0, data[i], 0, values.length);
        }
        return data;
    }
    public static void displayErrorMessage(Component panel , String message) {
        JOptionPane.showMessageDialog(panel, message ,  "Error Message" , JOptionPane.WARNING_MESSAGE );
    }

}
