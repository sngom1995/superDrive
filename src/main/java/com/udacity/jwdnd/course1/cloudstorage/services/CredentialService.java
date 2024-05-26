package com.udacity.jwdnd.course1.cloudstorage.services;

import com.udacity.jwdnd.course1.cloudstorage.domain.Credential;
import com.udacity.jwdnd.course1.cloudstorage.mapper.CredentialMapper;
import org.springframework.stereotype.Service;


import java.security.SecureRandom;
import java.util.Base64;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CredentialService implements ICredentialService {
    private final CredentialMapper credentialMapper;
    private final EncryptionService encryptionService;

    public CredentialService(CredentialMapper credentialMapper, EncryptionService encryptionService) {
        this.credentialMapper = credentialMapper;
        this.encryptionService = encryptionService;
    }

    @Override
    public void saveCredential(Credential credential) {
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);
        String key = Base64.getEncoder().encodeToString(salt);
        String encryptedPassword = encryptionService.encryptValue(credential.getPassword(), key);
        credential.setKey(key);
        credential.setPassword(encryptedPassword);
        credentialMapper.insertCredential(credential);
    }

    @Override
    public List<Credential> getAllCredentialByUserId(Integer userId) {
        return credentialMapper.findCredentialsByUserId(userId).stream().map(credential -> {
            credential.setPassword(encryptionService.decryptValue(credential.getPassword(), credential.getKey()));
            return credential;
        }).collect(Collectors.toList());
    }

    @Override
    public Credential getCredentialById(Integer credentialId) {
        return credentialMapper.findCredentialById(credentialId);
    }

    @Override
    public void deleteCredentialById(Integer credentialId) {
        credentialMapper.deleteCredential(credentialId);
    }

    @Override
    public String decryptPassword(String password, String key) {
        return encryptionService.decryptValue(password, key);
    }

    @Override
    public void updateCredential(Credential credential) {
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);
        String key = Base64.getEncoder().encodeToString(salt);
        String encryptedPassword = encryptionService.encryptValue(credential.getPassword(), key);
        credential.setKey(key);
        credential.setPassword(encryptedPassword);
        System.out.println("cred:"+credential);
        credentialMapper.updateCredential(credential);
    }
}
