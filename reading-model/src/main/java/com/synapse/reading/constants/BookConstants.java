package com.synapse.reading.constants;

/**
 * <p>
 * BookConstants
 * </p>
 *
 * @author liuguangfu
 * @since 2018-12-27
 */
public interface  BookConstants  {

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
