package in.ayush.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import in.ayush.model.Tourist;

public interface ITouristRepo extends JpaRepository<Tourist, Integer> {

}
