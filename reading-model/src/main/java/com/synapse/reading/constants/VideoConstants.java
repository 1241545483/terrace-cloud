package com.synapse.reading.constants;

/**
 * <p>
 * VideoConstants
 * </p>
 *
 * @author wangyifan
 * @since 2018-11-24
 */
public interface VideoConstants {

    enum BelongToType {
        SECTION("section"), LESSON("lesson");

        public final String code;

        BelongToType(String code) {
            this.code = code;
        }

        public String value() {
            return code;
        }
    }
}
