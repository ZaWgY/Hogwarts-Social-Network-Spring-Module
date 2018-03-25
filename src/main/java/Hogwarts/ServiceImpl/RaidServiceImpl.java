package Hogwarts.ServiceImpl;

import Hogwarts.Domain.People;
import Hogwarts.Domain.Raid;
import Hogwarts.Domain.RaidRespond;
import Hogwarts.Repository.PeopleRepository;
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
    private PeopleRepository peopleRepository;

    @Autowired
    public RaidServiceImpl(RaidRepository raidRepository, RaidRespondRepository raidRespondRepository, PeopleRepository peopleRepository) {
        this.raidRepository = raidRepository;
        this.raidRespondRepository = raidRespondRepository;
        this.peopleRepository = peopleRepository;
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

    @Override
    public List<RaidRespond> getRaidResonds() {
        List<RaidRespond> list = new ArrayList<>();
        raidRespondRepository.findAll().forEach(list::add);
        return list;
    }

    @Override
    public Boolean checkRaidRespond(String login, String raid) {
        Raid raid1 = raidRepository.getRaidByName(raid);
        if (raid1.getNumberOfRequiredStudents().equals(raid1.getNumberOfCurrentStudents())){
            return false;
        }
        List<RaidRespond> list = getRaidResonds();
        for (RaidRespond r:list) {
            if (r.getUserName().equals(login)){
                if(r.getRaidName().equals(raid)){
                    return false;
                }
            }
        }
        raid1.setNumberOfCurrentStudents(raid1.getNumberOfCurrentStudents()+1);
        raidRepository.save(raid1);
        return true;
    }

    @Override
    public void deleteAll() {
        raidRespondRepository.deleteAll();
    }

    @Override
    public void deleteAllRaids() {
        raidRepository.deleteAll();
    }

    @Override
    public void setRaidUnactive(String raidName) {
       Raid raid = raidRepository.getRaidByName(raidName);
       raid.setActive(false);
       raidRepository.save(raid);
    }

    @Override
    public void addPoints(RaidRespond raidRespond) {
        Raid raid =raidRepository.getRaidByName(raidRespond.getRaidName());
        Integer points = raid.getPoints();
        People people = peopleRepository.findByLogin(raidRespond.getUserName());
        people.addPoints(points);
        peopleRepository.save(people);
    }
}

