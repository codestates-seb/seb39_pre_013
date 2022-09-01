package project.user.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import project.tag.entity.Tag;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class UserTag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TAG_ID")
    private Tag tag;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID")
    private User user;

    public void setUser(User user){
        this.user = user;
        if (!this.user.getUserTags().contains(this)) {
            this.user.getUserTags().add(this);
        }
    }
}
