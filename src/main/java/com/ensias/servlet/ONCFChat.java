package com.ensias.servlet;


import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.restfb.DefaultFacebookClient;
import com.restfb.DefaultJsonMapper;
import com.restfb.FacebookClient;
import com.restfb.JsonMapper;
import com.restfb.Parameter;
import com.restfb.Version;
import com.restfb.types.send.IdMessageRecipient;
import com.restfb.types.send.Message;
import com.restfb.types.send.SendResponse;
import com.restfb.types.webhook.WebhookEntry;
import com.restfb.types.webhook.WebhookObject;
import com.restfb.types.webhook.messaging.MessagingItem;


@WebServlet("/Webhook")
public class ONCFChat extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
  

	//FB access Token
	private String accessToken="EAAMp0XTKmKIBAKHNZCcj3qM5XdMULRNq1CDP5keHIIWCZCuZBn4zAw6fG8xEcP1rZBZAVh0QqZCWqwBXKtGKooNMDGtW3wytbS5oOws0N047sy0fpeteZA7SRWj6e57RPlIxxW24dWmQjIKZBHljnSB8nLFbTOvaarEK2YANZCTvhxmANk6yt3tl7K1v5mLJKmWoZD";
	//URL verification
	private String verifyToken="maroc2018";
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String hubToken=request.getParameter("hub.verify_token");
		String hubChallenge=request.getParameter("hub.challenge");
		
		if(verifyToken.equals(hubToken))
		{
			response.getWriter().write(hubChallenge);
			response.getWriter().flush();
			response.getWriter().close();
		}
		else {
			response.getWriter().write("incorrect token");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Read POST body
		StringBuffer sb = new StringBuffer();
		BufferedReader br = request.getReader();
		String line = "";
		
		while((line = br.readLine()) != null)
		{
			sb.append(line);
		}
		//Convert java string to java object
		JsonMapper mapper = new DefaultJsonMapper();
		WebhookObject webhookObj = mapper.toJavaObject(sb.toString(), WebhookObject.class);
		
		for(WebhookEntry entry : webhookObj.getEntryList())
		{
			if(entry.getMessaging()!= null)
			{
				for(MessagingItem mItem : entry.getMessaging())
				{
					String senderId = mItem.getSender().getId();
					IdMessageRecipient recipient = new IdMessageRecipient(senderId);
					
					//Receive text message
					if(mItem.getMessage() != null && mItem.getMessage().getText() != null)
					{
						sendMessage(recipient, new Message("Hi"));
					}
				}
			}
		}
	}
	
	void sendMessage(IdMessageRecipient recipient,Message message){
		
		FacebookClient pageClient = new DefaultFacebookClient(accessToken, Version.VERSION_2_6);

		SendResponse resp = pageClient.publish("me/messages", SendResponse.class,
		     Parameter.with("recipient", recipient), // the id or phone recipient
			 Parameter.with("message", message)); // one of the messages from above
	}

}
