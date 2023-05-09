package com.example.projet_pfe.dao.subdivision;

import com.example.projet_pfe.dao.branche.Branche;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.LinkedList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "SUBDIVISION")
public class Subdivision {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CODE_SUB")
    private Long codeSub;

    @Column(name = "NOM_SUB")
    private String nomSub;

    @OneToMany(mappedBy = "subdivision")
    private List<Branche> branches = new LinkedList<Branche>();


    // Constructor, getters and setters
}




