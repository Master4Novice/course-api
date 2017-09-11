package io.abhi.data;

import java.util.List;

public class StatusResponse {
	String status;
	String msg;
	List<DoctorRecord> list;
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public List<DoctorRecord> getList() {
		return list;
	}
	public void setList(List<DoctorRecord> list) {
		this.list = list;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}  
	

	

}
