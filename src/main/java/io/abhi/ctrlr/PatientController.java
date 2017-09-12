package io.abhi.ctrlr;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.abhi.data.Patient;

@RestController
public class PatientController {
	
	List<Patient> patientList = new ArrayList<Patient>();
	private static final String URL_CROSS = "*";
	
	PatientController(){
                    Patient patient = new Patient();
                    patient.setPatientId(11);
                    patient.setName("kjasd");
                    patient.setAddress("INSIDA");
                    patient.setAge("23");
                    patient.setContactNo("324243");
                   
                   
                    Patient patient1 = new Patient();
                    patient1.setPatientId(22);
                    patient1.setName("BGH");
                    patient1.setAddress("UA");
                    patient1.setAge("98");
                    patient1.setContactNo("909090");
                    patientList.add(patient);
                    patientList.add(patient1);
                   
    }
   
   
    //Map to store employees, ideally we should use database
   
/*           public static final String GET_ALL_PATIENT = "/rest/getallpatients";
    public static final String SAVE_PATIENT = "/rest/savepatient";
    public static final String DELETE_PATIENT = "/rest/deletepatient}";
    public static final String UPDATE_PATIENT = "/rest/updatepatient";
*/
   
	@CrossOrigin(origins=URL_CROSS)
	@GetMapping("/rest/getallpatients")
    public List<Patient> getAllWards() {
    	System.out.println("Start get All Patient");
                   
                   
   
                   
                    System.out.println("emp list="+patientList);
                    return patientList;
    }
   
    /*@RequestMapping(value = EmpRestURIConstants.GET_EMP, method = RequestMethod.GET)
    public @ResponseBody Employee getEmployee(@PathVariable("id") int empId) {
                    logger.info("Start getEmployee. ID="+empId);
                   
                    return empData.get(empId);
    }*/
   
    /*@RequestMapping(value = EmpRestURIConstants.GET_ALL_EMP, method = RequestMethod.GET)
    public @ResponseBody List<Employee> getAllEmployees() {
                    logger.info("Start getAllEmployees.");
                    List<Employee> emps = new ArrayList<Employee>();
                    Set<Integer> empIdKeys = empData.keySet();
                    for(Integer i : empIdKeys){
                                    emps.add(empData.get(i));
                    }
                    return emps;
    }
*/   
	@CrossOrigin(origins=URL_CROSS)
    @RequestMapping(value = "/rest/savepatient", method = RequestMethod.POST)
    public List<Patient> saveWard(@RequestBody Patient patient) {
    	            System.out.println("Save Patient.");
                    /*System.out.println(ward.getWardName()+""+ ward.getWardType()+""+ward.getNoOfBeds()+""+ward.getChargesPerBed());
                    ward.setWardName("Sun");
                    ward.setWardType("General");*/
                    patientList.add(patient);
                    System.out.println("patient save is :"+ patient.getName() + patient.getFatherName() + patient.getContactNo());
                    return patientList;
    }
   
	@CrossOrigin(origins=URL_CROSS)
    @RequestMapping(value = "/rest/updatepatient", method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Patient> updateWard(@RequestBody Patient tempPatient) {
    	            System.out.println("Update patient.");
                    boolean update=false;
                    List<Patient> tempPatientList=new ArrayList<Patient>();
                    for(Patient patient:patientList){
                                    if(tempPatient.getPatientId()==patient.getPatientId()){
                                                    update=true;
                                                    tempPatientList.add(tempPatient);
                                                    continue;
                                                   
                                    }
                                    tempPatientList.add(patient);
                                   
                    }
                   
                   
                    patientList.clear();
                    patientList=new ArrayList<Patient>(tempPatientList);
                    tempPatientList.clear();
                   
                    return patientList;
    }
   
	@CrossOrigin(origins=URL_CROSS)
    @RequestMapping(value = "/rest/deletepatient",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Patient> deleteWard(@RequestParam("Id") int Id) {
    	            System.out.println("Delete patient.");
                    boolean delete=false;
                    List<Patient> tempPatientList=new ArrayList<Patient>();
                    for(Patient patient:patientList){
                                    if(Id==patient.getPatientId()){
                                                    delete=true;
                                                    continue;
                                                   
                                    }
                                    tempPatientList.add(patient);
                                   
                    }
                   
                    patientList.clear();
                    patientList=new ArrayList<Patient>(tempPatientList);
                    tempPatientList.clear();
                    return patientList;
    }
}
