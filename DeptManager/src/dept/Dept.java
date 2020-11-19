package dept;

// VO : 데이터를 저장하는 기능만 가지는 클래스 , read only
// DTO : 데이터를 저장하는 기능만 가지는 클래스 , write도 가능 
public class Dept {
	private int deptno;
	private String dname;
	private String loc;
	
	
	public Dept(int deptno, String dname, String loc) {
		this.deptno = deptno;
		this.dname = dname;
		this.loc = loc;
	}

	public int getDeptno() {
		return deptno;
	}

	public String getDname() {
		return dname;
	}

	public String getLoc() {
		return loc;
	}

	
	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public void setLoc(String loc) {
		this.loc = loc;
	}

	@Override
	public String toString() {
		return "Dept [deptno=" + deptno + ", dname=" + dname + ", loc=" + loc + "]";
	}


	
	
}
