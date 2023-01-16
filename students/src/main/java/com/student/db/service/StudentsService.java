package com.student.db.service;

import java.sql.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.student.db.dao.StudentsRepo;
import com.student.db.entity.Students;

@Service
public class StudentsService {
	@Autowired
	StudentsRepo repo;

	public Students save(Students s) {
		String name = s.getName();
		name = name.trim();
		s.setName(name);
		Pattern pattern = Pattern.compile("[^A-Za-z \\s]");
		Matcher match = pattern.matcher(s.getName());
		boolean val = match.find();
		if (val == true || s.getName() == null || s.getName().equals("") || s.getName().isEmpty()
				|| s.getName().length() > 25) {
			return null;
		}
		String STARTDATE = "2000-04-20";
		String ENDDATE = "2002-06-20";
		Date date = Date.valueOf(STARTDATE);
		Date date1 = Date.valueOf(ENDDATE);
		System.out.println(s.getDate().compareTo(date));

		if (s.getDate() == null || s.getDate().compareTo(date1) > 0) {

			return null;
		} else if (s.getDate().compareTo(date) < 0) {
			return null;
		}
		if (s.getMarks() < 0 || s.getMarks() > 500) {
			return null;
		}
		if (s.getPercentile() < 0 || s.getPercentile() > 10) {
			return null;
		}
		return repo.save(s);
	}

	public Students update(Students s) {
		String name = s.getName();
		name = name.trim();
		s.setName(name);
		Pattern pattern = Pattern.compile("[^A-Za-z \\s]");
		Matcher match = pattern.matcher(s.getName());
		boolean val = match.find();
		if (val == true || s.getName() == null || s.getName().equals("") || s.getName().isEmpty()
				|| s.getName().length() > 25) {
			System.out.println(1);
			return null;
		}
		String STARTDATE = "2000-04-20";
		String ENDDATE = "2002-06-20";
		Date date = Date.valueOf(STARTDATE);
		Date date1 = Date.valueOf(ENDDATE);
		System.out.println(s.getDate().compareTo(date));

		if (s.getDate() == null || s.getDate().compareTo(date1) > 0) {

			return null;
		} else if (s.getDate().compareTo(date) < 0) {
			return null;
		}
		if (s.getMarks() < 0 || s.getMarks() > 500) {
			return null;
		}
		if (s.getPercentile() < 0 || s.getPercentile() > 10) {
			return null;
		}
		try {
			repo.getById(s.getId());
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
		return repo.updatePrd(s);
	}
	public List<Students> marksRange(short start, short end) {
		if(start<0 || start>500 || start>end) {
			return null;
		}
		if(end<0 || end>500 || end<start) {
			return null;
		}
		return repo.marksRange(start, end);
		
	}
	public List<Students> dobRange(Date start, Date end) {
		String STARTDATE = "2000-04-20";
		String ENDDATE = "2002-06-20";
		Date date = Date.valueOf(STARTDATE);
		Date date1 = Date.valueOf(ENDDATE);
		if (end.compareTo(date1) > 0) {
			return null;
		} else if (start.compareTo(date) < 0) {
			return null;
		}
		return repo.dobRange(start, end);
	}

	public List<Students> showAll() {
		return repo.getall();
	}

	public Students getById(long id) {
		Students s;
		try {
			s = repo.getById(id);

		} catch (EmptyResultDataAccessException e) {
			return null;
		}
		return s;
	}

	public int delete(long id) {
		try {
			Students s = repo.getById(id);
			repo.delete(id);
			return 1;
		} catch (EmptyResultDataAccessException e) {
			return 0;
		}
	}
}
