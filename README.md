1. Checkout this project from github using https://github.com/hareeshbillagit/exercise.git repository.
2. As this maven based project build this project using maven (mvn clean install).
3. Once the application build completed please follow below steps for execution.
4. Run application using below command:
		java -jar /<path where you copy this jar file>/exercise-0.0.1-SNAPSHOT.jar com.mars.exercise.exerciseApplication

	When you run the application, it starts and prompts you to provide input like below, please provide valid input details from below.
	{Please provide valid actions(insert/update/delete/count/all/exit):} listed from below for each action.

		Actions					values:
		-------------------------------
		Insert Person: 			insert
		Update Person: 			update
		Delete Person: 			delete
		Get all Persons: 		all
		Get Persons count:		count
		Exit from application: 	exit 
		
		Sample inputs for some of the requests.
		INSERT JSON format:
			{"firstName":"Anand","surname":"Mahindra"}
			{"firstName":"ABC","surname":"DEF"}
		
		UPDATE JSON format:
		{"id":3,"firstName":"RodNew","surname":"JohnsonOld"}
		
		DELETE input: (Numeric) 1
