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


    }

    @JvmStatic
    fun initClient() {
    }
}
