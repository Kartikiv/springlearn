# springlearn
  Creating a pojo ------------------------------------------------------------->
1 use @Entity
and it require Atleast one @Id
all the required methods and annotations
@Column(unique = true) // unique constrain
@CreationTimestamp
@UpdationTimeStamp
@ManytoOne
private Pojo pojo;
@Column(columnDefinition = "DECIMAL(2)")

   @RestController------------------------------------------------------------>
*@PostMapping
*@GetMappping 
*@PutMapping 
*@DeleteMapping

    @RestTermplate------------------------------------------------------------>
//create a pojo of the same params as the handle or database class 
then @AutoWired the RestTemplate class like -
@Bean
	@Qualifier("resttemplate")
	public RestTemplate temp() {
		return new RestTemplate();
	}
  or we can use 
  RestTemplate template =new RestTemplate();
  //post or create a new entery
  //save-
  template.postForObject
  template.postForObject(url,pojo.class);
  
  //getbyid-
template.getForObject("http://localhost:9099/products/" + id, product.class); //getByID

//update by id-
public int update(Pojo p){
template.put("http://localhost:9099/products/update", p, Pojo.class);
}
//getallobjects-
convert or take the json in form of a String and the use ObjectMapper and pass a new  TypeReference<List<pojo>>() to convert in it to the required the List<pojo>

String plist = template.getForObject(url, String.class);
		List<product> prd;
    

			prd = new ObjectMapper().readValue(plist, new TypeReference<List<product>>() {
			});
			for(product p:prd) {
			System.out.println(p.getPrice());
			}
 // deletebyid-
 public void delete(long id) {
		template.delete("http://localhost:9099/products/" + id);
	}
  
  
  Aspect or logging------------------------------------------------------------>
we can add some properties in the application.properties
logging.file.path=/
logging.file.name=productrest.logs
logging.level.root=info
logging.level.org.springframework=info
logging.level.com.database.demo.dao=debug
logging.level.com.database.demo.entity=debug
logging.level.com.database.demo.rest=debug
logging.level.com.database.demo.service=debug
the we create an aspect class with @Aspect and @Component
Logger log = LoggerFactory.logger(Classtobelogged.class);
or we create a class with @Aspect and @ Component and an @interface 
then in the created class
Logger log = LoggerFactory.logger(ServiceValidation.class);
@Before("@annotation(com.database.demo.aspect.LoggerPrd)")
@After("@annotation(com.database.demo.aspect.LoggerPrd)")
@Around("@annotation(the annotation path)")
using debug generally makes the program slower 


JDBC TEMPLATE EXAMPLE------------------------------------------------------------>
// we generally mark the the connect class with the @Repository
@Repository
public class JdbcConnector {
String Appl_pp="insert into Students(id,name,joining_date,rollno) values(?,?,?,?)";
String dell_pp="delete from Students where id=?";
String show_pp="select * from Students";
String Show_usr="select* from students where id=?";
String UPP_PPL="update students set name =?,rollno=?,joining_date=? where id=?";
	@Autowired
	JdbcTemplate studentcon;
// the sequence of new Object Array should be the same as insert into Students(id,name,joining_date,rollno) values(?,?,?,?)";
and the values given in the string should match the sql db names;
	public int saveStud(Students stu) {
		return studentcon.update(Appl_pp,new Object[] {stu.getId(),stu.getName(),stu.getJoiningDate(),stu.getRollno()});
		
	}
	public int delStud(Integer s1) {
		return studentcon.update(dell_pp,new Object[] {s1});
		
	} 
	public List<Students> showstudent(){
		
		return studentcon.query(show_pp, new studentrowm());


	}
	public Students showuserById(Integer id){
		return studentcon.queryForObject(Show_usr,new BeanPropertyRowMapper<Students>(Students.class),new Object[] {
		id});	 
		
	}
	public List<Students> showuserById1(Integer id){
		return studentcon.query(Show_usr,new studentrowm(),new Object[] {id});
		 
		
	}
	public void updatestudents(Students a) {
	      
		 studentcon.update(UPP_PPL,new Object[] {a.getName(),a.getRollno(),a.getJoiningDate(),a.getId()});
		
	}

}
class studentresextractor implements ResultSetExtractor<Students>{

	@Override
	@Nullable
	public Students extractData(ResultSet rs) throws SQLException, DataAccessException {
		Students s=new Students();
		s.setId(rs.getInt("id"));
		s.setName(rs.getString("name"));
		s.setJoiningDate(rs.getString("joining_date"));
		s.setRollno(rs.getString("rollno"));
		
		return s;
	}
	
}
class studentrowm implements RowMapper<Students> {
//we can use this or new BeanPropertyRowMapper<Students>(Students.class)
	@Override
	@Nullable
	public Students mapRow(ResultSet rs, int rowNum) throws SQLException {
		Students s=new Students();
		s.setId(rs.getInt("id"));
		s.setName(rs.getString("name"));
		s.setJoiningDate(rs.getString("joining_date"));
		s.setRollno(rs.getString("rollno"));
		
		return s;
	}


}
NAMEPARAMJDBC TEMPLATE EXAMPLE------------------------------------------------------------>
//THE NAMEPARAM JDBC IS LOOSLY COUPLED
@Repository
public class StudentsRepo {
	String INSERT = "insert into students (id,date,name,marks,percentile)values(:id,:date ,:name,:marks,:percentile)";
	String GETBYID = "select * from students where id=:id";
	String DELETE = "delete from students  where id=:id";
	String UPDATE = "update students set name=:name,percentile=:percentile,marks=:marks,date=:date where id=:id";
	String ShowAll = "select * from students";
	String DOBRANGE = "select * from students where date between :startdate and :enddate  ";
	String MARKSRANGE = "select * from students where marks between :start and :end";
	@Autowired
	NamedParameterJdbcTemplate template;
	@Autowired
	ApplicationEventPublisher publisher;
	
	 
    @Transactional
	public Students save(Students s) {
    
		var rowsAffected = template.update(INSERT, new BeanPropertySqlParameterSource(s));
		if(s.getName().equals("kartik")) {
			throw new  RuntimeException("invalid");
		}
	
		publisher.publishEvent(new StudentRegister(s));
		return s;
	}

	public Students getById(long id) throws EmptyResultDataAccessException {
		SqlParameterSource namedParameters = new MapSqlParameterSource();
		((MapSqlParameterSource) namedParameters).addValue("id", id);
		return template.queryForObject(GETBYID, namedParameters, new BeanPropertyRowMapper<Students>(Students.class));
	}

	public Students updatePrd(Students p) {

		template.update(UPDATE, new BeanPropertySqlParameterSource(p));
		return p;
	}

	public int delete(long id) {
		SqlParameterSource namedParameters = new MapSqlParameterSource();
		((MapSqlParameterSource) namedParameters).addValue("id", id);
		return template.update(DELETE, namedParameters);
	}

	public List<Students> getall() {
		return template.query(ShowAll, new BeanPropertyRowMapper<Students>(Students.class));
	}

	public List<Students> dobRange(Date start, Date end) {
		MapSqlParameterSource map = new MapSqlParameterSource();
		map.addValue("startdate", start);
		map.addValue("enddate", end);
		return template.query(DOBRANGE, map, new BeanPropertyRowMapper<Students>(Students.class));
	}

	public List<Students> marksRange(short start, short end) {
		MapSqlParameterSource map = new MapSqlParameterSource();
		map.addValue("start", start);
		map.addValue("end", end);
		return template.query(MARKSRANGE, map, new BeanPropertyRowMapper<Students>(Students.class));
	}
}

JPA INTERFACE----------------------------------------------------------------------------------------------->
WE CREATE AN INTERFACE WHICH EXTENDS THE JPAREPOSITORY WE PASS IN THE CLASS OF POJO AND THE PRIMARY KEY DATA TYPE IN THE JPAREPOSITORY
public interface ProductService extends JpaRepository<Products, Long> {
// THIS IS A WAYS WRITE CUSTOM QUERIES INT JPA
	@Transactional
	@Modifying(clearAutomatically = true ,flushAutomatically = true)
	@Query("update from Products p set p.name=?1 where p.id=?2")
	public int update(String name,Long id);


}

// THEN WE CREATE A JPACONNECTOR CLASS AND MAKE A LIST OF CRUD OPERATRIONS TO BE DONE ON OUR DATABASE
@Repository
public class JpaConnector implements Jpainterf {
	final static org.jboss.logging.Logger logger = LoggerFactory.logger(JpaConnector.class);
	@Autowired
	ProductService service;

	@Override
	public ResponseEntity<Object> save(Products p) {

		Products savedProduct = service.save(p);
		ResponseEntity<Object> k = new ResponseEntity<>(savedProduct, HttpStatus.CREATED);

		return k;
	}

	@Override
	public List<Products> getAll() {

		return service.findAll();

	}

	@Override
	public void delPrById(long Id) {
		service.deleteById(Id);
	}

	@Override
	public Optional<Products> getById(Long id) {

		return service.findById(id);
	}

	@Override
	public int update(String name, Long id) {

		return service.update(name, id);
	}

}

EVENTS,TRANSACTIONAL IN SPRING AND ADVANTAGES---------------------------------------------------------------------------------------------------------------->
THE @Transactional is used to marks a method as a transactional method whih means only when the method is completely executed without and errors then only 
the effects are reflected in the the database otherwise it rollsback to the start.

 Events in the spring are a way to make a all the events loosly coupled of one and other
  we create a class that the eventlistener listens like--
  public class StudentRegister {
private Students s;
public StudentRegister() {
	
}
public StudentRegister(Students s) {
	this.s=s;
}
public Students getS() {
	return s;
}

public void setS(Students s) {
	this.s = s;
}
}
 WE PUBLISH THIS EVENT SO THAT THE LISTENER CAN EXECUTE IN PARALLEL
 LIKE -
 ApplicationEventPublisher publisher;
	
	 
    @Transactional
	public Students save(Students s) {
    
		var rowsAffected = template.update(INSERT, new BeanPropertySqlParameterSource(s));
		if(s.getName().equals("kartik")) {
			throw new  RuntimeException("invalid");
		}
	
		publisher.publishEvent(new StudentRegister(s));
		return s;
	}
  
  WE CAN LISTEN TO THE PUBLISHED EVENT BY CREATING A EVENTLISTENER CLASS LIKE -
  THE EVENT LISTENER CLASS IS MARKED AS @Component and the @EventListner IS USED TO LISTEN TO THE PUBLISHED EVENT
  @Component
public class EventListen {
	@Autowired
	EmailRepo repo;

	@EventListener
	public void saved(StudentRegister s) {
		repo.save(s.getS().getName() + "@test.com");
		System.out.println(s.getS() + " hi");

	}
}


ASYNC--------------------------------------------------------------------------------------------->
IT IS A CONCEPT OF MULTITHREADING IN SPRING AND THE ANNOTATIONS @EnableAsync and @Async



