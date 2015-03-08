package edu.iu.secretsanta.factories;

import edu.iu.secretsanta.services.Draw;
import edu.iu.secretsanta.services.impl.RandomDrawImpl;
import edu.iu.secretsanta.services.impl.ZigzagDrawImpl;

public class DrawServiceFactory {
	
	private static RandomDrawImpl randomDrawImpl;
	
	private static ZigzagDrawImpl zigzagDrawImpl;
	
	static{
		randomDrawImpl = new RandomDrawImpl();
		zigzagDrawImpl = new ZigzagDrawImpl();
	}
	
	private DrawServiceFactory(){
		
	}
	
	public static Draw getDrawService(String serviceName){
		Draw draw = null;
		
		if("Zigzag".equals(serviceName)){
			draw= zigzagDrawImpl;
		}
		else if("Random".equals(serviceName)){
			draw = randomDrawImpl;
		}
		
		return draw;
	}
	
}
