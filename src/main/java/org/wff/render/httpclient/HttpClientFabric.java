package org.wff.render.httpclient;

import okhttp3.OkHttpClient;

public interface HttpClientFabric {
    OkHttpClient getClient();

    String getToken();
}
