package com.project.Controller;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEvent;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.Service.DoctorPrimaryServive;
import com.project.Service.EmailSenderService;
import com.project.Service.LoginService;
import com.project.Service.PasswordEncoderServie;
import com.project.Service.UniqueKeyCheckService;
import com.project.entity.Address;
import com.project.entity.DoctorAvailMaster;
import com.project.entity.DoctorEstablishment;
import com.project.entity.DoctorMedRegistration;
import com.project.entity.DoctorPrimary;
import com.project.entity.SecurityQuestions;
import com.project.entity.proxy.DoctorPrimaryRegistrationProxy;
import com.project.entity.proxy.LoginProxy;
import com.project.exception.UniqueKeyExistException;
import com.project.payload.FileResponse;
@RestController
public class DoctorPrimaryController {
	
	@Autowired 
	private DoctorPrimaryServive doctorPrimaryServive;
	
	@Autowired
	private SecurityQuestionsController securityQuestionsController;
	
	@Autowired
	private DoctorMedRegistrationController doctorMedRegistrationController;
	
	@Autowired 
	private DoctorEstablishmentController doctorEstablishmentController;
	
	@Autowired
	private DoctorAvailMasterController doctorAvailMasterController;
	
	@Autowired
	private AddressController addressController;
	
	@Autowired
	private LoginService loginService;
	
	@Autowired
	private UniqueKeyCheckService uniqueKeyCheckService;
	
	@Autowired
	private PasswordEncoderServie passwordEncoderServie;
	
	@Autowired
	private EmailSenderService emailSenderService;
	
	
	@PostMapping("/doctor/register")
	@Transactional
	public ResponseEntity<DoctorPrimary> registerDoctor(@RequestBody DoctorPrimaryRegistrationProxy proxy)
	{
		
		Address address = new Address();
		address.setAddressLine1(proxy.getAddressLine1());
		address.setCity(proxy.getCity());
		address.setCountry(proxy.getCountry());
		address.setPinCode(proxy.getPinCode());
		address.setUserState(proxy.getUserState());
	
		
		DoctorAvailMaster master = new DoctorAvailMaster();
		master.setDoctorAvailDay(proxy.getDoctorAvailDay());
		master.setDoctorAvailTime(proxy.getDoctorAvailTime());
		master.setFees(proxy.getFees());
	        DoctorEstablishment establishment = new DoctorEstablishment();
		establishment.setEstablishment(proxy.getEstablishment());
		establishment.setEstablishmentCity(proxy.getEstablishmentCity());
		establishment.setEstablishmentLocation(proxy.getEstablishmentLocation());
		establishment.setEstablishmentName(proxy.getEstablishmentName());
		establishment.setEstablishmentPin(proxy.getPinCode());
		establishment.setEstablishmentProof(proxy.getEstablishmentProof());
		
     	DoctorMedRegistration registration = new DoctorMedRegistration();
		registration.setCollege(proxy.getCollege());
		registration.setDegree(proxy.getDegree());
		registration.setMedicalRegId(proxy.getMedicalRegId());
		registration.setRegistrationCouncil(proxy.getRegistrationCouncil());
		//registration.setRegistrationYear(proxy.getRegistrationYear());
		//registration.setYearOfCompletion(proxy.getYearOfCompletion());
	
		SecurityQuestions questions = new SecurityQuestions();
		questions.setSecurityQuestion(proxy.getSecurityQuestion());
		
		
		try
		{
		//getting the dependant properties
	 
		int questionId = securityQuestionsController.getQuestionId(proxy.getSecurityQuestion());
		proxy.setSecurityQuestionsId(questionId);
	
		//checking for duplicate in doctor-med-registration
		boolean ismedIdPresent = this.uniqueKeyCheckService.checkDuplicateMedRegistration(registration.getMedicalRegId());
		//if the med registration id is already present then exeption will be thrown
		if(ismedIdPresent)
		throw new UniqueKeyExistException("Registration id already Exist");
		
		//checking for email 
		boolean isEmailPresent = this.uniqueKeyCheckService.checkDuplicateEmail(proxy.getEmail());
		if(isEmailPresent)
		throw new UniqueKeyExistException("Email Id already exists in database");
		
		//checking for adhaarCard
		boolean isAdhaarPresent = this.uniqueKeyCheckService.checkDuplicateAdhaar(proxy.getAdhaarCard());
		if(isAdhaarPresent)
		throw new UniqueKeyExistException("Adhaar No already exists in database");
		
		//checking for panCard
		boolean isPanPresent = this.uniqueKeyCheckService.checkDuplicatePanCard(proxy.getPanCard());
		if(isPanPresent)
		throw new UniqueKeyExistException("PanCard already exists in database");	
		
		//checking for phone no
		boolean isPhonePresent = this.uniqueKeyCheckService.checkDuplicatePhone(proxy.getPhoneNumber());
		if(isPhonePresent)
		throw new UniqueKeyExistException("Phone No already exists in database");	
		
		DoctorMedRegistration insertDoctorMed = doctorMedRegistrationController.insertDoctorMed(registration);
		
		
		DoctorEstablishment insertEstablishment = doctorEstablishmentController.insertEstablishment(establishment);
		
		DoctorAvailMaster insertAvailability = doctorAvailMasterController.insertAvailability(master);
		
		Address insertAddress = addressController.insertAddress(address);
		
		DoctorPrimary docPrimary = new DoctorPrimary();
		docPrimary.setDoctorId(insertAvailability.getDoctorId());
		docPrimary.setAddress(insertAddress.getAddressId());
		docPrimary.setDoctorEstablishment(insertEstablishment.getEid());
		docPrimary.setDoctorMedRegistration(insertDoctorMed.getMedicalRegId());
		docPrimary.setDoctorAvailMaster(insertAvailability.getDoctorId());
		docPrimary.setSecurityQuestions(questionId);
		docPrimary.setDoctorId(insertAvailability.getDoctorId());
		docPrimary.setAdhaarCard(proxy.getAdhaarCard());
		docPrimary.setEmail(proxy.getEmail());
		docPrimary.setFname(proxy.getFname());
		docPrimary.setGender(proxy.getGender());
		docPrimary.setLname(proxy.getLname());
		docPrimary.setPanCard(proxy.getPanCard());
		docPrimary.setPhoneNumber(proxy.getPhoneNumber());
		docPrimary.setProfileStatus('U');
		
		//encrypting the password before setting it to the doctor object
		String encryptedPassword = this.passwordEncoderServie.encodePassword(proxy.getPwd());
		
		docPrimary.setPwd(encryptedPassword); //the hashed password is set at this line
		docPrimary.setSecurityQuestionsAnswer(proxy.getSecurityQuestionsAnswer());
		docPrimary.setSpecialization(proxy.getSpecialization());
		docPrimary.setYearOfExperience(proxy.getYearOfExperience());
		
		DoctorPrimary doctor = this.doctorPrimaryServive.insertDoctor(docPrimary);
	   
	    //transacation.commit();
		
		//on successful registration an email has to be sent to the doctor
		//implementing the email sender code
		this.emailSenderService.sendSimpleEmail(doctor.getEmail(),
				"<h1>You have been successfully logged into patient management system app.</h1>"
				+ "<h4>All future communications will be done through this email </h4>"+"<h4>Your user-id is:"+doctor.getDoctorId()+"</h4>",
				"Welcome to patient history management app");
		
	    return new ResponseEntity<>(doctor,HttpStatus.OK);
	    
		}
		
		catch(ConstraintViolationException e)
		{
			return new ResponseEntity<>(null,HttpStatus.CONFLICT);
		}
		catch (Exception e)
		{
			//transacation.rollback();
			return new ResponseEntity<>(null,HttpStatus.CONFLICT);
		}
		
		
		
		
	}

	@PostMapping("/doctor/login")
	public boolean validateLogin(@RequestBody LoginProxy proxy)
	{
		return this.loginService.ValidateDoctorLogin(proxy);
	}
}
