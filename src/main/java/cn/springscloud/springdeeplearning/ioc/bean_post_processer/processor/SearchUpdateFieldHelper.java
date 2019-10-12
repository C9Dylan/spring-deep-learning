package cn.springscloud.springdeeplearning.ioc.bean_post_processer.processor;

import cn.springscloud.springdeeplearning.ioc.bean_post_processer.processor.annotation.CheckUpdate;
import cn.springscloud.springdeeplearning.ioc.bean_post_processer.processor.annotation.IgnoreCheck;
import com.google.common.collect.Maps;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Field;
import java.util.Map;
import org.apache.commons.lang3.ArrayUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Kim QQ.Cong on 2019-09-02 / 14:31:52
 *
 * @author: CongQingquan
 * @Description: 搜集修改字段组件
 */
class SearchUpdateFieldHelper implements BeanHelper {

    private static Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Override
    public Map<String, Object[]> searchDifferentFieldValue(Object sourceObj, Object updateObj) {
        if (null == sourceObj || null == updateObj) {
            return null;
        }
        Map<String, Object[]> resultMap = Maps.newHashMap();
        // init source data
        // 1) 获取更新对象的Class对象
        Class<?> updateObjClass = updateObj.getClass();
        // 2) 获取源对象的所有字段
        Field[] sourceObjDeclaredFields = sourceObj.getClass().getDeclaredFields();
        // 3) 是否标记了全局检查注解
        boolean checkAll = sourceObj.getClass().getDeclaredAnnotation(CheckUpdate.class) != null;
        // 1. 迭代搜寻不同值字段
        for (int i = 0; i < sourceObjDeclaredFields.length; i++) {
            // 1.1 获取源对象本次迭代的Field对象
            Field sourceObjDeclaredField = sourceObjDeclaredFields[i];
            sourceObjDeclaredField.setAccessible(Boolean.TRUE);
            // 1.2 如果字段没有标记检查更新注解, 且类上也没有添加检查更新注解, 则结束本次迭代
            if (null == sourceObjDeclaredField.getDeclaredAnnotation(CheckUpdate.class)
                && !checkAll) {
                continue;
            }
            // 1.3 如果字段标记了忽略检查注解则结束本次迭代
            if (null != sourceObjDeclaredField.getDeclaredAnnotation(IgnoreCheck.class)) {
                continue;
            }
            // 1.4 获取更新对象上的同名同类型字段
            Field updateObjDeclaredField = getSameField(sourceObjDeclaredField.getName(),
                sourceObjDeclaredField.getType(), updateObjClass);
            // 1.5 如果没有相同字段则结束本次迭代
            if (null == updateObjDeclaredField) {
                continue;
            }
            updateObjDeclaredField.setAccessible(Boolean.TRUE);
            // 1.6 分别获取源对象/更新对象上的本次迭代字段的值
            Object sourceObjDeclaredFieldVal = null;
            Object updateObjDeclaredFieldVal = null;
            try {
                sourceObjDeclaredFieldVal = sourceObjDeclaredField.get(sourceObj);
                updateObjDeclaredFieldVal = updateObjDeclaredField.get(updateObj);
            } catch (IllegalAccessException e) {
                logger.info("search update field error, exit method after return null");
                return null;
            }
            // 1.7 equals
            if (!sourceObjDeclaredFieldVal.equals(updateObjDeclaredFieldVal)) {
                // 1.7.1 equals不同则存储结果集中, 格式: fieldName: [oldVal, newVal]
                resultMap.put(sourceObjDeclaredField.getName(),
                    new Object[]{sourceObjDeclaredFieldVal, updateObjDeclaredFieldVal});
            }
        }
        return resultMap;
    }

    /**
     * 获取源类上的同名同类型Field实例
     */
    private Field getSameField(String fieldName, Class<?> typeClass, Class<?> searchClass) {
        Field searchField;
        try {
            searchField = searchClass.getDeclaredField(fieldName);
            if (!searchField.getType().getName().equals(typeClass.getName())) {
                return null;
            }
        } catch (NoSuchFieldException | SecurityException e) {
            return null;
        }
        return searchField;
    }

    /**
     * 将JavaBean实体内的字段组装成Key/Value结构
     */
    @Override
    public Map<String, Object> properties2Map(Object bean) {
        if (null == bean) {
            return null;
        }
        // 获取bean的所有字段
        Field[] declaredFields = bean.getClass().getDeclaredFields();
        if (ArrayUtils.isEmpty(declaredFields)) {
            return null;
        }
        // 结果集
        Map<String, Object> resultMap = Maps.newHashMapWithExpectedSize(declaredFields.length);
        for (int i = 0; i < declaredFields.length; i++) {
            // 获取本次迭代的字段
            Field field = declaredFields[i];
            // 暴力访问
            field.setAccessible(true);
            // 装载到结果集中
            try {
                resultMap.put(field.getName(), field.get(bean));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return resultMap;
    }
}
