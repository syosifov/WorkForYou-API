package com.radichev.workforyou.service;

import java.io.InputStream;
import java.net.URL;
import java.util.Map;
import java.util.Optional;

public interface FileStoreService {

    void save(String path, String fileName, Optional<Map<String, String>> optionalMetadata, InputStream inputStream);
}
