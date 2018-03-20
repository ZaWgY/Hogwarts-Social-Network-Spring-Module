package Hogwarts.Service;


import Hogwarts.Domain.People;

import java.util.List;

public interface NotificationService {
    void sendRegistrationNotification(People people);
    void sendRegInfoNotification(People user, List<People> admins);
    void sendApproveInfo(People user);
}
