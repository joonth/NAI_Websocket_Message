package com.hk.web.dtos;

public class MessageDto {

	private int n_seq;
	private String n_receiver;
	private String n_sender;
	private String n_time;
	private String n_content;
	private String ns_state_code;
	
	
	public int getN_seq() {
		return n_seq;
	}
	public void setN_seq(int n_seq) {
		this.n_seq = n_seq;
	}
	public String getN_receiver() {
		return n_receiver;
	}
	public void setN_receiver(String n_receiver) {
		this.n_receiver = n_receiver;
	}
	public String getN_sender() {
		return n_sender;
	}
	public void setN_sender(String n_sender) {
		this.n_sender = n_sender;
	}
	public String getN_time() {
		return n_time;
	}
	public void setN_time(String n_time) {
		this.n_time = n_time;
	}
	public String getN_content() {
		return n_content;
	}
	public void setN_content(String n_content) {
		this.n_content = n_content;
	}
	public String getNs_state_code() {
		return ns_state_code;
	}
	public void setNs_state_code(String ns_state_code) {
		this.ns_state_code = ns_state_code;
	}
	
	
	
	
}
