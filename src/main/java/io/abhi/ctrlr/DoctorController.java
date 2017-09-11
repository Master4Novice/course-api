package io.abhi.ctrlr;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.abhi.data.DoctorRecord;
import io.abhi.data.StatusResponse;

@RestController
public class DoctorController {

	private static final String URL_CROSS = "*";

	List<DoctorRecord> doctorList=null;
	
	StatusResponse res=null;
	
	public DoctorController(){
		doctorList=new ArrayList<DoctorRecord>();
		DoctorRecord doctorRecord1=new DoctorRecord();
		doctorRecord1.setId("1");
		doctorRecord1.setName("ravi");
		doctorRecord1.setFatherName("fname");
		doctorRecord1.setAddress("address");
		doctorRecord1.setContactNo("1234567893");
		doctorRecord1.setEmail("eamil@gmai.com");
		doctorRecord1.setQualification("qualification");
		doctorRecord1.setSpecialization("specification");
		doctorRecord1.setGender("M");
		doctorRecord1.setBloodGroup("O+");
		doctorRecord1.setDoj("12-23-2017");
		doctorList.add(doctorRecord1);
		DoctorRecord doctorRecord2=new DoctorRecord();
		doctorRecord2.setId("2");
		doctorRecord2.setName("raj");
		doctorRecord2.setFatherName("fname");
		doctorRecord2.setAddress("address");
		doctorRecord2.setContactNo("1234567893");
		doctorRecord2.setEmail("eamil@gmai.com");
		doctorRecord2.setQualification("qualification");
		doctorRecord2.setSpecialization("specification");
		doctorRecord2.setGender("M");
		doctorRecord2.setBloodGroup("O+");
		doctorRecord2.setDoj("12-23-2017");
		doctorList.add(doctorRecord2);
		DoctorRecord doctorRecord3=new DoctorRecord();
		doctorRecord3.setId("3");
		doctorRecord3.setName("raj");
		doctorRecord3.setFatherName("fname");
		doctorRecord3.setAddress("address");
		doctorRecord3.setContactNo("1234567893");
		doctorRecord3.setEmail("eamil@gmai.com");
		doctorRecord3.setQualification("qualification");
		doctorRecord3.setSpecialization("specification");
		doctorRecord3.setGender("M");
		doctorRecord3.setBloodGroup("O+");
		doctorRecord3.setDoj("12-23-2017");
		doctorList.add(doctorRecord3);
	}


	@CrossOrigin(origins=URL_CROSS)
	@RequestMapping(value={"/test"}, produces = MediaType.APPLICATION_JSON_VALUE)
	public DoctorRecord test(){
		DoctorRecord doctorRecord=new DoctorRecord();
		doctorRecord.setId("123");
		doctorRecord.setName("name");
		doctorRecord.setFatherName("");
		doctorRecord.setAddress("address");
		doctorRecord.setContactNo("1234567893");
		doctorRecord.setEmail("eamil@gmai.com");
		doctorRecord.setQualification("qualification");
		doctorRecord.setSpecialization("specification");
		doctorRecord.setGender("M");
		doctorRecord.setBloodGroup("O+");
		doctorRecord.setDoj("12-23-2017");
		System.out.println("called to the test API :");
		return doctorRecord;

	}
	
	@CrossOrigin(origins=URL_CROSS)
	@RequestMapping(value={"/save"}	,method= RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
	public StatusResponse saveDoctorRecord(@RequestBody DoctorRecord doctorRecord){
		res=new StatusResponse();
		boolean saved=true;
		try{
			ObjectMapper obj=new ObjectMapper();
			String str=obj.writeValueAsString(doctorRecord);
			System.out.println("doctor record :\n"+str);

			for(DoctorRecord doc:doctorList){
				if(doc.getId().equalsIgnoreCase(doctorRecord.getId())){
					saved=false;
				}
			}
			if(saved){
				doctorList.add(doctorRecord);
				res.setStatus("success");
				res.setMsg("saved");
				res.setList(doctorList);

			}
			else{
				res.setStatus("failure");
				res.setMsg("not_saved");
				res.setList(doctorList);
			}
		}
		catch(Exception e){
			System.out.println("exception "+e);
		}
		return res;
	}
	
	@CrossOrigin(origins=URL_CROSS)
	@RequestMapping(value={"/delete"},produces = MediaType.APPLICATION_JSON_VALUE)
	public StatusResponse deleteRecord(@RequestParam("id") String id){
		List<DoctorRecord> templist=new ArrayList();
		boolean found=false;
		res=new StatusResponse();
		System.out.println("data deleted for :"+id);
		for(DoctorRecord doc:doctorList){

			if(doc.getId().equalsIgnoreCase(id)){
				found=true;
				continue;
			}
			templist.add(doc);
		}
		doctorList.clear();
		doctorList=new ArrayList(templist);
		templist.clear();
		if(found){
			res.setStatus("success");
			res.setMsg("deleted");
			res.setList(doctorList);
			return res;
		}

		res.setStatus("failure");
		res.setMsg("not_deleted");
		res.setList(doctorList);
		return res;
	}
	
	@CrossOrigin(origins=URL_CROSS)
	@RequestMapping(value={"/getdata"}, produces = MediaType.APPLICATION_JSON_VALUE)
	public StatusResponse getData(){
		res=new StatusResponse();
		res.setList(doctorList);
		res.setStatus("success");
		res.setMsg("retrieved");
		return res;
	}
	
	@CrossOrigin(origins=URL_CROSS)
	@RequestMapping(value={"/update"},produces = MediaType.APPLICATION_JSON_VALUE)
	public StatusResponse updateData(@RequestBody DoctorRecord doctorRecord){
		res=new StatusResponse();
		boolean updated=false;
		List<DoctorRecord> tempDocList=new ArrayList<>();
		for(DoctorRecord doc: doctorList){

			if(doc.getId().equalsIgnoreCase(doctorRecord.getId())){
				tempDocList.add(doctorRecord);
				updated=true;
				continue;
			}
			tempDocList.add(doc);
		}
		if(updated){
			doctorList.clear();
			doctorList=new ArrayList(tempDocList);
			tempDocList.clear();
			res.setList(doctorList);
			res.setMsg("updated");
			res.setStatus("success");
			return res;
		}
		res.setList(doctorList);
		res.setMsg("not_updated");
		res.setStatus("failure");
		return res;
	}
}

