package io.github.psychopath21312.welcome

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.player.PlayerJoinCallback;
import net.fabricmc.fabric.api.networking.v1.ServerPlayConnectionEvents;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.text.Style;
import net.minecraft.text.util.Formatting;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Welcome2Server implements ModInitializer {
	public static final String MOD_ID = "welcome2server";

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("welcome2server loaded");

		ServerPlayConnectionEvents.JOIN.register((handler, sender, server) -> {
			ServerPlayerEntity player = handler.getPlayer();
			String playerName = player.getName().getString();
			
			Text welcomeMessage = Text.literal("Добро пожаловать на сервер, ")
				.styled(style -> style.withColor(formatting.GREEN).withBold(true))
				.append(Text.literal(playerName)
					.styled(style -> style.withColor(formatting.AQUA).withItalic(true)))
				.append(Text.literal("!")
					.styled(style -> style.withColor(formatting.GREEN).withBold(true)))

			player.sendMessage(welcomeMessage, false);
		})
	}
}
