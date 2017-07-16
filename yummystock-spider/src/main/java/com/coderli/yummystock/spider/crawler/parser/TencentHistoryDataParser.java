package com.coderli.yummystock.spider.crawler.parser;

import com.coderli.yummystock.core.constant.RestorationType;
import com.coderli.yummystock.core.entity.HistoryStockData;
import com.coderli.yummystock.core.util.JsonUtil;
import com.coderli.yummystock.core.util.StringUtil;
import com.google.common.base.Strings;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

/**
 * @author li.hzh
 * @date 2016-12-01 00:07
 */
@Slf4j
@Component
public class TencentHistoryDataParser implements RawHistoryDataParser {
    
    @Override
    public List<HistoryStockData> parseRawData(String rawData, String fullStockCode, RestorationType restorationType) {
        List<HistoryStockData> dataList = Collections.emptyList();
        if (Strings.isNullOrEmpty(rawData)) {
            log.warn("[{}] raw data is null or empty.", fullStockCode);
            return dataList;
        }
        String[] dataKV = rawData.split("=");
        if (dataKV.length != 2) {
            log.warn("Invalid raw data pattern [{}]. [{}]", rawData, fullStockCode);
            return dataList;
        }
        String dataValue = dataKV[1];
        String dataArrayJsonString = JsonUtil.findValue(dataValue, "data", fullStockCode, restorationType.name() + "day");
        if (StringUtil.isNullOrEmpty(dataArrayJsonString)) {
            return Collections.EMPTY_LIST;
        }
        return JsonUtil.fromJson(dataArrayJsonString, List.class);
    }
    
    @Data
    private static class dataModel {
        
        @Data
        private static class data {
        }
        
        
        private String code;
        private String msg;
        
    }
    
}
