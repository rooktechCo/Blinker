package org.blinker;
import org.blinker.ui.*;
import org.blinker.actions.*;
import org.blinker.utils.*;
import javax.swing.*;

public class Blinker extends JFrame {
    private final TextAreaPanel textPanel;
    private final FileActions fileActions;

    public Blinker() {
        setTitle("Blinker");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(700, 660);
        setLocationRelativeTo(null);

        textPanel = new TextAreaPanel();
        fileActions = new FileActions(textPanel.getTextArea());

        setJMenuBar(new MenuBuilder().createMenuBar());
        add(textPanel);

        setVisible(true);
    }
}
