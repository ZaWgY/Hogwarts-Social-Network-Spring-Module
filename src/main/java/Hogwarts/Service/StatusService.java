package Hogwarts.Service;


import Hogwarts.Domain.Status;

public interface StatusService {

    void remove(int id);
    Iterable<Status> findAll();
    Status find(int id);
    void delete(Status status);
    void save(Status status);
    void updateStatus(String status, int id);
}
