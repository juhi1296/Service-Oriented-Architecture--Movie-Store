package org.priyendu.mail;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class MailInfo {
	private String time;
	private String msg;
	private String emailid;
	
	
	
	public String getTime() {
		return time;
	}



	public void setTime(String time) {
		this.time = time;
	}



	public String getMsg() {
		return msg;
	}



	public void setMsg(String msg) {
		this.msg = msg;
	}



	public String getEmailid() {
		return emailid;
	}



	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}



	public MailInfo getInfo(){
		MailInfo mf=new MailInfo();
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd-HH:mm:ss");
		mf.setTime(dateFormat.format(new Date()));
		mf.setMsg("meeting at 60");
		mf.setEmailid("priyendu.mori@gmail.com");
		return mf; 
	}
}
