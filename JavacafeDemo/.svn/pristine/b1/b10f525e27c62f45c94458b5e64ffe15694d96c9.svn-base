package kr.or.javacafe.test1.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.or.javacafe.test1.domain.Demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class Test1Repository {

	private final String PREFIX = "Test1Map."; 
	
	@Autowired
	SqlMapClientTemplate sqlMapClientTemplate;

	@SuppressWarnings("unchecked")
	public void insertDemo(Demo demo) {
		sqlMapClientTemplate.insert(PREFIX + "insertDemo", demo);
	}

	public List<HashMap> selectDemo() {
		return sqlMapClientTemplate.queryForList(PREFIX + "selectDemo");
	}
	
}