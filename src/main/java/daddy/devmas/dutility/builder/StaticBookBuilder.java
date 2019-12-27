package daddy.devmas.dutility.builder;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;

public class StaticBookBuilder {

    private ItemStack item;

    public StaticBookBuilder() {
        item = new ItemStack(Material.WRITTEN_BOOK);
        BookMeta meta = (BookMeta) item.getItemMeta();
    }

    public StaticBookBuilder setName(String name) {
        BookMeta meta = (BookMeta) item.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', name));
        item.setItemMeta(meta);
        return this;
    }

    public StaticBookBuilder setAuthor(String author) {
        BookMeta meta = (BookMeta) item.getItemMeta();
        meta.setAuthor(ChatColor.translateAlternateColorCodes('&', author));
        item.setItemMeta(meta);
        return this;
    }

    public StaticBookBuilder addPage(String text) {

        BookMeta meta = (BookMeta) item.getItemMeta();
        meta.addPage(ChatColor.translateAlternateColorCodes('&', text));
        item.setItemMeta(meta);
        return this;
    }

    public ItemStack build() {
        return item;
    }

 }