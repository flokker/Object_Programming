package Operation;

/**
 * define using data & some of structure(like Programming language C) class
 * history : June hyuk, 1.0 2017.10.14 initiate version
 * @author June hyuk
 * @since 2017-10-14 
 * @version 1.1 - 2017.11.08 add CustLock variable 
 */
public class data_set {

	private String CustLock; 
	private String CustId; 
	private String CustName; 
	private String CustNum; 
	private String CustPeriod; 

	/**
	 * this class has 5param of data what we use in this program
	 * CustLock means Locker's number
	 * CustId means user's Student ID
	 * CustName means user's name
	 * CustNum means user's phone number
	 * CustPeriod means user's Period of use
	 * 
	 * <br>
	 * @param String CustLock
	 * @param String CustId
	 * @param String CustName
	 * @param String CustNum
	 * @param String CustPeriod
	 * @author june hyeock
	 */
	public data_set(String CustLock, String CustId, String CustName, String CustNum, String CustPeriod) {		// data set about id,name,num,peroid
	
		super();
		this.CustLock = CustLock;
		this.CustId = CustId;
		this.CustName = CustName;
		this.CustNum = CustNum;
		this.CustPeriod = CustPeriod;
	}
	/**
	 * 
	 * Method of return CustLock variable
	 * 
	 * @param void
	 * @return CustLock
	 */
	public String getCustLock() {
		return CustLock;
	}
	
	/**
	 * Method of Store CustLock variable
	 * @param String CustLock
	 */
	public void setCustLock(String CustLock) {
		this.CustLock = CustLock;
	}

	/**
	 * Method of return CustId variable
	 * @return CustId
	 * @param void
	 */
	
	public String getCustId() {
		return CustId;
	}
/**
 * Method of Store CustId variable
 * @param String CustId
 */
	public void setCustId(String CustId) {
		this.CustId = CustId;
	}
/**
 * Method of return CustName variable 
 * @return CustName
 * @param void
 */
	public String getCustName() {
		return CustName;
	}
/**
 * Method of Store CustName variable
 * @param String CustName
 */
	public void setCustName(String CustName) {
		this.CustName = CustName;
	}

/**
 * Method of return CustNum variable
 * @return CustNum
 * @param void
 */
	public String getCustNum() {
		return CustNum;
	}

/**
 * Method of Store CustNum variable
 * @param String CustNum
 * 
 */
	public void setCustNum(String CustNum) {
		this.CustNum = CustNum;
	}
/**
 * Method of return CustPeriod variable
 * @return CustPeriod
 * @param void
 */
	public String getCustPeriod() {
		return CustPeriod;
	}
/**
 * Method of Store CustPeriod variable
 * @param String CustPeriod
 */
	public void setCustPeriod(String CustPeriod) {
		this.CustPeriod = CustPeriod;
	}


	/*public String toString() {  // override
		StringBuffer sb = new StringBuffer();

		sb.append("ID : " + CustLock);
		sb.append("ID : " + CustId);
		sb.append("ID : " + CustName);
		sb.append("ID : " + CustNum);
		sb.append("ID : " + CustPeriod);

		return sb.toString();
	}*/
}
