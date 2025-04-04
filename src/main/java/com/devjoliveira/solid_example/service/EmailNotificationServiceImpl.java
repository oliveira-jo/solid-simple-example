package com.devjoliveira.solid_example.service;

public class EmailNotificationServiceImpl implements NotificationService {
  @Override
  public void sendEmailConfirmation(String message) {
    System.out.println("Sending email: " + message);
  }
}