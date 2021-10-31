package me.drex.gamerulify.mixin;

import me.drex.gamerulify.GameRulify;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.level.GameRules;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

/**
 * Notice:
 * We're using {@link Overwrite}, because the targeted methods are one-liners and this will alert us of any mod conflicts immediately.
 */

@Mixin(MinecraftServer.class)
public abstract class MinecraftServerMixin {

    @Shadow public abstract GameRules getGameRules();

    /**
     * @author Drex
     * @reason Add "pvp" gamerule
     */
    @Overwrite
    public boolean isPvpAllowed() {
        return this.getGameRules().getBoolean(GameRulify.PVP);
    }

    /**
     * @author Drex
     * @reason Add "allow-flight" gamerule
     */
    @Overwrite
    public boolean isFlightAllowed() {
        return this.getGameRules().getBoolean(GameRulify.ALLOW_FLIGHT);
    }

    /**
     * @author Drex
     * @reason Add "prevent-proxy-connections" gamerule
     */
    @Overwrite
    public boolean getPreventProxyConnections() {
        return this.getGameRules().getBoolean(GameRulify.PREVENT_PROXY_CONNECTIONS);
    }

}
