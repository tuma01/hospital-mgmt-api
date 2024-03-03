package com.amachi.app.hospitalappservice.entities;

//import lombok.AllArgsConstructor;
//import lombok.Builder;
//import lombok.Data;
//import lombok.NoArgsConstructor;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "PERSONAL_HISTORY")
public class PersonalHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_PERSONAL_HISTORY", nullable = false)
    private Long idPersonalHistory;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FK_ID_TOXIC_HABITS", foreignKey = @ForeignKey(name = "FK_PERSONALHISTORY_TOXICHABITS"))
    private ToxicHabits toxicHabits;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FK_ID_PHYSIOLOGICAL_HABITS", foreignKey = @ForeignKey(name = "FK_PERSONALHISTORY_PHYSIOLOGICALHABITS"))
    private PhysiologicalHabits physiologicalHabits;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FK_ID_FAMILY_HISTORY", foreignKey = @ForeignKey(name = "FK_PERSONALHISTORY_FAMILYHISTORY"))
    private FamilyHistory familyHistory;
}
