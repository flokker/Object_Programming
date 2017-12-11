package Operation;

/**
 * define using data like some of structure(like Programming language C) class
 * <br>
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
	 * <br>
	 * 
	 * @param CustLock - this value means CustLock variable
	 * @param CustId - this value means CustId variable
	 * @param CustName - this value means CustName variable
	 * @param CustNum - this value means CustNum variable
	 * @param CustPeriod - this value means CustPeriod variable
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
	 * @return CustLock - return CustLock value
	 */
	public String getCustLock() {
		return CustLock;
	}
	
	/**
	 *  Method of Store CustLock value
	 * @param CustLock - this is value about CustLock 
	 */
	public void setCustLock(String CustLock) {
		this.CustLock = CustLock;
	}

	/**
	 * Method of return CustId value
	 * @return - return CustId value
	 */
	
	public String getCustId() {
		return CustId;
	}

	/**
	 * Method of Store CustId variable
	 * @param CustId - this is value about CustId
	 */
	public void setCustId(String CustId) {
		this.CustId = CustId;
	}

	/**
	 * Method of return CustName value 
	 * @return - return CustName value
	 */
	public String getCustName() {
		return CustName;
	}
	
/**
 * Method of Store CustName value
 * @param CustName - this is value about CustName
 */
	public void setCustName(String CustName) {
		this.CustName = CustName;
	}

	/**
	 * Method of return CustNum value
	 * @return - return CustNum value
	 */
	public String getCustNum() {
		return CustNum;
	}

/**
 * Method of Store CustNum value
 * @param CustNum - this is value about CustNum
 */
	public void setCustNum(String CustNum) {
		this.CustNum = CustNum;
	}

	/**
	 * Method of return CustPeriod value
	 * @return - return CustPeriod value
	 */
	public String getCustPeriod() {
		return CustPeriod;
	}

	/**
	 * Method of Store CustPeriod value
	 * @param CustPeriod - this is value about CustPeriod
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
