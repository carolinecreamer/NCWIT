/*
 * InsulinCalc.java
 * Insulin
 * 
 * Created by Caroline Creamer on 10/20/18.
 * Copyright © 2018 Caroline Creamer. All rights reserved. 
 */


import java.awt.*;
import java.awt.event.*;

// inherits all math and dosage stuff from Insulin and Dosage classes, inherits Frame class for user interface, implements ActionListener for button

public class InsulinCalc extends Insulin implements ActionListener {
	private Label bsLowLabel;
	private Label bsHighLabel;
	private Label correctionLabel;
	private Label insulinCarbLabel;
	private Label bsLabel;
	private Label carbLabel;
	private Label insulinTotal;
	private TextField tfBSLow;
	private TextField tfBSHigh;
	private TextField tfCorrection;
	private TextField tfInsulinCarb;
	private TextField tfBS;
	private TextField tfCarb;
	private static TextField tfInsulinTotal;
	private Button button;

	public InsulinCalc(int bsLow, int bsHigh, int correction, int insulinCarb, int bs, int carb) {
		super(bsLow, bsHigh, correction, insulinCarb, bs, carb);
		setLayout(new FlowLayout());

		// adds titles and user text input box things 

		bsLowLabel = new Label("Low blood sugar: ");
		add(bsLowLabel);
		tfBSLow = new TextField("80", 10);
		tfBSLow.setEditable(true);
		add(tfBSLow);

		bsHighLabel = new Label("High blood sugar: ");
		add(bsHighLabel);
		tfBSHigh = new TextField("180", 10);
		tfBSHigh.setEditable(true);
		add(tfBSHigh);

		correctionLabel = new Label("Correction Dosage (1 unit:___mg/dL out of range): ");
		add(correctionLabel);
		tfCorrection = new TextField("50", 10);
		tfCorrection.setEditable(true);
		add(tfCorrection);

		insulinCarbLabel = new Label("Insulin:Carb Ratio (1 unit:___g of carbs):");
		add(insulinCarbLabel);
		tfInsulinCarb = new TextField("15", 15);
		tfInsulinCarb.setEditable(true);
		add(tfInsulinCarb);

		bsLabel = new Label("Current blood sugar: ");
		add(bsLabel);
		tfBS = new TextField("100", 10);
		tfBS.setEditable(true);
		add(tfBS);

		carbLabel = new Label("Carb intake: ");
		add(carbLabel);
		tfCarb = new TextField("0", 10);
		tfCarb.setEditable(true);
		add(tfCarb);

		// adds button
		button = new Button("Submit");
		add(button);

		// gives total, not editable because user shouldn't be changing the answer
		insulinTotal = new Label("You should take: ");
		add(insulinTotal);
		tfInsulinTotal = new TextField(15);
		tfInsulinTotal.setEditable(false);
		add(tfInsulinTotal);

		// makes button an action listener so that when you click on it, it does stuff
		button.addActionListener(this);
		// sets the title and size of the user interface and makes it visible
		setTitle("Insulin Dosage Calculator");
		setSize(500, 250);
		setResizable(false);
		setVisible(true);
	}

	// when button is clicked, the calculator calulates insulin needed and outputs the total
	public void actionPerformed(ActionEvent evt) {
		this.setInsulin(0);
		this.setBsLow(Integer.parseInt(tfBSLow.getText()));
		this.setBsHigh(Integer.parseInt(tfBSHigh.getText()));
		this.setCorrection(Integer.parseInt(tfCorrection.getText()));
		this.setInsulinCarb(Integer.parseInt(tfInsulinCarb.getText()));
		this.setBS(Integer.parseInt(tfBS.getText()));
		this.setCarb(Integer.parseInt(tfCarb.getText()));
		this.correctBS();
		this.carbDose();
		tfInsulinTotal.setText((int)this.getInsulin() + " units");


	}

	// default values
	public static void main(String[] args) {
		InsulinCalc dose = new InsulinCalc(80, 180, 50, 15, 100, 0);
		dose.correctBS();
		dose.carbDose();
		tfInsulinTotal.setText((int)dose.getInsulin() + " units");
	}
}