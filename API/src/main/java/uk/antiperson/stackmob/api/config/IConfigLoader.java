package uk.antiperson.stackmob.api.config;

import org.bukkit.configuration.file.FileConfiguration;

import java.io.File;

public interface IConfigLoader {
    boolean check(String config, String toCheck);

    void reloadCustomConfig();

    FileConfiguration getCustomConfig();

    File getF();

    void generateNewVersion();

    void copyDefault();

    boolean updateConfig();
}
