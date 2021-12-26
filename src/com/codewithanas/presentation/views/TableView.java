package com.codewithanas.presentation.views;

import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.regex.PatternSyntaxException;
import javax.swing.*;
import javax.swing.RowFilter;
import javax.swing.table.TableRowSorter;

import com.codewithanas.presentation.controllers.ControllerManager;
import com.codewithanas.presentation.models.TableModelManager;


public abstract class TableView<T, typeId> extends JFrame {
	
	private static final long serialVersionUID = -9072590340643165251L;
	private JButton back,add,edit,del;
	private JTextField search;
	private ControllerManager<T, typeId> controller;
	private TableModelManager<T> model;
	private JTable table;
	
	public TableView(TableModelManager<T> model) {
		
		setTitle("Manage");
		setSize(700,500);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		this.model = model;
		
		init();
		draw();
		System.out.println("ok draw");
		ajouterListeners();
	}
	
	private void init() {
		back = new JButton("Retour");
		add = new JButton("Ajouter");
		search = new JTextField();
		table = new JTable(model);
		edit = new JButton("Modifier");
		del = new JButton("Supprimer");
	}
	
	private void draw() {
		JScrollPane scrollPane;
		JLabel searchlabel = new JLabel("rechercher: ");
		
		JPanel pan = (JPanel) getContentPane();
		pan.setLayout(null);
		back.setBounds(600,430,80,25);
		JPanel panel = new JPanel(null);
		panel.setBounds(30,80,635,330);
		panel.setBorder(BorderFactory.createTitledBorder("Entity"));
		add.setBounds(547,295,80,25);
		edit.setBounds(470,295,80,25);
		del.setBounds(392, 295,80, 25);
		searchlabel.setBounds(10, 295, 80, 25);
		search.setBounds(70,295,220,25);
		panel.add(search);
		panel.add(searchlabel);
		panel.add(add);
		panel.add(del);
		panel.add(edit);
		//tableUser.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		scrollPane = new JScrollPane(table);
		scrollPane.setBounds(7,25,620,270);
		panel.add(scrollPane);
		panel.setBackground(SystemColor.inactiveCaptionBorder);
		pan.setBackground(SystemColor.inactiveCaptionBorder);
		pan.add(panel);
		pan.add(back);

	}
    
     private void ajouterListeners(){
         add.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
				 controller.displayAddView();
				 //dispose();
             }
         });

		 del.addActionListener(new ActionListener() {
			 @Override
			 public void actionPerformed(ActionEvent e) {
				 typeId id;
				 int selectedRowIndex;
				 selectedRowIndex = table.getSelectedRow();
				 if (selectedRowIndex == -1) {
					 JOptionPane.showMessageDialog(TableView.this, "aucune ligne selectione");
					 return;
				 }
				 selectedRowIndex = table.convertRowIndexToModel(selectedRowIndex);
				 int reponse = JOptionPane.showConfirmDialog(TableView.this, "vous voulez vraiment supprimer ?","confirmation",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
				 if(reponse == JOptionPane.YES_OPTION)
				 {
					 id = (typeId) model.getValueAt(selectedRowIndex, 0);
					 controller.delete(id);
					 dispose();
				 }
			 }
		 });
	}

	public ControllerManager<T, typeId> getController() {
		return controller;
	}

	public void setController(ControllerManager<T, typeId> controller) {
		this.controller = controller;
	}
}