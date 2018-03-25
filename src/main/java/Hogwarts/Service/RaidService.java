package Hogwarts.Service;


import Hogwarts.Domain.Raid;
import Hogwarts.Domain.RaidRespond;

import java.util.List;

public interface RaidService {
    void remove(int id);
    List<Raid> findAll();
    Raid find(String name);
    void delete(Raid status);
    void save(Raid status);
    void updateStatus(String status, int id);
    void addRaidRespond(RaidRespond raidRespond);
    List<RaidRespond> getRaidsByLogin(String login);
    Boolean checkAvailiable(String name);
}
