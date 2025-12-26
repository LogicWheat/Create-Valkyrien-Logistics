package io.github.techtastic.valkyrien_logistics.registry

import dev.architectury.registry.CreativeTabRegistry
import dev.architectury.registry.registries.DeferredRegister
import io.github.techtastic.valkyrien_logistics.ValkyrienLogistics
import io.github.techtastic.valkyrien_logistics.platform.PanelRegistry
import net.liukrast.eg.api.logistics.board.PanelBlockItem
import net.minecraft.core.registries.Registries
import net.minecraft.network.chat.Component
import net.minecraft.world.item.Item

object VLItems {
    private val TABS = DeferredRegister.create(ValkyrienLogistics.MOD_ID, Registries.CREATIVE_MODE_TAB)
    private val ITEMS = DeferredRegister.create(ValkyrienLogistics.MOD_ID, Registries.ITEM)

    val TAB = TABS.register("valkyrien_logistics") {
        CreativeTabRegistry.create { builder ->
            builder
                .title(Component.translatable("itemGroup.valkyrien_logistics"))
                .icon { ROTATION_GAUGE.get().defaultInstance }
                .displayItems { params, output ->
                    output.accept(POSITION_GAUGE.get())
                    output.accept(LINEAR_VELOCITY_GAUGE.get())
                    output.accept(ANGULAR_VELOCITY_GAUGE.get())
                    output.accept(ROTATION_GAUGE.get())
                    output.accept(MASS_GAUGE.get())
                    output.accept(SLUG_GAUGE.get())
                    output.accept(EULER_GAUGE.get())
                }
                .build()
        }
    }

    val POSITION_GAUGE = ITEMS.register("position_gauge") { PanelBlockItem(PanelRegistry::getPositionPanel, Item.Properties()) }
    val LINEAR_VELOCITY_GAUGE = ITEMS.register("linear_velocity_gauge") { PanelBlockItem(PanelRegistry::getLinearVelocityPanel, Item.Properties()) }
    val ANGULAR_VELOCITY_GAUGE = ITEMS.register("angular_velocity_gauge") { PanelBlockItem(PanelRegistry::getAngularVelocityPanel, Item.Properties()) }
    val ROTATION_GAUGE = ITEMS.register("rotation_gauge") { PanelBlockItem(PanelRegistry::getRotationPanel, Item.Properties()) }
    val MASS_GAUGE = ITEMS.register("mass_gauge") { PanelBlockItem(PanelRegistry::getMassPanel, Item.Properties()) }
    val SLUG_GAUGE = ITEMS.register("slug_gauge") { PanelBlockItem(PanelRegistry::getSlugPanel, Item.Properties()) }
    val EULER_GAUGE = ITEMS.register("euler_gauge") { PanelBlockItem(PanelRegistry::getEulerPanel, Item.Properties()) }

    fun register() {
        TABS.register()
        ITEMS.register()
    }
}