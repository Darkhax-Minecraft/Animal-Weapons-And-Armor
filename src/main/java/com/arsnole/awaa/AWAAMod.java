package com.arsnole.awaa;

import com.arsnole.awaa.items.ItemBlazeBow;

import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.monster.BlazeEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent.Register;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod("awaa")
public class AWAAMod {
	
    private Item blazeBow;

    public AWAAMod() {
    	
    	FMLJavaModLoadingContext.get().getModEventBus().addGenericListener(Item.class, this::registerItems);

        MinecraftForge.EVENT_BUS.addListener(this::onMobDropItems);
    }
    
    private void registerItems(Register<Item> event) {

        this.blazeBow = new ItemBlazeBow();
    	event.getRegistry().register(this.blazeBow);
    }

    private void onMobDropItems(LivingDropsEvent event) {
        
        if (event.getEntity() instanceof BlazeEntity && event.getEntity().world.rand.nextDouble() < 0.3) {
            
            event.getDrops().add(new ItemEntity(event.getEntity().world, event.getEntity().getPosX(), event.getEntity().getPosY(), event.getEntity().getPosZ(), new ItemStack(this.blazeBow)));
        }
    }
}