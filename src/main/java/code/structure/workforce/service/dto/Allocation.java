package code.structure.workforce.service.dto;

import java.util.List;

import code.structure.workforce.service.util.Util;

public class Allocation {
	
	private List<Workforce> workforces;

	public List<Workforce> getWorkforces() {
		return workforces;
	}

	public void setWorkforces(List<Workforce> workforces) {
		this.workforces = workforces;
	}
	
	@Override
	public String toString() {
		return Util.toJsonString(this);
	}
}
