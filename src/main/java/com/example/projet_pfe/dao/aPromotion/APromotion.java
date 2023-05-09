package com.example.projet_pfe.dao.aPromotion;

import com.example.projet_pfe.dao.promotion.Promotion;
import com.example.projet_pfe.dao.stagiaire.Stagiaire;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "A_PROMOTION")

public class APromotion {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    @ManyToOne
    @JoinColumn(name = "CODE_STAG", referencedColumnName = "CODE_STAG")
    private Stagiaire stagiaire;

    @ManyToOne
    @JoinColumn(name = "CODE_PROM", referencedColumnName = "CODE_PROM")
    private Promotion promotion;
    @Column(name = "N_EQUIPE ")
    private Integer nEquipe;
    
    
    @Column(name = "  DECLENCH ")
    private String declenche;

    @Column(name = "  DATE_ARRIVE_STAG")
    private Date dateArriveStag;
    @Column(name = "EXCLU")
    private String exclu;
    @Column(name = "  INTERNAT ")
    private String internat;
    @Column(name = "  TYPE_DECLENCH")
    private String typeDeclench;

}

