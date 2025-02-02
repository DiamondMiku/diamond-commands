package com.github.kaktushose.jda.commands.annotations.interactions;

import com.github.kaktushose.jda.commands.dispatching.commands.CommandEvent;
import net.dv8tion.jda.api.Permission;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Methods annotated with SlashCommand will be registered as a command at startup.
 *
 * <p>Therefore the method must be declared inside a class that is annotated with
 * {@link com.github.kaktushose.jda.commands.annotations.interactions.Interaction}.
 * Furthermore, the method signature has to meet the following conditions:
 * <ul>
 * <li>First parameter must be of type {@link CommandEvent}</li>
 * <li>Remaining parameter types must be registered at the
 * {@link com.github.kaktushose.jda.commands.dispatching.adapter.TypeAdapterRegistry TypeAdapterRegistry} or be a
 * String array</li>
 * <li>Parameter constraints must be valid</li>
 * </ul>
 *
 * @author Kaktushose
 * @version 4.0.0
 * @see com.github.kaktushose.jda.commands.annotations.interactions.Interaction Interaction
 * @see com.github.kaktushose.jda.commands.annotations.constraints.Constraint Constraint
 * @since 1.0.0
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface SlashCommand {

    /**
     * Returns the name of the command.
     *
     * @return the name of the command
     */
    String value() default "";

    /**
     * Returns whether this command is only usable in a guild.
     * This only has an effect if this command is registered globally.
     *
     * @return {@code true} if this command is only usable in a guild
     */
    boolean isGuildOnly() default false;

    /**
     * Returns the description of the command.
     *
     * @return the description of the command
     */
    String desc() default "N/A";

    /**
     * Returns whether this command is active and thus can be executed or not.
     *
     * @return {@code true} if this command is active
     */
    boolean isActive() default true;

    /**
     * Returns whether this command can only be executed in NSFW channels.
     *
     * @return {@code true} if this command can only be executed in NSFW channels
     */
    boolean isNSFW() default false;

    /**
     * Returns whether this command should send ephemeral replies by default. Note that {@link Interaction#ephemeral()}
     * set to {@code true} will override this value.
     *
     * @return {@code true} if this command should send ephemeral replies
     */
    boolean ephemeral() default false;

    /**
     * Returns an array of {@link net.dv8tion.jda.api.Permission Permissions} this command
     * should be enabled for by default. Note that guild admins can modify this at any time.
     *
     * @return a set of permissions this command will be enabled for by default
     * @see Permissions Permission
     * @see net.dv8tion.jda.api.interactions.commands.DefaultMemberPermissions DefaultMemberPermissions.ENABLED
     * @see net.dv8tion.jda.api.interactions.commands.DefaultMemberPermissions DefaultMemberPermissions.DISABLED
     */
    Permission[] enabledFor() default Permission.UNKNOWN;

    /**
     * Returns whether this command should be registered as a global or as a guild command.
     *
     * @return whether this command should be registered as a global or as a guild command
     * @see CommandScope
     */
    CommandScope scope() default CommandScope.GLOBAL;

    /**
     * Enum describing the two possible scopes a command can be registered for.
     *
     * @author Kaktushose
     * @version 4.0.0
     * @see SlashCommand#scope()
     * @since 4.0.0
     */
    enum CommandScope {
        GUILD,
        GLOBAL
    }

}
