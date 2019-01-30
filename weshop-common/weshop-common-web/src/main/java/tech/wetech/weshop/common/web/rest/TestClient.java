package tech.wetech.weshop.common.web.rest;

import org.springframework.cloud.openfeign.FeignClient;
import tech.wetech.weshop.common.service.TestService;

@FeignClient("weshop-common-service")
public interface TestClient extends TestService {

}
