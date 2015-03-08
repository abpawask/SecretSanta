package edu.iu.secretsanta.controller;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import edu.iu.secretsanta.services.Draw;

public class DrawControllerTestCase {
	
	private DrawController drawController;
	
	
	private Draw draw;

	@Before
	public void setUp() throws Exception {
		
		draw = Mockito.mock(Draw.class);
		drawController = new DrawController(draw);
	}

	@Test
	public void testGenerateAssignments() {
		
		String participants[] ={"Kyle","Kenny","Eric","Stan","Stewie","Brain","Ela","Ram"};
		
		String expectedAssignments[] = {"Stewie","Kyle","Stan","Brain","Ela","Ram","Kenny","Eric"};
		
		Mockito.when(draw.generateAssignments(participants)).thenReturn(expectedAssignments);
		
		String assignments[]= drawController.generateAssignments(participants);
		
		Assert.assertNotNull("", assignments);
		Assert.assertEquals("",  expectedAssignments.length, assignments.length);
		Assert.assertArrayEquals("", expectedAssignments, assignments);
	}

}
