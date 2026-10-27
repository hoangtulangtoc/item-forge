package com.hoangtulangtoc.infrastructure.bukkit.model;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;

import org.junit.jupiter.api.Test;

import java.util.logging.Logger;

import com.hoangtulangtoc.application.ServerVersion;
import com.hoangtulangtoc.infrastructure.resourcepack.ModelJsonGenerator;
import com.hoangtulangtoc.infrastructure.resourcepack.TextureFileCopier;

class ItemModelStrategyFactoryTest {

    private final ItemModelStrategyFactory factory = new ItemModelStrategyFactory();
    private final ModelJsonGenerator modelJsonGenerator = new ModelJsonGenerator();
    private final TextureFileCopier textureFileCopier = new TextureFileCopier(Logger.getAnonymousLogger());

    @Test
    void selectsModernStrategyAtCutoffVersion() {
        ItemModelStrategy strategy = factory.create(new ServerVersion(1, 21, 4), modelJsonGenerator,
                textureFileCopier);
        assertInstanceOf(ModernModelStrategy.class, strategy);
    }

    @Test
    void selectsModernStrategyAboveCutoffVersion() {
        ItemModelStrategy strategy = factory.create(new ServerVersion(1, 21, 11), modelJsonGenerator,
                textureFileCopier);
        assertInstanceOf(ModernModelStrategy.class, strategy);
    }

    @Test
    void selectsLegacyStrategyBelowCutoffVersion() {
        ItemModelStrategy strategy = factory.create(new ServerVersion(1, 20, 6), modelJsonGenerator,
                textureFileCopier);
        assertInstanceOf(LegacyModelStrategy.class, strategy);
    }

    @Test
    void selectsLegacyStrategyJustBelowCutoffPatch() {
        ItemModelStrategy strategy = factory.create(new ServerVersion(1, 21, 3), modelJsonGenerator,
                textureFileCopier);
        assertInstanceOf(LegacyModelStrategy.class, strategy);
    }
}
