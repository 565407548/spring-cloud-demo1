package com.zcj.statistics.client;

import com.zcj.statistics.domain.Currency;
import com.zcj.statistics.domain.ExchangeRatesContainer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(url = "${rates.url}", name = "rates-client", fallback = ExchangeRatesClientFallback.class)
public interface ExchangeRatesClient {

    @RequestMapping(method = RequestMethod.GET, value = "/latest")
    ExchangeRatesContainer getRates(@RequestParam("base") Currency base);

}
