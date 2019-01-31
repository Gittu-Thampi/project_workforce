package code.structure.workforce.service.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import code.structure.workforce.service.dto.Allocation;
import code.structure.workforce.service.dto.Work;
import code.structure.workforce.service.dto.Workforce;

@Service
public class WorkforceService {
	
	public Allocation findOptimalAllocation(Work work) {
		List<Workforce> workforces = new ArrayList<Workforce>();
		for (int rooms : work.getRooms()) {
			WorkforceManager workforceManger = new WorkforceManager(rooms, work.getSenior(), work.getJunior());
			Workforce workforce = new Workforce();
			workforce.setSenior(workforceManger.getSeniorCount());
			workforce.setJunior(workforceManger.getJuniorCount());
			workforces.add(workforce);
		}
		Allocation allocation = new Allocation();
		allocation.setWorkforces(workforces);
		System.out.println(allocation);
		return allocation;
	}
}
