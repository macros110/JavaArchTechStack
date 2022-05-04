package com.macrodream.noifelse;

/**
 * @author Macros.Zhang
 * @date 5/4/2022 11:46
 * 处理工具类
 */
public class HandleUtils {
    /**
     * 如果参数为true抛出异常信息
     * @param b
     * @return
     */
    public static ThrowExceptionFunction isTrue(boolean b) {
        return errorMessage -> {
            if (b) {
                throw new RuntimeException(errorMessage);
            }
        };
    }

    /**
     * 参数为true或false时，分别进行不同操作
     * @param b
     * @return
     */
    public static BranchHandler isTrueOrFalse(boolean b) {
        return (trueHandle, falseHandle) -> {
            if (b) {
                trueHandle.run();
            } else {
                falseHandle.run();
            }
        };
    }

    /**
     * 参数为空和不空，分别进行不同操作
     * @param str
     * @return
     */
    public static PresentOrElseHandler<?> isBlankOrNoBlank(String str) {
        return (consumer, runnable) -> {
            if (str == null || str.length() == 0) {
                runnable.run();
            }else {
                consumer.accept(str);
            }
        };
    }
}
