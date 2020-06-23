package com.example;

import io.micronaut.core.annotation.Introspected;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;
import lombok.NoArgsConstructor;

@Introspected
@Data
@NoArgsConstructor
public class Email {

  private String recipient;

  private String subject;

  private List<String> cc = new ArrayList<>();
  private List<String> bcc = new ArrayList<>();

  private String htmlBody;
  private String replyTo;

}
