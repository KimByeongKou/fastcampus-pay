package com.fastcampuspay.membership.adapter.out.vault;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.vault.core.VaultKeyValueOperations;
import org.springframework.vault.core.VaultKeyValueOperationsSupport;
import org.springframework.vault.core.VaultTemplate;

@Component
public class VaultAdapter {
    private final AESProvider encryptionProvider;

    @Autowired
    public VaultAdapter(VaultTemplate vaultTemplate) throws Exception {
        // vault path: kv-v1/encrypt/data/dbkey
        // key: QgOklUDRhvNfCex0/BIIsQ==
        VaultKeyValueOperations ops = vaultTemplate.opsForKeyValue("kv-v1/data/encrypt", VaultKeyValueOperationsSupport.KeyValueBackend.KV_2);
        String key = (String) ops.get("dbkey").getData().get("key");
        encryptionProvider = new AESProvider(key);
    }

    public String encryptData (String plainText) {
         try {
              return encryptionProvider.encrypt(plainText);
         } catch (Exception e) {
              throw new RuntimeException(e);
         }
    }

    public String decryptData (String encryptedText) {
         try {
              return encryptionProvider.decrypt(encryptedText);
         } catch (Exception e) {
              throw new RuntimeException(e);
         }
    }
}
