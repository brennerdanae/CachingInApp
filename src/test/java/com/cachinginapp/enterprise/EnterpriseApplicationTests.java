package com.cachinginapp.enterprise;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class EnterpriseApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	private ICacheService cacheService;
	private Cache cache;

}
