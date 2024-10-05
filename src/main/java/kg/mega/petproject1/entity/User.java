package kg.mega.petproject1.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "users")
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String username;
    private String email;
    private String password;
    private String name;
    private String lastName;

    @ManyToOne
    @JoinColumn(name = "replacing_id")
    private User replacing;

    @ManyToOne
    @JoinColumn(name = "head_user_id")
    private User user;

    @ManyToMany
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    @JsonManagedReference
    private List<Role> roles;

    @ManyToMany
    @JoinTable(
            name = "users_positions",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "position_id")
    )
    @JsonManagedReference
    private List<Position> positions;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles;
    }
}
