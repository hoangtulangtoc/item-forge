package com.hoangtulangtoc.infrastructure.bukkit.model;

import com.hoangtulangtoc.application.ServerVersion;
import com.hoangtulangtoc.infrastructure.resourcepack.BlockModelJsonGenerator;
import com.hoangtulangtoc.infrastructure.resourcepack.BlockStateJsonGenerator;
import com.hoangtulangtoc.infrastructure.resourcepack.BlockTextureFileCopier;

public class BlockModelStrategyFactory {

    public BlockModelStrategy create(ServerVersion version, BlockModelJsonGenerator modelJsonGenerator,
            BlockTextureFileCopier textureFileCopier, BlockStateJsonGenerator blockStateJsonGenerator) {
        return version.isAtLeast(1, 21, 4)
                ? new ModernBlockModelStrategy(modelJsonGenerator, textureFileCopier, blockStateJsonGenerator)
                : new LegacyBlockModelStrategy(modelJsonGenerator, textureFileCopier, blockStateJsonGenerator);
    }
}
