package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Message;
import za.ac.cput.repository.MessageRepository;

@Service
public class MessageService implements IService<Message, String>{
    private final MessageRepository repository;

    @Autowired
    public MessageService(MessageRepository repository) {
        this.repository = repository;
    }


    @Override
    public Message create(Message object) {
        return repository.save(object);
    }

    @Override
    public Message read(String s) {
        return repository.findById(s).orElse(null);
    }

    @Override
    public Message update(Message object) {
        if(repository.findById(object.getId()).orElse(null)!= null) {
            return repository.save(object);
        }
        else return null;
    }

    @Override
    public void delete(String s) {
        repository.deleteById(s);
    }
}
