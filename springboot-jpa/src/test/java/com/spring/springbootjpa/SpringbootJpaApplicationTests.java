package com.spring.springbootjpa;

import com.spring.springbootjpa.pojo.Person;
import com.spring.springbootjpa.repository.PersonRepository;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
class SpringbootJpaApplicationTests {
	@Autowired
	private PersonRepository personRepository;
	private Long id;

	/**
	 * 保存person数据库
	 */
	@Before
	public 	void setUp(){
		assertNotNull(personRepository);
		Person person = new Person("方慧平",18);
		Person savePerson = personRepository.saveAndFlush(person);
		savePerson.setName("方大大");
		personRepository.save(savePerson);

		id = savePerson.getId();
	}

	/**
	 * 使用JPA自带方法查找person
	 */
	public void should_get_person(){
		Optional<Person> personOptional = personRepository.findById(id);
		assertTrue(personOptional.isPresent());
		assertEquals("SnailClimb",personOptional.get().getName());
		assertEquals(Integer.valueOf(23), personOptional.get().getAge());

		List<Person> personList = personRepository.findByAgeGreaterThan(18);
		assertEquals(1, personList.size());
		// 清空数据库
		personRepository.deleteAll();
	}

	/**
	 * 自定义 query sql 查询语句查找 person
	 */

	@Test
	public void should_get_person_use_custom_query() {
		// 查找所有字段
		Optional<Person> personOptional = personRepository.findByNameCustomeQuery("SnailClimb");
		assertTrue(personOptional.isPresent());
		assertEquals(Integer.valueOf(23), personOptional.get().getAge());
		// 查找部分字段
		String personName = personRepository.findPersonNameById(id);
		assertEquals("SnailClimb", personName);
		System.out.println(id);
		// 更新
		personRepository.updatePersonNameById("UpdatedName", id);
		Optional<Person> updatedName = personRepository.findByNameCustomeQuery("UpdatedName");
		assertTrue(updatedName.isPresent());
		// 清空数据库
		personRepository.deleteAll();
	}

}
