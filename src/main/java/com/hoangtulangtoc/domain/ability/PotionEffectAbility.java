package com.hoangtulangtoc.domain.ability;

import com.hoangtulangtoc.domain.model.EffectCommand;
import com.hoangtulangtoc.domain.model.PotionEffectAbilityDefinition;

public class PotionEffectAbility implements Ability<PotionEffectAbilityDefinition, EffectCommand> {

    @Override
    public EffectCommand resolveEffect(PotionEffectAbilityDefinition definition) {
        return definition.toEffectCommand();
    }
}
