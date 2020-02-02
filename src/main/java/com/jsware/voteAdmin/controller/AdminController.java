package com.jsware.voteAdmin.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.jsware.voteAdmin.entities.Voter;
import com.jsware.voteAdmin.repositories.VoterRepo;
import com.jsware.voteAdmin.transactions.Receipt;

@Controller
public class AdminController {
	
	@Autowired
	private VoterRepo voterRepo;
	
	private BufferedReader br;
	
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
	
	
	@RequestMapping(value="/addVoters",method= {RequestMethod.POST})
	@ResponseBody
	public Receipt addVoters(@RequestPart MultipartFile  csv )
	{

		List<Voter> voters =new ArrayList<Voter>();
		try {
			
			
			InputStream  fileStream =csv.getInputStream();
			InputStreamReader inbputReader = new InputStreamReader(fileStream);
			br = new BufferedReader(inbputReader);
			String line = "";
			
			while((line = br.readLine()) !=null)
			{
				voters.add(new Voter(line.split(",")));
			}
			
			if(voters.isEmpty())
			{

				return new Receipt("Voter csv file failed try a different one", null);
			}
			voterRepo.saveAll(voters);
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return new Receipt("Voter csv file failed try a different one", null);
		} catch (IOException e) {
			e.printStackTrace();
			return new Receipt("Voter csv file failed try a different one", null);
		}
		return new Receipt("Voters hav been added or updated  ", voters);
	}
	
	
	

}
