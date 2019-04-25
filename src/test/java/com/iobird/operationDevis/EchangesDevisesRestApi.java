package com.iobird.operationDevis;

import com.iobird.echangesdevises.repository.DeviseRepository;
import com.iobird.echangesdevises.repository.EchangeDevisesAchatRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EchangesDevisesRestApi {

	@Autowired
	EchangeDevisesAchatRepository echangeDevisesAchatRepository;

	@Autowired
	DeviseRepository deviseRepository;


	@Test
	public void fetchDevise() {
		deviseRepository.findById(1l);
	}
}

