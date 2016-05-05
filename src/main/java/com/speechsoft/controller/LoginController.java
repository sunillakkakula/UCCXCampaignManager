package com.speechsoft.controller;

import java.util.ArrayList;
import java.util.List;

import javax.xml.transform.Result;
import javax.xml.ws.Response;

import org.codehaus.jackson.map.util.JSONPObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.speechsoft.bean.Campaign;
import com.speechsoft.bean.UserDetails;
import com.speechsoft.service.LoginService;
import com.speechsoft.util.UccxUtility;
//@RequestMapping("/Outbound")
@Controller
public class LoginController {

	@RequestMapping(value="/login", method= {RequestMethod.GET, RequestMethod.POST})
	public String login(ModelMap map){
		
		System.err.println("Inside login..!");
		/*String targetURL="http://192.168.0.101:8080/UCCXVerS3/Outbound/authenticateuser";
		RestTemplate restTemplate = new RestTemplate();

		//Create a list for the message converters
		List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>();

		//Add the Jackson Message converter
		messageConverters.add(new MappingJacksonHttpMessageConverter());
		restTemplate.setMessageConverters(messageConverters); 

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		HttpEntity<String> entity = new HttpEntity<String>(requestJson,headers);
		restTemplate.put(uRL, entity);
		
		HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
		ResponseEntity<String> response = restTemplate.postForEntity(targetURL,  requestEntity, String.class);
		
		if (response.equals("dashboard")) {
			System.err.println("Forwarding to Dashboard Page");
			return "dashboard";
		}else{
			System.err.println("Forwarding to Login Page");
			return "login";
		}*/
		return "login";
	}

	@RequestMapping(value = "/authenticateuser", method= {RequestMethod.GET, RequestMethod.POST})//,headers = "Accept=application/json,Content-type=application/json")
	public  @ResponseBody String authenticateUser(@RequestBody UserDetails userDetails , Model model) {
		System.err.println("Inside authenticateUser..!");
		String userName,userPwd=null;
		System.out.println(" User name: " + userDetails.getUserName()+", User Password:"+userDetails.getUserPassword());
		userName= userDetails.getUserName();
		userPwd=userDetails.getUserPassword();
		
		if (userName.equalsIgnoreCase("adminstrator")&&userPwd.equalsIgnoreCase("Sp33chs0ft")) {
			System.err.println("Forwarding to Dashboard Page");
			return "dashboard";
		}else{
			System.err.println("Forwarding to Login Page");
			return "login";
		}
	}

	@RequestMapping(value="/validateuser",method=RequestMethod.POST)//, consumes = {"application/json"})
	public String validateUser(ModelMap map){
		System.err.println("Inside validateUser..!");
		String targetPageURL="";
		LoginService loginService=new LoginService();
		//		System.err.println("userDetails : "+userDetails.getUserName()+", Password: "+userDetails.getUserPassword());
		/*if(loginService.validateUserCredentials(userDetails)){
			System.err.println("Done validateUserCredentials():-->Valid user");
			targetPageURL="dashboard";
		}
		else{
			System.err.println("Done validateUserCredentials():-->InValid user");
			targetPageURL="login";
		}*/
		System.err.println("exit validateUser.!!");
		return targetPageURL; 

	}
	@RequestMapping(value="/dashboard",method= RequestMethod.GET)
	public String dashboard(ModelMap map){
		System.err.println("Inside dashboard()..!");

		System.err.println("exit dashboard().!!");
		return "dashboard"; 

	}
	@RequestMapping(value="/logout",method=RequestMethod.GET)
	public String logout(ModelMap map){
		System.err.println("Inside logout..!");

		System.err.println("exit logout.!!");
		return "login"; 
	}
}
