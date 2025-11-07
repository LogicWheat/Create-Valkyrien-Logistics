package io.github.techtastic.valkyrien_logistics.platform.fabric

import dev.architectury.registry.registries.DeferredRegister
import io.github.techtastic.valkyrien_logistics.ValkyrienLogistics
import io.github.techtastic.valkyrien_logistics.content.logistics.board.*
import net.liukrast.eg.api.EGRegistries
import net.liukrast.eg.api.registry.PanelType

object PanelRegistryImpl {
    private val PANELS = DeferredRegister.create(ValkyrienLogistics.MOD_ID, EGRegistries.PANEL_REGISTRY_KEY)

    val POSITION = PANELS.register("position") { PanelType(::PositionPanelBehaviour, PositionPanelBehaviour::class.java) }
    val LINEAR_VELOCITY = PANELS.register("linear_velocity") { PanelType(::LinearVelocityPanelBehaviour, LinearVelocityPanelBehaviour::class.java) }
    val ANGULAR_VELOCITY = PANELS.register("angular_velocity") { PanelType(::AngularVelocityPanelBehaviour, AngularVelocityPanelBehaviour::class.java) }
    val ROTATION = PANELS.register("rotation") { PanelType(::QuaternionPanelBehaviour, QuaternionPanelBehaviour::class.java) }
    val MASS = PANELS.register("mass") { PanelType(::MassPanelBehaviour, MassPanelBehaviour::class.java) }
    val SLUG = PANELS.register("slug") { PanelType(::SlugPanelBehaviour, SlugPanelBehaviour::class.java) }

    fun register() {
        PANELS.register()
    }

    @JvmStatic
    fun getPositionPanel() = POSITION.get()

    @JvmStatic
    fun getLinearVelocityPanel() = LINEAR_VELOCITY.get()

    @JvmStatic
    fun getAngularVelocityPanel() = ANGULAR_VELOCITY.get()

    @JvmStatic
    fun getRotationPanel() = ROTATION.get()

    @JvmStatic
    fun getMassPanel() = MASS.get()

    @JvmStatic
    fun getSlugPanel() = SLUG.get()
}