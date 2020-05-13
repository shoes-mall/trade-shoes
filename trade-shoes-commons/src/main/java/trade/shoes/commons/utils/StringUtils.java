package trade.shoes.commons.utils;
import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @version V1.0
 * @Description:
 * @author:dustine
 * @date 2017/10/20 下午6:27
 */
@SuppressWarnings("all")
public class StringUtils extends org.apache.commons.lang3.StringUtils {
    private static final Log LOG = LogFactory.getLog(StringUtils.class);

    private static final char SEPARATOR = '_';
    private static final String CHARSET_NAME = "UTF-8";

    public StringUtils() {
    }

    public static byte[] getBytes(String str) {
        if (str != null) {
            try {
                return str.getBytes("UTF-8");
            } catch (UnsupportedEncodingException var2) {
                return null;
            }
        } else {
            return null;
        }
    }

    public static String toString(byte[] bytes) {
        try {
            return new String(bytes, "UTF-8");
        } catch (UnsupportedEncodingException var2) {
            return "";
        }
    }

    public static boolean inString(String str, String... strs) {
        if (str != null) {
            String[] var2 = strs;
            int var3 = strs.length;

            for (int var4 = 0; var4 < var3; ++var4) {
                String s = var2[var4];
                if (str.equals(trim(s))) {
                    return true;
                }
            }
        }

        return false;
    }

    public static String replaceHtml(String html) {
        if (isBlank(html)) {
            return "";
        } else {
            String regEx = "<.+?>";
            Pattern p = Pattern.compile(regEx);
            Matcher m = p.matcher(html);
            String s = m.replaceAll("");
            return s;
        }
    }


    public static String abbr(String str, int length) {
        if (str == null) {
            return "";
        } else {
            try {
                StringBuilder e = new StringBuilder();
                int currentLength = 0;
                char[] var4 = replaceHtml(StringEscapeUtils.unescapeHtml4(str)).toCharArray();
                int var5 = var4.length;

                for (int var6 = 0; var6 < var5; ++var6) {
                    char c = var4[var6];
                    currentLength += String.valueOf(c).getBytes("GBK").length;
                    if (currentLength > length - 3) {
                        e.append("...");
                        break;
                    }

                    e.append(c);
                }

                return e.toString();
            } catch (UnsupportedEncodingException var8) {
                var8.printStackTrace();
                return "";
            }
        }
    }

    public static String toCamelCase(String s) {
        if (s == null) {
            return null;
        } else {
            s = s.toLowerCase();
            StringBuilder sb = new StringBuilder(s.length());
            boolean upperCase = false;

            for (int i = 0; i < s.length(); ++i) {
                char c = s.charAt(i);
                if (c == 95) {
                    upperCase = true;
                } else if (upperCase) {
                    sb.append(Character.toUpperCase(c));
                    upperCase = false;
                } else {
                    sb.append(c);
                }
            }

            return sb.toString();
        }
    }

    public static String toCapitalizeCamelCase(String s) {
        if (s == null) {
            return null;
        } else {
            s = toCamelCase(s);
            return s.substring(0, 1).toUpperCase() + s.substring(1);
        }
    }

    public static String toUnderScoreCase(String s) {
        if (s == null) {
            return null;
        } else {
            StringBuilder sb = new StringBuilder();
            boolean upperCase = false;

            for (int i = 0; i < s.length(); ++i) {
                char c = s.charAt(i);
                boolean nextUpperCase = true;
                if (i < s.length() - 1) {
                    nextUpperCase = Character.isUpperCase(s.charAt(i + 1));
                }

                if (i > 0 && Character.isUpperCase(c)) {
                    if (!upperCase || !nextUpperCase) {
                        sb.append('_');
                    }

                    upperCase = true;
                } else {
                    upperCase = false;
                }

                sb.append(Character.toLowerCase(c));
            }

            return sb.toString();
        }
    }

    /**
     * 函数功能说明 ： 判断字符串是否为空 . 修改者名字： 修改日期： 修改内容：
     *
     * @return boolean
     * @throws
     * @参数： @param str
     * @参数： @return
     */
    public static boolean isEmpty(String str) {
        return null == str || "".equals(str);
    }

    /**
     * 函数功能说明 ： 判断对象数组是否为空. 修改者名字： 修改日期： 修改内容：
     *
     * @return boolean
     * @throws
     * @参数： @param obj
     * @参数： @return
     */
    public static boolean isEmpty(Object[] obj) {
        return null == obj || 0 == obj.length;
    }

    /**
     * 函数功能说明 ： 判断对象是否为空. 修改者名字： 修改日期： 修改内容：
     *
     * @return boolean
     * @throws
     * @参数： @param obj
     * @参数： @return
     */
    public static boolean isEmpty(Object obj) {
        if (null == obj) {
            return true;
        }
        if (obj instanceof String) {
            return ((String) obj).trim().isEmpty();
        }
        return !(obj instanceof Number) ? false : false;
    }

    /**
     * 函数功能说明 ： 判断集合是否为空. 修改者名字： 修改日期： 修改内容：
     *
     * @return boolean
     * @throws
     * @参数： @param obj
     * @参数： @return
     */
    public static boolean isEmpty(List<?> obj) {
        return null == obj || obj.isEmpty();
    }

    /**
     * 函数功能说明 ： 判断Map集合是否为空. 修改者名字： 修改日期： 修改内容：
     *
     * @return boolean
     * @throws
     * @参数： @param obj
     * @参数： @return
     */
    public static boolean isEmpty(Map<?, ?> obj) {
        return null == obj || obj.isEmpty();
    }

    /**
     * 函数功能说明 ： 获得文件名的后缀名. 修改者名字： 修改日期： 修改内容：
     *
     * @return String
     * @throws
     * @参数： @param fileName
     * @参数： @return
     */
    public static String getExt(String fileName) {
        return fileName.substring(fileName.lastIndexOf(".") + 1);
    }

    /**
     * 获取去掉横线的长度为32的UUID串.
     *
     * @return uuid.
     * @author dustine
     */
    public static String get32UUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    /**
     * 获取带横线的长度为36的UUID串.
     *
     * @return uuid.
     * @author dustine
     */
    public static String get36UUID() {
        return UUID.randomUUID().toString();
    }

    /**
     * 验证一个字符串是否完全由纯数字组成的字符串，当字符串为空时也返回false.
     *
     * @param str 要判断的字符串 .
     * @return true or false .
     * @author dustine
     */
    public static boolean isNumeric(String str) {
        if (StringUtils.isEmpty(str)) {
            return false;
        } else {
            return str.matches("\\d*");
        }
    }

    /**
     * 计算采用utf-8编码方式时字符串所占字节数
     *
     * @param content
     * @return
     */
    public static int getByteSize(String content) {
        int size = 0;
        if (null != content) {
            try {
                // 汉字采用utf-8编码时占3个字节
                size = content.getBytes("utf-8").length;
            } catch (UnsupportedEncodingException e) {
                LOG.error(e);
            }
        }
        return size;
    }

    /**
     * 函数功能说明 ： 截取字符串拼接in查询参数. 修改者名字： 修改日期： 修改内容：
     *
     * @return String
     * @throws
     * @参数： @param ids
     * @参数： @return
     */
    public static List<String> getInParam(String param) {
        boolean flag = param.contains(",");
        List<String> list = new ArrayList<String>();
        if (flag) {
            list = Arrays.asList(param.split(","));
        } else {
            list.add(param);
        }
        return list;
    }


    /**
     * 将bigDecimal转换为标准的人民币格式
     *
     * @param bigDecimal
     * @return
     */
    public static String currencyFormat(BigDecimal bigDecimal) {
        NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.CHINA);
        String s = nf.format(bigDecimal);
        return s.substring(1, s.length());//格式化
    }


    /**
     * 宝付统一返回标识
     *
     * @param map
     * @return
     */
    public static boolean bfResultVerify(Map<String, Object> map) {


        if (!StringUtils.isEmpty(map.get("resp_code") + "") && map.get("resp_code").toString().equals("0000")) {
            //处理业务逻辑
            return true;
        } else {
            return false;
        }
    }

    /**
     * 易宝返回统一标识
     *
     * @param map
     * @return
     */
    public static boolean ybResultVerify(Map<String, String> map) {

        if ("".equals(map.get("errorcode"))) {

            return true;
        } else {
            return false;
        }

    }

    //分转元
    public static String per2Yuan(String orderMoney) {

        return fenToYuan(orderMoney);


    }

    public static String fenToYuan(Object o) {
        if (o == null){
            return "0.00";
        }
        String s = o.toString();
        int len = -1;
        StringBuilder sb = new StringBuilder();
        if (s != null && s.trim().length() > 0 && !s.equalsIgnoreCase("null")) {
            s = removeZero(s);
            if (s != null && s.trim().length() > 0 && !s.equalsIgnoreCase("null")) {
                len = s.length();
                int tmp = s.indexOf("-");
                if (tmp >= 0) {
                    if (len == 2) {
                        sb.append("-0.0").append(s.substring(1));
                    } else if (len == 3) {
                        sb.append("-0.").append(s.substring(1));
                    } else {
                        sb.append(s.substring(0, len - 2)).append(".").append(s.substring(len - 2));
                    }
                } else {
                    if (len == 1) {
                        sb.append("0.0").append(s);
                    } else if (len == 2) {
                        sb.append("0.").append(s);
                    } else {
                        sb.append(s.substring(0, len - 2)).append(".").append(s.substring(len - 2));
                    }
                }
            } else {
                sb.append("0.00");
            }
        } else {
            sb.append("0.00");
        }
        return sb.toString();
    }


    public static String removeZero(String str) {
        char ch;
        String result = "";
        if (str != null && str.trim().length() > 0 && !str.trim().equalsIgnoreCase("null")) {
            try {
                for (int i = 0; i < str.length(); i++) {
                    ch = str.charAt(i);
                    if (ch != '0') {
                        result = str.substring(i);
                        break;
                    }
                }
            } catch (Exception e) {
                result = "";
            }
        } else {
            result = "";
        }
        return result;

    }

    /**
     * 将元变为分格式化价格
     *
     * @param orderAmount
     * @return
     */
    public static String formatOrderMoney(BigDecimal orderAmount) {


        //格式化款项
        String orderMoney = "";
        if (!StringUtils.isEmpty(orderAmount)) {
            BigDecimal a;
            a = orderAmount.multiply(BigDecimal.valueOf(100)); //使用分进行提交
            orderMoney = String.valueOf(a.setScale(0));
        } else {
            orderMoney = ("0");
        }
        return orderMoney;
    }


    /**
     * 判断是否含有英文
     *
     * @param str
     * @return
     */
    public static boolean isEnglishChar(String str) {
        Pattern p = Pattern.compile("[a-zA-z]");
        return p.matcher(str).find();

    }


    /**
     * 判断是否是含有中文
     *
     * @param str
     * @return
     */
    public static boolean isChineseChar(String str) {
        boolean temp = false;
        Pattern p = Pattern.compile("[\u4e00-\u9fa5]");
        return p.matcher(str).find();

    }

    public static boolean hasNumeric(String str) {
        boolean flag = false;

        Pattern p = Pattern.compile(".*\\d+.*");

        Matcher m = p.matcher(str);

        if (m.matches()){
            flag = true;
        }

        return flag;

    }


    /**
     * url参数转化成map
     *
     * @param paramStr
     * @return
     */
    public static Map<String, String> paramUrlToMap(String paramStr) {
        String[] params = paramStr.split("&");
        Map<String, String> resMap = new HashMap<>();
        for (int i = 0; i < params.length; i++) {
            String[] param = params[i].split("=");
            if (param.length >= 2) {
                String key = param[0];
                String value = param[1];
                for (int j = 2; j < param.length; j++) {
                    value += "=" + param[j];
                }
                resMap.put(key, value);
            }
        }
        return resMap;
    }


    public static String getChannelResponse(String msg) {

        if (StringUtils.isEmpty(msg)) {

            return "";

        } else {
            try {
                if (msg.length() > 100) {
                    return "需要开发人员排查结果信息";

                } else {

                    return msg;
                }
            } catch (Exception e) {
                return "需要开发人员排查结果信息";
            }
        }

    }

    /**
     * 错误代码分割
     *
     * @param errorCodeMsg
     * @return
     */
    public static String splitErrorMsg(String errorCodeMsg) {
        String[] err = errorCodeMsg.split(":");
        return err[1];
    }


    public static String getTodayWeek() {
        Date date = new Date();
        SimpleDateFormat dateFm = new SimpleDateFormat("E", Locale.CHINA);
        String currSun = dateFm.format(date);
        return currSun;

    }

    /**
     * 转换数据
     * @param str
     * @return
     */
    public static String convertEmpty(String str) {

        if (null == str || "".equals(str)) {

            return "";
        } else {
            return str;
        }

    }

    public static <T, K, V> T map2Bean(Map<K, V> mp, Class<T> beanCls)
            throws Exception, IllegalArgumentException, InvocationTargetException {
        T t = null;
        try {

            BeanInfo beanInfo = Introspector.getBeanInfo(beanCls);
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();

            t = beanCls.newInstance();

            for (PropertyDescriptor property : propertyDescriptors) {
                String key = property.getName();

                if (mp.containsKey(key)) {
                    Object value = mp.get(key);
                    Method setter = property.getWriteMethod();// Java中提供了用来访问某个属性的
                    // getter/setter方法
                    setter.invoke(t, value);
                }
            }

        } catch (IntrospectionException e) {

            e.printStackTrace();
            return  null;
        }
        return t;
    }

    public static boolean isNullOrEmpty(String str) {
        return str == null || str.trim().length() == 0 || "null".equals(str) || "NULL".equals(str) || "undefined".equals(str) || "UNDEFINED".equals(str);
    }

}

