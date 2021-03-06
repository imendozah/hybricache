/**
 * 
 */
package org.hybricache.needRedisRunning.ehCacheTests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.List;

import org.hybricache.HybriCacheConfiguration;
import org.hybricache.needRedisRunning.BaseTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.CollectionUtils;

/**
 * The BaseTest class
 *
 * @author Batir Akhmerov
 * Created on Jan 26, 2017
 */
@RunWith(SpringJUnit4ClassRunner.class)
@DirtiesContext
@ContextConfiguration(classes = {LocalCacheAppConfig1.class})
public class LocalCachePerformaceTest1 extends BaseTest {
	
	@Test
	public void test() {
		String cacheName = "ehCache";
		
		List<HybriCacheConfiguration> confList = this.cacheManager.getHybriCacheConfigurationList();
		assertFalse(CollectionUtils.isEmpty(confList));
		
		HybriCacheConfiguration remoteConf = confList.get(0);
		assertEquals(cacheName, remoteConf.getCacheName());
		
		String key = "1";
		
		String[][] testValues = new String[][]{
			new String[]{key, "Jan"}
		};
		testCacheValues(cacheName, testValues);
		
		testPerformance(cacheName, key, 3000);
	}
	
	
}
