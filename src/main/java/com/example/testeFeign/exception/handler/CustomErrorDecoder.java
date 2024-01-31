package com.example.testeFeign.exception.handler;

import feign.Response;
import feign.codec.ErrorDecoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;

public class CustomErrorDecoder implements ErrorDecoder {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public Exception decode(String methodKey, Response response) {

        String errorMessage = null;
        try {
            errorMessage = String.format("method: %s - status: %s - body: %s", methodKey, response.status(), getResponseBodyMessage(response));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        logger.error(errorMessage);

        return new Exception(errorMessage);
    }

    private String getResponseBodyMessage(Response response) throws IOException {
        InputStream inputStream = response.body().asInputStream();
        return new BufferedReader(new InputStreamReader(inputStream)).lines().collect(Collectors.joining("\n"));
    }

//    private String getBodyMessage(InputStream inputStream) {
//        return new BufferedReader(new InputStreamReader(inputStream)).lines().collect(Collectors.joining("\n"));
//    }
//    private String getBodyMessage(Reader reader) {
//        return new BufferedReader(reader).lines().collect(Collectors.joining("\n"));
//    }

}
