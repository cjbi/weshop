package tech.wetech.weshop.config;

import feign.MethodMetadata;
import feign.Util;
import org.springframework.cloud.openfeign.AnnotatedParameterProcessor;
import org.springframework.cloud.openfeign.support.SpringMvcContract;
import org.springframework.core.convert.ConversionService;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

class HierarchicalContract extends SpringMvcContract {


    public HierarchicalContract() {
        super();
    }

    public HierarchicalContract(List<AnnotatedParameterProcessor> annotatedParameterProcessors) {
        super(annotatedParameterProcessors);
    }

    public HierarchicalContract(List<AnnotatedParameterProcessor> annotatedParameterProcessors, ConversionService conversionService) {
        super(annotatedParameterProcessors, conversionService);
    }

    @Override
    public List<MethodMetadata> parseAndValidatateMetadata(Class<?> targetType) {
        Util.checkState(targetType.getTypeParameters().length == 0, "Parameterized types unsupported: %s", new Object[]{targetType.getSimpleName()});
//        Util.checkState(targetType.getInterfaces().length <= 1, "Only single inheritance supported: %s", new Object[]{targetType.getSimpleName()});
//        if (targetType.getInterfaces().length == 1) {
//            Util.checkState(targetType.getInterfaces()[0].getInterfaces().length == 0, "Only single-level inheritance supported: %s", new Object[]{targetType.getSimpleName()});
//        }

        Map<String, MethodMetadata> result = new LinkedHashMap();
        Method[] var3 = targetType.getMethods();
        int var4 = var3.length;

        for(int var5 = 0; var5 < var4; ++var5) {
            Method method = var3[var5];
            if (method.getDeclaringClass() != Object.class && (method.getModifiers() & 8) == 0 && !Util.isDefault(method)) {
                MethodMetadata metadata = this.parseAndValidateMetadata(targetType, method);
                Util.checkState(!result.containsKey(metadata.configKey()), "Overrides unsupported: %s", new Object[]{metadata.configKey()});
                result.put(metadata.configKey(), metadata);
            }
        }

        return new ArrayList(result.values());
    }
}

