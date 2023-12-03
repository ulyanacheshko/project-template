package edu.hw2.task4;

public record CallingInfo(String className, String methodName) {
    public static CallingInfo callingInfo() {
        Throwable throwable = new Throwable();
        StackTraceElement element = throwable.getStackTrace()[1];
        String className = element.getClassName();
        String methodName = element.getMethodName();
        return new CallingInfo(className, methodName);
    }
}
