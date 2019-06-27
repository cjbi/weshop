package tech.wetech.weshop.common.utils;

import java.beans.Introspector;
import java.lang.invoke.SerializedLambda;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;
import java.util.regex.Pattern;


/**
 * 反射工具类
 *
 * @author cjbi@outlook.com
 */
public class Reflections {
    private static final Pattern GET_PATTERN = Pattern.compile("^get[A-Z].*");
    private static final Pattern IS_PATTERN = Pattern.compile("^is[A-Z].*");

    private Reflections() {
    }

    /**
     * @param fn 静态方法引用  枚举名::要展示的中文字段
     * @return
     */
    public static <A extends Enum<A>, B> List<Map<String, String>> getSelectByEnum(Fn<A, B> fn, String name, String value) {
        List<Map<String, String>> list = new ArrayList();
        Arrays.asList(Reflections.fnToClass(fn).getEnumConstants()).forEach(e -> {
            Map<String, String> map = new HashMap<>(2);
            map.put(name, Reflections.fnToFieldValue(fn, e));
            map.put(value, e.toString());
            list.add(map);
        });
        return list;
    }

    /**
     * @param fn 静态方法引用  枚举名::要展示的中文字段
     * @return
     */
    public static <A extends Enum<A>, B> Map<String, String> toEnumMap(Fn<A, B> fn) {
        Map<String, String> map = new HashMap<>(16);
        for (Object enumConstant : Reflections.fnToClass(fn).getEnumConstants()) {
            map.put(enumConstant.toString(), Reflections.fnToFieldValue(fn, enumConstant));
        }
        return map;
    }

    public static <A, B> String[] fnToFieldName(Fn<A, B>... fns) {
        String[] arr = new String[fns.length];
        for (int i = 0; i < fns.length; i++) {
            arr[i] = fnToFieldName(fns[i]);
        }
        return arr;
    }

    public static <A, B> String fnToFieldName(Fn<A, B> fn) {
        try {
            SerializedLambda serializedLambda = getSerializedLambda(fn);
            String getter = serializedLambda.getImplMethodName();
            if (GET_PATTERN.matcher(getter).matches()) {
                getter = getter.substring(3);
            } else if (IS_PATTERN.matcher(getter).matches()) {
                getter = getter.substring(2);
            }
            return Introspector.decapitalize(getter);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static SerializedLambda getSerializedLambda(Fn fn) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = fn.getClass().getDeclaredMethod("writeReplace");
        method.setAccessible(Boolean.TRUE);
        return (SerializedLambda) method.invoke(fn);
    }

    public static String fnToFieldValue(Fn fn, Object object) {
        try {
            SerializedLambda serializedLambda = getSerializedLambda(fn);
            String getter = serializedLambda.getImplMethodName();
            Method method = object.getClass().getMethod(getter);
            return (String) method.invoke(object);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Class fnToClass(Fn fn) {
        try {
            SerializedLambda serializedLambda = getSerializedLambda(fn);
            String implClass = serializedLambda.getImplClass();
            return Class.forName(implClass.replace("/", "."));
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

}
