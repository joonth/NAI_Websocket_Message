package com.hk.web.daos;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

 
import com.hk.web.dtos.MessageDto;

@Repository
public class MessageDao {

	@Autowired
	private SqlSessionTemplate ssf;
	private String ns = "com.hk.web.";
	
	public String getMsgNum(String n_receiver) {
		List<MessageDto> list = new ArrayList<MessageDto>();
		list = ssf.selectList(ns+"getMsgNum",n_receiver);
		return String.valueOf(list.size());
	
	}
	
	public List<MessageDto> getMessageList(String n_receiver){
		return ssf.selectList(ns+"getMessageList", n_receiver);
	}
	
	public MessageDto getMessage(int n_seq) {
		return ssf.selectOne(ns+"getMessage", n_seq);
	}
	
	public void sendMessage (MessageDto dto) {
		ssf.insert(ns+"sendMessage", dto);
	}
	
	public void deleteMessage (int n_seq) {
		ssf.delete(ns+"deleteMessage", n_seq);
	}
	
}
