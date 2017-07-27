package com.coderli.yummystock.test.spider;

import com.coderli.yummystock.core.constant.RestorationType;
import com.coderli.yummystock.core.entity.HistoryStockData;
import com.coderli.yummystock.spider.spider.NetEaseDailyDataSpider;
import com.coderli.yummystock.spider.spider.NetEaseHistoryDataSpider;
import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;

/**
 * @author li.hzh
 * @date 2017-07-27 16:03
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpiderTestConfig.class)
public class NetEaseDailySpiderTest {
    
    @Autowired
    private NetEaseDailyDataSpider netEaseCrawler;
    
    private Date from;
    private Date to;
    
    
    @Before
    public void init() {
        from = DateTime.parse("2017-07-27").toDate();
        to = DateTime.parse("2017-07-27").toDate();
    }
    
    @Test
    public void testCrawlDailyData() {
        String stockCode = "600887";
        List<HistoryStockData> stockDataList = netEaseCrawler.crawlHistoryData(stockCode, from, to, RestorationType.qfq);
//        System.out.println(stockDataList.size());
//        for (HistoryStockData historyStockData : stockDataList) {
//            System.out.println(historyStockData.getDate());
//        }
//        System.out.println(stockDataList);
    }
}
