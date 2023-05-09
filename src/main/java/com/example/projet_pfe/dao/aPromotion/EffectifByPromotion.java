package com.example.projet_pfe.dao.aPromotion;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EffectifByPromotion {
    APromotion promotion;
    Long effectif;
}
