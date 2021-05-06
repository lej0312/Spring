package com.person2.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class Person2DAOImpl implements Person2DAO{
	@Autowired
	private JdbcTemplate template;
	
	//추가하기
	@Override
	public void person_insert(PersonVO person) {
		String sql = "insert into person values(?,?,?,?,?)";
		Object[] param = new Object[] {
				person.getId(), person.getName(), person.getPassword(),
				person.getGender(), person.getJob()
		};
		template.update(sql, param);
	}

	//전체보기
	@Override
	public List<PersonVO> person_list() {
		String sql = "select * from person";
		List<PersonVO> personlist = template.query(sql, new RowMapper<PersonVO>() {
			@Override
			public PersonVO mapRow(ResultSet rs, int arg1) throws SQLException {
				PersonVO p = new PersonVO();
				p.setGender(rs.getString("gender"));
				p.setId(rs.getString("id"));
				p.setJob(rs.getString("job"));
				p.setName(rs.getString("name"));
				p.setPassword(rs.getString("password"));
				return p;
			}
		});
		return personlist;
	}

	//상세보기
	@Override
	public PersonVO person_view(String id) {
		String sql = "select * from person where id='"+id+"'";
		PersonVO person = template.queryForObject(sql, new RowMapper<PersonVO>() {

			@Override
			public PersonVO mapRow(ResultSet rs, int arg1) throws SQLException {
				PersonVO p = new PersonVO();
				p.setGender(rs.getString("gender"));
				p.setId(rs.getString("id"));
				p.setJob(rs.getString("job"));
				p.setPassword(rs.getString("password"));
				p.setName(rs.getString("name"));
				return p;
			}
		});
		return person;
	}
	
	//업데이트
	@Override
	public void person_update(PersonVO person) {
		String sql = "update person set name=?, job=?, gender=?, password=? where id=?";
		Object[] param = new Object[] {
				person.getName(), person.getJob(), person.getGender(),
				person.getPassword(), person.getId()
		};
		template.update(sql, param);
	}

	//삭제하기
	@Override
	public void person_delete(String id) {
		String sql = "delete from person where id='"+id+"'";
		template.update(sql);
	}

}
