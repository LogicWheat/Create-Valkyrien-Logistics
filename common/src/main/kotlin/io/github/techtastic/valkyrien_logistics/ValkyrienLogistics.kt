package io.github.techtastic.valkyrien_logistics

import dev.architectury.registry.CreativeTabRegistry
import io.github.techtastic.valkyrien_logistics.registry.VLItems
import io.github.techtastic.valkyrien_logistics.registry.VLPartialModels
import net.minecraft.network.chat.Component
import net.minecraft.world.item.CreativeModeTab

object ValkyrienLogistics {
    const val MOD_ID = "valkyrien_logistics"

    @JvmStatic
    fun init() {
        VLItems.register()
        VLPartialModels.init()

        CreativeTabRegistry.create { builder ->
            builder
                .title(Component.translatable("itemGroup.valkyrien_logistics"))
                .icon { VLItems.ROTATION_GAUGE.get().defaultInstance }
                .displayItems { params, output ->
                    output.accept(VLItems.POSITION_GAUGE.get())
                    output.accept(VLItems.LINEAR_VELOCITY_GAUGE.get())
                    output.accept(VLItems.ANGULAR_VELOCITY_GAUGE.get())
                    output.accept(VLItems.ROTATION_GAUGE.get())
                    output.accept(VLItems.MASS_GAUGE.get())
                    output.accept(VLItems.SLUG_GAUGE.get())
                }
                .build()
        }
    }

    @JvmStatic
    fun initClient() {
    }
}
