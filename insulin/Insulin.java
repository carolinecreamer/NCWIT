/*
 * Insulin.java
 * Insulin
 * 
 * Created by Caroline Creamer on 10/19/18.
 * Copyright © 2018 Caroline Creamer. All rights reserved. 
 */


public class Insulin extends Dosage {
	private double insulin;
	private int bs;
	private int carb;
// inherits dosing from Dosage.java, sets initial insulin count to zero 
	public Insulin(int bsLow, int bsHigh, int correction, int insulinCarb, int bs, int carb) {
		super (bsLow, bsHigh, correction, insulinCarb);
		this.insulin = 0.0;
		this.bs = bs;
		this.carb = carb;
	}

	// accessor methods

	public int getBS() {
		return this.bs;
	}

	public double getInsulin() {
		if (insulin < 0) {
			throw new IllegalArgumentException("You need sugar!!");
		}
		return this.insulin;
	}

	public int getCarb() {
		return this.carb;
	}

	// mutator methods

	public void setBS(int newBS) {
		this.bs = newBS;
	}

	public void setCarb(int newCarb) {
		this.carb =  newCarb;
	}

	public void setInsulin(double newInsulin) {
		this.insulin = newInsulin;
	}

	public void correctBS() {
		// divides mg/dL out of range by correction dosage to get the units you should take to get blood sugar down
		if (this.bs > this.getBsHigh()) {
			if (this.getCorrection() <= 0) {
				this.insulin += 0;
			}
			else { this.insulin += ((double)(this.bs - this.getBsHigh())/(double)this.getCorrection()); }
		}
		// if blood sugar is low, subtract insulin, automatically subtracts 1 if blood sugar is low but now low enough to need to subtract multiple units
		if (this.bs < this.getBsLow()) {
			if ((this.getBsLow() - this.bs) <= 15) { this.insulin -= 1; }
			else { 
				if (this.getCorrection() <= 0) { throw new IllegalArgumentException(); }
				this.insulin -= ((double)(this.getBsLow() - this.bs)/(double)this.getCorrection()); 
			}
		}
	}

	public void carbDose() {
		// adds units of insulin needed according to insulin:carb ratio, int so that insulin rounds down to prevent low blood sugar
		// divides carbs by insulin:carb ratio to get insulin needed
		if (this.carb > 0) { 
			if (this.getInsulinCarb() <= 0) { 
				System.out.println(this.getInsulinCarb());
				throw new IllegalArgumentException("this is my error!"); 
			}
			this.insulin += ((double)this.carb / (double)this.getInsulinCarb());
		}
	}
}