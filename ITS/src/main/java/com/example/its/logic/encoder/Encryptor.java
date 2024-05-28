package com.example.its.logic.encoder;

public interface Encryptor {
    public String encode(String rawPassword);
    public boolean matches(String rawPassword, String encryptedPassword);
}
