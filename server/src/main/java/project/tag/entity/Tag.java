package project.tag.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import project.user.entity.User;
import project.user.entity.UserTag;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;

    @OneToMany(mappedBy = "tag")
    private List<UserTag> userTags;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User user;
}
