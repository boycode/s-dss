package com.dataflue.cip.persistence;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.util.StopWatch;

import com.dataflue.cip.persistence.entities.Consumer;
import com.dataflue.cip.persistence.repository.ConsumerRepository;
import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.ExpectedDatabase;

/**
 * Inetegration Suite to  Test the DB 
 * 
 * @author Vishnu Sankar
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:dataflue-cip-persistence.xml" })
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class,
		DirtiesContextTestExecutionListener.class,
		TransactionalTestExecutionListener.class,
		DbUnitTestExecutionListener.class })
public class ConsumerRepositoryTest {

	@Autowired
	private ConsumerRepository repository;
	
	private StopWatch stopWatch = new StopWatch();
	
	/**
	 * Minimal Integration Test - Connection - Hikari Source
	 */
	@Test
	public void search_NoTodoEntriesFound_ShouldReturnEmptyList() {
		List<Consumer> todoEntries = repository.search("NOT FOUND");
		assertThat(todoEntries.size(), is(0));
	}
	
	/**
	 * Sample Test DB if needed - for 
	 */
	@Test
	@DatabaseSetup("/sampledata.xml")
	public void setUpDatabase_ShouldValidateAnEntry(){
		List<Consumer> returnConsumerList = (List<Consumer>)repository.findAll();
		assertEquals(16, returnConsumerList.size());
		assertEquals("Rajiv", returnConsumerList.get(0).getConsumerName());
		
	}
	
	/**
	 * Test time taken in ms for each DB fetch 
	 */
	@Test
    public void testRetrieveAll() throws Exception {
        stopWatch.start();
        repository.findAllConsumers();
        stopWatch.stop();
        System.out.println("time to retrieve all: " + stopWatch.getLastTaskTimeMillis() + "ms");
    }
     
	/**
	 * Test ehcache by calling testretriveAll()
	 *  multiple times and check time taken for each DB fetch
	 */
    @Test
    public void testMultipleRetrieveAll() throws Exception {
        for (int i=0;i<10;i++) {
            testRetrieveAll();
        }
    }
	
	/**
	 * 
	 * @throws Exception
	 */
	//@Test
	@DatabaseSetup("classpath:sampledata.xml")
	@ExpectedDatabase("classpath:expecteddata.xml")
	public void testRemove() throws Exception {
		repository.deleteAll();
	}
}
