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
	void savePictureToCache_returnsCacheWithPicture() {
		givenSavedCacheSelected();
		whenUploadPhotoOfCache();
		thenReturnCacheWithAddedPicture();

	}

	private void givenSavedCacheSelected() {
	}

	private void whenUploadPhotoOfCache() {
		cache = cacheService.fetchCacheById(63);
	}

	private void thenReturnCacheWithAddedPicture() {
		String description = cache.getDescription();
		assertEquals("Filler description", description);
	}
}
