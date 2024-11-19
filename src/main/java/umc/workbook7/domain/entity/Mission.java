package umc.workbook7.domain.entity;

import jakarta.persistence.*;
import lombok.*;
import umc.workbook7.domain.common.BaseEntity;
import umc.workbook7.domain.entity.mapping.MemberMission;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Mission extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long missionId;

    private Integer reward;

    private LocalDate deadLine;

    private String missionSpec;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_id")
    private Store store;

    @OneToMany(mappedBy = "mission", cascade = CascadeType.ALL)
    private List<MemberMission> memberMissionList = new ArrayList<>();

    // created_at, updated_at은 BaseEntity에 있음 (extends BaseEntity)

    public void setStore(Store store) {
        this.store = store;
    }



}


