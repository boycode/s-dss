/**
 * 
 */
package com.dataflue.cip.persistence.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Vishnu Sankar
 *
 */
@Entity
@Table(name = "CIP_CONSUMER")
public class Consumer {
	
	@Id
    @Column(name = "consumer_cid")
    private int consumerId;
	
	@Column(name="consumer_name")
	private String consumerName;
	
	@Column(name="consumer_key")
	private String consumerKey;
	
	@Column(name="consumer_address")
	private String consumerAddress;
	
	
	
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
