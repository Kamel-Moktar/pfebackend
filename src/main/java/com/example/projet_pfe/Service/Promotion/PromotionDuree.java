package com.example.projet_pfe.service.promotion;

import com.example.projet_pfe.dao.promotion.Promotion;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PromotionDuree {

    Promotion promotion;
    Date dateD;
    Date dateF;
    Long durree;
}
