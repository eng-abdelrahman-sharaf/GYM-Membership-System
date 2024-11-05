import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddClassPanel  implements Card {

    private JPanel addClassPanel;
    private JTextField ClassIDfield;
    private JTextField TrainerIDField;
    private JTextField ClassNameField;
    private JSpinner DurationSpinner;
    private JSpinner MaxSpinner;
    private JButton ADD;

    @Override
    public JPanel getPanel() {
        return addClassPanel;
    }

    public AddClassPanel(Utils utils){
        ADD.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String ClassID = ClassIDfield.getText();
                String ClassName = ClassNameField.getText();
                int ClassDuration = (int)DurationSpinner.getValue();
                String TrainerID = TrainerIDField.getText();
                int Max = (int)MaxSpinner.getValue();
                if(utils.validateName(ClassName)  && utils.validateClassID(ClassID) && utils.validateTrainerID(TrainerID) && (Max>0) && (ClassDuration>0) ) {
                    Class class_ = new Class(ClassID,ClassName,TrainerID,Max,ClassDuration);
                    utils.displaySuccessMessage("Class was added");
                }
                else{
                    utils.displayErrorMessage("Please enter all the fields correctly.");
                }
                utils.goToPage(new TrainerPanel(utils));
            }
        });

    }
}
