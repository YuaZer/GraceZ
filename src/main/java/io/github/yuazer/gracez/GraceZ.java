package io.github.yuazer.gracez;

import com.pixelmonmod.pixelmon.api.pokemon.Pokemon;
import com.pixelmonmod.pixelmon.api.pokemon.stats.BattleStatsType;
import com.pixelmonmod.pixelmon.entities.pixelmon.PixelmonEntity;
import io.github.yuazer.gracez.GuiSetting.Window;
import io.github.yuazer.gracez.Registry.ItemRegistry;
import io.github.yuazer.gracez.Utils.ZUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import java.util.ArrayList;
import java.util.List;


@Mod("gracez")
//模组主类注解
@Mod.EventBusSubscriber
//模组方法监听类注解
public class GraceZ {
    public static final String MOD_ID = "gracez";
    public static final String MOD_AUTHOR = "YuaZer";
    public static Entity interactEntity = null;

    public GraceZ() {
        FMLJavaModLoadingContext.get().getModEventBus();   //获取MOD总线
        ItemRegistry.ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        //initWindow();
    }

    //    @SubscribeEvent
//    public static void onJoin(PlayerEvent.PlayerLoggedInEvent event) {
//        PlayerEntity player = event.getPlayer();
//        ZUtils.sendMsg(player, "Welcome!欢迎您！" + player.getDisplayName().getString() + "|isClient:" + (player.level.isClientSide ? "Client" : "Server"));
//    }
    @SubscribeEvent
    public static void onInput(InputEvent.KeyInputEvent event) {
        //当按下T键的时候
        if (event.getKey() == 84) {
            PlayerEntity player = Minecraft.getInstance().player;
            if (interactEntity instanceof PixelmonEntity) {
                Pokemon pokemon = ((PixelmonEntity) interactEntity).getPokemon();
                List<String> pokeInfo = new ArrayList<>();
                pokeInfo.add("名称:" + pokemon.getLocalizedName());
                pokeInfo.add("血量:" + pokemon.getHealth());
                pokeInfo.add("个体值:");
                pokeInfo.add("生命:" + pokemon.getStats().getIVs().getStat(BattleStatsType.HP) + "|攻击:" + pokemon.getIVs().getStat(BattleStatsType.ATTACK));
                pokeInfo.add("防御:" + pokemon.getStats().getIVs().getStat(BattleStatsType.DEFENSE) + "|特防:" + pokemon.getIVs().getStat(BattleStatsType.SPECIAL_DEFENSE));
                pokeInfo.add("特攻:" + pokemon.getStats().getIVs().getStat(BattleStatsType.SPECIAL_ATTACK) + "|速度:" + pokemon.getIVs().getStat(BattleStatsType.SPEED));
                ZUtils.sendMsg(player, pokeInfo);
            } else {
                ZUtils.sendMsg(player, "这不是个宝可梦");
            }
        }
    }

    @SubscribeEvent
    public static void onRightClick(PlayerInteractEvent.EntityInteract event) {
        interactEntity = event.getTarget();
    }

    public static void initWindow() {
        Window window = new Window(600, 600, "GraceZ Mod [1.16.5]");
        window.run();
    }
}
