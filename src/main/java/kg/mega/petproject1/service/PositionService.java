package kg.mega.petproject1.service;

import jakarta.persistence.EntityNotFoundException;
import kg.mega.petproject1.entity.Position;
import kg.mega.petproject1.repository.PositionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PositionService {
    private final PositionRepository positionRepository;

    public List<Position> findAll() {
        return positionRepository.findAll();
    }

    public void update(Position position, Long id) {
        if(position.getId() != null){
            positionRepository.save(position);
        }
        else{
            throw new EntityNotFoundException("Position with positionId:" + id + "not found");
        }
    }

    public void deleteById(Long id) {
        positionRepository.deleteById(id);
    }

    public void create(String name) {
        Position savedPosition = new Position();
        savedPosition.setName(name);
        positionRepository.save(savedPosition);
    }


    public void getById(@PathVariable Long id) {
        Optional<Position> positionOptional = positionRepository.findById(id);
        positionOptional.ifPresent(System.out::println);
        throw new EntityNotFoundException("Position with id: " + id + " not found");
    }
}
