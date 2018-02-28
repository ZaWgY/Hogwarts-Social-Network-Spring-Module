package Hogwarts.ServiceImpl;


import Hogwarts.Domain.Status;
import Hogwarts.Repository.StatusRepository;
import Hogwarts.Service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StatusServiceImpl implements StatusService {
    private StatusRepository statusRepository;

    @Autowired
    public StatusServiceImpl(StatusRepository statusRepository) {
        this.statusRepository = statusRepository;
    }

    @Override
    public void remove(int id) {

    }

    @Override
    public List<Status> findAll() {
        List<Status> list = new ArrayList<>();
        statusRepository.findAll().forEach(list::add);
        return list;
    }

    @Override
    public Status find(int id) {
        return null;
    }

    @Override
    public void delete(Status status) {

    }

    @Override
    public void save(Status status) {
        statusRepository.save(status);
    }

    @Override
    public void updateStatus(String status, int id) {

    }
}
