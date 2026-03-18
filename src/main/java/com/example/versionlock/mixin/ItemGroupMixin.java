package com.example.versionlock.mixin;

import com.example.versionlock.BlockVersionData;
import com.example.versionlock.VersionManager;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Mixin(CreativeModeTab.class)
public class ItemGroupMixin {

    /**
     * Intercepte le retour de getDisplayItems() et filtre les blocs trop récents.
     * Cette approche est plus fiable que d'injecter dans buildContents()
     * car elle ne dépend pas de la structure interne des champs.
     */
    @Inject(method = "getDisplayItems", at = @At("RETURN"), cancellable = true)
    private void firstversionblocklocker$filterDisplayItems(
            CallbackInfoReturnable<Collection<ItemStack>> cir) {

        if (VersionManager.getSelectedVersion() == null) return;

        Collection<ItemStack> original = cir.getReturnValue();
        if (original == null || original.isEmpty()) return;

        List<ItemStack> filtered = original.stream()
                .filter(stack -> {
                    if (stack.isEmpty()) return true;
                    ResourceLocation id = BuiltInRegistries.ITEM.getKey(stack.getItem());
                    return id == null || BlockVersionData.shouldShow(id.toString());
                })
                .collect(Collectors.toList());

        cir.setReturnValue(filtered);
    }

    /**
     * Même filtre pour l'onglet de recherche.
     */
    @Inject(method = "getSearchTabDisplayItems", at = @At("RETURN"), cancellable = true)
    private void firstversionblocklocker$filterSearchItems(
            CallbackInfoReturnable<Collection<ItemStack>> cir) {

        if (VersionManager.getSelectedVersion() == null) return;

        Collection<ItemStack> original = cir.getReturnValue();
        if (original == null || original.isEmpty()) return;

        List<ItemStack> filtered = original.stream()
                .filter(stack -> {
                    if (stack.isEmpty()) return true;
                    ResourceLocation id = BuiltInRegistries.ITEM.getKey(stack.getItem());
                    return id == null || BlockVersionData.shouldShow(id.toString());
                })
                .collect(Collectors.toList());

        cir.setReturnValue(filtered);
    }
}