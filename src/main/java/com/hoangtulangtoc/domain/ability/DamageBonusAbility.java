package com.hoangtulangtoc.domain.ability;

import com.hoangtulangtoc.domain.model.DamageBonusAbilityDefinition;
import com.hoangtulangtoc.domain.model.DamageModifierEffect;

public class DamageBonusAbility implements Ability<DamageBonusAbilityDefinition, DamageModifierEffect> {

    @Override
    public DamageModifierEffect resolveEffect(DamageBonusAbilityDefinition definition) {
        return new DamageModifierEffect(definition.bonusPercent());
    }
}
