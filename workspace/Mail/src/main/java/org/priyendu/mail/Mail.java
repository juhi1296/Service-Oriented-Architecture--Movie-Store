package org.priyendu.mail;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;    
import javax.mail.*;    
import javax.mail.internet.*;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;    

@Path("/mail")
public class Mail {
	@POST
	//@Path("/{emailid}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public static void sendMail(final MailInfo tm) {    
        //from,password,to,subject,message  
		System.out.println("in method");
		Thread thread = new Thread(new Runnable(){
			  @Override
			  public void run(){
				  Mailer.send("sdpchatbot@gmail.com","sendingmail",tm.getEmailid(),"reminder",tm.getMsg(),tm.getTime());
			  }
			});
			thread.start();
          
        //change from, password and to
        //return new MailInfo().getInfo();
    }
	
	@GET
	@Path("/get")
	@Produces(MediaType.APPLICATION_JSON)
	public MailInfo getInfo(){
		//return new MailInfo().getInfo();
		//return "sgrs";
		
		return new MailInfo().getInfo();
	}
	
	@GET
	@Path("/try")
	@Produces(MediaType.TEXT_PLAIN)
	public String test(){
		return "okk";
	}
	
	@POST
	@Path("/{emailid}/{test}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String test(@PathParam("time") Date time,@PathParam("emailid") String emailid){
		System.out.println("{test}");
		return "ad  "+time+"  "+emailid+" "+new Date().toString();
		
	}
}


    
class Mailer{  
    public static void send(final String from,final String password,String to,String sub,String msg,String time){  
          //Get properties object    
    	DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd-HH:mm:ss");
    	String d=(dateFormat.format(new Date()));
        while(!d.equals(time)){
        	System.out.println(d+" "+time);
        	d=(dateFormat.format(new Date()));
        }
    	Properties props = new Properties();    
          props.put("mail.smtp.host", "smtp.gmail.com");    
          props.put("mail.smtp.socketFactory.port", "465");    
          props.put("mail.smtp.socketFactory.class",    
                    "javax.net.ssl.SSLSocketFactory");    
          props.put("mail.smtp.auth", "true");    
          props.put("mail.smtp.port", "465");    
          //get Session   
          Session session = Session.getDefaultInstance(props,    
           new javax.mail.Authenticator() {    
           protected PasswordAuthentication getPasswordAuthentication() {    
           return new PasswordAuthentication(from,password);  
           }    
          });    
          //compose message    
          try {    
           MimeMessage message = new MimeMessage(session);    
           message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));    
           message.setSubject(sub);    
           message.setText(msg);    
           //send message  
           Transport.send(message);    
           System.out.println("message sent successfully");    
          } catch (MessagingException e) {throw new RuntimeException(e);}    
             
    }  
}  