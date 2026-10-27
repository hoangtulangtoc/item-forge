package com.hoangtulangtoc.domain.model;

/**
 * AbilityDefinition
 */
public sealed interface AbilityDefinition
        permits PotionEffectAbilityDefinition, DamageBonusAbilityDefinition {

    TriggerType trigger();

    int cooldownSeconds();
}
