package io.github.techtastic.valkyrien_logistics.platform

import dev.architectury.injectables.annotations.ExpectPlatform
import io.github.techtastic.valkyrien_logistics.content.logistics.board.LinearVelocityPanelBehaviour
import io.github.techtastic.valkyrien_logistics.content.logistics.board.PositionPanelBehaviour
import net.liukrast.eg.api.registry.PanelType

object PanelRegistry {
    @ExpectPlatform
    @JvmStatic
    fun getPositionPanel(): PanelType<PositionPanelBehaviour> {
        throw AssertionError()
    }

    @ExpectPlatform
    @JvmStatic
    fun getLinearVelocityPanel(): PanelType<LinearVelocityPanelBehaviour> {
        throw AssertionError()
    }
}