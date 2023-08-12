package com.bams22.test.spring.data.jdbc.aop;

import com.bams22.test.spring.data.jdbc.model.PersistableBaseEntity;
import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;
import lombok.SneakyThrows;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Optional;

@Aspect
@Component
public class RepositoryAspect {

    @AfterReturning(
            pointcut = "execution(public * org.springframework.data.repository.*.*(..))",
            returning = "result"
    )
    public void afterSave(@Nullable Object result) {
        if (result == null || Optional.empty().equals(result)) {
            return;
        }

        if (result instanceof PersistableBaseEntity persistableBaseEntity) {
            setIsNew(persistableBaseEntity);
        }

        if (result instanceof Optional<?> optional &&
                optional.isPresent() &&
                optional.get() instanceof PersistableBaseEntity persistableBaseEntity) {
            setIsNew(persistableBaseEntity);
        }

        if (result instanceof Collection<?> collection &&
                !collection.isEmpty() &&
                collection.iterator().next() instanceof PersistableBaseEntity persistableBaseEntity) {
            collection.stream()
                    .map(o -> (PersistableBaseEntity) o)
                    .forEach(this::setIsNew);
            setIsNew(persistableBaseEntity);
        }
    }

    @SneakyThrows
    private void setIsNew(@Nonnull PersistableBaseEntity persistableBaseEntity) {
        final var setNewMethod = PersistableBaseEntity.class.getDeclaredMethod(
                "setNew", boolean.class);
        setNewMethod.setAccessible(true); //NOSONAR
        setNewMethod.invoke(persistableBaseEntity, false);
    }
}
