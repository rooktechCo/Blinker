package org.example;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Blinker extends JFrame {
    JTextArea textArea = new JTextArea();
    JTextArea subtextArea = new JTextArea();
    JPanel panel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
    JMenuBar menuBar = new JMenuBar();
    JMenu fileMenu;
    JMenuItem newMenuItem;
    JMenuItem openMenuItem;
    JSeparator separator1;
    JMenuItem saveMenuItem;
    JMenuItem saveAsMenuItem;
    JMenu editMenu;
    JMenuItem copy;
    JMenuItem paste;
    JMenuItem delete;
    JSeparator separator2;
    JMenuItem find;
    JMenu viewMenu;
    JMenuItem fullscreen;
    JMenuItem smallscreen;
    JSeparator separator3;
    JMenuItem zoom;
    JMenuItem ruler;
    JMenuItem lineNumber;
    JSeparator separator4;
    JMenuItem border;
    JMenuItem outline;
    JMenuItem printL;
    JMenuItem webL;
    JMenu formatMenu;
    JMenuItem font;
    JMenuItem indentation;
    JMenuItem alignment;
    JSeparator separator5;
    JMenuItem column;
    JMenuItem tab;
    JMenuItem textOrientation;
    JMenuItem styleFormat;
    JMenu insertMenu;
    JMenuItem comments;
    JMenuItem dateTime;
    JSeparator separator6;
    JMenuItem blankPage;
    JMenuItem hyperlink;
    JMenu toolsMenu;
    JMenuItem track;
    JMenuItem restrict;
    JMenuItem language;
    JMenu goToMenu;
    JMenuItem cracker;
    JMenu runMenu;

    public Blinker() {
        setTitle("Blinker");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(700, 660);
        setLocationRelativeTo(null);
        setResizable(true);

        initializeComponents();
        addMenuListeners();
        addTextAreaListener();
        setVisible(true);
    }

    private void initializeComponents() {
        // Set up colors for dark theme
        Color darkBackgroundColor = new Color(0x1A2125);
        Color menuTextColor = Color.BLACK; // White text color

        // Set the background color of the JFrame
        getContentPane().setBackground(darkBackgroundColor);

        // Create and customize menu bar
        menuBar.setForeground(menuTextColor);
        setJMenuBar(menuBar);

        // Creating the menu items
        fileMenu = createMenu("File", menuTextColor);
        newMenuItem = createMenuItem("New");
        openMenuItem = createMenuItem("Open");
        separator1 = new JSeparator();
        saveMenuItem = createMenuItem("Save");
        saveAsMenuItem = createMenuItem("Save As");

        editMenu = createMenu("Edit", menuTextColor);
        copy = createMenuItem("Copy");
        paste = createMenuItem("Paste");
        delete = createMenuItem("Delete");
        separator2 = new JSeparator();
        find = createMenuItem("Find");

        viewMenu = createMenu("View", menuTextColor);
        fullscreen = createMenuItem("Full Screen");
        smallscreen = createMenuItem("Small Screen");
        separator3 = new JSeparator();
        zoom = createMenuItem("Zoom");
        ruler = createMenuItem("Ruler");
        lineNumber = createMenuItem("Line Numbering");
        separator4 = new JSeparator();
        border = createMenuItem("Border");
        outline = createMenuItem("Outline Layout");
        printL = createMenuItem("Print Layout");
        webL = createMenuItem("Web Layout");

        formatMenu = createMenu("Format", menuTextColor);
        font = createMenuItem("Font");
        indentation = createMenuItem("Indentation");
        alignment = createMenuItem("Alignment");
        separator5 = new JSeparator();
        column = createMenuItem("Columns");
        tab = createMenuItem("Tab");
        textOrientation = createMenuItem("Text Orientation");
        styleFormat = createMenuItem("Style and Format");

        insertMenu = createMenu("Insert", menuTextColor);
        comments = createMenuItem("Comments");
        dateTime = createMenuItem("Date and Time");
        separator6 = new JSeparator();
        blankPage = createMenuItem("Blank Page");
        hyperlink = createMenuItem("HyperLink");

        toolsMenu = createMenu("Tools", menuTextColor);
        track = createMenuItem("Track Changes");
        restrict = createMenuItem("Restrict Editing");
        language = createMenuItem("Set Language");

        goToMenu = createMenu("Goto", menuTextColor);
        cracker = createMenuItem("Cracker");

        runMenu = createMenu("Run", menuTextColor);

        // Adding menu items to menu bar
        menuBar.add(fileMenu);
        fileMenu.add(newMenuItem);
        fileMenu.add(openMenuItem);
        fileMenu.add(separator1);
        fileMenu.add(saveMenuItem);
        fileMenu.add(saveAsMenuItem);

        // Adding edit menu items
        menuBar.add(editMenu);
        editMenu.add(copy);
        editMenu.add(paste);
        editMenu.add(delete);
        editMenu.add(separator2);
        editMenu.add(find);

        // Adding view menu items
        menuBar.add(viewMenu);
        viewMenu.add(fullscreen);
        viewMenu.add(smallscreen);
        viewMenu.add(separator3);
        viewMenu.add(zoom);
        viewMenu.add(ruler);
        viewMenu.add(lineNumber);
        viewMenu.add(separator4);
        viewMenu.add(border);
        viewMenu.add(outline);
        viewMenu.add(printL);
        viewMenu.add(webL);

        // Adding format menu items
        menuBar.add(formatMenu);
        formatMenu.add(font);
        formatMenu.add(indentation);
        formatMenu.add(alignment);
        formatMenu.add(separator5);
        formatMenu.add(column);
        formatMenu.add(tab);
        formatMenu.add(textOrientation);
        formatMenu.add(styleFormat);

        // Adding insert menu items
        menuBar.add(insertMenu);
        insertMenu.add(comments);
        insertMenu.add(dateTime);
        insertMenu.add(separator6);
        insertMenu.add(blankPage);
        insertMenu.add(hyperlink);

        // Adding tools menu items
        menuBar.add(toolsMenu);
        toolsMenu.add(track);
        toolsMenu.add(restrict);
        toolsMenu.add(language);

        // Adding Goto menu items
        menuBar.add(goToMenu);
        goToMenu.add(cracker);

        menuBar.add(runMenu);

        // Text area setup
        textArea.setFont(new Font("Arial", Font.PLAIN, 14)); // Example font
        textArea.setBackground(darkBackgroundColor);
        textArea.setForeground(Color.white);
        textArea.setCaretColor(Color.WHITE);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setBorder(null);
        Insets textAreaMargin = new Insets(10, 10, 10, 10); // Top, Left, Bottom, Right
        textArea.setMargin(textAreaMargin);

        // Scroll pane setup
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setBorder(null);
        scrollPane.getViewport().setBackground(darkBackgroundColor);

        // Adding scroll pane to content pane
        getContentPane().add(scrollPane, BorderLayout.CENTER);

        Panels();
    }
    private void addTextAreaListener() {
        textArea.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                copyTextToSubtextArea();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                copyTextToSubtextArea();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                copyTextToSubtextArea();
            }
        });
    }
    private JMenu createMenu(String name, Color textColor) {
        JMenu menu = new JMenu(name);
        menu.setForeground(textColor);
        return menu;
    }

    private JMenuItem createMenuItem(String name) {
        JMenuItem menuItem = new JMenuItem(name);
        return menuItem;
    }

    private void Panels() {
        int widthX = 100;
        int heightY = 7000;
        Dimension dimensionX = new Dimension(widthX, heightY);

        subtextArea.setLineWrap(true);
        subtextArea.setWrapStyleWord(true);
        subtextArea.setBorder(null);
        subtextArea.setFont(new Font("Arial", Font.PLAIN, 7)); // Example font
        subtextArea.setForeground(new Color(255, 255, 255, 255));
        subtextArea.setCaretColor(Color.WHITE);
        subtextArea.setBackground(new Color(255, 255, 255, 19));
        subtextArea.setOpaque(true);
        subtextArea.setEditable(false);
        subtextArea.setPreferredSize(dimensionX);

        Insets subtextAreaMargin = new Insets(0, 10, 10, 10); // Top, Left, Bottom, Right
        subtextArea.setMargin(subtextAreaMargin);
        Insets subtextAreaPadding = new Insets(10, 10, 10, 10); // Top, Left, Bottom, Right
        subtextArea.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createEmptyBorder(subtextAreaPadding.top, subtextAreaPadding.left, subtextAreaPadding.bottom, subtextAreaPadding.right),
                subtextArea.getBorder()));

        JScrollPane scrollPane = new JScrollPane(subtextArea);
        scrollPane.setBorder(null);
        scrollPane.getViewport().setBackground(Color.white);


        panel.add(scrollPane);
        panel.setBackground(new Color(255, 255, 255, 20));
        panel.setOpaque(true);

        int width = 100;
        int height = 50;
        Dimension dimension = new Dimension(width, height);
        panel.setPreferredSize(dimension);
        copyTextToSubtextArea();
        // Add the panel to the EAST position of the JFrame
        this.add(panel, BorderLayout.EAST);
    }

    private void copyTextToSubtextArea() {
        subtextArea.setText(textArea.getText());
    }


    private void addMenuListeners() {
        // ActionListener for "Copy" menu item
        copy.addActionListener(e -> {
            textArea.copy();
        });

        // ActionListener for "Paste" menu item
        paste.addActionListener(e -> {
            textArea.paste();
        });

        // ActionListener for "Delete" menu item
        delete.addActionListener(e -> {
            textArea.replaceSelection(""); // Deletes the selected text
        });

        // ActionListener for "Find" menu item
        find.addActionListener(e -> {
            String searchText = JOptionPane.showInputDialog(this, "Enter text to find:");
            if (searchText != null && !searchText.isEmpty()) {
                String documentText = textArea.getText();
                int index = documentText.indexOf(searchText);
                if (index >= 0) {
                    textArea.setCaretPosition(index);
                    textArea.setSelectionStart(index);
                    textArea.setSelectionEnd(index + searchText.length());
                } else {
                    JOptionPane.showMessageDialog(this, "Text not found.");
                }
            }
        });

        // ActionListener for "New" menu item
        newMenuItem.addActionListener(e -> {
            textArea.setText(""); // Clear the text area
        });

        // ActionListener for "Open" menu item
        openMenuItem.addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser();
            int option = fileChooser.showOpenDialog(this);
            if (option == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
                try (Scanner scanner = new Scanner(selectedFile)) {
                    StringBuilder fileContent = new StringBuilder();
                    while (scanner.hasNextLine()) {
                        fileContent.append(scanner.nextLine()).append("\n");
                    }
                    textArea.setText(fileContent.toString());
                } catch (FileNotFoundException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(this, "Error opening file: " + ex.getMessage());
                }
            }
        });

        // ActionListener for "Save" menu item
        saveMenuItem.addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser();
            int option = fileChooser.showSaveDialog(this);
            if (option == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
                try (PrintWriter writer = new PrintWriter(selectedFile)) {
                    writer.print(textArea.getText());
                } catch (FileNotFoundException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(this, "Error saving file: " + ex.getMessage());
                }
            }
        });

        // ActionListener for "Save As" menu item
        saveAsMenuItem.addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser();
            int option = fileChooser.showSaveDialog(this);
            if (option == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
                try (PrintWriter writer = new PrintWriter(selectedFile)) {
                    writer.print(textArea.getText());
                } catch (FileNotFoundException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(this, "Error saving file: " + ex.getMessage());
                }
            }
        });

        // Add similar ActionListener for other menu items as needed

        // ActionListener for "Fullscreen" menu item
        fullscreen.addActionListener(e -> {
            setExtendedState(JFrame.MAXIMIZED_BOTH);
        });

// ActionListener for "Smallscreen" menu item
        smallscreen.addActionListener(e -> {
            setSize(700, 660); // Set your default size here
            setLocationRelativeTo(null); // Center the frame
        });

// ActionListener for "Comments" menu item
        comments.addActionListener(e -> {
            String comment = JOptionPane.showInputDialog(this, "Enter comment:");
            if (comment != null) {
                int caretPosition = textArea.getCaretPosition();
                textArea.insert(comment, caretPosition);
            }
        });

// ActionListener for "Date and Time" menu item
        dateTime.addActionListener(e -> {
            int caretPosition = textArea.getCaretPosition();
            String dateTimeString = new java.util.Date().toString();
            textArea.insert(dateTimeString, caretPosition);
        });

// ActionListener for "Blank Page" menu item
        blankPage.addActionListener(e -> {
            textArea.setText(""); // Clear the text area
        });

// ActionListener for "Hyperlink" menu item
        hyperlink.addActionListener(e -> {
            // Implement hyperlink functionality here
            // You might need to use HTML formatting in the JTextArea
        });

    }
}
