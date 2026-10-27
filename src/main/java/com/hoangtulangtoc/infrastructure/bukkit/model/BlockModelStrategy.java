package com.hoangtulangtoc.infrastructure.bukkit.model;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

import org.bukkit.inventory.meta.ItemMeta;

import com.hoangtulangtoc.domain.model.CustomBlockDefinition;

// Block models are generated separately from item models. Their textures are selected
// by the note-block instrument and note value.
public interface BlockModelStrategy {

    // Applies the identity of the held ITEM (before it is placed) -- CustomModelData
    // on legacy, the item_model component on modern. The placed block in the world
    // needs nothing from here: the note_block.json blockstate picks its texture from
    // the instrument/note pair, independent of CustomModelData/item_model.
    void applyModel(ItemMeta meta, CustomBlockDefinition definition);

    void generateResourcePackFiles(List<CustomBlockDefinition> blocks, Path textureSourceDir, String namespace,
            Path outputDir) throws IOException;
}
