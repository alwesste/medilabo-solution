package com.medilabo.medilabo_ui.proxies;

import com.medilabo.medilabo_ui.models.RisqueLevelBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "gateway-rapport", url = "http://localhost:9003")
public interface MicroServiceRapportProxy {

    @GetMapping("/api/rapport/{id}")
    public RisqueLevelBean getRisqueLevelByPatientId(@PathVariable Long id);
}
