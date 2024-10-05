package kg.mega.petproject1.service;

import jakarta.persistence.EntityNotFoundException;
import kg.mega.petproject1.entity.Position;
import kg.mega.petproject1.entity.Role;
import kg.mega.petproject1.entity.User;
import kg.mega.petproject1.repository.PositionRepository;
import kg.mega.petproject1.repository.RoleRepository;
import kg.mega.petproject1.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService implements UserDetailsService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PositionRepository positionRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public void update(User user) {
        userRepository.save(user);
    }

    public void deleteById(Integer id) {
        userRepository.deleteById(id);
    }

    public void create(User user) {
        userRepository.save(user);
    }

    public User getById(@PathVariable Integer id) {
        Optional<User> user = userRepository.findById(id);
        return user.orElseThrow(() -> new EntityNotFoundException("User with id: " + id + " not found"));
    }

    public List<User> findUserByRoleId(Integer roleId) {
        Optional<Role> roleOptional = roleRepository.findById(roleId);
        if (roleOptional.isPresent()) {
            return roleOptional.get().getUsers();
        } else {
            throw new EntityNotFoundException("User with roleId: " + roleId + " not found");
        }
    }

    public List<User> findUserByPositionId (Long positionId){
        Optional<Position> positionOptional = positionRepository.findById(positionId);
        if (positionOptional.isPresent()) {
            Position position = positionOptional.get();
            return position.getUsers();
        } else {
            throw new EntityNotFoundException("User with positionId: " + positionId + " not found");
        }
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.loadByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User: " + username + " not found");
        }
        return org.springframework.security.core.userdetails.User.builder()
                .username(user.getUsername())
                .password(user.getPassword())
                .build();
    }
}