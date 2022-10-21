package com.cachinginapp.enterprise;

import com.cachinginapp.enterprise.dto.Cache;
import com.cachinginapp.enterprise.service.ICacheService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
class EnterpriseApplicationTests {

	@Autowired
	private ICacheService cacheService;
	private Cache cache;


	@Test
	void contextLoads() {
	}
	@Test

	void fetchCacheByID_returnsMtAuburnForID83(){
		givenCacheDataAreAvailable();
		whenSearchCacheWithID83();
		thenReturnOneMtAuburnCacheForID83();

	}

	private void givenCacheDataAreAvailable() {
	}


	private void whenSearchCacheWithID83() {
		cache = cacheService.fetchById(83);
	}

	private void thenReturnOneMtAuburnCacheForID83() {
		String description = cache.getDescription();
		assertEquals("Mount Auburn", description);

	}

}
