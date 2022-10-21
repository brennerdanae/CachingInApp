package com.cachinginapp.enterprise;

import com.cachinginapp.enterprise.dao.ICacheDAO;
import com.cachinginapp.enterprise.dto.Cache;
import com.cachinginapp.enterprise.service.CacheServiceStub;
import com.cachinginapp.enterprise.service.ICacheService;
import com.mysql.cj.x.protobuf.MysqlxDatatypes;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class EnterpriseApplicationTests {


	private ICacheService cacheService;
	private Cache cache = new Cache();

	@MockBean
	private ICacheDAO cacheDAO;


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

	@Test
	void fetchCacheByID_returnsMountainOverlookForID420() throws Exception {
		givenCacheDataAreAvailable();
		whenSearchCacheWithID420();
		thenReturnOneMountainOverlookCacheForID420();
	}

	private void givenCacheDataAreAvailable() throws Exception{
		Mockito.when(cacheDAO.save(cache)).thenReturn(cache);
		cacheService = new CacheServiceStub(cacheDAO);
	}

	private void whenSearchCacheWithID420() { cache = cacheService.fetchCacheById(420); }

	private void thenReturnOneMountainOverlookCacheForID420() {
		String description = cache.getDescription();
		assertEquals("Mountain Overlook", description);
	}

	@Test
	void saveCache_validateReturnCacheWithLatitudeAndLongitude() throws Exception {
		givenCacheDataAreAvailable();
		whenUserCreatesANewCacheAndSaves();
		thenCreateNewCacheRecordAndReturnIt();
	}

	private void whenUserCreatesANewCacheAndSaves() {
		cache.setLatitude("35.3606");
		cache.setLongitude("138.7274");
	}

	private void thenCreateNewCacheRecordAndReturnIt() throws Exception {
		Cache createdCache = cacheService.save(cache);
		assertEquals(cache, createdCache);
		verify(cacheDAO, atLeastOnce()).save(cache);
	}
}
