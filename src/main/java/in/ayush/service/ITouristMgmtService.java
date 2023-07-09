package in.ayush.service;

import java.util.List;

import in.ayush.model.Tourist;

public interface ITouristMgmtService {
	public String saveTourist(Tourist tourist);
	public List<Tourist> fetchAllTourist();
	public Tourist fetchTouristById(Integer id);
	public String updateTouristByDetails(Tourist tourist);
	public String updateTouristBudgetById(Integer id,Float hikePercent);
	public String deleteTouristById(Integer id);
}
