package com.hoangtulangtoc.application;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.hoangtulangtoc.application.port.EffectApplierPort;
import com.hoangtulangtoc.domain.ItemRegistry;
import com.hoangtulangtoc.domain.ability.DamageBonusAbility;
import com.hoangtulangtoc.domain.ability.PotionEffectAbility;
import com.hoangtulangtoc.domain.model.AbilityDefinition;
import com.hoangtulangtoc.domain.model.AbilityEffect;
import com.hoangtulangtoc.domain.model.DamageBonusAbilityDefinition;
import com.hoangtulangtoc.domain.model.ItemDefinition;
import com.hoangtulangtoc.domain.model.PotionEffectAbilityDefinition;
import com.hoangtulangtoc.domain.model.TriggerType;
import com.hoangtulangtoc.domain.model.TriggeredAbility;

public class AbilityDispatchService {

    private final ItemRegistry itemRegistry;
    private final CooldownService cooldownService;
    private final EffectApplierPort effectApplier;
    private final PotionEffectAbility potionEffectAbility = new PotionEffectAbility();
    private final DamageBonusAbility damageBonusAbility = new DamageBonusAbility();

    public AbilityDispatchService(ItemRegistry itemRegistry, CooldownService cooldownService,
            EffectApplierPort effectApplier) {
        this.itemRegistry = itemRegistry;
        this.cooldownService = cooldownService;
        this.effectApplier = effectApplier;
    }

    public List<TriggeredAbility> dispatch(UUID playerId, String itemId, TriggerType trigger) {
        Optional<ItemDefinition> item = itemRegistry.get(itemId);
        if (item.isEmpty()) {
            return List.of();
        }

        List<AbilityDefinition> abilities = item.get().abilities();
        List<TriggeredAbility> triggered = new ArrayList<>();

        for (int i = 0; i < abilities.size(); i++) {
            AbilityDefinition definition = abilities.get(i);
            if (definition.trigger() != trigger) {
                continue;
            }

            // The index is the cooldown key, because the domain has no per-ability id yet.
            String cooldownKey = itemId + "#" + i;
            if (cooldownService.isOnCooldown(playerId, cooldownKey)) {
                continue;
            }

            AbilityEffect effect = resolveEffect(definition);
            cooldownService.markUsed(playerId, cooldownKey, Duration.ofSeconds(definition.cooldownSeconds()));
            effectApplier.apply(playerId, effect);
            triggered.add(new TriggeredAbility(definition, effect));
        }

        return triggered;
    }

    private AbilityEffect resolveEffect(AbilityDefinition definition) {
        return switch (definition) {
            case PotionEffectAbilityDefinition d -> potionEffectAbility.resolveEffect(d);
            case DamageBonusAbilityDefinition d -> damageBonusAbility.resolveEffect(d);
        };
    }
}
