package com.quanbio.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;

public class MyMD5Util {
    private static final String HEX_NUMS_STR = "0123456789ABCDEF";
    private static final Integer SALT_LENGTH = 12;

    //Converts a hexadecimal character to a byte array
    public static byte[] hexStringToByte(String hex) {
        int len = (hex.length() / 2);
        byte[] result = new byte[len];
        char[] hexChars = hex.toCharArray();
        for (int i = 0; i < len; i++) {
            int pos = i * 2;
            result[i] = (byte) (HEX_NUMS_STR.indexOf(hexChars[pos]) << 4 | HEX_NUMS_STR
                    .indexOf(hexChars[pos + 1]));
        }
        return result;
    }


    //Converts the specified byte array to a hexadecimal string
    public static String byteToHexString(byte[] b) {
        StringBuffer hexString = new StringBuffer();
        for (int i = 0; i < b.length; i++) {
            String hex = Integer.toHexString(b[i] & 0xFF);
            if (hex.length() == 1) {
                hex = '0' + hex;
            }
            hexString.append(hex.toUpperCase());
        }
        return hexString.toString();
    }

    //Verify that the password is valid
    public static boolean validPassword(String password, String passwordInDb)
            throws NoSuchAlgorithmException, UnsupportedEncodingException {
        // Converts a hexadecimal string format password to a byte array
        byte[] pwdInDb = hexStringToByte(passwordInDb);
        // Declare the salt variable
        byte[] salt = new byte[SALT_LENGTH];
        // Extract the salt from the password byte array stored in the database
        System.arraycopy(pwdInDb, 0, salt, 0, SALT_LENGTH);
        // Create a message digest object
        MessageDigest md = MessageDigest.getInstance("MD5");
        // Pass the salt data into the message digest object
        md.update(salt);
        // Pass the password data to the message digest object
        md.update(password.getBytes("UTF-8"));
        // Generates a message digest for the input password
        byte[] digest = md.digest();
        // 声明一个保存数据库中口令消息摘要的变量
        byte[] digestInDb = new byte[pwdInDb.length - SALT_LENGTH];
        // 取得数据库中口令的消息摘要
        System.arraycopy(pwdInDb, SALT_LENGTH, digestInDb, 0, digestInDb.length);
        // 比较根据输入口令生成的消息摘要和数据库中消息摘要是否相同
        if (Arrays.equals(digest, digestInDb)) {
            // 口令正确返回口令匹配消息
            return true;
        } else {
            // 口令不正确返回口令不匹配消息
            return false;
        }
    }

    //获得加密后的口令
    public static String getEncryptedPwd(String password)
            throws NoSuchAlgorithmException, UnsupportedEncodingException {
        // 声明加密后的口令数组变量
        byte[] pwd = null;
        // 随机数生成器
        SecureRandom random = new SecureRandom();
        // 声明盐数组变量
        byte[] salt = new byte[SALT_LENGTH];
        // 将随机数放入盐变量中
        random.nextBytes(salt);

        // 声明消息摘要对象
        MessageDigest md = null;
        // 创建消息摘要
        md = MessageDigest.getInstance("MD5");
        // 将盐数据传入消息摘要对象
        md.update(salt);
        // 将口令的数据传给消息摘要对象
        md.update(password.getBytes("UTF-8"));
        // 获得消息摘要的字节数组
        byte[] digest = md.digest();

        // 因为要在口令的字节数组中存放盐，所以加上盐的字节长度
        pwd = new byte[digest.length + SALT_LENGTH];
        // 将盐的字节拷贝到生成的加密口令字节数组的前12个字节，以便在验证口令时取出盐
        System.arraycopy(salt, 0, pwd, 0, SALT_LENGTH);
        // 将消息摘要拷贝到加密口令字节数组从第13个字节开始的字节
        System.arraycopy(digest, 0, pwd, SALT_LENGTH, digest.length);
        // 将字节数组格式加密后的口令转化为16进制字符串格式的口令
        return byteToHexString(pwd);
    }


}