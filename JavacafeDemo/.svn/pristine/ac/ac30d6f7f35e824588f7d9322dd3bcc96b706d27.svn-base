package kr.or.javacafe.test1.service;

import java.text.SimpleDateFormat;
import java.util.*;

import kr.or.javacafe.test1.domain.Demo;
import kr.or.javacafe.test1.repository.Test1Repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional(readOnly=true)
public class Test1Service {

	@Autowired
	Test1Repository testRepository;

	
	@Transactional
	public void addDemoForTest(List<Demo> objList) {
		for (Demo demo : objList) {
			testRepository.insertDemo(demo);
		}
	}
	
	
	public List<String> findDemoList() {
		List<String> objList = new ArrayList();
		
		List<HashMap> objDemoList = testRepository.selectDemo();
		for (HashMap m : objDemoList) {
			objList.add((String)m.get("data_1"));
		}
		
		return objList;
	}
	
	
	@Cacheable(value="sampleCache", key="#boardId")
	public List<String> findCachingDemoList(String boardId) {
		List<String> objList = new ArrayList();
		
		List<HashMap> objDemoList = testRepository.selectDemo();
		for (HashMap m : objDemoList) {
			objList.add((String)m.get("data_1"));
		}
		
		return objList;		
	}
	
	
	@CacheEvict(value="sampleCache", allEntries=true)
	public void updateAllDemoList() {
		// Update Raw Data
	}
	
	
	@CacheEvict(value="sampleCache", key="#boardId")
	public void updateDemoList(String boardId) {
		// Update Raw Data
	}

	
	@CacheEvict(value="sampleCache", allEntries=true)
	public void insertDemoList() {
		
		SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		Calendar sTime = Calendar.getInstance();
		
		String strNow = sdFormat.format(sTime.getTime());
		
		Demo demo = new Demo();
		demo.setId(0);
		demo.setData(strNow);
		
		testRepository.insertDemo(demo);
	}

}
























