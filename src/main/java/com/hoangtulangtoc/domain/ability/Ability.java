package com.hoangtulangtoc.domain.ability;

import com.hoangtulangtoc.domain.model.AbilityDefinition;
import com.hoangtulangtoc.domain.model.AbilityEffect;

public interface Ability<D extends AbilityDefinition, E extends AbilityEffect> {

    E resolveEffect(D definition);
}
