package Operation;

/**
 * 사용할 데이터를 선언하고,이에 대한 일종의 구조체를 작성한 클래스
 * history : June hyuk, 1.0 2017.10.14 초기 작성
 * @author June hyuk
 * @since 2017-10-14 
 * @version 1.1 - 2017.11.08 CustLock변수 추가 
 */
public class data_set {

	private String CustLock; 
	private String CustId; 
	private String CustName; 
	private String CustNum; 
	private String CustPeriod; 

	// data set about id,name,num,peroid
	public data_set(String CustLock, String CustId, String CustName, String CustNum, String CustPeriod) {		
		/**
		 * 데이터들의 구조체
		 * 
		 */		
		super();
		this.CustLock = CustLock;
		this.CustId = CustId;
		this.CustName = CustName;
		this.CustNum = CustNum;
		this.CustPeriod = CustPeriod;
	}
	/**
	 * CustLock을 반환하는 메소드
	 * @return CustLock
	 */
	public String getCustLock() {
		return CustLock;
	}
	
	/**
	 * CustLock을 담는 메소드
	 * @param String CustLock
	 */
	public void setCustLock(String CustLock) {
		this.CustLock = CustLock;
	}

	/**
	 * CustId를 반환하는 메소드
	 * @return CustId
	 */
	
	public String getCustId() {
		return CustId;
	}
/**
 * CustId를 담는 메소드
 * @param String CustId
 */
	public void setCustId(String CustId) {
		this.CustId = CustId;
	}
/**
 * CustName을 반환하는 메소드
 * @return CustName
 */
	public String getCustName() {
		return CustName;
	}
/**
 * CustName을 담는 메소드
 * @param String CustName
 */
	public void setCustName(String CustName) {
		this.CustName = CustName;
	}

/**
 * CustNum을 반환하는 메소드
 * @return CustNum
 */
	public String getCustNum() {
		return CustNum;
	}

/**
 * CustNum을 담는 메소드
 * @param String CustNum
 */
	public void setCustNum(String CustNum) {
		this.CustNum = CustNum;
	}
/**
 * CustPeriod를 반환하는 메소드
 * @return CustPeriod
 */
	public String getCustPeriod() {
		return CustPeriod;
	}
/**
 * CustPeriod를 담는 메소드
 * @param String CustPeriod
 */
	public void setCustPeriod(String CustPeriod) {
		this.CustPeriod = CustPeriod;
	}


	public String toString() {  // override
		StringBuffer sb = new StringBuffer();

		sb.append("ID : " + CustLock);
		sb.append("ID : " + CustId);
		sb.append("ID : " + CustName);
		sb.append("ID : " + CustNum);
		sb.append("ID : " + CustPeriod);

		return sb.toString();
	}
}
