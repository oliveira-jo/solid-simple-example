package com.devjoliveira.solid_example.service;

// ISP: Separate interfaces for notifications
public interface NotificationService {
  void sendEmailConfirmation(String message);

}