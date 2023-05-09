package com.example.projet_pfe.dao.phase;

import com.example.projet_pfe.dao.promotion.Promotion;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Phase")
public class Phase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CODE_PH")
    private Integer codePh;

    @Column(name = "COEF_PH")
    private Integer coefPh;


    @Column(name = "LIB_PHASE")
    private String libPhase;
    @Column(name = "CODE_PH3")
    private String codePh3;

    @Column(name = "CODE_PROM3")
    private String codeProm3;

    @Column(name = "LIEU")
    private String lieu;


    @Column(name = "DATE_D")
    private Date dateD;
    @Column(name = "DATE_F")
    private Date dateF;
    @Column(name = "NB_SEM ")
    private Integer nbSem;

    @ManyToOne(fetch =FetchType.EAGER)

    @JoinColumn(name = "CODE_PROM", referencedColumnName = "CODE_PROM" )
    private Promotion promotion;


    @Column(name = "CODE_PHASE_ORIG")
    private String codePhaseOrig;
    @Column(name = "DATE_C")
    private Date dateC;

}

