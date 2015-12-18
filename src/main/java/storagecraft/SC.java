package storagecraft;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import storagecraft.proxy.CommonProxy;

@Mod(modid = SC.ID, version = SC.VERSION)
public class SC {
	public static final class GUI {
		public static final int CONTROLLER = 0;
		public static final int GRID = 1;
		public static final int DRIVE = 2;
		public static final int IMPORTER = 3;
	}

	public static final String ID = "storagecraft";
	public static final String VERSION = "1.0";
	public static final SimpleNetworkWrapper NETWORK = NetworkRegistry.INSTANCE.newSimpleChannel(ID);
	public static final CreativeTabs TAB = new CreativeTabs(ID) {
		@Override
		public Item getTabIconItem() {
			return Item.getItemFromBlock(SCBlocks.CONTROLLER);
		}
	};
	@SidedProxy(clientSide = "storagecraft.proxy.ClientProxy", serverSide = "storagecraft.proxy.ServerProxy")
	public static CommonProxy PROXY;
	@Instance
	public static SC INSTANCE;

	@EventHandler
	public void preInit(FMLPreInitializationEvent e) {
		PROXY.preInit(e);
	}

	@EventHandler
	public void init(FMLInitializationEvent e) {
		PROXY.init(e);
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent e) {
		PROXY.postInit(e);
	}
}
