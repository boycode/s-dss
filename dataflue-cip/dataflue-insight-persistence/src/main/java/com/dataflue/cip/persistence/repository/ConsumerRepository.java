package com.dataflue.cip.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.dataflue.cip.persistence.entities.Consumer;

/**
 * 
 * @author Vishnu Sankar
 *
 */
public interface ConsumerRepository extends CrudRepository<Consumer,Integer>{

	    @Query("Select t FROM Consumer t WHERE LOWER(t.consumerName) LIKE LOWER(CONCAT('%', :searchTerm, '%'))")
	    public List<Consumer> search(@Param("searchTerm") String searchTerm);
}
