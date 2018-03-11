package Hogwarts.Service;


import Hogwarts.Domain.People;

public interface NotificationService {
    void sendRegistrationNotification(People people);
    void sendRegInfoNotification(People people);
}
