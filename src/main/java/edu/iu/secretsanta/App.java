package edu.iu.secretsanta;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import edu.iu.secretsanta.controller.DrawController;
import edu.iu.secretsanta.factories.DrawServiceFactory;
import edu.iu.secretsanta.services.Draw;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	Map<Integer, String> userOptionServiceMapper = new HashMap<Integer, String>();
    	userOptionServiceMapper.put(1, "Random");
    	userOptionServiceMapper.put(2, "Zigzag");
    	System.out.println("Select method to generate assignments:\n1 for Random\n2 for Zigzag.");
    	Scanner scanner = new Scanner(System.in);
    	int userOption = scanner.nextInt();
    	
    	String serviceSelected =  userOptionServiceMapper.get(userOption);
    	if(serviceSelected!= null){
    		Draw draw = DrawServiceFactory.getDrawService("Random");
            DrawController drawController = new DrawController(draw);
            
            final String participants[] ={"Kyle","Kenny","Eric","Stan","Stewie","Brain","Ela"};
            
            String assignments[];
    		assignments = drawController.generateAssignments(participants);
    		
    		for(int i=0 ; i < assignments.length;i++)
    		{
    			System.out.println(participants[i]+"->"+ assignments[i]);
    		}	
    	}
    	
    	
    }
}
