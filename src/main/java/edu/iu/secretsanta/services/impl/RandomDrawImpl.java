package edu.iu.secretsanta.services.impl;

import java.util.Random;

import edu.iu.secretsanta.services.Draw;

public class RandomDrawImpl implements Draw {

	private String[] getRemainingAssignments(String input[], int replaceIndex) {
		input[replaceIndex] = input[input.length - 1];

		String replaceInputArray[] = new String[input.length - 1];

		for (int i = 0; i < replaceInputArray.length; i++)
			replaceInputArray[i] = input[i];

		return replaceInputArray;
	}

	public String[] generateAssignments(String[] participants) {
		String assignments[] = new String[participants.length];

		String remainingAssignments[] = new String[participants.length];

		for (int i = 0; i < participants.length; i++) {
			remainingAssignments[i] = participants[i];
		}

		Random randomAssignment = new Random();
		for (int i = assignments.length - 1; i >= 2; i--) {
			if (i >= 2) {
				int currentAssignmentIndex = randomAssignment.nextInt(i - 1);
				String currentAssignment = remainingAssignments[currentAssignmentIndex];
				remainingAssignments = getRemainingAssignments(
						remainingAssignments, currentAssignmentIndex);

				assignments[i] = currentAssignment;
			}

		}

		assignments[1] = remainingAssignments[0];
		assignments[0] = remainingAssignments[1];

		return assignments;
	}

}
