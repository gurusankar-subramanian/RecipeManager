# RecipeManager

Pre requistic  : Maven version 3 or above
                 Java 1.8 or above

# POST :: localhost:8080/receipe/save
{
     "name": "test 2",
     "incredients":[
     	{
     		"name":"INC1"
     	},
     	{
     		"name":"INC2"
     	},
     	{
     		"name":"INC3"
     	}]
}



# GET : dropdown :: localhost:8080/receipe/

[
    {
        "id": 1,
        "name": "test 2"
    },
    {
        "id": 2,
        "name": "test 2"
    },
    {
        "id": 3,
        "name": "test 2"
    }
]


# GET :: for single :: localhost:8080/receipe/1

{
    "id": 1,
    "name": "test 2",
    "incredients": [
        {
            "id": 1,
            "name": "INC1"
        },
        {
            "id": 2,
            "name": "INC2"
        },
        {
            "id": 3,
            "name": "INC3"
        }
    ]
}



DB used is H2 inbuilt from Spring Boot.
Run the App using the  ' mvn spring-boot:run ' command 
or create JAR using mvn clean install command and run the JAR using ' java -jar <fileName>.jar ' command



