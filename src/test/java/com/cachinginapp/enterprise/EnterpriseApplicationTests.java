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
	void fetchPostByID_returnsLOTRpostforID10(){
		givenCacheDataAreAvailable();
		whenSearchCacheWithID11();
		thenReturnCacheForID11();
	}

	private void givenCacheDataAreAvailable() {
	}

	private void whenSearchCacheWithID11() {
		cache = cacheService.fetchById(11);
	}

	private void thenReturnCacheForID11() {
		String description = cache.getDescription();
		assertEquals("I am a cache :)", description);
	}
}
