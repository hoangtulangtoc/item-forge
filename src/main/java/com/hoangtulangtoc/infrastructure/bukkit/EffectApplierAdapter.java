package com.hoangtulangtoc.infrastructure.bukkit;

import java.util.UUID;
import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import com.hoangtulangtoc.application.port.EffectApplierPort;
import com.hoangtulangtoc.domain.model.AbilityEffect;
import com.hoangtulangtoc.domain.model.DamageModifierEffect;
import com.hoangtulangtoc.domain.model.EffectCommand;

public class EffectApplierAdapter implements EffectApplierPort {

    private final Logger logger;

    public EffectApplierAdapter(Logger logger) {
        this.logger = logger;
    }

    @Override
    public void apply(UUID playerId, AbilityEffect effect) {
        Player player = Bukkit.getPlayer(playerId);
        if (player == null) {
            return; // the player is offline, nothing to apply it to
        }

        switch (effect) {
            case EffectCommand ec -> applyPotionEffect(player, ec);
            case DamageModifierEffect dm -> logger.warning(
                    "DamageModifierEffect is not supported in this version yet: " + dm.bonusPercent() + "%");
        }
    }

    private void applyPotionEffect(Player player, EffectCommand command) {
        PotionEffectType type = mapEffectType(command.type());
        player.addPotionEffect(new PotionEffect(type, command.durationSeconds() * 20, command.amplifier()));
    }

    private PotionEffectType mapEffectType(EffectCommand.EffectType type) {
        return switch (type) {
            case FIRE_RESISTANCE -> PotionEffectType.FIRE_RESISTANCE;
            case SLOWNESS -> PotionEffectType.SLOWNESS;
            case SPEED -> PotionEffectType.SPEED;
            case NIGHT_VISION -> PotionEffectType.NIGHT_VISION;
            case REGENERATION -> PotionEffectType.REGENERATION;
        };
    }
}
