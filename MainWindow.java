import javax.swing.*;

public class MainWindow extends JFrame {
    private JPanel CardsContainer;

    public MainWindow() {
        CardsContainer.removeAll();
        CardsContainer.add(new ViewMembers().getPanel());
        setContentPane(CardsContainer);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

}
