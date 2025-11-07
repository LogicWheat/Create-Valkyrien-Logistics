package io.github.techtastic.valkyrien_logistics.registry

import dev.architectury.registry.registries.DeferredRegister
import io.github.techtastic.valkyrien_logistics.ValkyrienLogistics
import io.github.techtastic.valkyrien_logistics.platform.PanelRegistry
import net.liukrast.eg.api.logistics.board.PanelBlockItem
import net.minecraft.core.registries.Registries
import net.minecraft.world.item.Item

object VLItems {
    private val ITEMS = DeferredRegister.create(ValkyrienLogistics.MOD_ID, Registries.ITEM)

    val POSITION_GAUGE = ITEMS.register("position_gauge") { PanelBlockItem(PanelRegistry::getPositionPanel, Item.Properties()) }
    val LINEAR_VELOCITY_GAUGE = ITEMS.register("linear_velocity_gauge") { PanelBlockItem(PanelRegistry::getLinearVelocityPanel, Item.Properties()) }
    val ANGULAR_VELOCITY_GAUGE = ITEMS.register("angular_velocity_gauge") { PanelBlockItem(PanelRegistry::getAngularVelocityPanel, Item.Properties()) }
    val ROTATION_GAUGE = ITEMS.register("rotation_gauge") { PanelBlockItem(PanelRegistry::getRotationPanel, Item.Properties()) }
    val MASS_GAUGE = ITEMS.register("mass_gauge") { PanelBlockItem(PanelRegistry::getMassPanel, Item.Properties()) }
    val SLUG_GAUGE = ITEMS.register("slug_gauge") { PanelBlockItem(PanelRegistry::getSlugPanel, Item.Properties()) }

    fun register() {
        ITEMS.register()
    }
}