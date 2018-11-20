package com.synapse.reading.constants;

/**
 * Created by wangyifan on 2017/8/28.
 */
public interface UserConstants {

    enum FLAG {
        // 4为协同者
        ADMIN(0, "系统管理员"), CREATOR(1, "创建者"), NOT_CREATOR(2, "非创建者"), ANONYMOUS(3, "匿名用户"),
        COLLABORATOR(4, "协同者"), SCHOOL_MANAGER(5, "学校管理员"), AREA_MANAGER(6, "区管理员"),
        PROJECT_MANAGER(7, "组长"), TEACHER(8, "学员"), APPLIER(9, "已报名学员"),EXPERT(10,"专家");

        private final int flag;
        private final String desc;

        FLAG(int flag, String desc) {
            this.flag = flag;
            this.desc = desc;
        }

        public int value() {
            return flag;
        }

        public String desc() {
            return desc;
        }
    }

    enum ROLE {
        ADMIN("admin", "0"), CREATOR("creator", "1"), NOT_CREATOR("not_creator", "2"), ANONYMOUS("anonymous", "3"),
        COLLABORATOR("operator", "4"), SCHOOL_MANAGER("school_manager", "5"), AREA_MANAGER("area_manager", "6"),
        PROJECT_MANAGER("manager", "7"), TEACHER("teacher", "8"), APPLIER("applier", "9"),EXPERT("expert","10");

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

        public static String nameOf(String code) {
            if (null == code) {
                return "";
            }
            switch (code.toLowerCase()) {
                case "admin":
                    return ADMIN.num;
                case "creator":
                    return CREATOR.num;
                case "not_creator":
                    return NOT_CREATOR.num;
                case "anonymous":
                    return ANONYMOUS.num;
                case "operator":
                    return COLLABORATOR.num;
                case "school_manager":
                    return SCHOOL_MANAGER.num;
                case "area_manager":
                    return AREA_MANAGER.num;
                case "manager":
                    return PROJECT_MANAGER.num;
                case "teacher":
                    return TEACHER.num;
                case "applier":
                    return APPLIER.num;
                case "expert":
                    return EXPERT.num;
                default:
                    return "";
            }
        }
    }
}
