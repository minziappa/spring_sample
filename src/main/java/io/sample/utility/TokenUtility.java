package io.sample.utility;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class TokenUtility {

	public static String generateTokenSha256(
			String value) {

        try {
            byte id[] = value.getBytes();
            long current = System.currentTimeMillis();

            byte now[] = (new Long(current)).toString().getBytes();
            MessageDigest md = MessageDigest.getInstance("SHA-256");

            md.update(now);
            md.update(id);

            return toHex(md.digest());
        } catch (NoSuchAlgorithmException e){
            return null;
        }
    }

	public static String generateToken(String value) {

        try {
            byte id[] = value.getBytes();
            long current = System.currentTimeMillis();

            byte now[] = (new Long(current)).toString().getBytes();
            MessageDigest md = MessageDigest.getInstance("MD5");
            
            md.update(now);
            md.update(id);

            return toHex(md.digest());
        } catch (NoSuchAlgorithmException e){
            return null;
        }
    }

    private static String toHex(byte buffer[]) {

    	StringBuilder sb = new StringBuilder(buffer.length * 2);

    	for (int i = 0; i < buffer.length; i++) {
            sb.append(Character.forDigit((buffer[i] & 240) >> 4, 16));
            sb.append(Character.forDigit(buffer[i] & 15, 16));
        }

        return sb.toString();
    }

}
