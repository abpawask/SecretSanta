package edu.iu.secretsanta.controller;

import edu.iu.secretsanta.services.Draw;

public class DrawController {
	private Draw draw;

	public DrawController(Draw draw) {
		this.draw = draw;
	}
	
	public String[] generateAssignments(final String participants[]){
		String[] assignments = draw.generateAssignments(participants);
		return assignments;
	}
}
