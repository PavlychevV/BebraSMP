package moscow.pavlychev.bebra

import net.fabricmc.api.DedicatedServerModInitializer
import net.fabricmc.fabric.api.networking.v1.ServerPlayConnectionEvents
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger

class BebraSMP : DedicatedServerModInitializer {
    companion object {
        val LOGGER: Logger = LogManager.getLogger("BebraSMP")
    }

    override fun onInitializeServer() {
        LOGGER.info("Initializing BebraSMP...")

        ServerPlayConnectionEvents.JOIN.register(PlayerEvents())

        LOGGER.info("BebraSMP initialized!")
    }
}
