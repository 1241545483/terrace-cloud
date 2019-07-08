package com.synapse.reading.constants.constants;

/**
 * <p>
 * UserRoleConstants
 * </p>
 *
 * @author liuguangfu
 * @since 2019-05-30
 */
public interface  UserRoleConstants  {

    /**
     * 角色
     */
    enum ROLE {
        STUDENT("student", "0"), TEACHER("teacher", "1"), SCHOOL("school", "2");

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

}
