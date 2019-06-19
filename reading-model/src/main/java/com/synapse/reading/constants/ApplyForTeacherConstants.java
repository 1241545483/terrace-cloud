package com.synapse.reading.constants;

/**
 * <p>
 * ApplyForTeacherConstants
 * </p>
 *
 * @author liuguangfu
 * @since 2019-06-19
 */
public interface  ApplyForTeacherConstants  {

    /**
     * 状态
     */
    enum STATUS {
        REJECT("reject", "0"), CHECK("check", "1"), UNCHECK("uncheck", "2");

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
