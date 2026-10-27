package com.hoangtulangtoc.infrastructure.bukkit.model;

import java.util.logging.Logger;

import com.hoangtulangtoc.application.ServerVersion;
import com.hoangtulangtoc.infrastructure.resourcepack.ArmorTextureFileCopier;
import com.hoangtulangtoc.infrastructure.resourcepack.EquipmentAssetGenerator;
import com.hoangtulangtoc.infrastructure.resourcepack.ModelJsonGenerator;

public class ArmorModelStrategyFactory {

    public ArmorModelStrategy create(ServerVersion version, EquipmentAssetGenerator equipmentAssetGenerator,
            ArmorTextureFileCopier armorTextureFileCopier, ModelJsonGenerator modelJsonGenerator, Logger logger) {
        return version.isAtLeast(1, 21, 4)
                ? new ModernArmorModelStrategy(equipmentAssetGenerator, armorTextureFileCopier, modelJsonGenerator,
                        logger)
                : new LegacyArmorModelStrategy(armorTextureFileCopier, modelJsonGenerator, logger);
    }
}
