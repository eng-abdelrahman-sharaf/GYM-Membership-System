import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

public class RegisterMemberForClass implements Card{
    private JButton button1;
    private JTextField MemberIDField;
    private JTextField ClassIDField;
    private JTextField DateField;
    private JPanel panel;

    @Override
    public JPanel getPanel() {
        return panel;
    }

    public RegisterMemberForClass(Utils utils) {
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LocalDate date = utils.validateDate(DateField.getText());
                if(!utils.validateMemberID(MemberIDField.getText())) {
                    utils.displayErrorMessage("Enter a valid Member ID");
                }
                else if(!utils.validateClassID(ClassIDField.getText())) {
                    utils.displayErrorMessage("Enter a valid Class ID");
                }
                else if(date==null){
                    utils.displayErrorMessage("Enter a valid Date");
                }
                else if(!utils.getTrainerRole().getMemberDatabase().contains(MemberIDField.getText())){
                    utils.displayErrorMessage("Member ID Not Found");
                }
                else if(!utils.getTrainerRole().getClassDatabase().contains(ClassIDField.getText())){
                    utils.displayErrorMessage("Class ID Not Found");
                }
                else if (!utils.getTrainerRole().registerMemberForClass(MemberIDField.getText() , ClassIDField.getText() , date)){
                    utils.displayErrorMessage("No Available Seats");
                }
                utils.goToPage(new TrainerPanel(utils));
            }
        });
    }
}
