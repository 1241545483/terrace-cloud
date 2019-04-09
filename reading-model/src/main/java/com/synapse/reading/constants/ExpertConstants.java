package com.synapse.reading.constants;

/**
 * <p>
 * ExpertConstants
 * </p>
 *
 * @author liuguangfu
 * @since 2019-04-09
 */
public interface  ExpertConstants  {

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
