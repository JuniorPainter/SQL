package com.wang_idea.udf.rsa;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

/**
 * @author wang_idea
 * @projectName SQL
 * @className ProduceKey
 * @description 生成秘钥和公钥
 */
public class ProduceKey {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        //获取秘钥对
        KeyPair keyPair= getKeyPair();
        String privateKey = new String(Base64.getEncoder().encode(keyPair.getPrivate().getEncoded()));
        String publicKey = new String(Base64.getEncoder().encode(keyPair.getPublic().getEncoded()));

    }

    private static KeyPair getKeyPair() throws NoSuchAlgorithmException {
        //KeyPairGenerator类用于生成公钥和私钥对，基于RSA算法生成对象
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        //初始化秘钥对生成器，迷药大小为96-1024位
        keyPairGenerator.initialize(1024);
        return keyPairGenerator.generateKeyPair();
    }
}
