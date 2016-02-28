package action;

import dao.D3DAO;
import dto.D3DTO;

public class D3Action {
	private int d3test;
	private int test1;
	private int test2;
	private int test3;
	public String execute(){
		String result = "success";
		D3DAO dao = new D3DAO();
		D3DTO dto = new D3DTO();
		dao.selectToD3(d3test,dto);
		test1 = dto.getTest1();
		test2 = dto.getTest2();
		test3 = dto.getTest3();
		return result;
	}
	public int getD3test() {
		return d3test;
	}
	public void setD3test(int d3test) {
		this.d3test = d3test;
	}
	public int getTest1() {
		return test1;
	}
	public void setTest1(int test1) {
		this.test1 = test1;
	}
	public int getTest2() {
		return test2;
	}
	public void setTest2(int test2) {
		this.test2 = test2;
	}
	public int getTest3() {
		return test3;
	}
	public void setTest3(int test3) {
		this.test3 = test3;
	}
}
