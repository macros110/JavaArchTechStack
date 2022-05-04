package com.macrodream.noifelse;

/**
 * @author Macros.Zhang
 * @date 5/4/2022 11:51
 * 处理分支接口
 */
@FunctionalInterface
public interface BranchHandler {
    /**
     * 分支操作
     * @param trueHandle 为true时要进行的操作
     * @param falseHandle 为false是要进行的操作
     */
    void trueOrFalseHandle(Runnable trueHandle, Runnable falseHandle);
}
