package io.github.thefive40.back_tienda.service;

import io.github.thefive40.back_tienda.model.dto.UserDTO;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

@Service
@Getter
@Setter
public class EncryptDataService {

    public void encrypt ( UserDTO user ) {
        try {
            KeyGenerator keyGen = KeyGenerator.getInstance ( "AES" );
            keyGen.init ( 128 );
            SecretKey secretKey = keyGen.generateKey ( );
            byte[] iv = new byte[16];
            SecureRandom random = new SecureRandom ( );
            random.nextBytes ( iv );
            IvParameterSpec ivSpec = new IvParameterSpec ( iv );
            Cipher cipher = Cipher.getInstance ( "AES/CBC/PKCS5PADDING" );
            cipher.init ( Cipher.ENCRYPT_MODE, secretKey, ivSpec );
            byte[] encryptedPassword = cipher.doFinal ( user.getPassword ( ).getBytes ( ) );
            user.setPassword ( Base64.getEncoder ( ).encodeToString ( encryptedPassword ) );
            user.setSecretKey ( Base64.getEncoder ( ).encodeToString ( secretKey.getEncoded ( ) ) );
            user.setInitVector ( Base64.getEncoder ( ).encodeToString ( iv ) );
        } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | IllegalBlockSizeException |
                 BadPaddingException | InvalidAlgorithmParameterException e) {
            throw new RuntimeException ( e );
        }
    }

    public String decrypt ( String encryptedText, String secretKey, String initVector ) throws Exception {
        byte[] encryptedBytes = Base64.getDecoder ( ).decode ( encryptedText );
        SecretKeySpec keySpec = new SecretKeySpec ( Base64.getDecoder ( ).decode ( secretKey ), "AES" );
        IvParameterSpec ivSpec = new IvParameterSpec ( Base64.getDecoder ( ).decode ( initVector ) );
        Cipher cipher = Cipher.getInstance ( "AES/CBC/PKCS5PADDING" );
        cipher.init ( Cipher.DECRYPT_MODE, keySpec, ivSpec );
        byte[] originalBytes = cipher.doFinal ( encryptedBytes );
        return new String ( originalBytes );
    }
}
