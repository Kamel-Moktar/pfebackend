package com.example.projet_pfe.dao.subdivision;

import com.example.projet_pfe.dao.promotion.RealisationPhysiqueFPS;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubdivisionRepository extends JpaRepository<Subdivision, Integer> {

    Subdivision getByCodeSub(Long codeSub);
    @Query("select new com.example.projet_pfe.dao.promotion.RealisationPhysiqueFPS(s,10L) from Subdivision s")
    List<RealisationPhysiqueFPS> getRealisationPhysiqueFPS();
}
