package Hogwarts.Service;


import Hogwarts.Domain.Raid;

import java.util.List;

public interface RaidService {
    void remove(int id);
    List<Raid> findAll();
    Raid find(String name);
    void delete(Raid status);
    void save(Raid status);
    void updateStatus(String status, int id);
}
