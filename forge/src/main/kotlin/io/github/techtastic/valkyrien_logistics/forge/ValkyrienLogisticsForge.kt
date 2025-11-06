package io.github.techtastic.valkyrien_logistics.forge

import dev.architectury.platform.forge.EventBuses
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent
import io.github.techtastic.valkyrien_logistics.ValkyrienLogistics
import io.github.techtastic.valkyrien_logistics.ValkyrienLogistics.init
import io.github.techtastic.valkyrien_logistics.ValkyrienLogistics.initClient
import io.github.techtastic.valkyrien_logistics.platform.forge.PanelRegistryImpl
import thedarkcolour.kotlinforforge.KotlinModLoadingContext

@Mod(ValkyrienLogistics.MOD_ID)
class ValkyrienLogisticsForge {
    init {
        val modBus = KotlinModLoadingContext.get().getKEventBus()
        EventBuses.registerModEventBus(ValkyrienLogistics.MOD_ID, modBus)

        modBus.addListener { event: FMLClientSetupEvent? ->
            clientSetup(event)
        }
        init()

        PanelRegistryImpl.register(modBus)
    }

    private fun clientSetup(event: FMLClientSetupEvent?) {
        initClient()
    }
}
