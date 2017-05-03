package org.wff.render.httpclient.impl;

import com.google.inject.Singleton;
import okhttp3.OkHttpClient;
import org.wff.render.httpclient.HttpClientFabric;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.Properties;
import java.util.logging.Logger;

@Singleton
public class OkHttpFabric implements HttpClientFabric {
    private final Logger logger = Logger.getLogger(OkHttpFabric.class.getName());
    private OkHttpClient client;
    private String token;

    public OkHttpFabric() throws IOException {
        Properties properties = new Properties();
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        InputStream is = classloader.getResourceAsStream("local.properties");
        properties.load(is);
        logger.info("config file found");
        String proxyenabled = properties.getProperty("PROXY_ENABLED");
        this.token = properties.getProperty("TOKEN");
        if ("NO".equals(proxyenabled)) {
            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            this.client = builder.build();
            logger.info("client configured without proxy");
        } else {
            String proxyaddr = properties.getProperty("PROXY_IP");
            Integer proxyport = Integer.parseInt(properties.getProperty("PROXY_PORT"));
            Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(proxyaddr, proxyport));
            OkHttpClient.Builder builder = new OkHttpClient.Builder().proxy(proxy);
            this.client = builder.build();
            logger.info("client configured with proxy " + proxyaddr + ":" + properties.getProperty("PROXY_PORT"));
        }
    }

    @Override
    public OkHttpClient getClient() {
        return this.client;
    }

    @Override
    public String getToken() {
        return this.token;
    }
}
