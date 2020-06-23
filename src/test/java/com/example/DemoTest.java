package com.example;


import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.MediaType;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.http.client.multipart.MultipartBody;
import io.micronaut.test.annotation.MicronautTest;
import javax.inject.Inject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

@MicronautTest
public class DemoTest {

  @Inject
  @Client("/")
  HttpClient client;

  @Test
  void multiPartAttachmentWithJsonDataUpload() {

    MultipartBody body = MultipartBody.builder()
        .addPart("email", "email.json", MediaType.APPLICATION_JSON_TYPE,
            "{\"recipient\":\"amit_vyas@t.com\",\"subject\":\"Test Email Service\",\"htmlBody\":\"My First TeXt EmAiL\"}"
                .getBytes())
        .addPart("attachment", "amazon", MediaType.TEXT_PLAIN_TYPE, new byte[0])
        .build();

    HttpResponse response = client.toBlocking().exchange(HttpRequest.POST("/mail/attachment", body)
        .contentType(MediaType.MULTIPART_FORM_DATA_TYPE));

    Assertions.assertEquals(response.getStatus(), HttpStatus.OK);

  }

}
