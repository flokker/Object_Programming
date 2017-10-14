package object_project;

public class data_set { //excel에 넣어야할 데이터들의 뭉치를 정의한 일종의 structure class

	private String CustId; // 학번
	private String CustName; // 이름
	private String CustNum; // 핸드폰 번호
	private String CustPeriod; // 사용기한

	// data set about id,name,num,peroid
	public data_set(String CustId, String CustName, String CustNum, String CustPeriod) {
		super();
		this.CustId = CustId;
		this.CustName = CustName;
		this.CustNum = CustNum;
		this.CustPeriod = CustPeriod;
	}

	public String getCustId() {
		return CustId;
	}

	public void setCustId(String CustId) {
		this.CustId = CustId;
	}

	public String getCustName() {
		return CustName;
	}

	public void setCustName(String CustName) {
		this.CustName = CustName;
	}

	public String getCustNum() {
		return CustNum;
	}

	public void setCustNum(String CustNum) {
		this.CustNum = CustNum;
	}

	public String getCustPeriod() {
		return CustPeriod;
	}

	public void setCustPeriod(String CustPeriod) {
		this.CustPeriod = CustPeriod;
	}

	// override
	public String toString() {
		StringBuffer sb = new StringBuffer();

		sb.append("ID : " + CustId);
		sb.append("ID : " + CustName);
		sb.append("ID : " + CustNum);
		sb.append("ID : " + CustPeriod);

		return sb.toString();
	}
}
