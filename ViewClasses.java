import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewClasses implements Card {
    private JTable classesTable;
    private JPanel panel;
    private JButton Close;

    public ViewClasses(Utils utils) {
        utils.fillTable(classesTable , utils.RecordsToData(utils.getTrainerRole().getListOfClasses()), new String[] {"Class ID" , "Class Name" , "Trainer ID" , "Duration" , "Available Seats"} );
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
