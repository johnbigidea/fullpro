package com.app.controller;


import java.util.*;
import java.util.stream.Collectors;

import com.app.model.*;
import com.app.service.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private ComplexService complexService;
	@Autowired
	private SimpleService simpleService;
	@Autowired
	private EqualService equalService;
	@Autowired
	private ImagineService imagineService;
	@Autowired
	private LogicService logicService;
	@Autowired
	private QuestionService questionService;
	@Autowired
	private WrongwayService wrongwayService;
	@Autowired
	private ExmapleService exmapleService;


	private static final Logger logger = LogManager.getLogger(EmployeeController.class);

	@PostMapping(value = "/createemployee")
	public ResponseEntity<String> createEmployee(@ModelAttribute Employee employee) {
		logger.info(employee.toString());
		ResponseEntity<String> response = null;
		if (employee != null) {

			employeeService.saveEmployee(employee);
			response = new ResponseEntity<String>("Employee Created successfully", HttpStatus.CREATED);

		} else {
			response = new ResponseEntity<String>("Employee Creation fail try try again", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return response;
	}

	@SuppressWarnings("unchecked")
	@PostMapping(value = "/getallemployees")
	public ResponseEntity<?> getEmployees(@RequestParam Integer pagesize,Integer pageN,String cat,String whichrelation,String doneornot) {
		ResponseEntity<?> response = null;
		logger.info(pagesize);
		List<Employee> employeesList = null;
		logger.info(whichrelation);
		if(whichrelation.equals("word")){

			 employeesList = employeeService.getAllEmployees();

		}else if(whichrelation.equals("equal")){
			 employeesList = equalService.getAllEmployees();
			 logger.info(employeesList.size());
		}else if(whichrelation.equals("question")){
			 employeesList = questionService.getAllEmployees();

		}else if(whichrelation.equals("complex")){
			 employeesList = complexService.getAllEmployees();

		}else if(whichrelation.equals("simple")){
			employeesList = simpleService.getAllEmployees();

		}else if(whichrelation.equals("wrongway")){
			 employeesList = wrongwayService.getAllEmployees();

		}else if(whichrelation.equals("logic")){
			 employeesList = logicService.getAllEmployees();

		}else if(whichrelation.equals("imagine")){
			employeesList = imagineService.getAllEmployees();

		}else if(whichrelation.equals("example")){
			employeesList = exmapleService.getAllEmployees();

		}

		List filterList = employeesList.stream().filter(a -> a.getF9().equals(cat)).sorted(Comparator.comparing(Employee::getEdittime))
				.collect(Collectors.toList());

//		List filterList7 = employeesList.stream().filter(a -> a.getTimes().equals(7))
//				.collect(Collectors.toList());

		List filterList6 = employeesList.stream().filter(a -> a.getF9().equals(cat)).filter(a -> a.getTimes().equals(6))
				.collect(Collectors.toList());

		List filterList5 = employeesList.stream().filter(a -> a.getF9().equals(cat)).filter(a -> a.getTimes().equals(5))
				.collect(Collectors.toList());

		List filterList4 = employeesList.stream().filter(a -> a.getF9().equals(cat)).filter(a -> a.getTimes().equals(4))
				.collect(Collectors.toList());

		List filterList3 = employeesList.stream().filter(a -> a.getF9().equals(cat)).filter(a -> a.getTimes().equals(3))
				.collect(Collectors.toList());

		List filterList2 = employeesList.stream().filter(a -> a.getF9().equals(cat)).filter(a -> a.getTimes().equals(2))
				.collect(Collectors.toList());

		List filterList1 = employeesList.stream().filter(a -> a.getF9().equals(cat)).filter(a -> a.getTimes().equals(1))
				.collect(Collectors.toList());

		List filterList0 = employeesList.stream().filter(a -> a.getF9().equals(cat)).filter(a -> a.getTimes().equals(0))
				.collect(Collectors.toList());

//		Integer ttlength7 = filterList.size();
		Integer ttlength6 = filterList6.size();
		Integer ttlength5 = filterList5.size();
		Integer ttlength4 = filterList4.size();
		Integer ttlength3 = filterList3.size();
		Integer ttlength2 = filterList2.size();
		Integer ttlength1 = filterList1.size();
		Integer ttlength0 = filterList0.size();
		Integer ttremem = ttlength0*7+ttlength1*6+ttlength2*5+ttlength3*4+ttlength4*3+ttlength5*2+ttlength6*1;




		Integer ttlength = filterList.size();
		Integer start = pagesize*pageN;
		Integer end = (pagesize+1)*pageN;
		List newList = null;

		if(doneornot.equals("notdone")){
			if(end<=ttlength){
				newList = filterList.subList(start, end);
			}else{
				newList = filterList.subList(start, ttlength);

			}

		}else{
			newList =employeesList.stream().filter(a -> a.getF9().equals(cat)).filter(a->a.getTimes().equals(0)).sorted(Comparator.comparing(Employee::getEdittime))
					.collect(Collectors.toList());
			ttlength = newList.size();
		}

		if (newList == null || newList.isEmpty()) {
			JSONObject jsonObject = new JSONObject();

			jsonObject.put("status", false);
			jsonObject.put("total", 0);
			jsonObject.put("finish", ttremem);


			response = new ResponseEntity<JSONObject>(jsonObject, HttpStatus.OK);
		} else {
			JSONObject jsonObject = new JSONObject();
			JSONArray array = new JSONArray();
			array.add(newList);
			jsonObject.put("Employee_List", array);
			jsonObject.put("total", ttlength);
			jsonObject.put("finish", ttremem);
			logger.info("aaa");
			response = new ResponseEntity<JSONObject>(jsonObject, HttpStatus.OK);
		}
		return response;
	}

	@GetMapping("/getemployee/{employeeId}")
	public ResponseEntity<?> getEmployeerById(@PathVariable Integer employeeId) {

		ResponseEntity<?> resp = null;
		if (employeeId != null) {
			Employee employee = employeeService.getEmployeeById(employeeId);
			resp = new ResponseEntity<Employee>(employee, HttpStatus.OK);
		} else {
			resp = new ResponseEntity<String>("USER NOT FOUND", HttpStatus.OK);
		}

		return resp;
	}

	@PutMapping("updateemployee")
	public ResponseEntity<String> updateEmployee(@ModelAttribute Employee employee) {
		Integer id = employee.getId();
		boolean exist = employeeService.isExsits(id);
		ResponseEntity<String> resp = null;
		if (exist) {
			employeeService.updateEmployee(employee);
			resp = new ResponseEntity<String>("USER UPDATED SUCESSFULLY", HttpStatus.OK);
		} else {
			resp = new ResponseEntity<String>("USER NOT EXISTS", HttpStatus.BAD_REQUEST);
		}
		return resp;
	}

	@DeleteMapping("/deleteemployee/{employeeId}")
	public ResponseEntity<String> removeUser(@PathVariable Integer employeeId) {


		employeeService.deleteEmployee(employeeId);
		ResponseEntity<String> resp = new ResponseEntity<String>("USER DELETED SUCCESSFULLY", HttpStatus.OK);

		return resp;

	}


	//equal
	@PostMapping(value = "/createequal")
	public ResponseEntity<String> createEqual(@ModelAttribute Employee employee) {


		ResponseEntity<String> response = null;
		if (employee != null) {

			equalService.saveEmployee(employee);
			response = new ResponseEntity<String>("Equal Created successfully", HttpStatus.CREATED);

		} else {
			response = new ResponseEntity<String>("Equal Creation fail try try again", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return response;
	}

	@SuppressWarnings("unchecked")
	@GetMapping(value = "/getallequal")
	public ResponseEntity<?> getEqual() {
		ResponseEntity<?> response = null;
		logger.info("asf");
		List<Employee> employeesList = equalService.getAllEmployees();
		logger.info("bbb");
		if (employeesList == null || employeesList.isEmpty()) {
			response = new ResponseEntity<String>("Equal Data Not FouND", HttpStatus.OK);
		} else {
			JSONObject jsonObject = new JSONObject();
			JSONArray array = new JSONArray();
			array.add(employeesList);
			jsonObject.put("Employee_List", array);
			logger.info("aaa");
			response = new ResponseEntity<JSONObject>(jsonObject, HttpStatus.OK);
		}
		return response;

	}

	@GetMapping("/getequal/{employeeId}")
	public ResponseEntity<?> getEqualById(@PathVariable Integer employeeId) {

		ResponseEntity<?> resp = null;
		if (employeeId != null) {
			Employee employee = equalService.getEmployeeById(employeeId);
			resp = new ResponseEntity<Employee>(employee, HttpStatus.OK);
		} else {
			resp = new ResponseEntity<String>("Equal NOT FOUND", HttpStatus.OK);
		}

		return resp;
	}

	@PutMapping("updateequal")
	public ResponseEntity<String> updateEqual(@ModelAttribute Employee employee) {
		Integer id = employee.getId();
		boolean exist = equalService.isExsits(id);
		ResponseEntity<String> resp = null;
		if (exist) {
			equalService.updateEmployee(employee);
			resp = new ResponseEntity<String>("Equal UPDATED SUCESSFULLY", HttpStatus.OK);
		} else {
			resp = new ResponseEntity<String>("Equal NOT EXISTS", HttpStatus.BAD_REQUEST);
		}
		return resp;
	}

	@DeleteMapping("/deleteequal/{employeeId}")
	public ResponseEntity<String> removeEqual(@PathVariable Integer employeeId) {


		equalService.deleteEmployee(employeeId);
		ResponseEntity<String> resp = new ResponseEntity<String>("equal DELETED SUCCESSFULLY", HttpStatus.OK);

		return resp;

	}


	//complex
	@PostMapping(value = "/createcomplex")
	public ResponseEntity<String> createcomplex(@ModelAttribute Employee employee) {


		ResponseEntity<String> response = null;
		if (employee != null) {

			complexService.saveEmployee(employee);
			response = new ResponseEntity<String>("complex Created successfully", HttpStatus.CREATED);

		} else {
			response = new ResponseEntity<String>("complex Creation fail try try again", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return response;
	}

	@PostMapping(value = "/searchsamecontain")
	public Map<String, List>  searchsamecontain(String name,String tt) {

		ResponseEntity<String> response = null;
		Map<String, List> map = new HashMap<>();

		if (name != null) {

			List<Employee> response1=complexService.findEmployeecontainName(name,tt);

			map.put("tt",response1);


		} else {
			List sd = null;
			map.put("error",sd);


		}
		return map;


	}



		@PostMapping(value = "/searchsamedefine")
	public Map<String, List>  searchsamedefine(String name) {




		ResponseEntity<String> response = null;
		Map<String, List> map = new HashMap<>();

		if (name != null) {

			List<Employee> response1=complexService.findEmployeeByName(name);
			List<Employee> response2=employeeService.findEmployeeByName(name);
			List<Employee> response3=equalService.findEmployeeByName(name);
			List<Employee> response4=exmapleService.findEmployeeByName(name);

			List<Employee> response5=imagineService.findEmployeeByName(name);
			List<Employee> response6=logicService.findEmployeeByName(name);
			List<Employee> response7=questionService.findEmployeeByName(name);
			List<Employee> response8=simpleService.findEmployeeByName(name);
			List<Employee> response9=wrongwayService.findEmployeeByName(name);

			map.put("Complex",response1);
			map.put("Employee",response2);
			map.put("Equal",response3);
			map.put("Example",response4);
			map.put("Imagine",response5);

			map.put("Logic",response6);
			map.put("Question",response7);
			map.put("Simple",response8);
			map.put("Wrongway",response9);


		} else {
			List sd = null;
			map.put("error",sd);


		}
		return map;
	}

	@SuppressWarnings("unchecked")
	@GetMapping(value = "/getallcomplex")
	public ResponseEntity<?> getcomplex() {
		ResponseEntity<?> response = null;
		logger.info("asf");
		List<Employee> employeesList = complexService.getAllEmployees();
		logger.info("bbb");
		if (employeesList == null || employeesList.isEmpty()) {
			response = new ResponseEntity<String>("complex Data Not FouND", HttpStatus.OK);
		} else {
			JSONObject jsonObject = new JSONObject();
			JSONArray array = new JSONArray();
			array.add(employeesList);
			jsonObject.put("Employee_List", array);
			logger.info("aaa");
			response = new ResponseEntity<JSONObject>(jsonObject, HttpStatus.OK);
		}
		return response;

	}

	@GetMapping("/getcomplex/{employeeId}")
	public ResponseEntity<?> getcomplexById(@PathVariable Integer employeeId) {

		ResponseEntity<?> resp = null;
		if (employeeId != null) {
			Employee employee = complexService.getEmployeeById(employeeId);
			resp = new ResponseEntity<Employee>(employee, HttpStatus.OK);
		} else {
			resp = new ResponseEntity<String>("complex NOT FOUND", HttpStatus.OK);
		}

		return resp;
	}

	@PutMapping("updatecomplex")
	public ResponseEntity<String> updatecomplex(@ModelAttribute Employee employee) {
		Integer id = employee.getId();
		boolean exist = complexService.isExsits(id);
		ResponseEntity<String> resp = null;
		if (exist) {
			complexService.updateEmployee(employee);
			resp = new ResponseEntity<String>("complex UPDATED SUCESSFULLY", HttpStatus.OK);
		} else {
			resp = new ResponseEntity<String>("complex NOT EXISTS", HttpStatus.BAD_REQUEST);
		}
		return resp;
	}

	@DeleteMapping("/deletecomplex/{employeeId}")
	public ResponseEntity<String> removecomplex(@PathVariable Integer employeeId) {


		complexService.deleteEmployee(employeeId);
		ResponseEntity<String> resp = new ResponseEntity<String>("complex DELETED SUCCESSFULLY", HttpStatus.OK);

		return resp;


	}


	//simple

	@PostMapping(value = "/createsimple")
	public ResponseEntity<String> createsimple(@ModelAttribute Employee employee) {


		ResponseEntity<String> response = null;
		if (employee != null) {

			simpleService.saveEmployee(employee);
			response = new ResponseEntity<String>("simple Created successfully", HttpStatus.CREATED);

		} else {
			response = new ResponseEntity<String>("simple Creation fail try try again", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return response;
	}

	@SuppressWarnings("unchecked")
	@GetMapping(value = "/getallsimple")
	public ResponseEntity<?> getsimple() {
		ResponseEntity<?> response = null;
		logger.info("asf");
		List<Employee> employeesList = simpleService.getAllEmployees();
		logger.info("bbb");
		if (employeesList == null || employeesList.isEmpty()) {
			response = new ResponseEntity<String>("simple Data Not FouND", HttpStatus.OK);
		} else {
			JSONObject jsonObject = new JSONObject();
			JSONArray array = new JSONArray();
			array.add(employeesList);
			jsonObject.put("Employee_List", array);
			logger.info("aaa");
			response = new ResponseEntity<JSONObject>(jsonObject, HttpStatus.OK);
		}
		return response;

	}

	@GetMapping("/getsimple/{employeeId}")
	public ResponseEntity<?> getsimpleById(@PathVariable Integer employeeId) {

		ResponseEntity<?> resp = null;
		if (employeeId != null) {
			Employee employee = simpleService.getEmployeeById(employeeId);
			resp = new ResponseEntity<Employee>(employee, HttpStatus.OK);
		} else {
			resp = new ResponseEntity<String>("simple NOT FOUND", HttpStatus.OK);
		}

		return resp;
	}

	@PutMapping("updatesimple")
	public ResponseEntity<String> updatesimple(@ModelAttribute Employee employee) {
		Integer id = employee.getId();
		boolean exist = simpleService.isExsits(id);
		ResponseEntity<String> resp = null;
		if (exist) {
			simpleService.updateEmployee(employee);
			resp = new ResponseEntity<String>("simple UPDATED SUCESSFULLY", HttpStatus.OK);
		} else {
			resp = new ResponseEntity<String>("simple NOT EXISTS", HttpStatus.BAD_REQUEST);
		}
		return resp;
	}

	@DeleteMapping("/deletesimple/{employeeId}")
	public ResponseEntity<String> removesimple(@PathVariable Integer employeeId) {


		simpleService.deleteEmployee(employeeId);
		ResponseEntity<String> resp = new ResponseEntity<String>("simple DELETED SUCCESSFULLY", HttpStatus.OK);

		return resp;
	}

	//logic
	@PostMapping(value = "/createlogic")
	public ResponseEntity<String> createlogic(@ModelAttribute Employee employee) {


		ResponseEntity<String> response = null;
		if (employee != null) {

			logicService.saveEmployee(employee);
			response = new ResponseEntity<String>("logic Created successfully", HttpStatus.CREATED);

		} else {
			response = new ResponseEntity<String>("logic Creation fail try try again", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return response;
	}

	@SuppressWarnings("unchecked")
	@GetMapping(value = "/getalllogic")
	public ResponseEntity<?> getlogic() {
		ResponseEntity<?> response = null;
		logger.info("asf");
		List<Employee> employeesList = logicService.getAllEmployees();
		logger.info("bbb");
		if (employeesList == null || employeesList.isEmpty()) {
			response = new ResponseEntity<String>("logic Data Not FouND", HttpStatus.OK);
		} else {
			JSONObject jsonObject = new JSONObject();
			JSONArray array = new JSONArray();
			array.add(employeesList);
			jsonObject.put("Employee_List", array);
			logger.info("aaa");
			response = new ResponseEntity<JSONObject>(jsonObject, HttpStatus.OK);
		}
		return response;

	}

	@GetMapping("/getlogic/{employeeId}")
	public ResponseEntity<?> getlogicById(@PathVariable Integer employeeId) {

		ResponseEntity<?> resp = null;
		if (employeeId != null) {
			Employee employee = logicService.getEmployeeById(employeeId);
			resp = new ResponseEntity<Employee>(employee, HttpStatus.OK);
		} else {
			resp = new ResponseEntity<String>("logic NOT FOUND", HttpStatus.OK);
		}

		return resp;
	}

	@PutMapping("updatelogic")
	public ResponseEntity<String> updatelogic(@ModelAttribute Employee employee) {
		Integer id = employee.getId();
		boolean exist = logicService.isExsits(id);
		ResponseEntity<String> resp = null;
		if (exist) {
			logicService.updateEmployee(employee);
			resp = new ResponseEntity<String>("logic UPDATED SUCESSFULLY", HttpStatus.OK);
		} else {
			resp = new ResponseEntity<String>("logic NOT EXISTS", HttpStatus.BAD_REQUEST);
		}
		return resp;
	}

	@DeleteMapping("/deletelogic/{employeeId}")
	public ResponseEntity<String> removelogic(@PathVariable Integer employeeId) {


		logicService.deleteEmployee(employeeId);
		ResponseEntity<String> resp = new ResponseEntity<String>("logic DELETED SUCCESSFULLY", HttpStatus.OK);

		return resp;
	}

	//question
	@PostMapping(value = "/createquestion")
	public ResponseEntity<String> createquestion(@ModelAttribute Employee employee) {


		ResponseEntity<String> response = null;
		if (employee != null) {

			questionService.saveEmployee(employee);
			response = new ResponseEntity<String>("question Created successfully", HttpStatus.CREATED);

		} else {
			response = new ResponseEntity<String>("question Creation fail try try again", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return response;
	}

	@SuppressWarnings("unchecked")
	@GetMapping(value = "/getallquestion")
	public ResponseEntity<?> getquestion() {
		ResponseEntity<?> response = null;
		logger.info("asf");
		List<Employee> employeesList = questionService.getAllEmployees();
		logger.info("bbb");
		if (employeesList == null || employeesList.isEmpty()) {
			response = new ResponseEntity<String>("question Data Not FouND", HttpStatus.OK);
		} else {
			JSONObject jsonObject = new JSONObject();
			JSONArray array = new JSONArray();
			array.add(employeesList);
			jsonObject.put("Employee_List", array);
			logger.info("aaa");
			response = new ResponseEntity<JSONObject>(jsonObject, HttpStatus.OK);
		}
		return response;

	}

	@GetMapping("/getquestion/{employeeId}")
	public ResponseEntity<?> getquestionById(@PathVariable Integer employeeId) {

		ResponseEntity<?> resp = null;
		if (employeeId != null) {
			Employee employee = questionService.getEmployeeById(employeeId);
			resp = new ResponseEntity<Employee>(employee, HttpStatus.OK);
		} else {
			resp = new ResponseEntity<String>("question NOT FOUND", HttpStatus.OK);
		}

		return resp;
	}

	@PutMapping("updatequestion")
	public ResponseEntity<String> updatequestion(@ModelAttribute Employee employee) {
		Integer id = employee.getId();
		boolean exist = questionService.isExsits(id);
		ResponseEntity<String> resp = null;
		if (exist) {
			questionService.updateEmployee(employee);
			resp = new ResponseEntity<String>("question UPDATED SUCESSFULLY", HttpStatus.OK);
		} else {
			resp = new ResponseEntity<String>("question NOT EXISTS", HttpStatus.BAD_REQUEST);
		}
		return resp;
	}

	@DeleteMapping("/deletequestion/{employeeId}")
	public ResponseEntity<String> removequestion(@PathVariable Integer employeeId) {

		questionService.deleteEmployee(employeeId);
		ResponseEntity<String> resp = new ResponseEntity<String>("question DELETED SUCCESSFULLY", HttpStatus.OK);
		return resp;

	}


	//imagine
	@PostMapping(value = "/createimagine")
	public ResponseEntity<String> createimagine(@ModelAttribute Employee employee) {

		ResponseEntity<String> response = null;
		if (employee != null) {
			imagineService.saveEmployee(employee);
			response = new ResponseEntity<String>("imagine Created successfully", HttpStatus.CREATED);

		} else {
			response = new ResponseEntity<String>("imagine Creation fail try try again", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return response;
	}

	@SuppressWarnings("unchecked")
	@GetMapping(value = "/getallimagine")
	public ResponseEntity<?> getimagine() {
		ResponseEntity<?> response = null;
		logger.info("asf");
		List<Employee> employeesList = imagineService.getAllEmployees();
		logger.info("bbb");
		if (employeesList == null || employeesList.isEmpty()) {
			response = new ResponseEntity<String>("imagine Data Not FouND", HttpStatus.OK);
		} else {
			JSONObject jsonObject = new JSONObject();
			JSONArray array = new JSONArray();
			array.add(employeesList);
			jsonObject.put("Employee_List", array);
			logger.info("aaa");
			response = new ResponseEntity<JSONObject>(jsonObject, HttpStatus.OK);
		}
		return response;

	}

	@GetMapping("/getimagine/{employeeId}")
	public ResponseEntity<?> getimagineById(@PathVariable Integer employeeId) {

		ResponseEntity<?> resp = null;
		if (employeeId != null) {
			Employee employee = imagineService.getEmployeeById(employeeId);
			resp = new ResponseEntity<Employee>(employee, HttpStatus.OK);
		} else {
			resp = new ResponseEntity<String>("imagine NOT FOUND", HttpStatus.OK);
		}

		return resp;
	}

	@PutMapping("updateimagine")
	public ResponseEntity<String> updateimagine(@ModelAttribute Employee employee) {
		Integer id = employee.getId();
		boolean exist = imagineService.isExsits(id);
		ResponseEntity<String> resp = null;
		if (exist) {
			imagineService.updateEmployee(employee);
			resp = new ResponseEntity<String>("imagine UPDATED SUCESSFULLY", HttpStatus.OK);
		} else {
			resp = new ResponseEntity<String>("imagine NOT EXISTS", HttpStatus.BAD_REQUEST);
		}
		return resp;
	}

	@DeleteMapping("/deleteimagine/{employeeId}")
	public ResponseEntity<String> removeimagine(@PathVariable Integer employeeId) {
		imagineService.deleteEmployee(employeeId);
		ResponseEntity<String> resp = new ResponseEntity<String>("imagine DELETED SUCCESSFULLY", HttpStatus.OK);
		return resp;

	}

	//wrongway
	@PostMapping(value = "/createwrongway")
	public ResponseEntity<String> createwrongway(@ModelAttribute Employee employee) {


		ResponseEntity<String> response = null;
		if (employee != null) {

			wrongwayService.saveEmployee(employee);
			response = new ResponseEntity<String>("wrongway Created successfully", HttpStatus.CREATED);

		} else {
			response = new ResponseEntity<String>("wrongway Creation fail try try again", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return response;
	}

	@SuppressWarnings("unchecked")
	@GetMapping(value = "/getallwrongway")
	public ResponseEntity<?> getwrongway() {
		ResponseEntity<?> response = null;
		logger.info("asf");
		List<Employee> employeesList = wrongwayService.getAllEmployees();
		logger.info("bbb");
		if (employeesList == null || employeesList.isEmpty()) {
			response = new ResponseEntity<String>("wrongway Data Not FouND", HttpStatus.OK);
		} else {
			JSONObject jsonObject = new JSONObject();
			JSONArray array = new JSONArray();
			array.add(employeesList);
			jsonObject.put("Employee_List", array);
			logger.info("aaa");
			response = new ResponseEntity<JSONObject>(jsonObject, HttpStatus.OK);
		}
		return response;

	}

	@GetMapping("/getwrongway/{employeeId}")
	public ResponseEntity<?> getwrongwayById(@PathVariable Integer employeeId) {

		ResponseEntity<?> resp = null;
		if (employeeId != null) {
			Employee employee = wrongwayService.getEmployeeById(employeeId);
			resp = new ResponseEntity<Employee>(employee, HttpStatus.OK);
		} else {
			resp = new ResponseEntity<String>("wrongway NOT FOUND", HttpStatus.OK);
		}

		return resp;
	}

	@PutMapping("updatewrongway")
	public ResponseEntity<String> updatewrongway(@ModelAttribute Employee employee) {
		Integer id = employee.getId();
		boolean exist = wrongwayService.isExsits(id);
		ResponseEntity<String> resp = null;
		if (exist) {
			wrongwayService.updateEmployee(employee);
			resp = new ResponseEntity<String>("wrongway UPDATED SUCESSFULLY", HttpStatus.OK);
		} else {
			resp = new ResponseEntity<String>("wrongway NOT EXISTS", HttpStatus.BAD_REQUEST);
		}
		return resp;
	}

	@DeleteMapping("/deletewrongway/{employeeId}")
	public ResponseEntity<String> removewrongway(@PathVariable Integer employeeId) {


		wrongwayService.deleteEmployee(employeeId);
		ResponseEntity<String> resp = new ResponseEntity<String>("wrongway DELETED SUCCESSFULLY", HttpStatus.OK);

		return resp;


	}

	//exmaple
	@PostMapping(value = "/createexmaple")
	public ResponseEntity<String> createexmaple(@ModelAttribute Employee employee) {


		ResponseEntity<String> response = null;
		if (employee != null) {

			exmapleService.saveEmployee(employee);
			response = new ResponseEntity<String>("exmaple Created successfully", HttpStatus.CREATED);

		} else {
			response = new ResponseEntity<String>("exmaple Creation fail try try again", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return response;
	}

	@SuppressWarnings("unchecked")
	@GetMapping(value = "/getallexmaple")
	public ResponseEntity<?> getexmaple() {
		ResponseEntity<?> response = null;
		logger.info("asf");
		List<Employee> employeesList = exmapleService.getAllEmployees();
		logger.info("bbb");
		if (employeesList == null || employeesList.isEmpty()) {
			response = new ResponseEntity<String>("exmaple Data Not FouND", HttpStatus.OK);
		} else {
			JSONObject jsonObject = new JSONObject();
			JSONArray array = new JSONArray();
			array.add(employeesList);
			jsonObject.put("Employee_List", array);
			logger.info("aaa");
			response = new ResponseEntity<JSONObject>(jsonObject, HttpStatus.OK);
		}
		return response;

	}

	@GetMapping("/getexmaple/{employeeId}")
	public ResponseEntity<?> getexmapleById(@PathVariable Integer employeeId) {

		ResponseEntity<?> resp = null;
		if (employeeId != null) {
			Employee employee = exmapleService.getEmployeeById(employeeId);
			resp = new ResponseEntity<Employee>(employee, HttpStatus.OK);
		} else {
			resp = new ResponseEntity<String>("exmaple NOT FOUND", HttpStatus.OK);
		}

		return resp;
	}

	@PutMapping("updateexmaple")
	public ResponseEntity<String> updateexmaple(@ModelAttribute Employee employee) {
		Integer id = employee.getId();
		boolean exist = exmapleService.isExsits(id);
		ResponseEntity<String> resp = null;
		if (exist) {
			exmapleService.updateEmployee(employee);
			resp = new ResponseEntity<String>("exmaple UPDATED SUCESSFULLY", HttpStatus.OK);
		} else {
			resp = new ResponseEntity<String>("exmaple NOT EXISTS", HttpStatus.BAD_REQUEST);
		}
		return resp;
	}

	@DeleteMapping("/deleteexmaple/{employeeId}")
	public ResponseEntity<String> removeexmaple(@PathVariable Integer employeeId) {


		exmapleService.deleteEmployee(employeeId);
		ResponseEntity<String> resp = new ResponseEntity<String>("exmaple DELETED SUCCESSFULLY", HttpStatus.OK);

		return resp;


	}
}