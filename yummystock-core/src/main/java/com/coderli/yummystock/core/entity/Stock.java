package com.coderli.yummystock.core.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

/**
 * @author li.hzh
 * @date 2017-07-17 15:46
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Stock {
    
    /**
     * 完整的股票代码，带sz、sh
     */
    private String symbol;
    private String name;
    private String code;
    
}
