package com.medilabo.medilabo_ui.proxies;

import com.medilabo.medilabo_ui.models.RisqueLevelBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Client Feign permettant de communiquer avec le microservice des rapports.
 */
@FeignClient(name = "gateway-rapport", url = "${gateway.url}")
public interface MicroServiceRapportProxy {

    /**
     * Récupère le niveau de risque d’un patient à partir de son identifiant.
     *
     * @param id identifiant du patient
     * @return le niveau de risque du patient
     */
    @GetMapping("/api/rapport/{id}")
    public RisqueLevelBean getRisqueLevelByPatientId(@PathVariable Long id);
}
