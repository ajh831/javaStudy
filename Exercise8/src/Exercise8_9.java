public class Exercise8_9 
{
	public static void main(String[] args) throws Exception 
	{
		throw new UnsupportedFunctionException("지원하지 않는 기능입니다.", 100);
	}
}

class UnsupportedFunctionException extends RuntimeException {
	final private int ERR_CODE;
	
	UnsupportedFunctionException() {
		this("지원하지 않는 기능입니다.", 100);
	}

	UnsupportedFunctionException(String str) {
		this(str, 100);
	}

	UnsupportedFunctionException(String str, int error) {
		super(str);
		this.ERR_CODE = error;
	}


	
	public int getErrorCode() {
		return this.ERR_CODE;
	}
	
	// Exception클래스의 getMessage()를 오버라이딩
	public String getMessage() {
		
		return "[" + getErrorCode() + "]" + super.getMessage();
	}
}
