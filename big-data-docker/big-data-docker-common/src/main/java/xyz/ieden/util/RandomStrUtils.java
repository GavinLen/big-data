package xyz.ieden.util;

import java.util.UUID;

/**
 *
 * @author Gavin
 * @date 2018.04.15
 */
public class RandomStrUtils {

    /**
     * 获取整理后的 uuid
     * 去除 UUID 中的 "-"
     *
     * @return
     */
    public static String getStrByTrimUid() {
        String uid = getStrByUid();
        return uid.replaceAll("-", "");
    }

    /**
     * 通过 uid 获取 String
     *
     * @return
     */
    public static String getStrByUid() {
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }

}
