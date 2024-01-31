package com.example.testeFeign.rest.config;

import feign.Client;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.ssl.SSLContextBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.util.ResourceUtils;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import java.io.FileInputStream;
import java.security.KeyStore;

public class BadsslRestConfig {

    Logger log = LoggerFactory.getLogger(BadsslRestConfig.class);

    @Value("${badssl.cert.password}")
    private String keyStorePassword;

    @Bean
    public Client feignClient() throws Exception {
        log.info("Configuring SSL Context for Feign Client");
        return new Client.Default(createSSLContext(), SSLConnectionSocketFactory.getDefaultHostnameVerifier());
    }

    private SSLSocketFactory createSSLContext() throws Exception {
//        String trustStorePath = "classpath:cacerts";
        String keyStorePath = "classpath:badssl.com-client.p12";

//        log.info("Trust Store for Feign Client: " + trustStorePath);
        log.info("Key Store for Feign Client: " + keyStorePath);

        KeyStore keyStore = KeyStore.getInstance("PKCS12"); // PKCS12 for PFX files. Change this to 'JKS' if you are using java keystore
        keyStore.load(new FileInputStream(ResourceUtils.getFile(keyStorePath)), keyStorePassword.toCharArray());

        SSLContext context = SSLContextBuilder.create()
//                .loadTrustMaterial(ResourceUtils.getFile(trustStorePath), trustStorePassword.toCharArray())
                .loadKeyMaterial(keyStore, keyStorePassword.toCharArray())
                .build();
        return context.getSocketFactory();
    }
}
