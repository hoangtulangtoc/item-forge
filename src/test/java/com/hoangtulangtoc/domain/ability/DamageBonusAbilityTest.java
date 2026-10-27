package com.hoangtulangtoc.domain.ability;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.hoangtulangtoc.domain.model.DamageBonusAbilityDefinition;
import com.hoangtulangtoc.domain.model.DamageModifierEffect;
import com.hoangtulangtoc.domain.model.TriggerType;

class DamageBonusAbilityTest {

    @Test
    void resolveEffectWrapsBonusPercent() {
        DamageBonusAbilityDefinition definition = new DamageBonusAbilityDefinition(TriggerType.ON_HIT, 30, 25.0);

        DamageModifierEffect effect = new DamageBonusAbility().resolveEffect(definition);

        assertEquals(new DamageModifierEffect(25.0), effect);
    }
}
