package com.hoangtulangtoc.application.port;

import java.util.Optional;

public interface ResourcePackPort {

    void rebuild();

    Optional<ResourcePackInfo> currentPack();
}
