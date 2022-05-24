package com.portfolio.loadcsv.rabbitmq.connections;

import javax.annotation.PostConstruct;

import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class RabbitMqConnection {
	
   private AmqpAdmin amqpAdmin;
   
   private RabbitMqConnection(AmqpAdmin amqpAdmin) {
	   this.amqpAdmin = amqpAdmin;
	   
   }
	
	@Value("${spring.rabbitmq.exchangename}")
	private String exchangeName;
	
	@Value("${spring.rabbitmq.queuecarparts}")
	private String queueCarParts;
	
	private Binding biding(Queue queue, DirectExchange de) {
	    return new Binding(queue.getName(), Binding.DestinationType.QUEUE, de.getName(), queue.getName(), null);
	}

	@PostConstruct
	private void add(){
	    Queue qCarParts = new Queue(queueCarParts, false, false, false);
		DirectExchange de = new DirectExchange(exchangeName);
	    Binding bindingCarParts = this.biding(qCarParts, de);

	    //Crate Queue in RabbitMQ
	    this.amqpAdmin.declareQueue(qCarParts);
	    this.amqpAdmin.declareExchange(de);
	    this.amqpAdmin.declareBinding(bindingCarParts);
	  }
}
