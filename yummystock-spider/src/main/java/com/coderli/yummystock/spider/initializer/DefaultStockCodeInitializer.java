package com.coderli.yummystock.spider.initializer;

import com.coderli.yummystock.core.entity.Stock;
import com.coderli.yummystock.core.service.StockService;
import com.coderli.yummystock.core.util.BeanUtil;
import com.coderli.yummystock.spider.spider.StockSpider;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * @author li.hzh
 * @date 2017-07-20 22:59
 */
@Slf4j
public class DefaultStockCodeInitializer implements StockCodeInitializer {
    
    @Override
    public void init() {
        StockSpider stockSpider = BeanUtil.getBean(StockSpider.class);
        if (stockSpider == null) {
            log.error("No stock spider configured. Can not init stock code.");
            return;
        }
        List<Stock> stockList = stockSpider.getAllStock();
        StockService stockService = BeanUtil.getBean(StockService.class);
        stockService.saveStocks(stockList);
    }
}


