package com.speechsoft.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.ArrayList;
import java.util.List;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import com.speechsoft.bean.Campaign;
import com.speechsoft.util.UccxUtility;

//@RequestMapping("/Outbound")
@Controller
public class ContactsController {

	@RequestMapping(value="/resetcontacts",method=RequestMethod.DELETE)
	public String deleteContacts(ModelMap map,@RequestParam String campaignName) {
		System.err.println("Inside resetcontacts..! Fwd to deleteContacts Page"+campaignName);
		String targetURL=null;
		try {
//			targetURL="http://198.18.133.19/adminapi/campaign/15/contacts";
			targetURL="http://10.1.53.198/adminapi/campaign/3/contacts";

			RestTemplate restTemplate = new RestTemplate();

			//Create a list for the message converters
			List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>();

			//Add the Jackson Message converter
			messageConverters.add(new MappingJacksonHttpMessageConverter());
			restTemplate.setMessageConverters(messageConverters); 

			String base64Creds = UccxUtility.convertToBase64("administrator:Sp33chs0ft");

			HttpHeaders headers = new HttpHeaders();
//			headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
			headers.setContentType(MediaType.TEXT_XML);
			headers.set("username", "administrator");
			headers.set("password", "Sp33chs0ft");
			headers.add("Authorization", "Basic " + base64Creds);

			HttpEntity<String> request = new HttpEntity<String>(headers);
			ResponseEntity<Campaign> response = restTemplate.exchange(targetURL, HttpMethod.DELETE, request, Campaign.class);

			Campaign responseCampaign= response.getBody();
			System.err.println("responseCampaign:--> "+responseCampaign);
			if (HttpStatus.OK == response.getStatusCode()) 
				System.err.println("Success:---> hurray..!"+response);
			else 
				System.err.println("OOps..got some Error"+response);

			System.err.println("Response:--> "+response);
			targetURL="contactsPage";
		}
		catch(Exception e)
		{
			System.out.println("GENERIC Exception " +e);
			targetURL= "errorpage";
		}
		System.err.println("exit deleteContacts.!!");
		return "campaigns"; 
	}

}