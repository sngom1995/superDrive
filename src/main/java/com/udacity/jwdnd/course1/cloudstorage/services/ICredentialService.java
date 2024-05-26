package com.udacity.jwdnd.course1.cloudstorage.services;

import com.udacity.jwdnd.course1.cloudstorage.domain.Credential;

import java.util.List;

public interface ICredentialService {
    void saveCredential(Credential credential);
    List<Credential> getAllCredentialByUserId(Integer userId);
    Credential getCredentialById(Integer credentialId);
    void deleteCredentialById(Integer credentialId);
    String decryptPassword(String password,String key);
    void updateCredential(Credential credential);
}
