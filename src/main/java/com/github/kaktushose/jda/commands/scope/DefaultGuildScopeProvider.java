package com.github.kaktushose.jda.commands.scope;

import net.dv8tion.jda.api.interactions.commands.build.CommandData;

import java.util.Collections;
import java.util.Set;

/**
 * Default implementation of {@link GuildScopeProvider}. <b>This will always return an empty Set!</b>
 *
 * @author Kaktushose
 * @version 4.0.0
 * @see GuildScopeProvider
 * @since 4.0.0
 */
public class DefaultGuildScopeProvider implements GuildScopeProvider {

    @Override
    public Set<Long> getGuildsForCommand(CommandData commandData) {
        return Collections.emptySet();
    }

}
