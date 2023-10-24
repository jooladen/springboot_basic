# spring boot 2.7.16
# JDK 8
# MySql 5.7
#---------------------------------
# 기능
#---------------------------------
# MyBatis 연동 basic CRUD
# log4JDBC
# BootStarap
# jquery
# List<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
#List<User> list = new ArrayList<>();
#public ResponseEntity<List<Map<String, Object>>> queryDirect() {
	    List<Map<String, Object>> userList = um.findAll();

	    return new ResponseEntity<>(userList, HttpStatus.OK);
	}
#