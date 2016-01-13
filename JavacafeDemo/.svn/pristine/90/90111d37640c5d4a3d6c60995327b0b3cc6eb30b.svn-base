package kr.or.javacafe.test1.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import kr.or.javacafe.test1.service.Test1Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping("/test1")
public class Test1Controller {
	
	private static final Logger logger = LoggerFactory.getLogger(Test1Controller.class);
	
	@Autowired
	Test1Service test1Service;
	

	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public String main(Locale locale, Model model) {
		logger.info("Welcome home! the client locale is "+ locale.toString());

		return "test1/main";
	}
	

	
	@RequestMapping(value = "/menu", method = RequestMethod.GET)
	public String menu(Locale locale, Model model) {
		logger.info("Menu start!!!");

		return "test1/menu";
	}

	
	
	@RequestMapping(value = "/demo1", method = RequestMethod.GET)
	public String demo1(Model model) {		
		logger.info("Demo1 start!!!");
		
		Calendar sTime = Calendar.getInstance();
		long s = System.currentTimeMillis();
		
		model.addAttribute("demoList", test1Service.findDemoList());	// Get List
		
		Calendar eTime = Calendar.getInstance();
		long e = System.currentTimeMillis();
				
		SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		long elapsed = (e-s);
		
		model.addAttribute("startTime", sdFormat.format(sTime.getTime()));
		model.addAttribute("endTime", sdFormat.format(eTime.getTime()));
		model.addAttribute("diffTime", elapsed);
		
		return "test1/demo1";
	}
	

	
	@RequestMapping(value = "/demo2", method = RequestMethod.GET)
	public String demo2(@RequestParam("boardId") String boardId, Model model) {		
		logger.info("Demo2 start!!!");
		
		Calendar sTime = Calendar.getInstance();
		long s = System.currentTimeMillis();
		
		model.addAttribute("demoList", test1Service.findCachingDemoList(boardId));	// Get List
		
		Calendar eTime = Calendar.getInstance();
		long e = System.currentTimeMillis();
				
		SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		long elapsed = (e-s);
		
		model.addAttribute("startTime", sdFormat.format(sTime.getTime()));
		model.addAttribute("endTime", sdFormat.format(eTime.getTime()));
		model.addAttribute("diffTime", elapsed);
		
		return "test1/demo2";
	}


	
	@RequestMapping(value = "/update/{boardId}", produces = "application/json")
	@ResponseBody
	public ResponseEntity<String> update(@PathVariable("boardId") String boardId) {
		logger.info("update start!!!");

		test1Service.updateDemoList(boardId);
		String strRet = "{\"result\":\"OK\"}";
		
		HttpHeaders header = new HttpHeaders();
		header.add("Content-Type", "application/json; charset=UTF-8");
		
		return new ResponseEntity<String>(strRet, header, HttpStatus.OK);
	}


	
	@RequestMapping(value = "/updateAll", produces = "application/json")
	@ResponseBody
	public ResponseEntity<String> updateAll() {
		logger.info("update start!!!");

		test1Service.updateAllDemoList();
		String strRet = "{\"result\":\"OK\"}";
		
		HttpHeaders header = new HttpHeaders();
		header.add("Content-Type", "application/json; charset=UTF-8");
		
		return new ResponseEntity<String>(strRet, header, HttpStatus.OK);
	}

	
	@RequestMapping(value = "/insert", produces = "application/json")
	@ResponseBody
	public ResponseEntity<String> insert() {
		logger.info("insert start!!!");

		test1Service.insertDemoList();
		String strRet = "{\"result\":\"OK\"}";
		
		HttpHeaders header = new HttpHeaders();
		header.add("Content-Type", "application/json; charset=UTF-8");
		
		return new ResponseEntity<String>(strRet, header, HttpStatus.OK);
	}


	
	
}
