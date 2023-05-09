package com.example.projet_pfe.dao.branche;

import com.example.projet_pfe.dao.actionFormation.ActionFormation;
import com.example.projet_pfe.dao.subdivision.Subdivision;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.LinkedList;
import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Branche")
public class Branche {

    @Id
    @Column(name = "CODE_BR")
    private Integer codeBr;

    @Column(name = "DESIGN_BR")
    private String designBr;

    @Column(name = "COULEUR")
    private String couleur;

    @Column(name = "IMPUT")
    private String imput;

    @ManyToOne
    @JoinColumn(name = "CODE_SUB")
    @JsonIgnore
    private Subdivision subdivision;

    @Column(name = "CODE_DOM")
    private Integer codeDom;
    @OneToMany(mappedBy = "branche", fetch = FetchType.LAZY)
    private List<ActionFormation> actionFormations=new LinkedList<ActionFormation>();


}



