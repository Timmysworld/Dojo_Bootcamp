from flask_app.config.mysqlconnection import connectToMySQL
from .ninja import Ninja

class Dojo:
    def __init__(self, data):
        self.id = data['id']
        self.name = data['name']
        self.created_at = data['created_at']
        self.updated_at = data['updated_at']
        self.ninjas = []
        
    @classmethod
    def get_all(cls):
        query = "SELECT * FROM dojo";
        results = connectToMySQL('dojos_and_ninjas_schema').query_db(query)

        dojos = []

        for dojo in results:
            dojos.append(cls(dojo))
        return dojos

    @classmethod
    def save(cls, data):
        query = "INSERT INTO dojo (name, created_at, updated_at) VALUE (%(name)s, NOW(), NOW() );"
        return connectToMySQL ('dojos_and_ninjas_schema').query_db(query,data)

    @classmethod
    def get_dojo_ninja(cls,data):
        query = "SELECT * FROM dojo LEFT JOIN ninjas on dojo.id = ninjas.dojo_id WHERE dojo.id = %(id)s;"
        results = connectToMySQL ('dojos_and_ninjas_schema').query_db(query,data)
        print (results)
        dojo = cls(results[0])
        for row in results:
            n = {
                'id': row['ninjas.id'],
                'first_name': row['first_name'],
                'last_name': row['last_name'],
                'age': row['age'],
                'created_at': row['ninjas.created_at'],
                'updated_at': row['ninjas.updated_at']
            }
            dojo.ninjas.append(Ninja(n))
        return dojo