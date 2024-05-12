package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Calendar_Entry;
import za.ac.cput.repository.Calendar_Entry_Repository;

@Service
public class Calendar_Entry_Service implements IService<Calendar_Entry, Integer>{
    private final Calendar_Entry_Repository repository;

}