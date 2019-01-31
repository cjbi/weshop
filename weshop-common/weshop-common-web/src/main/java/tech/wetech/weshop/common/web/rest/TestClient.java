package tech.wetech.weshop.common.web.rest;

import org.springframework.cloud.openfeign.FeignClient;
import tech.wetech.weshop.common.service.TestService;
import tech.wetech.weshop.common.web.fallback.TestClientFallback;

@FeignClient(value = "weshop-common-service",fallback = TestClientFallback.class)
public interface TestClient extends TestService {

}
