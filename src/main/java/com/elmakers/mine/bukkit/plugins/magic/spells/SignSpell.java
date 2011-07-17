package com.elmakers.mine.bukkit.plugins.magic.spells;

import java.text.DateFormat;
import java.util.Date;
import java.util.Map;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;

import com.elmakers.mine.bukkit.plugins.magic.Spell;
import com.elmakers.mine.bukkit.plugins.magic.Target;

public class SignSpell extends Spell
{  
    @Override
    public boolean onCast(ConfigurationNode parameters) 
    {
        if (parameters.containsKey("type"))
        {
            String typeString = (String)parameters.get("type");
            if (typeString.equals("give"))
            {

                castMessage(player, "Have some signs!");
                return giveMaterial(Material.SIGN, 8, (short)0, (byte)0);
            }
        }
        
        setMaxRange(8, false);
        targetEntity(Player.class);
        Target target = getTarget();
        if (target.isBlock())
        {
            Block targetBlock = getFaceBlock();
            if (targetBlock.getFace(BlockFace.DOWN).getType() == Material.AIR)
            {
                targetBlock.setType(Material.WALL_SIGN);
                switch(target.getBlock().getFace(targetBlock))
                {
                    case EAST:
                        targetBlock.setData((byte)2);
                        break;
                    case WEST:
                        targetBlock.setData((byte)3);
                        break;
                    case NORTH:
                        targetBlock.setData((byte)4);
                        break;
                    case SOUTH:
                        targetBlock.setData((byte)5);
                        break;
                }
            }
            else
            {
                targetBlock.setType(Material.SIGN_POST);
                float yaw = player.getLocation().getYaw();
                yaw = yaw < 180 ? yaw + 180 : yaw - 180;
                targetBlock.setData((byte)(yaw * 15 / 360));
            }
            if (targetBlock.getState() instanceof Sign)
            {
                Sign sign = (Sign)targetBlock.getState();
                sign.setLine(0, player.getName());
                sign.setLine(1, "was here");
                Date currentDate = new Date();
                sign.setLine(3, DateFormat.getInstance().format(currentDate));
                castMessage(player, "You leave a tag");
                return true;
            }
            else
            {
                sendMessage(player, "Sign placement failed!");
                return false;
            }
        }
        else if (target.isEntity() && target.getEntity() instanceof Player)
        {
            Player targetPlayer = (Player)target.getEntity();
            targetPlayer.sendMessage(player.getName() + " says hi!");
            sendMessage(player, "You send " + targetPlayer.getName() + " a message");
            return true;
        }
            
        return false;
    }
}
