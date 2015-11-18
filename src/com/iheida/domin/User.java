package com.iheida.domin;


import java.sql.Timestamp;


public class User {  
	private int id;    
	private String username;        //用户名
	private String student_id;      //学号
	private int state;              //是否审核
	private Timestamp publish_time;       //发布时间
	private String event_name;       //事件名称
	private String community_name;   //社团名称
	private String event_content;  //事件内容
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getStudent_id() {
		return student_id;
	}
	public void setStudent_id(String student_id) {
		this.student_id = student_id;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public Timestamp getPublish_time() {
		return publish_time;
	}
	public void setPublish_time(Timestamp publish_time) {
		this.publish_time = publish_time;
	}
	public String getEvent_name() {
		return event_name;
	}
	public void setEvent_name(String event_name) {
		this.event_name = event_name;
	}
	public String getCommunity_name() {
		return community_name;
	}
	public void setCommunity_name(String community_name) {
		this.community_name = community_name;
	}
	public String getEvent_content() {
		return event_content;
	}
	public void setEvent_content(String event_content) {
		this.event_content = event_content;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((community_name == null) ? 0 : community_name.hashCode());
		result = prime * result
				+ ((event_content == null) ? 0 : event_content.hashCode());
		result = prime * result
				+ ((event_name == null) ? 0 : event_name.hashCode());
		result = prime * result + id;
		result = prime * result
				+ ((publish_time == null) ? 0 : publish_time.hashCode());
		result = prime * result + state;
		result = prime * result
				+ ((student_id == null) ? 0 : student_id.hashCode());
		result = prime * result
				+ ((username == null) ? 0 : username.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (community_name == null) {
			if (other.community_name != null)
				return false;
		} else if (!community_name.equals(other.community_name))
			return false;
		if (event_content == null) {
			if (other.event_content != null)
				return false;
		} else if (!event_content.equals(other.event_content))
			return false;
		if (event_name == null) {
			if (other.event_name != null)
				return false;
		} else if (!event_name.equals(other.event_name))
			return false;
		if (id != other.id)
			return false;
		if (publish_time == null) {
			if (other.publish_time != null)
				return false;
		} else if (!publish_time.equals(other.publish_time))
			return false;
		if (state != other.state)
			return false;
		if (student_id == null) {
			if (other.student_id != null)
				return false;
		} else if (!student_id.equals(other.student_id))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}
	
	
	

}
