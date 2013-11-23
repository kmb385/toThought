package org.tothought.data.repositories;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.tothought.data.views.RecentDataLoadLogEntry;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:META-INF/test-context.xml"})
public class RecentDataLoadLogEntryRepositoryTest {

	@Autowired
	RecentDataLoadLogEntryRepository repository;
	
	@Test
	public void findByLoadName(){
		RecentDataLoadLogEntry dlle = repository.findByLoadName("GITHUB");
		assertNotNull(dlle);
		assertEquals("GITHUB",dlle.getLoadName());
		assertEquals(new Integer(1), dlle.getDataLoadLogEntryId());
	}
}
