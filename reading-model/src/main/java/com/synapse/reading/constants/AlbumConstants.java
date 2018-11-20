package com.synapse.reading.constants;

/**
 * <p>
 * AlbumConstants
 * </p>
 *
 * @author wangyifan
 * @since 2018-11-20
 */
public interface  AlbumConstants  {

    /**
     * 状态
     */
    enum STATUS {
        DELETED("deleted", "0"), OK("ok", "1");

        public final String code;
        public final String num;

        STATUS(String code, String num) {
            this.code = code;
            this.num = num;
        }

        public String value() {
            return code;
        }

        public String num() {
            return num;
        }
    }
}
