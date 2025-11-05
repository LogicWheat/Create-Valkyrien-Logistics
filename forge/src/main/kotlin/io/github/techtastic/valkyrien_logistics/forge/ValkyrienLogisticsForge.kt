package io.github.techtastic.valkyrien_logistics.forge

import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent
import io.github.techtastic.valkyrien_logistics.ValkyrienLogistics
import io.github.techtastic.valkyrien_logistics.ValkyrienLogistics.init
import io.github.techtastic.valkyrien_logistics.ValkyrienLogistics.initClient
import thedarkcolour.kotlinforforge.KotlinModLoadingContext

@Mod(ValkyrienLogistics.MOD_ID)
class ValkyrienLogisticsForge {
    init {
        KotlinModLoadingContext.get().getKEventBus().addListener { event: FMLClientSetupEvent? ->
            clientSetup(event)
        }
        init()
    }

    private fun clientSetup(event: FMLClientSetupEvent?) {
        initClient()
    }
}
