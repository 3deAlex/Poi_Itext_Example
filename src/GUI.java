import javax.swing.*;
import java.awt.*;
import java.io.IOException;

/**
 * Created by Алекс on 27.05.2014.
 */
public class GUI extends JPanel {
    NavPanel navPanel = new NavPanel();
    ViewPanel viewPanel = new ViewPanel();

    public GUI (){
        setLayout(new BorderLayout());

        add(viewPanel);
        add(navPanel, BorderLayout.EAST);
    }

    private class ViewPanel extends JPanel {

        JTextArea textArea;

        public ViewPanel (){
            textArea = new JTextArea();
            try {
                textArea.setText(new Connection().getRowText());
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, "Could not read from file", "Error", JOptionPane.ERROR_MESSAGE);
            }

            add(textArea);
        }
    }

    private class NavPanel extends JPanel {
        JButton[] bts = new JButton[4];

        public NavPanel (){
            setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

            for (JButton button : bts){
                button = new JButton();
                button.setText("some text");
                add(button);
            }
        }
    }
}
