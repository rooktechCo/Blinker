/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.blinker.ui;
import javax.swing.*;
import java.awt.*;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 *
 * @author USER
 */
// MenuBuilder.java

public class MenuBuilder {
    private final JMenuBar menuBar = new JMenuBar();

    public JMenuBar createMenuBar() {
        addFileMenu();
        addEditMenu();
        addViewMenu();
        addFormatMenu();
        addInsertMenu();
        addToolsMenu();
        addGoToMenu();
        addRunMenu();
        return menuBar;
    }

    private JMenu createMenu(String name) {
        JMenu menu = new JMenu(name);
        menu.setForeground(Color.BLACK);
        return menu;
    }

    private JMenuItem item(String name) {
        return new JMenuItem(name);
    }

    private void addFileMenu() {
        JMenu file = createMenu("File");
        file.add(item("New"));
        file.add(item("Open"));
        file.add(new JSeparator());
        file.add(item("Save"));
        file.add(item("Save As"));
        menuBar.add(file);
    }

    private void addEditMenu() {
        JMenu edit = createMenu("Edit");
        edit.add(item("Copy"));
        edit.add(item("Paste"));
        edit.add(item("Delete"));
        edit.add(new JSeparator());
        edit.add(item("Find"));
        menuBar.add(edit);
    }

    private void addViewMenu() {
        JMenu view = createMenu("View");
        view.add(item("Full Screen"));
        view.add(item("Small Screen"));
        menuBar.add(view);
    }

    private void addFormatMenu() { menuBar.add(createMenu("Format")); }
    private void addInsertMenu() { menuBar.add(createMenu("Insert")); }
    private void addToolsMenu() { menuBar.add(createMenu("Tools")); }
    private void addGoToMenu() { menuBar.add(createMenu("Goto")); }
    private void addRunMenu() { menuBar.add(createMenu("Run")); }
}
