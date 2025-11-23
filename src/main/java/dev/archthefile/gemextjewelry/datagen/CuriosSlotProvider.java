package dev.archthefile.gemextjewelry.datagen;

import com.google.gson.JsonObject;
import dev.archthefile.gemextjewelry.GemExtJewelry;
import net.minecraft.data.CachedOutput;
import net.minecraft.data.DataProvider;
import net.minecraft.data.PackOutput;

import java.nio.file.Path;
import java.util.concurrent.CompletableFuture;

public class CuriosSlotProvider implements DataProvider {
    private final PackOutput output;

    public CuriosSlotProvider(PackOutput output) {
        this.output = output;
    }

    @Override
    public CompletableFuture<?> run(CachedOutput cache) {
        JsonObject obj = new JsonObject();
        obj.addProperty("size", 1);
        obj.addProperty("order", 0);
        obj.addProperty("icon", "curios:slot/empty_ring_slot");

        Path path = output.getOutputFolder()
                .resolve("data/" + GemExtJewelry.MODID + "/curios/slots/ring.json");

        return DataProvider.saveStable(cache, obj, path);
    }

    @Override
    public String getName() {
        return "Curios Slot Provider";
    }
}