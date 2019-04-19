package com.synapse.reading.constants;

/**
 * <p>
 * MemberConstants
 * </p>
 *
 * @author liuguangfu
 * @since 2018-12-06
 */
public interface  MemberConstants  {

    /**
     * 验证登录是否包含该字段
     */
    enum LOGIN_CODE {
        SUCCESS_CODE("success_code", "1000"), FAIL_CODE("fail_code", "1001");

        public final String code;
        public final String num;

        LOGIN_CODE(String code, String num) {
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

    /**
     * 状态
     */
    enum ROLE {
        TEACHER("teacher", "1"), STUDENT("student", "2");

        public final String code;
        public final String num;

        ROLE(String code, String num) {
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

    /**
     * 状态
     */
    enum REGWAY {
        READING_IMPORT("READING_IMPORT", "1"), READING("READING", "2");

        public final String code;
        public final String num;

        REGWAY(String code, String num) {
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



    /**
     * 组织
     */
    enum ORG {
        DEFAULT("default", "-999");

        public final String code;
        public final String num;

        ORG(String code, String num) {
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
