package client;

import javax.ws.rs.core.MediaType;

import business.SubscriberDTO;
import restinterface.RestInterface;

public class SubscribeReaders {
	private static final String URL_SUBSCRIBER_1 = "http://localhost:8080/CQRSReader_cor/events";
	private static final String URL_SUBSCRIBER_2 = "http://localhost:8080/CQRSReader2_cor/events";
	private static final String URL_PUB_SUB = "http://localhost:8080/HubPubSubService_cor/subscribers";

public static void main(String[] args) {
	
	
	// inscrire(subscribe) les 2 services CQRSReader pour recevoir les mises a jour concernant la topic "film" 
			SubscriberDTO dto1 = new SubscriberDTO("film",URL_SUBSCRIBER_1);
			SubscriberDTO dto2 = new SubscriberDTO("film",URL_SUBSCRIBER_2);
		
			
			new RestInterface().postRemoteObject(URL_PUB_SUB,MediaType.APPLICATION_XML, SubscriberDTO.class,dto1);
			
			new RestInterface().postRemoteObject(URL_PUB_SUB,MediaType.APPLICATION_XML, SubscriberDTO.class,dto2);
			
			
			
			System.out.println("subscription des readers terminee"); 
			
			
}
}
