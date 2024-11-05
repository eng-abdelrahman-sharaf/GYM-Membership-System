import java.awt.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

public class Utils {
    private final TrainerRole trainerRole = new TrainerRole();
    private final AdminRole adminRole = new AdminRole();
    private JPanel mainPanel;

    public Utils(JPanel mainPanel) {
        this.mainPanel = mainPanel;

    }

    public void fillTable(JTable table, Object[][] data, String[] cols) {
        table.setModel(new DefaultTableModel(data, cols){
            @Override
            public boolean isCellEditable(int row, int column) {
            //all cells false
                return false;
            }
        });
    }
    
    public Object[][] RecordsToData(List<Record> records) {
        if(records.size() == 0) return new Object[0][0];
        Object[][] data = new Object[records.size()][records.get(0).linerepresentation().split(",").length];
        for (int i = 0; i < records.size(); i++) {
            String [] values = records.get(i).linerepresentation().split(",");
            System.arraycopy(values, 0, data[i], 0, values.length);
        }
        return data;
    }

    public void displayErrorMessage(String message) {
        JOptionPane.showMessageDialog(null, message, "Error Message", JOptionPane.WARNING_MESSAGE);
    }
    public void displaySuccessMessage(String message) {
        JOptionPane.showMessageDialog(null, message, "Success Message", JOptionPane.INFORMATION_MESSAGE);
    }
    
    public AdminRole getAdminRole() {
        return adminRole;
    }

    public TrainerRole getTrainerRole() {
        return trainerRole;
    }

    public void goToPage(Card page){
        Border blackline = BorderFactory.createTitledBorder(page.getClass().getSimpleName());
        page.getPanel().setBorder(blackline);
        mainPanel.removeAll();
        mainPanel.add(page.getPanel());
        mainPanel.repaint();
        mainPanel.revalidate();
    }

    public boolean validateName(String name) {
        return name.matches("[a-zA-Z]+");
    }
    public boolean validateEmail(String email) {
        return email.matches("[a-zA-Z0-9_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}");
    }
    public boolean validatePhone(String phone) {
        return phone.matches("01+[0-9]{9}");
    }
    public boolean validateMemberID(String memberID) {
        return memberID.matches("M+[0-9]+");
    }

    public boolean validateTrainerID(String memberID) {
        return memberID.matches("T+[0-9]+");
    }
    public boolean validateClassID(String memberID) {
        return memberID.matches("C+[0-9]+");
    }
    public LocalDate validateDate(String date) {
        try{
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            return LocalDate.parse(date, formatter);
        }catch (DateTimeParseException e){
            return null;
        }
    }
}
