package com.turtlehoarder.cobblemonchallenge.mixin;

import com.cobblemon.mod.common.battles.BattleBuilder;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;

@Mixin(BattleBuilder.class)
public class pvePreBattleBuilderMixin {
    @Inject(method = "pve*", at = @At(value = "HEAD"))
    public void method() {

    }
}