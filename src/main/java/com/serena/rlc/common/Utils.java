package com.serena.rlc.common;
import org.apache.commons.codec.binary.Base64;
import org.json.JSONObject;

import java.io.File;
import java.net.URL;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

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

    public String readFile(String path) throws IOException {
        String content = new String(Files.readAllBytes(Paths.get(path)));
        return content;
    }
}

