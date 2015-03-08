package edu.iu.secretsanta.services.impl;

import edu.iu.secretsanta.services.Draw;

public class ZigzagDrawImpl implements Draw {

	public String[] generateAssignments(String[] participants) {
		String[] assignments = new String[participants.length];
		
		int leftStart=0, leftEnd = participants.length/2-1;
		int rightStart= leftEnd+1, rightEnd= participants.length-1;
				
		leftStart=0; 
		leftEnd = participants.length/2-1;
		 
		rightEnd= participants.length-1;
		
		if(participants.length % 2 ==0)
		{
			rightStart= leftEnd+1;
		}
		else
		{
			rightStart = leftEnd + 2; 
		}
		
		
		int leftTracker, rightStartTracker= rightStart, rightEndTracker= rightEnd;
		
		for(leftTracker = leftEnd; leftTracker>= leftStart; leftTracker--)
		{
			if(leftTracker % 2 ==0)
			{
				assignments[leftTracker]= participants[rightEndTracker];
				rightEndTracker--;
			}
			else
			{
				assignments[leftTracker]= participants[rightStartTracker];
				rightStartTracker++;
			}
		}
		
		int rightTracker, leftStartTracker, leftEndTracker;
		
		if(participants.length % 2 ==0)
		{
			leftStartTracker= leftStart;
			leftEndTracker= leftEnd;
		}
		else
		{
			assignments[participants.length/2]= participants[0];
			leftStartTracker= leftStart+1;
			leftEndTracker= leftEnd+1;
		}
		
		for(rightTracker = rightStart; rightTracker <= rightEnd; rightTracker++)
		{
			if(rightTracker % 2 ==0)
			{
				assignments[rightTracker]= participants[leftStartTracker++];
			}
			else
			{
				assignments[rightTracker]= participants[leftEndTracker--];
			}
		}
		
		return assignments;
	}

}
