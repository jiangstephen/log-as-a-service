package com.example.springsplunk;

import java.util.HashMap;
import java.util.Map;

import org.apache.http.impl.bootstrap.HttpServer;

import com.splunk.Args;
import com.splunk.HttpService;
import com.splunk.Receiver;
import com.splunk.SSLSecurityProtocol;
import com.splunk.Service;

public class SplunkLogging {
	
	public static void main(String args[]){
		HttpService.setSslSecurityProtocol(SSLSecurityProtocol.TLSv1_2);
		Map<String, Object> connectionArgs = new HashMap<String, Object>();
		connectionArgs.put("host", "sjiang-vm");
		connectionArgs.put("username", "admin");
		connectionArgs.put("password", "Abc@12345");
		connectionArgs.put("port", 8089);
		connectionArgs.put("scheme", "https");
		Service splunkService = Service.connect(connectionArgs);
		
		Receiver receiver = splunkService.getReceiver();
		Args logArgs = new Args();
		logArgs.put("sourcetype", "hellosplunk");
		for(int i=0;i<20; i++){
			System.out.println("Writing the log into splunk " + i);
			receiver.log("main", logArgs, "hello splunk event" +i);
		}
		
		System.exit(0);
	}

}
