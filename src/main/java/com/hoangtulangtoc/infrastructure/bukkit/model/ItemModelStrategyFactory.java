package com.hoangtulangtoc.infrastructure.bukkit.model;

import com.hoangtulangtoc.application.ServerVersion;
import com.hoangtulangtoc.infrastructure.resourcepack.ModelJsonGenerator;
import com.hoangtulangtoc.infrastructure.resourcepack.TextureFileCopier;

public class ItemModelStrategyFactory {

    public ItemModelStrategy create(ServerVersion version, ModelJsonGenerator modelJsonGenerator,
            TextureFileCopier textureFileCopier) {
        return version.isAtLeast(1, 21, 4)
                ? new ModernModelStrategy(modelJsonGenerator, textureFileCopier)
                : new LegacyModelStrategy(modelJsonGenerator, textureFileCopier);
    }
}
