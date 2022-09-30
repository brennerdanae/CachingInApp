package com.cachinginapp.enterprise;

import com.cachinginapp.enterprise.dto.Cache;
import com.cachinginapp.enterprise.service.ICacheService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;


/**
 * <h1>CachingInApp Unit Tests</h1>
 *
 * <p>
 *     This class uses unit tests to provide a safety net for classes and methods within the application.
 *     So when changed they can confirm that your code is still working and not broken.
 * </p>
 *
 * @since 09/29/2022
 */
@SpringBootTest
class EnterpriseApplicationTests {

	@Autowired
	private ICacheService cacheService;
	private Cache cache;


	@Test
	void contextLoads() {
	}
	@Test
	void fetchCacheByID_returnsCacheLongAndLatforID11(){
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
		String latitude = cache.getLatitude();
		String longitude = cache.getLongitude();
		assertEquals("90", latitude);
		assertEquals("100", longitude);
	}

}
