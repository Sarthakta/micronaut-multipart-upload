package com.example;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Part;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.multipart.CompletedFileUpload;

@Controller("/mail")
public class MailController {

  @Post(value = "/attachment" , consumes = {MediaType.MULTIPART_FORM_DATA})
  public HttpResponse<?> sendWithAttachment(@Part("email") Email email, @Part(value = "attachment") CompletedFileUpload attachmentFile) {
    System.out.println(email);
    return HttpResponse.ok();
  }

  @Post(value = "/attachmentStringPart" , consumes = {MediaType.MULTIPART_FORM_DATA})
  public HttpResponse<?> sendWithAttachmentAndStringPart(@Part("email") String email, @Part(value = "attachment") CompletedFileUpload attachmentFile) {
    System.out.println(email);
    return HttpResponse.ok();
  }
}