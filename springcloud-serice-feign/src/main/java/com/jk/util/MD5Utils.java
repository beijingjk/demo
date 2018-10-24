package com.jk.util;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
/*
 * @Description 散列算法 生成数据的摘要信息，是一种不可逆的算法，一般适合存储密码之类的数据，
 * @Author Madr
 * @Date 2018/3/24 13:28
 */
public class MD5Utils {
    //干扰数据 盐 防破解
    private static final String SALT = "mar%#$@";
    //散列算法类型为MD5
    private static final String ALGORITH_NAME = "md5";
    //hash的次数
    private static final int HASH_ITERATIONS = 2;

    public static String encrypt(String pswd) {
        String newPassword = new SimpleHash(ALGORITH_NAME, pswd, ByteSource.Util.bytes(SALT),HASH_ITERATIONS).toHex();
        return newPassword;
    }
    public static void main(String[] args) {
        System.out.println("加密后String"+MD5Utils.encrypt("123"));
    }

}
