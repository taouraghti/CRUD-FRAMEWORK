package com.codewithanas.presentation.views;

import com.codewithanas.presentation.controllers.ControllerManager;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Field;
import java.util.HashMap;

public abstract class AddView<T, typeId> extends JFrame{
    private JButton add,cancel;
    private T fieldsNameClass;
    // private T bean;
    private ControllerManager<T, typeId> controller;
    HashMap<String, JTextField> textFieldHashMap;

    public abstract T initBean();


    public AddView(){

    }

    public void draw(){
        setTitle("Ajouter");
        setSize(450,450);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);
        Field[] fs = fieldsNameClass.getClass().getDeclaredFields();

        textFieldHashMap = new HashMap<String, JTextField>();
        JLabel[] labels = new JLabel[fs.length];
        JTextField[] textFields = new JTextField[fs.length];
        add = new JButton("Ajouter");
        cancel = new JButton("Annuler");
        JPanel panel = (JPanel)this.getContentPane();
        panel.setLayout(null);
        int i = 0;
        int y=30;
        for(Field f : fs) {

            labels[i] = new JLabel(f.getName());
            labels[i].setBounds(75, y, 114, 25);
            panel.add(labels[i]);

            JTextField textField = new JTextField();
            textField.setBounds(235, y, 114, 25);
            panel.add(textField);
            textFieldHashMap.put(f.getName(), textField);
            y += 45;
            i++;
        }
        add.setBounds(240,y + 45,90,25);
        cancel.setBounds(338,y + 45,90,25);
        panel.add(add);
        panel.add(cancel);
        ajouterListeners();

    }

    private void ajouterListeners(){
        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.save(initBean());
                dispose();
            }
        });
        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }

    public T getFieldsNameClass() {
        return fieldsNameClass;
    }

    public void setFieldsNameClass(T fieldsNameClass) {
        this.fieldsNameClass = fieldsNameClass;
    }

    public ControllerManager<T, typeId> getController() {
        return controller;
    }

    public void setController(ControllerManager<T, typeId> controller) {
        this.controller = controller;
    }
}
