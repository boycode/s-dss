package com.dataflue.cip.persistence;

import java.util.List;

import com.dataflue.cip.persistence.entities.Consumer;
import com.dataflue.cip.persistence.repository.ConsumerRepository;
import com.github.springtestdbunit.DbUnitTestExecutionListener;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
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
	
	/**
	 * Minimal Integration Test - Connection - Hikari Source
	 */
	@Test
	public void search_NoTodoEntriesFound_ShouldReturnEmptyList() {
		List<Consumer> todoEntries = repository.search("NOT FOUND");
		assertThat(todoEntries.size(), is(0));
	}

}
