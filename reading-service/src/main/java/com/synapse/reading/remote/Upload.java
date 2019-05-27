package com.synapse.reading.remote;

import java.io.InputStream;

public interface Upload {

    String upload(InputStream inputStream, String filName);
}
