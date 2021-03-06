package com.synapse.reading.constants.auth;

/**
 * <p>
 * OrganizationConstants
 * </p>
 *
 * @author liuguangfu
 * @since 2019-05-28
 */
public interface  OrganizationConstants  {

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
