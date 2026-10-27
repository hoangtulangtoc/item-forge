package com.hoangtulangtoc.domain.model;

import com.hoangtulangtoc.domain.exception.InvalidItemDefinitionException;

public record DamageBonusAbilityDefinition(
        TriggerType trigger,
        int cooldownSeconds,
        double bonusPercent) implements AbilityDefinition {

    public DamageBonusAbilityDefinition {
        if (bonusPercent <= 0) {
            // A zero or negative damage bonus is meaningless in business terms.
            throw new InvalidItemDefinitionException("Damage bonus percent must be positive");
        }
    }
}
