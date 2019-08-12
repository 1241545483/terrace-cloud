package com.synapse.reading.constants;

public class CommonConstants {

    public static final String anonymousId = "-999";
    public static final String anonymousName = "智性阅读";
    public static final String anonymousPassword = "reading";
    public static final String anonymousRole = "ROLE_ANONYMOUS";
    public static final String anonymousToken = "ANON_TOKEN";

    public static final int SERVER_ERROR = 500;
    public static final int BAD_REQUEST = 400;
    public static final int UNAUTHORIZED_ERROR = 401;
    public static final int DEFAULT_CURRENTPAGE = 1;
    //绑定错误
    public static final int BIND_ERROR = 610;
    //未输入密码
    public static final int BIND_NOPASSWORD = 405;
    //密码错误
    public static final int BIND_WRONG_PASSWORD = 612;
    //绑定成功
    public static final int BIND_SUCCESS = 200;


    public static final int DEFAULT_PAGESIZE = 10;

    public static final String DEFAULT_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
    public static final String YEAR_FORMAT = "yyyy";
    public static final int STATUS_OK = 1;

    public static final int STATUS_NOT_OK = 0;


    //
    // 分割符定义
    //
    public final static String SEP_COMBINE_KEY = "_";
    public final static String SEP_SEMICOLON = ";";
    public final static String SEP_COMMA = ",";
    public final static String SEP_PAUSE = "、";
    public final static String SEP_COMMA_ZH = "，";
    public final static String SEP_POINT = ".";
    public final static String SEP_LINE = "-";
    public final static String SEP_LEFT_SLASH = "/";
    public final static String SEP_RIGHT_SLASH = "\\";
    public final static String SEP_COLON = ":";
    public final static String SEP_AND = "&";
    public final static String SEP_LINE_VERTICAL = "|";
    public final static String SEP_EQUAL = "=";
    public final static String SEP_Q_MARK = "?";

    /**
     * websocket指令
     */
    public static final String REG = "REG";//客户端注册
    public static final String PING = "PING";//心跳
    public static final String JOIN = "JOIN";//环节参与
    public static final String PAGE = "PAGE";//PPT翻页
}
