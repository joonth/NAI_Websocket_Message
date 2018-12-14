package com.hk.web;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.hk.web.daos.MessageDao;
import com.hk.web.dtos.MessageDto;


@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@Autowired
	private MessageDao dao;
	
	
	@RequestMapping(value = "/echo", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);		
		String formattedDate = dateFormat.format(date);		
		model.addAttribute("serverTime", formattedDate );		
		return "header";
	}
	
	@RequestMapping(value = "/getMessageList.do", method = RequestMethod.GET)
	public String getAllBoard(Locale locale, Model model, String n_receiver) {
		logger.info("메시지 리스트 출력", locale);
		System.out.println(n_receiver);
		List<MessageDto> list = dao.getMessageList(n_receiver);
		model.addAttribute("list", list);
		return "messagelist";
	}
	
	@RequestMapping(value = "/getMessage.do", method = RequestMethod.GET)
	public String getMessage(Locale locale, Model model, MessageDto dto) {
		logger.info("메시지 내용 출력", locale);
		MessageDto  mdto = dao.getMessage(dto.getN_seq());
		model.addAttribute("dto",mdto);
		return "messagecontent";
	}
	
	@RequestMapping(value = "/sendMessage.do", method = RequestMethod.GET)
	public String sendMessage(Locale locale, Model model, MessageDto dto) {
		logger.info("메시지 전송", locale);
		dao.sendMessage(dto);
		return "messagelist";
	}
	
	@RequestMapping(value = "/deleteMessage.do", method = RequestMethod.GET)
	public String deleteMessage(Locale locale, Model model, MessageDto dto, String n_receiver) {
		logger.info("메시지 삭제", locale);
		dao.deleteMessage(dto.getN_seq());
		List<MessageDto> list = dao.getMessageList(n_receiver);
		model.addAttribute("list", list);
		return "messagelist";
	}
	
}
