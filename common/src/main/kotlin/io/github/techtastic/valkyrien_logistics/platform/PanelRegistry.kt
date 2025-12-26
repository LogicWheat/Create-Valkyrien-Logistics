package io.github.techtastic.valkyrien_logistics.platform

import dev.architectury.injectables.annotations.ExpectPlatform
import io.github.techtastic.valkyrien_logistics.content.logistics.board.*
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

    @ExpectPlatform
    @JvmStatic
    fun getAngularVelocityPanel(): PanelType<AngularVelocityPanelBehaviour> {
        throw AssertionError()
    }

    @ExpectPlatform
    @JvmStatic
    fun getRotationPanel(): PanelType<QuaternionPanelBehaviour> {
        throw AssertionError()
    }

    @ExpectPlatform
    @JvmStatic
    fun getMassPanel(): PanelType<MassPanelBehaviour> {
        throw AssertionError()
    }

    @ExpectPlatform
    @JvmStatic
    fun getSlugPanel(): PanelType<SlugPanelBehaviour> {
        throw AssertionError()
    }

    @ExpectPlatform
    @JvmStatic
    fun getEulerPanel(): PanelType<EulerPanelBehaviour> {
        throw AssertionError()
    }
}