package kg.mega.petproject1.service;

import jakarta.persistence.EntityNotFoundException;
import kg.mega.petproject1.entity.Role;
import kg.mega.petproject1.repository.RoleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleService {
    private RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    public void createRole(Role role) {
        roleRepository.save(role);
    }

    public void deleteById(Integer id) {
        roleRepository.deleteById(id);
    }

    public Role getRoleById(Integer id) {
        Optional<Role> role = roleRepository.findById(id);
        if (role.isPresent()) {
            return role.get();
        }
        throw new EntityNotFoundException("Role with id: " + id + " not found");
    }
}



