package co.istad.lms.domain;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@Table(name = "authorities")
@Entity
public class Authority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;

    @Column(unique = true)
    private String uuid;

    @Column(nullable = false , length = 50 , name = "authority_name")
    private String authorityName;

    private String description;

    @ManyToMany(mappedBy = "authorities")
    private List<User> users;



}
