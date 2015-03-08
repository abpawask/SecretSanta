package edu.iu.secretsanta.services.impl;

import org.junit.Before;
import org.junit.Test;

public class RandomDrawImplTestCase extends AbstractDrawTestCase {
	
	
	@Before
	protected void setUp() throws Exception {
		super.setUp(new RandomDrawImpl());
	}
	
}
