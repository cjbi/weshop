package tech.wetech.weshop.storage;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import tech.wetech.weshop.core.utils.CharUtil;
import tech.wetech.weshop.mapper.StorageMapper;
import tech.wetech.weshop.po.Storage;

import java.io.InputStream;
import java.nio.file.Path;
import java.util.stream.Stream;

/**
 * 提供存储服务类，所有存储服务均由该类对外提供
 */
public class StorageService {

    private String active;

    private IStorage storage;

    @Autowired
    private StorageMapper storageMapper;

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public IStorage getStorage() {
        return storage;
    }

    public void setStorage(IStorage storage) {
        this.storage = storage;
    }

    /**
     * 存储一个文件对象
     *
     * @param inputStream   文件输入流
     * @param contentLength 文件长度
     * @param contentType   文件类型
     * @param fileName      文件索引名
     */
    public String store(InputStream inputStream, long contentLength, String contentType, String fileName) {
        String key = generateKey(fileName);
        storage.store(inputStream, contentLength, contentType, key);

        String url = generateUrl(key);

        Storage storage = new Storage();
        storage.setKey(key);
        storage.setName(fileName);
        storage.setType(contentType);
        storage.setSize(contentLength);
        storage.setUrl(url);
        storage.setSource("");

        storageMapper.insertSelective(storage);

        return url;
    }

    private String generateKey(String originalFilename) {
        int index = originalFilename.lastIndexOf('.');
        String suffix = originalFilename.substring(index);

        String key = null;
        Storage storage = null;

        do {
            key = CharUtil.getRandomString(20) + suffix;
            String finalKey = key;
            storage = storageMapper.selectOne(new Storage(){{setKey(finalKey);}});
        }
        while (storage != null);

        return key;
    }

    public Stream<Path> loadAll() {
        return storage.loadAll();
    }

    public Path load(String keyName) {
        return storage.load(keyName);
    }

    public Resource loadAsResource(String keyName) {
        return storage.loadAsResource(keyName);
    }

    public void delete(String keyName) {
        storage.delete(keyName);
    }

    private String generateUrl(String keyName) {
        return storage.generateUrl(keyName);
    }
}
