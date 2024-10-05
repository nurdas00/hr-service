package kg.mega.petproject1.service;

import kg.mega.petproject1.entity.Group;
import kg.mega.petproject1.repository.GroupRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor

public class GroupService {
    private final GroupRepository groupRepository;

    public Group create(Group group) {
        return groupRepository.save(group);
    }

    public void deleteById(Long id) {
        groupRepository.deleteById(id);

    }

    public List<Group> findAll() {
        return groupRepository.findAll();
    }

    public Group findById(Long id) {
        return groupRepository.findById(id).orElse(null);
    }

    public Group update(Group group) {
        return groupRepository.save(group);
    }
}

