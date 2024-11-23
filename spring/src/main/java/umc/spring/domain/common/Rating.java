package umc.spring.domain.common;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Rating extends BaseEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Integer rate;

    @Column(length = 200)
    private String ratingContent;

//    @ManyToOne(fetch = FetchType.LAZY)
//    private Rating rating;

    @ManyToOne(fetch = FetchType.LAZY)
    private Member member;

    @JoinColumn(name = "store_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Store store;

    public void setStore(Store store) {
        if (this.store != null) {
            store.getRatingList().remove(this);
        }
        this.store = store;
        store.getRatingList().add(this);
        store.setAvgRating();
    }

    public void setMember(Member member) {
        this.member = member;
        member.getRatingList().add(this);

    }
}
