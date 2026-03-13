package com.merge.model;

import com.merge.model.User;
import java.util.Properties;
import java.security.PrivateKey;
import com.merge.customenum.ProfilePropertyEnum;

public class Profile extends User {
    private PrivateKey privateKey;
    private String signature;

    public Profile(String name, String bio, Properties config) {
        super(name, bio, config);
    }

    public void save() {
        super.config.setProperty(ProfilePropertyEnum.NAME.toString(), super.name);
        super.config.setProperty(ProfilePropertyEnum.BIO.toString(), super.bio);
    }
}
