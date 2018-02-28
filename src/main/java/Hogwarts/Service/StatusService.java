package Hogwarts.Service;


import Hogwarts.Domain.Status;

import java.util.List;

public interface StatusService {

    void remove(int id);
    List<Status> findAll();
    Status find(int id);
    void delete(Status status);
    void save(Status status);
    void updateStatus(String status, int id);
}
