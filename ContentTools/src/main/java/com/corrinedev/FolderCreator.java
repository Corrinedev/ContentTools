package com.corrinedev;

import javax.swing.*;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FolderCreator {
    public static void createfolders() {

        String directory = JOptionPane.showInputDialog(null,"Input the directory of the content pack folder (Example: C:\\Users\\-----\\Syncable");
        String packid = JOptionPane.showInputDialog(null,"Input the id of the content pack (Example: tp for TestPack");

        try {
            Files.createDirectory(Path.of(directory + "\\animations"));
            Files.createDirectory(Path.of(directory + "\\attachments"));
            Files.createDirectory(Path.of(directory + "\\attachments\\data"));
            Files.createDirectory(Path.of(directory + "\\attachments\\display"));
            Files.createDirectory(Path.of(directory + "\\attachments\\index"));
            Files.createDirectory(Path.of(directory + "\\guns"));
            Files.createDirectory(Path.of(directory + "\\guns\\data"));
            Files.createDirectory(Path.of(directory + "\\guns\\display"));
            Files.createDirectory(Path.of(directory + "\\guns\\index"));
            Files.createDirectory(Path.of(directory + "\\lang"));
            Files.createDirectory(Path.of(directory + "\\models"));
            Files.createDirectory(Path.of(directory + "\\models\\ammo"));
            Files.createDirectory(Path.of(directory + "\\models\\ammo_entity"));
            Files.createDirectory(Path.of(directory + "\\models\\attachment"));
            Files.createDirectory(Path.of(directory + "\\models\\attachment\\lod"));
            Files.createDirectory(Path.of(directory + "\\models\\gun"));
            Files.createDirectory(Path.of(directory + "\\models\\gun\\lod"));
            Files.createDirectory(Path.of(directory + "\\models\\shell"));
            Files.createDirectory(Path.of(directory + "\\recipes"));
            Files.createDirectory(Path.of(directory + "\\recipes\\ammo"));
            Files.createDirectory(Path.of(directory + "\\recipes\\attachments"));
            Files.createDirectory(Path.of(directory + "\\recipes\\gun"));
            Files.createDirectory(Path.of(directory + "\\sounds"));
            Files.createDirectory(Path.of(directory + "\\textures"));
            Files.createDirectory(Path.of(directory + "\\tags"));
            Files.createDirectory(Path.of(directory + "\\tags\\attachments"));
            Files.createDirectory(Path.of(directory + "\\tags\\attachments\\allow_attachments"));
            Files.createDirectory(Path.of(directory + "\\textures\\ammo"));
            Files.createDirectory(Path.of(directory + "\\textures\\ammo\\slot"));
            Files.createDirectory(Path.of(directory + "\\textures\\ammo\\uv"));
            Files.createDirectory(Path.of(directory + "\\textures\\ammo_entity"));
            Files.createDirectory(Path.of(directory + "\\textures\\attachment"));
            Files.createDirectory(Path.of(directory + "\\textures\\attachment\\lod"));
            Files.createDirectory(Path.of(directory + "\\textures\\attachment\\slot"));
            Files.createDirectory(Path.of(directory + "\\textures\\attachment\\uv"));
            Files.createDirectory(Path.of(directory + "\\textures\\gun"));
            Files.createDirectory(Path.of(directory + "\\textures\\gun\\hud"));
            Files.createDirectory(Path.of(directory + "\\textures\\gun\\lod"));
            Files.createDirectory(Path.of(directory + "\\textures\\gun\\slot"));
            Files.createDirectory(Path.of(directory + "\\textures\\gun\\uv"));
            Files.createDirectory(Path.of(directory + "\\textures\\shell"));
            Files.createDirectory(Path.of(directory + "\\textures\\flash"));
            Files.createFile(Path.of(directory + "\\pack.json"));
            Files.createFile(Path.of(directory + "\\lang\\en_us.json"));
            Files.writeString(Path.of(directory + "\\lang\\en_us.json"),"{\n" +
                    "  \"pack." + packid + "." + packid + ".name\": \"Example Name\",\n" +
                    "  \"pack." + packid + "." + packid + ".desc\": \"Pack Description\",\n" +
                    "\n" +
                    "  \"" + packid + ".gun.example.name\": \"Example Gun Name\",\n" +
                    "\n" +
                    "  \"" + packid + ".gun.example.desc\": \"Example gun description\",\n" +
                    "\n" +
                    "  \"" + packid + ".ammo.example.name\": \"§aExample Ammo\",\n" +
                    "    \n" +
                    "  \"" + packid + ".attachment.example.name\": \"Example Attachment Name\",\n" +
                    "\n" +
                    "  \"" + packid + ".attachment.example.desc\": \"Example Attachment Description\"    //ALWAYS make sure the last line does not have a \",\"\n" +
                    "}");
            Files.writeString(Path.of(directory + "\\pack.json"), "{\n" +
                    "  \"version\": \"1.0.0\", //pack version number\n" +
                    "  \"name\": \"pack." + packid + "." + packid + ".name\", //refrence this in your lang file\n" +
                    "  \"desc\": \"pack." + packid + "." + packid + ".desc\", //refrence this in your lang file\n" +
                    "  \"license\": \"CC BY-NC-ND 4.0\", //license, dont bother changing unless you know what it means\n" +
                    "  \"authors\": [\n" +
                    "    \"TACZ Dev Team\" //your name or partners names or team name\n" +
                    "  ],\n" +
                    "  \"date\": \"2024-06-01\", //date of pack creation\n" +
                    "  \"url\": \"https://tacwiki.mcma.club/zh/\",\n" +
                    "  \"dependencies\": {\n" +
                    "    // 模组 ID 和版本号\n" +
                    "    // \"tacz\": \"[1.0.3,)\"\n" +
                    "  }\n" +
                    "}");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        String nameinput = "empty";

        while(!(nameinput == null)) {

            nameinput = JOptionPane.showInputDialog(null, "Put in the name of any guns you are making and it will generate folders for you!");
            if (nameinput == null) {
                System.out.println("Please input a gun");
            } else {
                try {
                    if(!(nameinput == null)) {
                        Files.createDirectory(Path.of(directory + "\\sounds" + "\\" + nameinput));
                        Files.createFile(Path.of(directory + "\\guns\\data\\" + nameinput + "_data.json"));
                        Files.writeString(Path.of(directory + "\\guns\\data\\" + nameinput + "_data.json"), "{\n" +
                                "  \"ammo\": \"" + packid + "9mm\",\n" +
                                "  \"rpm\": 400, //Rate of fire of your gun\n" +
                                "  \"bullet\": {\n" +
                                "    \"life\": 0.8,\n" +
                                "    \"bullet_amount\": 1, //Increase this for shotgun pellets\n" +
                                "    \"damage\": 6,       //Damage that shows up on the gun tooltip\n" +
                                "    \"tracer_count_interval\": 0,\n" +
                                "    \"extra_damage\": {\n" +
                                "      \"armor_ignore\": 0,\n" +
                                "      \"head_shot_multiplier\": 1.5,\n" +
                                "      \"damage_adjust\": [                //Actual damage values\n" +
                                "        {\"distance\": 20, \"damage\": 6},\n" +
                                "        {\"distance\": 45, \"damage\": 5},\n" +
                                "        {\"distance\": \"infinite\", \"damage\": 4}\n" +
                                "      ]\n" +
                                "    },\n" +
                                "    \"speed\": 150,       //Speed of projectile\n" +
                                "    \"gravity\": 0.15,    //Usually dont mess with this\n" +
                                "    \"knockback\": 0,\n" +
                                "    \"friction\": 0.025,  //Usually dont mess with this\n" +
                                "    \"ignite\": false,\n" +
                                "    \"pierce\": 1\n" +
                                "  },\n" +
                                "  \"ammo_amount\": 17,\n" +
                                "  \"extended_mag_ammo_amount\": [\n" +
                                "    20,\n" +
                                "    25,\n" +
                                "    30\n" +
                                "  ],\n" +
                                "  \"bolt\": \"closed_bolt\", //Only change if you know the parameters\n" +
                                "  \"reload\": {\n" +
                                "    \"type\": \"magazine\",\n" +
                                "    \"feed\": {            //Change all of these numbers to the values of the length of your animations\n" +
                                "      \"empty\": 1.63,\n" +
                                "      \"tactical\": 1.05\n" +
                                "    },\n" +
                                "    \"cooldown\": {\n" +
                                "      \"empty\": 1.88,\n" +
                                "      \"tactical\": 1.5\n" +
                                "    }\n" +
                                "  },\n" +
                                "  \"draw_time\": 0.32,\n" +
                                "  \"put_away_time\": 0.35,\n" +
                                "  \"aim_time\": 0.17,\n" +
                                "  \"sprint_time\": 0.05,\n" +
                                "  \"weight\": 1,\n" +
                                "  \"movement_speed\": {\n" +
                                "    \"base\": 0.0,\n" +
                                "    \"aim\": 0,\n" +
                                "    \"reload\": 0.1\n" +
                                "  },\n" +
                                "  \"crawl_recoil_multiplier\": 0.75,\n" +
                                "  \"fire_mode\": [    //Firemodes, semi, auto [burst is done differently]\n" +
                                "    \"semi\"\n" +
                                "  ],\n" +
                                "  \"allow_attachment_types\": [ //Allowed attachments\n" +
                                "    \"scope\",\n" +
                                "    \"muzzle\",\n" +
                                "    \"extended_mag\"\n" +
                                "  ],\n" +
                                "  \"recoil\": {                //Recoil values\n" +
                                "    \"pitch\": [\n" +
                                "      {\"time\": 0, \"value\": [0.55, 0.55]},\n" +
                                "      {\"time\": 0.35, \"value\": [0.55, 0.55]},\n" +
                                "      {\"time\": 0.6, \"value\": [-0.175, -0.175]},\n" +
                                "      {\"time\": 0.8, \"value\": [0.05, 0.05]},\n" +
                                "      {\"time\": 1.0, \"value\": [0, 0]}\n" +
                                "    ],\n" +
                                "    \"yaw\": [\n" +
                                "      {\"time\": 0, \"value\": [-0.2, 0.2]},\n" +
                                "      {\"time\": 0.45, \"value\": [0, 0]}\n" +
                                "    ]\n" +
                                "  },\n" +
                                "  \"inaccuracy\": {         //Increase innaccuracy for shotguns to have proper spread, decrease for snipers\n" +
                                "    \"stand\": 2,\n" +
                                "    \"move\": 2.5,\n" +
                                "    \"sneak\": 1.5,\n" +
                                "    \"lie\": 0.7,\n" +
                                "    \"aim\": 0.2\n" +
                                "  }\n" +
                                "}");
                        Files.createFile(Path.of(directory + "\\guns\\display\\" + nameinput + "_display.json"));
                        Files.createFile(Path.of(directory + "\\guns\\index\\" + nameinput + ".json"));

                        Files.writeString(Path.of(directory + "\\guns\\index\\" + nameinput + ".json"),"{\n" +
                                "  \"name\": \"" + packid + ".gun." + nameinput +".name\",\n" +
                                "  \"display\": \"" + packid + ":" + nameinput +"_display\",\n" +
                                "  \"data\": \"" + packid + ":" + nameinput +"_data\",\n" +
                                "  \"tooltip\": \"" + packid + ".gun." + nameinput +".desc\",\n" +
                                "  \"type\": \"place the type of gun here(pistol, rifle, sniper, shotgun, etc)\"\n" +
                                "}");

                        Files.writeString(Path.of(directory + "\\guns\\display\\" + nameinput + "_display.json"), "{\n" +
                                "  \"model\": \"" + packid + ":gun/" + nameinput +"_geo\",\n" +
                                "  \"texture\": \"" + packid + "gun/uv/" + nameinput +"\",\n" +
                                "  \"lod\": {\n" +
                                "    \"model\": \"" + packid + "gun/lod/" + nameinput +"\",\n" +
                                "    \"texture\": \"" + packid + "gun/lod/" + nameinput +"\"\n" +
                                "  },\n" +
                                "  \"hud\": \"" + packid + "gun/hud/" + nameinput +"\",\n" +
                                "  \"slot\": \"" + packid + "gun/slot/" + nameinput +"\",\n" +
                                "  \"animation\": \"" + packid + "" + nameinput +"\",\n" +
                                "  \"use_default_animation\": \"rifle\",\n" +
                                "  \"transform\": {\n" +
                                "    \"scale\": {\n" +
                                "      \"thirdperson\": [0.6, 0.6, 0.6],\n" +
                                "      \"ground\": [0.6, 0.6, 0.6],\n" +
                                "      \"fixed\": [1.2, 1.2, 1.2]\n" +
                                "    }\n" +
                                "  },\n" +
                                "  \"muzzle_flash\": {\n" +
                                "    \"texture\": \"" + packid + "flash/common_muzzle_flash\",\n" +
                                "    \"scale\": 1\n" +
                                "  },\n" +
                                "  \"sounds\": {\n" +
                                "    \"reload_empty\": \"" + packid + "" + nameinput +"/" + nameinput +"_reload_empty\",\n" +
                                "    \"reload_tactical\": \"" + packid + "" + nameinput +"/" + nameinput +"_reload_tactical\",\n" +
                                "    \"inspect\": \"" + packid + "" + nameinput +"/" + nameinput +"_inspect\",\n" +
                                "    \"inspect_empty\": \"" + packid + "" + nameinput +"/" + nameinput +"_inspect_empty\",\n" +
                                "    \"draw\": \"" + packid + "" + nameinput +"/" + nameinput +"_draw\",\n" +
                                "    \"shoot\": \"" + packid + "" + nameinput +"/" + nameinput +"shoot\",\n" +
                                "    \"shoot_3p\": \"" + packid + "" + nameinput +"/" + nameinput +"_shoot_3p\",\n" +
                                "    \"silence\": \"" + packid + "" + nameinput +"/" + nameinput +"_silence\",\n" +
                                "    \"silence_3p\": \"" + packid + "" + nameinput +"/" + nameinput +"_silence_3p\",\n" +
                                "    \"put_away\": \"" + packid + "" + nameinput +"/" + nameinput +"_put_away\",\n" +
                                "    \"melee_push\": \"" + packid + "melee_stock/melee_stock_02\",\n" +
                                "    \"melee_stock\": \"" + packid + "melee_stock/melee_stock_03\"\n" +
                                "  },\n" +
                                "  \"offhand_show\": {\n" +
                                "    \"pos\": [-2, 20, 4],\n" +
                                "    \"rotate\": [0, 0, 45],\n" +
                                "    \"scale\": [0.5, 0.5, 0.5]\n" +
                                "  },\n" +
                                "  \"hotbar_show\": {\n" +
                                "    \"0\": {\n" +
                                "      \"pos\": [-4, 26, 3],\n" +
                                "      \"rotate\": [-90, -5, -90],\n" +
                                "      \"scale\": [0.5, 0.5, 0.5]\n" +
                                "    }\n" +
                                "  }\n" +
                                "}");
                        Files.createFile(Path.of(directory + "\\recipes\\gun\\" + nameinput + ".json"));
                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }

        }


    }

}
