package edu.iu.secretsanta.services.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.HashSet;

import org.junit.Before;
import org.junit.Test;

import edu.iu.secretsanta.services.Draw;
import junit.framework.TestCase;

public class AbstractDrawTestCase extends TestCase {
	private Draw drawInstance;
	
	
	@Before
	protected void setUp(Draw draw) throws Exception {
		this.drawInstance = draw;
	}
	@Test
	public void testGenerateAssignmentsWithEvenInput(){
		final String participants[] ={"Kyle","Kenny","Eric","Stan","Stewie","Brain","Ela","Ram"};		
		final String assignments[];
		assignments = drawInstance.generateAssignments(participants);
		
		testGenerateAssignments(participants, assignments);
	}
	
	@Test
	public void testGenerateAssignmentsWithOddInput(){
final String participants[] ={"Kyle","Kenny","Eric","Stan","Stewie","Brain","Ela"};
		
		String assignments[];
		assignments = drawInstance.generateAssignments(participants);
		
		testGenerateAssignments(participants, assignments);
	}
	
	private void testGenerateAssignments(String participants[], String assignments[])
	{
		assertEquals(participants.length, assignments.length);
		
		testOneToOtherPersonAssignment(participants, assignments);
		testPassedListofParticipants(participants, assignments);
	}
	
	private void testOneToOtherPersonAssignment(String participants[], String assignments[])
	{
		for(int i=0;i< participants.length;i++)
		{
			if(participants[i].equals(assignments[i]))
			{
				fail("person can't be assigned to himself");
			}
		}				
	}
	
	private void testPassedListofParticipants(String participants[], String assignments[])
	{
		HashSet<String> assignedNamesDomain = new HashSet<String>();
		
		for(int i=0;i< participants.length;i++)
			assignedNamesDomain.add(participants[i]);
		
		for(int i=0;i< assignments.length;i++)
		{
			if(!assignedNamesDomain.contains(assignments[i]))
				fail("All particpants must be from passed list of participants");
		}
	}
}
