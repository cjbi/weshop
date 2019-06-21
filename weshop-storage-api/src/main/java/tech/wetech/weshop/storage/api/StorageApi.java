package tech.wetech.weshop.storage.api;


import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;
import tech.wetech.weshop.common.api.Api;
import tech.wetech.weshop.common.utils.Result;
import tech.wetech.weshop.storage.po.Storage;

import java.io.IOException;


public interface StorageApi extends Api<Storage> {

    @PostMapping("/upload")
    Result<String> upload(MultipartFile file) throws IOException;

    @GetMapping("/fetch/{key:.+}")
    ResponseEntity<Resource> fetch(@PathVariable String key);

    @GetMapping("/download/{key:.+}")
    ResponseEntity<Resource> download(@PathVariable String key);
}
