/*
 * Dosage.java
 * Insulin
 * 
 * Created by Caroline Creamer on 10/18/18.
 * Copyright © 2018 Caroline Creamer. All rights reserved. 
 */



import java.awt.*;
import java.awt.event.*;

//extends frame class that will be used to create user interface in InsulinCalc.java

public class Dosage extends Frame {
	private int bsLow;
	private int bsHigh;
	private int correction;
	private int insulinCarb;


	// sets blood sugar initially, but can be updated later
	public Dosage(int bsLow, int bsHigh, int correction, int insulinCarb) {
		// if blood sugar out of range is dangerously low, throws illegal argument exception so you don't die
		if (bsLow < 40) { throw new IllegalArgumentException("Are you trying to die? This is WAY too low!!"); }
		this.bsLow = bsLow;
		// if blood sugar out of range is dangerously high, throws illegal argument exception so that you don't die
		if (bsHigh > 250) { throw new IllegalArgumentException("You're going to go into DKA... have fun when you're blind and have to go through dialysis once a week in twenty years"); }
		this.bsHigh = bsHigh;
		// prevents later functions from being divided by 0
		if (correction <= 0) { throw new IllegalArgumentException(); }
		this.correction = correction;
		if (insulinCarb <= 0) { throw new IllegalArgumentException(); }
 		this.insulinCarb = insulinCarb;
	}

	// accessor methods

	public int getBsLow() {
		return this.bsLow;
	}

	public int getBsHigh() {
		return this.bsHigh;
	}

	public int getCorrection() {
		return this.correction;
	}

	public int getInsulinCarb() {
		return this.insulinCarb;
	}

	// mutator methods

	public void setBsLow(int newBsLow) {
		this.bsLow = newBsLow;
	}

	public void setBsHigh(int newBsHigh) {
		this.bsHigh = newBsHigh;
	}

	public void setCorrection(int newCorrection) {
		if (newCorrection <= 0) { throw new IllegalArgumentException(); }
		this.correction = newCorrection;
	}

	public void setInsulinCarb(int newInsulinCarb) {
		if (newInsulinCarb <= 0) { throw new IllegalArgumentException(); }
		this.insulinCarb = newInsulinCarb;
	}
}