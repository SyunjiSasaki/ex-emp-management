package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

import jp.co.sample.domain.Administrator;
import jp.co.sample.repository.AdministratorRepository;

@SpringBootConfiguration
@SpringBootTest
public class RepositoryTest {

	@Autowired
	private AdministratorRepository administratorRepository;
	
	@Test
	void testAssert1() {
		Administrator ad = administratorRepository.load(2);
		String name = ad.getName();
		assertEquals("佐々木隼嗣",name,"名前が一致する");
	}
	
	
	
}
