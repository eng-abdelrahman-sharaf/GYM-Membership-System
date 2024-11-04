import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {
    private JPanel MainPanel;

    public MainWindow() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(MainPanel);
        pack();
        setVisible(true);
        setLocationRelativeTo(null);

        Utils utils = new Utils(MainPanel);
        utils.goToPage(new DefaultPage(utils));
    }
}