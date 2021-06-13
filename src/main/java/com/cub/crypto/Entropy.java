package com.cub.crypto;

import org.apache.commons.codec.digest.DigestUtils;

import java.security.SecureRandom;

public class Entropy {

    SecureRandom secureRandom = new SecureRandom();

    public static void main(String[] args) {

        Entropy entropy = new Entropy();

        for(int i=0; i<1000000; i++) {
            System.out.println(entropy.generateSha256Hash());
        }

    }

    public String generateSha256Hash() {

        byte[] bytes = new byte[16];
        secureRandom.nextBytes(bytes);

        return DigestUtils.sha256Hex(bytes);

    }

}
