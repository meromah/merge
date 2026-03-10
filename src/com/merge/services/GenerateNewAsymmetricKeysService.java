package com.merge.services;

import java.security.SecureRandom;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.KeyPair;

public class GenerateNewAsymmetricKeysService {
    public KeyPair generate() {
        try {
            KeyPairGenerator generatorInstance = KeyPairGenerator.getInstance("RSA");
            SecureRandom secureRandom = new SecureRandom();
            generatorInstance.initialize(4096, secureRandom);
            KeyPair keys = generatorInstance.genKeyPair();
            return keys;
        }
        catch (NoSuchAlgorithmException exception) {
            throw new RuntimeException("RSA encryption type no longer supported or something went wrong.");
        }
    }
}
