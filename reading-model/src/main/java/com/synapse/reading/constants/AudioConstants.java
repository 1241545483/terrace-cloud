package com.synapse.reading.constants;

/**
 * <p>
 * AudioConstants
 * </p>
 *
 * @author wangyifan
 * @since 2018-11-24
 */
public interface  AudioConstants  {

    enum BelongToType {
        ALBUM("album");

        public final String code;

        BelongToType(String code) {
            this.code = code;
        }

        public String value() {
            return code;
        }
    }

}
