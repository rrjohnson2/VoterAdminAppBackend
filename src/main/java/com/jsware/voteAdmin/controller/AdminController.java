package com.jsware.voteAdmin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jsware.voteAdmin.entities.Voter;
import com.jsware.voteAdmin.repositories.VoterRepo;
import com.jsware.voteAdmin.transactions.Receipt;

@Controller
public class AdminController {
	
	@Autowired
	private VoterRepo voterRepo;
	
	@RequestMapping(value="/hello",method=RequestMethod.GET)
	@ResponseBody
	public String helloSSL()
	{
		return "Hello Friend";
	}
	
	
	@RequestMapping(value="/addSingleVoter",method= {RequestMethod.POST})
	@ResponseBody
	public Receipt addSingleVoter(@RequestBody Voter voter )
	
	{
		voterRepo.save(voter);
		return new Receipt("This went well user added ", voter);
	}
	
	
	

}
