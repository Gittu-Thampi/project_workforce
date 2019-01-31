package code.structure.workforce.service.service;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import code.structure.workforce.service.config.AppConfig;
import code.structure.workforce.service.dto.Allocation;
import code.structure.workforce.service.dto.Work;
import code.structure.workforce.service.dto.Workforce;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
public class WorkforceServiceTest {

	@Autowired
	private WorkforceService workflowService;

	@Test
	public void findOptimalAllocation_Example1() throws Exception {
		Work work = new Work();
		work.setRooms(new int[] {35, 21, 17});
		work.setSenior(10);
		work.setJunior(6);

		Allocation allocation = workflowService.findOptimalAllocation(work);
		
		Workforce workforce = allocation.getWorkforces().get(0);
		assertArrayEquals(new int[] {3}, new int[] {workforce.getSenior()});
		assertArrayEquals(new int[] {1}, new int[] {workforce.getJunior()});
		
		workforce = allocation.getWorkforces().get(1);
		assertArrayEquals(new int[] {1}, new int[] {workforce.getSenior()});
		assertArrayEquals(new int[] {2}, new int[] {workforce.getJunior()});
		
		workforce = allocation.getWorkforces().get(2);
		assertArrayEquals(new int[] {2}, new int[] {workforce.getSenior()});
		assertArrayEquals(new int[] {0}, new int[] {workforce.getJunior()});
	}
	
	@Test
	public void findOptimalAllocation_Example2() throws Exception {
		Work work = new Work();
		work.setRooms(new int[] {24, 28});
		work.setSenior(11);
		work.setJunior(6);

		Allocation allocation = workflowService.findOptimalAllocation(work);
		
		Workforce workforce = allocation.getWorkforces().get(0);
		assertArrayEquals(new int[] {2}, new int[] {workforce.getSenior()});
		assertArrayEquals(new int[] {1}, new int[] {workforce.getJunior()});
		
		workforce = allocation.getWorkforces().get(1);
		assertArrayEquals(new int[] {2}, new int[] {workforce.getSenior()});
		assertArrayEquals(new int[] {1}, new int[] {workforce.getJunior()});
	}
}
