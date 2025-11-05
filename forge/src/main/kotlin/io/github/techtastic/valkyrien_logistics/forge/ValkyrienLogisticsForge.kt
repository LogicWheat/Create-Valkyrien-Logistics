package io.github.techtastic.valkyrien_logistics.forge

import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent
import io.github.techtastic.valkyrien_logistics.ValkyrienLogistics
import io.github.techtastic.valkyrien_logistics.ValkyrienLogistics.init
import io.github.techtastic.valkyrien_logistics.ValkyrienLogistics.initClient
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext

@Mod(ValkyrienLogistics.MOD_ID)
class ValkyrienLogisticsForge(context: FMLJavaModLoadingContext) {
    init {
        context.modEventBus.addListener { event: FMLClientSetupEvent? ->
            clientSetup(
                event
            )
        }
        init()
    }

    private fun clientSetup(event: FMLClientSetupEvent?) {
        initClient()
    }
}
