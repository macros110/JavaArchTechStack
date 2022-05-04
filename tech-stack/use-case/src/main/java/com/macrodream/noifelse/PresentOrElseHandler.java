package com.macrodream.noifelse;

import java.util.function.Consumer;

/**
 * @author Macros.Zhang
 * @date 5/4/2022 12:17
 * 空值与非空值分支处理
 */
public interface PresentOrElseHandler <T extends Object>{
    /**
     *
     * @param action  值不为空时，执行的消费操作
     * @param emptyAction 值为空时，执行的操作
     */
    void presentOrElseHandle(Consumer<? super T> action, Runnable emptyAction);
}
