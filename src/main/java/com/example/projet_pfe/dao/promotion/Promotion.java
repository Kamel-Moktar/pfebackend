package com.example.projet_pfe.dao.promotion;

import com.example.projet_pfe.dao.aPromotion.APromotion;
import com.example.projet_pfe.dao.actionFormation.ActionFormation;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Repository
@Transactional
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "PROMOTIONS")
public class Promotion {

    @Id
    @Column(name = "CODE_PROM")
    private Integer codeProm;
    @OneToMany(mappedBy = "promotion")
    private List<APromotion> aPromotion;


    @Column(name = "CODE_PROM3", length = 5)
    private String codeProm3;

    @ManyToOne
    @JsonIgnore
    @JsonManagedReference
    @JoinColumn(name = "CODE_ACT", referencedColumnName = "CODE_ACT")
    private ActionFormation actionFormation;

    @Column(name = "CODE_RESP", nullable = false)
    private Integer codeResp;

    @Column(name = "LIB_PROMO", length = 40)
    private String libPromo;

    @Column(name = "DATE_D_F")
    private Date dateDF;

    @Column(name = "DATE_F")
    private Date dateF;

    @Column(name = "NB_EQUIPE")
    private Integer nbEquipe;

    @Column(name = "NB_STAG")
    private Integer nbStag;

    @Column(name = "DATE_RETOUR")
    private Date dateRetour;

    @Column(name = "DATE_F_PREV")
    private Date dateFPrev;

    @Column(name = "CODE_PHA_EXAM")
    private String codePhaExam;

    @Column(name = "COEF_PHA_EXAM")
    private Integer coefPhaExam;

    @Column(name = "DATE_JURY")
    private Date dateJury;

    @Column(name = "GSP", length = 10)
    private String gsp;

    @Column(name = "TYPE_HORAIRE", length = 3)
    private String typeHoraire;

    @Column(name = "IMPUTATION", length = 8)
    private String imputation;




}





