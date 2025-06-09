package com.client_service.client.service.util;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class GenerarLimiteCreditoService {

    public BigDecimal generarLimite() {
        double min = 1000.0;
        double max = 100000.0;
        double randomValue = ThreadLocalRandom.current().nextDouble(min, max);
        return BigDecimal.valueOf(randomValue).setScale(2, RoundingMode.HALF_UP);
    }
}
