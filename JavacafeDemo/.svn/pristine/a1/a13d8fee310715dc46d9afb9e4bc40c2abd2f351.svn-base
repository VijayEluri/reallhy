package kr.or.javacafe;

import kr.or.javacafe.test1.domain.Demo;
import kr.or.javacafe.test1.service.Test1Service;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly=true)
@TransactionConfiguration(defaultRollback=false)
public class DataInit extends AbstractTestCaseRunWithSpring {

	@Autowired
	Test1Service test1Service;
	
	@Test
	public void tableInit() {
		List objList = new ArrayList();
		for (int i=0; i<10000; i++) {
			Demo demo = new Demo();
			demo.setId((i+1));
			demo.setData("data" + (i+1));
			
			objList.add(demo);
		}
		
		test1Service.addDemoForTest(objList);
		assertThat(1, is(1));
	}
}
