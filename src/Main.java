import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    static JPanel panel = new JPanel();
    static void addObject(JComponent component){
        component.setAlignmentX(0.5F);
        panel.add(component);
        panel.add(Box.createVerticalStrut(10));
    }
    public static void main(String[] args) {
        panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
        panel.add(Box.createVerticalStrut(10));
        JFrame frame = new JFrame("JTextArea");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400,300);
        frame.setLocationRelativeTo(null);

        JTextField jTextField = new JTextField();
        jTextField.setMaximumSize(new Dimension(300,30));
        addObject(jTextField);

        JButton jButton = new JButton("Записать");
        addObject(jButton);

        JTextArea jTextArea = new JTextArea();
        jTextArea.setRows(4);
        JScrollPane scrollPane = new JScrollPane(jTextArea,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setMaximumSize(new Dimension(300,100));
        addObject(scrollPane);

        jButton.addActionListener(e -> jTextArea.setText(jTextArea.getText()+(jTextArea.getText().length()==0?"":"\n")
                +jTextField.getText()));

        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
    }
}