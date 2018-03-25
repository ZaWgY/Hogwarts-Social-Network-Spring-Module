package Hogwarts.ServiceImpl;

import Hogwarts.Domain.Raid;
import Hogwarts.Domain.RaidRespond;
import Hogwarts.Repository.RaidRepository;
import Hogwarts.Repository.RaidRespondRepository;
import Hogwarts.Service.RaidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class RaidServiceImpl implements RaidService {
    private RaidRepository raidRepository;
    private RaidRespondRepository raidRespondRepository;

    @Autowired
    public RaidServiceImpl(RaidRepository raidRepository, RaidRespondRepository raidRespondRepository) {
        this.raidRepository = raidRepository;
        this.raidRespondRepository = raidRespondRepository;
    }

    @Override
    public void remove(int id) {

    }

    @Override
    public List<Raid> findAll() {
        List<Raid> list = new ArrayList<>();
        raidRepository.findAll().forEach(list::add);
        return list;
    }

    @Override
    public Raid find(String name) {
        return null;
    }

    @Override
    public void delete(Raid status) {

    }

    @Override
    public void save(Raid status) {
        raidRepository.save(status);
    }

    @Override
    public void updateStatus(String status, int id) {

    }

    @Override
    public void addRaidRespond(RaidRespond raidRespond) {
        raidRespondRepository.save(raidRespond);
    }

    @Override
    public List<RaidRespond> getRaidsByLogin(String login) {
        return raidRespondRepository.findByUserName(login);
    }

    @Override
    public Boolean checkAvailiable(String name) {
        List<Raid> list = findAll();
        for (Raid r:list) {
            if (r.getName().equals(name)){
                return false;
            }
        }
        return true;
    }
}
