package kg.mega.petproject1.controller;

import kg.mega.petproject1.entity.Position;
import kg.mega.petproject1.service.PositionService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/positions")
public class PositionController {
    private final PositionService positionService;

    @GetMapping
    public List<Position> getAllPositions() {
        return positionService.findAll();
    }

    @GetMapping("/positionId/{id}")
    public void getPositionById(@PathVariable Long id) {
         positionService.getById(id);
    }

    @PostMapping("/create")
    public void createPosition(@RequestBody Position position) {
        positionService.create(position.getName());
    }

    @PutMapping("/update/{id}")
    public void updatePosition(@PathVariable Long id, @RequestBody Position position){
        positionService.update(position, id);
    }

    @DeleteMapping("/delete/{id}")
    public void deletePosition(@PathVariable Long id) {
        positionService.deleteById(id);
    }
}
