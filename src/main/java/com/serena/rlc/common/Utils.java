package com.serena.rlc.common;
import org.apache.commons.codec.binary.Base64;
import org.json.JSONObject;

import java.io.File;
import java.net.URL;

/**
 * Created by akolomakin on 27.01.2017.
 */
public class Utils {
    public String base64Encode(String encode) {
        byte[] encodedBytes = Base64.encodeBase64(encode.getBytes());
        return new String(encodedBytes);
    }

    public String base64Decode(String decode){
        byte[] decodedBytes = Base64.decodeBase64(decode);
        return new String(decodedBytes);
    }
}

