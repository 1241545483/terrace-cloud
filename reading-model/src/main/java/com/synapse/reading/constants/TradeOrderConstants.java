package com.synapse.reading.constants;

/**
 * <p>
 * TradeOrderConstants
 * </p>
 *
 * @author liuguangfu
 * @since 2019-04-10
 */
public interface  TradeOrderConstants  {

    /**
     * 状态
     */
    enum STATUS {
        DELETED("deleted", "0"), OK("ok", "1"), UNPAID("unpaid", "2");

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
     * 订单类型
     */
    enum ORDERTYPE {
            BOOK("book", "1"),  LESSON("lesson", "2"),  VIP("vip", "3");

        public final String code;
        public final String num;

        ORDERTYPE(String code, String num) {
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
