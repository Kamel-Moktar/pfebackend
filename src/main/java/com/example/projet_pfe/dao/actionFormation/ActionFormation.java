package com.example.projet_pfe.dao.actionFormation;

import com.example.projet_pfe.dao.branche.Branche;
import com.example.projet_pfe.dao.promotion.Promotion;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.LinkedList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ACTION_FORMATION")
public class ActionFormation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CODE_ACT")
    private Integer codeAct;
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    @JoinColumn(name = "CODE_BR")
    private Branche branche;
    @Column(name = "LIB_FORM", nullable = false)
    private String libForm;

    @Column(name = "CODE_ACT_I")
    private String codeActI;

    @Column(name = "DUREE")
    private Integer duree;

    @Column(name = "BUT_FORM")
    private String butForm;

    @Column(name = "COULEUR")
    private String couleur;

    @Column(name = "TYPE_HORAIRE", nullable = false, columnDefinition = "CHAR(3) default 'FPS'")
    private String typeHoraire;

    @Column(name = "GSP", columnDefinition = "CHAR(3)")
    private String gsp;

    @Column(name = "CODE_FICHE", columnDefinition = "CHAR(8)")
    private String codeFiche;

    @OneToMany(mappedBy = "actionFormation")
    @JsonBackReference

    private List<Promotion> promotions=new LinkedList<Promotion>();
}


