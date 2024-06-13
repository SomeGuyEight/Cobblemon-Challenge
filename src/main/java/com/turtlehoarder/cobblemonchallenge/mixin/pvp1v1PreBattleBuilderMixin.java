package com.turtlehoarder.cobblemonchallenge.mixin;

import com.turtlehoarder.cobblemonchallenge.config.DifficultyConfig;
import com.cobblemon.mod.common.battles.BattleBuilder;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;

@Mixin(BattleBuilder.class)
public class pvp1v1PreBattleBuilderMixin {

    @Inject(method = "pvp1v1*", at = @At(value = "HEAD"))
    public void handlePreBattleCheck() {
        /*
         * Parameters for main method:
         *
         * player1: ServerPlayerEntity,
         * player2: ServerPlayerEntity,
         * leadingPokemonPlayer1: UUID? = null,
         * leadingPokemonPlayer2: UUID? = null,
         * battleFormat: BattleFormat = BattleFormat.GEN_9_SINGLES,
         * cloneParties: Boolean = false,
         * healFirst: Boolean = false,
         * partyAccessor: (ServerPlayerEntity) -> PartyStore = { it.party() }
         *
         * gate -> Are there configs that apply? -> check cached value for pvp configs
         *      > true -> progress to #2
         *      > false -> do nothing
         * 2. Do the configs apply?
         *      > true -> register battle & apply adjustments to parameters -> progress to #3
         *      > false -> do nothing
         * 3. for now, nothing, b/c second mixin
         *      > second mixin:
         *          > path: 'com.cobblemon.mod.common.battles.BattleRegistry.startBattle'
         *          > when: 'tail'
         *          > purpose: get PokemonBattle && pokemon battle start result
         *              > class path: 'com.cobblemon.mod.common.api.battles.model.PokemonBattle'
         *                  > target UUID: 'PokemonBattle.battleId' -> val battleId = UUID.randomUUID()
         *              > !! A LOT of uses for PokemonBattle !!
         *                  >> Be thorough, so nothing slips through
         *                  >> Find the single exit if possible
         * After: Use override val battle: PokemonBattle in events to process each battle.
         *      com.cobblemon.mod.common.api.events.battles.BattleVictoryEvent
         *      com.cobblemon.mod.common.api.events.battles.BattleFaintedEvent
         *      com.cobblemon.mod.common.api.events.battles.BattleFledEvent
         *
         * ?! Are there any battles that can escape outside of these three events... ?!
         *
         * TODO: Handle application of status & post battle impact on actual pokemon
         *      > still planning...
         *      > ?? store reference to original pokemon & use mixin to catch battle at conclusion ??
         *      > this is the only entry -> find the only exit...
         *          > caveat: need to catch ErroredBattleStart if start battle called & error is thrown
         *          > need to update battle registry
         */


        if (DifficultyConfig.USE_UNIVERSAL_LEVEL || DifficultyConfig.USE_UNIVERSAL_LEVEL_RANGE || DifficultyConfig.USE_UNIVERSAL_HANDICAP) {
            /*
             *  1. Apply Pre Battle Configs
             *
             *  2. Make sure clones are used
             *      > ?? should be thrown out after battle ??
             *          > if so -> worst case is statuses/exp is not applied to actual pokemon
             *          > make sure clones that are cloned are also destroyed
             *              > check battles periodically to confirm any registered active battles are actually active
             *                  > clear clones if any battles are left hanging
             *  3. Cache HashMap of UUID (original,clone)
             *      > need to figure out how to get clones-clone to apply changes to original pokemon
             */
        }
    }
}

