package daddy.devmas.dutility.builder;

import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ItemBuilder {

    private ItemStack item;

    public ItemBuilder(ItemStack item) {
        this.item = item;
    }

    public ItemBuilder(Material mat) {
        this(mat, 1);
    }

    public ItemBuilder(Material mat, int amt) {
        this.item = new ItemStack(mat, amt, (short) 0);
    }

    public ItemBuilder(Material mat, short data) {
        this(mat, 1, data);
    }

    public ItemBuilder(Material mat, int amt, short data) {
        this.item = new ItemStack(mat, amt, data);
    }

    public ItemBuilder clone() {
        return new ItemBuilder(item);
    }

    public ItemBuilder setName(String name) {
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', name));
        item.setItemMeta(meta);
        return this;
    }

    public ItemBuilder addEnchantment(Enchantment enc, int level) {
        ItemMeta meta = item.getItemMeta();
        meta.addEnchant(enc, level, true);
        item.setItemMeta(meta);
        return this;
    }

    public ItemBuilder addEnchantments(HashMap<Enchantment, Integer> enchantments) {
        ItemMeta meta = item.getItemMeta();
        for(Enchantment e : enchantments.keySet()) {
            meta.addEnchant(e, enchantments.get(e), true);
        }
        return this;
    }

    public ItemBuilder removeEnchantment(Enchantment enc) {
        item.removeEnchantment(enc);
        return this;
    }

    public ItemBuilder setSkullOwner(String owner) {
        try {
            SkullMeta meta = (SkullMeta) item.getItemMeta();
            meta.setOwner(owner);
            item.setItemMeta(meta);
        } catch (ClassCastException e) {
            e.printStackTrace();
        }
        return this;
    }

    public ItemBuilder setDurability(short durability) {
        item.setDurability(durability);
        return this;
    }

    public ItemBuilder setInfiniteDurability() {
        item.setDurability(Short.MAX_VALUE);
        return this;
    }

    public ItemBuilder setLore(List<String> lore) {
        ItemMeta meta = item.getItemMeta();
        ArrayList<String> l = new ArrayList<>();
        for(String s : lore) {
            l.add(ChatColor.translateAlternateColorCodes('&', s));
        }
        meta.setLore(l);
        item.setItemMeta(meta);
        return this;
    }

    public ItemBuilder addLoreLine(String line) {
        ItemMeta meta = item.getItemMeta();
        List<String> lore = meta.getLore() != null ? meta.getLore() : new ArrayList<>();
        lore.add(ChatColor.translateAlternateColorCodes('&', line));
        meta.setLore(lore);
        item.setItemMeta(meta);
        return this;
    }

    public ItemBuilder setLoreLine(int pos, String line) {
        ItemMeta meta = item.getItemMeta();
        List<String> lore = meta.getLore() != null ? meta.getLore() : new ArrayList<>();
        lore.set(pos, ChatColor.translateAlternateColorCodes('&', line));
        meta.setLore(lore);
        item.setItemMeta(meta);
        return this;
    }

    public ItemBuilder removeLore(String line) {
        ItemMeta meta = item.getItemMeta();
        List<String> lore = meta.getLore() != null ? meta.getLore() : new ArrayList<>();
        lore.remove(line);
        meta.setLore(lore);
        item.setItemMeta(meta);
        return this;
    }
    public ItemBuilder removeLore(int line) {
        ItemMeta meta = item.getItemMeta();
        List<String> lore = meta.getLore() != null ? meta.getLore() : new ArrayList<>();
        lore.remove(line);
        meta.setLore(lore);
        item.setItemMeta(meta);
        return this;
    }

    public ItemBuilder setLeatherColor(Color color) {
        if(!item.getType().name().contains("LEATHER")) return this;
        LeatherArmorMeta meta = (LeatherArmorMeta) item.getItemMeta();
        meta.setColor(color);
        item.setItemMeta(meta);
        return this;
    }

    public ItemBuilder hideAttribute() {
        ItemMeta meta = item.getItemMeta();
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_POTION_EFFECTS);
        item.setItemMeta(meta);
        return this;
    }

    public ItemBuilder hideEnchants() {
        ItemMeta meta = item.getItemMeta();
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        return this;
    }

    public ItemStack build() {
        return item;
    }
}