package com.example.projet_pfe.dao.stagiaire;

import com.example.projet_pfe.dao.aPromotion.APromotion;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "STAGIAIRE")
public class Stagiaire {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CODE_STAG")
    private Integer codeStag;

    @OneToMany(mappedBy = "stagiaire")
    private List<APromotion> aPromotion;

    @Column(name = "CODE_UNIT")
    private Integer codeUnit;

    @Column(name = "CODE_TYPE_ST")
    private String codeTypeSt;

    @Column(name = "NOM_STAG")
    private String nomStag;

    @Column(name = "PRENOM_STAG")
    private String prenomStag;
    @Column(name = "CATEGORIE")
    private Integer categorie;
    @Column(name = "DATE_ENTRE_S")
    private Date dateEntreS;
    @Column(name = "DATE_NAISS_STAG")
    private Date dateNs;
    @Column(name = "LIEU_NAISS_STAG")
    private String lieuNS;
    @Column(name = "CAT_SOC_PROF")
    private String catSP;
    @Column(name = "SITUAT_FAM_STAG ")
    private String statuFS;
    @Column(name = "TEL_P_S ")
    private String telPS;
    @Column(name = "TEL_T_S ")
    private String telTS;
    @Column(name = "ADRESSE_S")
    private String adresseS;
    @Column(name = "SEXE_STAG")
    private String sexeS;
    @Column(name = " WILAYA_NAISS")
    private String wilayaN;
    @Column(name = "NOM_JEUNE_F ")
    private String nomJeuneF;
    @Column(name = "PERMIS")
    private String permis;

    @Column(name = "  NIVEAU_SCOL_STAG")
    private String niveauScolStag;

}

