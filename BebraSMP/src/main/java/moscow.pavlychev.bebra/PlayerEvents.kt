package moscow.pavlychev.bebra

import moscow.pavlychev.bebra.BebraSMP.Companion.LOGGER
import net.fabricmc.fabric.api.networking.v1.PacketSender
import net.fabricmc.fabric.api.networking.v1.ServerPlayConnectionEvents
import net.minecraft.server.MinecraftServer
import net.minecraft.server.network.ServerPlayNetworkHandler
import net.minecraft.text.Text
import net.minecraft.text.TextColor

class PlayerEvents : ServerPlayConnectionEvents.Join {
    override fun onPlayReady(handler: ServerPlayNetworkHandler?, sender: PacketSender?, server: MinecraftServer?) {
        LOGGER.info("Player joined: " + handler?.player?.name)
        handler!!.player!!.sendMessage(
            Text.literal("Привет, ")
                .append(
                    Text.literal(handler.player!!.name.string)
                        .styled { style -> style.withColor(TextColor.fromRgb(0xFFAA00)) }
                )
                .append("!")
        )
    }
}