package kg.mega.petproject1.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "branch")
public class Branch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String description;
    private String email;
    private String address;
    @OneToOne
    @JoinColumn(name = "head_user_id")
    private User headUser;
}
