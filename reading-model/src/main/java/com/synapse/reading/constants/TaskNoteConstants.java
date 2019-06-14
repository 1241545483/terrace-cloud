package com.synapse.reading.constants;

/**
 * <p>
 * TaskNoteConstants
 * </p>
 *
 * @author liuguangfu
 * @since 2019-06-13
 */
public interface  TaskNoteConstants  {

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
