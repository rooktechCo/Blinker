/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.blinker.actions;
import javax.swing.*;
import java.io.*;
import java.util.Scanner;

/**
 *
 * @author USER
 */

public class FileActions {
    private final JTextArea textArea;
    private File currentFile;

    public FileActions(JTextArea textArea) {
        this.textArea = textArea;
    }

    public void newFile() {
        textArea.setText("");
        currentFile = null;
    }

    public void openFile(JFrame parent) {
        JFileChooser chooser = new JFileChooser();
        if (chooser.showOpenDialog(parent) == JFileChooser.APPROVE_OPTION) {
            currentFile = chooser.getSelectedFile();
            try (Scanner scanner = new Scanner(currentFile)) {
                StringBuilder sb = new StringBuilder();
                while (scanner.hasNextLine()) sb.append(scanner.nextLine()).append("\n");
                textArea.setText(sb.toString());
            } catch (IOException e) {
                JOptionPane.showMessageDialog(parent, "Error: " + e.getMessage());
            }
        }
    }

    public void saveFile(JFrame parent) {
        if (currentFile == null) {
            saveFileAs(parent);
            return;
        }
        try (PrintWriter writer = new PrintWriter(currentFile)) {
            writer.print(textArea.getText());
        } catch (IOException e) {
            JOptionPane.showMessageDialog(parent, "Error: " + e.getMessage());
        }
    }

    public void saveFileAs(JFrame parent) {
        JFileChooser chooser = new JFileChooser();
        if (chooser.showSaveDialog(parent) == JFileChooser.APPROVE_OPTION) {
            currentFile = chooser.getSelectedFile();
            saveFile(parent);
        }
    }
}

