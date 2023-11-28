package study.spring.mybatis_spring.exception;

public class ExceptionUtil {

	public static void throwException() throws Exception {
		throw new Exception("Exception 고의발생");
	}

	public static void throwRuntimeException() {
		throw new RuntimeException("RuntimeException 고의발생");
	}

}
