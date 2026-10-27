package com.hoangtulangtoc.application.port;

import java.util.UUID;

import com.hoangtulangtoc.domain.model.AbilityEffect;

public interface EffectApplierPort {

    void apply(UUID playerId, AbilityEffect effect);
}
