package daddy.devmas.dutility.builder;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;

public class InventoryBuilder {

    private InventoryHolder holder;
    private int size = 54;
    private String name;
    private InventoryType type = null;
    private boolean useType;
    private boolean useFill;
    private ItemStack filler = null;
    private HashMap<Integer, ItemStack> items = new HashMap<>();

    public InventoryBuilder setHolder(InventoryHolder holder) {
        this.holder = holder;
        return this;
    }

    public InventoryBuilder setSize(int size) {
        this.size = size;
        return this;
    }

    public InventoryBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public InventoryBuilder setType(InventoryType type) {
        this.type = type;
        this.useType = true;
        return this;
    }

    public InventoryBuilder setFillItem(ItemStack item) {
        this.filler = item;
        this.useFill = true;
        return this;
    }

    public InventoryBuilder setItem(int slot, ItemStack item) {
        this.items.put(slot, item);
        return this;
    }

    public Inventory build() {
        Inventory inv;

        if(size % 9 != 0) size = 54;

        if(useType) inv = Bukkit.createInventory(holder, type, ChatColor.translateAlternateColorCodes('&', name));
        else inv = Bukkit.createInventory(holder, size, ChatColor.translateAlternateColorCodes('&', name));

        if(useFill && filler != null) {
            for(int i = 0; i < size; i++) {
                inv.setItem(i, filler);
            }
        }

        for(int s : items.keySet()) {
            inv.setItem(s, items.get(s));
        }

        return inv;
    }
}
