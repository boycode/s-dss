/**
 * 
 */
package com.dataflue.cip.persistence.entities;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * @author Vishnu Sankar
 *
 */
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Entity
@Table(name = "CIP_CONSUMER")
public class Consumer {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "consumer_cid")
    private int consumerId;
	
	@Column(name="consumer_name")
	private String consumerName;
	
	@Column(name="consumer_key")
	private String consumerKey;
	
	@Column(name="consumer_address")
	private String consumerAddress;
	
	
	/**
	 * Specifically for test database   
	 */
	public Consumer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Consumer(int consumerId, String consumerName, String consumerKey,
			String consumerAddress) {
		super();
		this.consumerId = consumerId;
		this.consumerName = consumerName;
		this.consumerKey = consumerKey;
		this.consumerAddress = consumerAddress;
	}

	public int getConsumerId() {
		return consumerId;
	}

	public void setConsumerId(int consumerId) {
		this.consumerId = consumerId;
	}

	public String getConsumerName() {
		return consumerName;
	}

	public void setConsumerName(String consumerName) {
		this.consumerName = consumerName;
	}

	public String getConsumerKey() {
		return consumerKey;
	}

	public void setConsumerKey(String consumerKey) {
		this.consumerKey = consumerKey;
	}

	public String getConsumerAddress() {
		return consumerAddress;
	}

	public void setConsumerAddress(String consumerAddress) {
		this.consumerAddress = consumerAddress;
	}

	
	

}
