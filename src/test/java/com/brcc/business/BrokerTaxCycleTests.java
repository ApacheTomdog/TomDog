package com.brcc.business;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.brcc.business.brokerTax.service.BrokerTaxCycleService;
import com.brcc.business.brokerTax.vo.BrokerTaxCycleVo;



@RunWith(SpringRunner.class)
@SpringBootTest
public class BrokerTaxCycleTests {
	
	@Autowired
	private BrokerTaxCycleService brokerTaxCycleService;
	
	@Test
	public void queryCycleList() {
		List<BrokerTaxCycleVo> voList = brokerTaxCycleService.queryCycleList();
		assertNotNull(voList);
		
		voList.forEach(vo -> System.out.println(vo.getBrokerTaxCycleName()));
	}
	
}
