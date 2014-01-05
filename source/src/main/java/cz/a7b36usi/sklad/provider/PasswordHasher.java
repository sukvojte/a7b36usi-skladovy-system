/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.a7b36usi.sklad.provider;

import java.security.MessageDigest;
import org.springframework.stereotype.Component;

/**
 *
 * @author Pedro
 */
@Component
public class PasswordHasher implements IHashProvider{

    private static String convertToHex(byte[] data) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < data.length; i++) {
            int halfbyte = (data[i] >>> 4) & 0x0F;
            int two_halfs = 0;
            do {
                if ((0 <= halfbyte) && (halfbyte <= 9)) {
                    builder.append((char) ('0' + halfbyte));
                } else {
                    builder.append((char) ('a' + (halfbyte - 10)));
                }
                halfbyte = data[i] & 0x0F;
            } while (two_halfs++ < 1);
        }
        return builder.toString();
    }

    public String computeHash(String password, String salt) {
        MessageDigest md = null;
        String salted = password + ":salt:" + salt;
        byte[] sha1hash = null;
        try {
            md = MessageDigest.getInstance("SHA-1");

            sha1hash = new byte[40];
            md.update(salted.getBytes("utf8"), 0, salted.length());
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
        sha1hash = md.digest();
        return convertToHex(sha1hash);
    }
}
