package io.sample.utility;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckUtility {

	public static boolean checkSpecialSymbol(String param) {

		try {
			String regularExpression = "[^a-zA-Z0-9_]";
			Pattern p = Pattern.compile(regularExpression);
			Matcher m = p.matcher(param);
			if (m.find()) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			return false;
		}

	}

	public static String decodingEucjp(String strEn) throws UnsupportedEncodingException{

		String strDe = null;

		// Exchange decoding
		strDe = URLDecoder.decode (strEn, "8859_1");
		strDe = new String (strEn.getBytes("8859_1"), "EUC-JP");

		return strDe;
	}

	public static String encodingEucjp(String strEn) throws UnsupportedEncodingException{

		String strDe = null;

		// Exchange encoding
		strDe = URLEncoder.encode(strEn, "EUC-JP");

		return strDe;
	}

	public static String encodingUtf(String strEn) throws UnsupportedEncodingException{

		String strDe = null;

		// Exchange encoding
		strDe = URLEncoder.encode(strEn, "UTF-8");

		return strDe;
	}


    public static boolean isNumber(String str){

        boolean result = true;

    	if(str==null) {
        	return false;
        }

        byte[] ori = str.getBytes();
        if(ori==null) {
        	return false;
        }

        for(int i=0; i<ori.length; i++){

            if(ori[i]>0x2F && ori[i] < 0x3A){
            	// If it's number....don't do it
            }else{
            	// If it's string....
            	return false;
            }
        }

        return result;
    }

}
