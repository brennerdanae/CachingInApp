package com.cachinginapp.enterprise;

import com.cachinginapp.enterprise.dto.Cache;
import com.cachinginapp.enterprise.service.ICacheService;
import com.mysql.cj.x.protobuf.MysqlxDatatypes;
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
	void fetchCacheByID_returnsMountainOverlookForID420() {
		givenCacheDataAreAvailable();
		whenSearchCacheWithID420();
		thenReturnOneMountainOverlookCacheForID420();
	}

	private void givenCacheDataAreAvailable() {
	}

	private void whenSearchCacheWithID420() {
		cache = cacheService.fetchCacheById(420);
	}

	private void thenReturnOneMountainOverlookCacheForID420() {
		String description = cache.getDescription();
		assertEquals("Mountain Overlook", description);
	}
}
