/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.blinker.ui;
import javax.swing.*;
import java.awt.*;
/**
 *
 * @author USER
 */
// TextAreaPanel.java


public class TextAreaPanel extends JPanel {
    private final JTextArea textArea;
    private final JTextArea subtextArea;

    public TextAreaPanel() {
        setLayout(new BorderLayout());
        setBackground(Theme.BACKGROUND);

        textArea = createTextArea();
        subtextArea = createSubtextArea();

        JScrollPane mainScroll = new JScrollPane(textArea);
        JScrollPane subScroll = new JScrollPane(subtextArea);

        JPanel sidePanel = new JPanel();
        sidePanel.setPreferredSize(new Dimension(100, 600));
        sidePanel.add(subScroll);

        add(mainScroll, BorderLayout.CENTER);
        add(sidePanel, BorderLayout.EAST);
    }

    private JTextArea createTextArea() {
        JTextArea area = new JTextArea();
        area.setFont(Theme.DEFAULT_FONT);
        area.setBackground(Theme.BACKGROUND);
        area.setForeground(Theme.TEXT_COLOR);
        area.setCaretColor(Theme.TEXT_COLOR);
        area.setLineWrap(true);
        area.setWrapStyleWord(true);
        return area;
    }

    private JTextArea createSubtextArea() {
        JTextArea area = new JTextArea();
        area.setEditable(false);
        area.setBackground(new Color(255, 255, 255, 19));
        area.setForeground(Color.WHITE);
        area.setFont(new Font("Arial", Font.PLAIN, 7));
        return area;
    }

    public JTextArea getTextArea() { return textArea; }
    public JTextArea getSubtextArea() { return subtextArea; }
}
