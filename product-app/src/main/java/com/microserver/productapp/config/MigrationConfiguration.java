package com.microserver.productapp.config;



import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("product-app")
public class MigrationConfiguration {
    private boolean migration;

    public boolean getMigration() {
        return migration;
    }

    public void setMigration(boolean migration) {
        this.migration = migration;
    }
}
